package top.lobot.base.util;


import top.lobot.base.conf.Constants;
import top.lobot.base.holder.RequestHolder;
import top.lobot.utils.IpUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * 当前线程请求工具类
 *
 * @author ykr
 * @date 2024/8/1
 */
public class RequestUtil {

    public static String getParameters() {
        HttpServletRequest request = RequestHolder.getRequest();
        if (null == request) {
            return null;
        }
        Enumeration<String> paraNames = request.getParameterNames();
        if (paraNames == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        while (paraNames.hasMoreElements()) {
            String paraName = paraNames.nextElement();
            sb.append("&").append(paraName).append("=").append(request.getParameter(paraName));
        }
        return sb.toString();
    }

    public static Map<String, String[]> getParametersMap() {
        HttpServletRequest request = RequestHolder.getRequest();
        if (null == request) {
            return new HashMap<>(Constants.NUM_ONE);
        }
        return request.getParameterMap();
    }

    public static String getHeader(String headerName) {
        HttpServletRequest request = RequestHolder.getRequest();
        if (null == request) {
            return null;
        }
        return request.getHeader(headerName);
    }

    public static String getReferer() {
        return getHeader("Referer");
    }

    public static String getUa() {
        return getHeader("User-Agent");
    }

    public static String getIp() {
        HttpServletRequest request = RequestHolder.getRequest();
        if (null == request) {
            return null;
        }
        return IpUtils.getRealIp(request);
    }

    public static String getRequestUrl() {
        HttpServletRequest request = RequestHolder.getRequest();
        if (null == request) {
            return null;
        }
        return request.getRequestURL().toString();
    }

    public static String getMethod() {
        HttpServletRequest request = RequestHolder.getRequest();
        if (null == request) {
            return null;
        }
        return request.getMethod();
    }

    public static boolean isAjax(HttpServletRequest request) {
        if (null == request) {
            request = RequestHolder.getRequest();
        }
        if (null == request) {
            return false;
        }
        return "XMLHttpRequest".equalsIgnoreCase(request.getHeader("X-Requested-With"))
                || request.getParameter("ajax") != null;

    }

}

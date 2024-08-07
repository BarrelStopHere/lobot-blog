package top.lobot.admin.restapi;

import top.lobot.admin.annotion.AuthorityVerify.AuthorityVerify;
import top.lobot.admin.annotion.OperationLogger.OperationLogger;
import top.lobot.admin.global.MessageConf;
import top.lobot.admin.global.SysConf;
import top.lobot.base.feign.SearchFeignClient;
import top.lobot.utils.JsonUtils;
import top.lobot.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 *
 * @author ykr
 * @date 2024/8/7
 */
@RestController
@RequestMapping("/search")
@Api(value = "索引维护相关接口", tags = {"索引维护相关接口"})
@Slf4j
public class SearchIndexRestApi {

    @Resource
    private SearchFeignClient searchFeignClient;

    @AuthorityVerify
    @OperationLogger(value = "初始化ElasticSearch索引")
    @ApiOperation(value = "初始化ElasticSearch索引", notes = "初始化solr索引")
    @PostMapping("/initElasticIndex")
    public String initElasticIndex() {

        String result = searchFeignClient.initElasticSearchIndex();
        Map<String, Object> blogMap = (Map<String, Object>) JsonUtils.jsonToObject(result, Map.class);
        if (SysConf.SUCCESS.equals(blogMap.get(SysConf.CODE))) {
            return ResultUtil.successWithMessage(MessageConf.OPERATION_SUCCESS);
        } else {
            return ResultUtil.errorWithMessage(blogMap.get(SysConf.MESSAGE).toString());
        }
    }

    @AuthorityVerify
    @OperationLogger(value = "初始化Solr索引")
    @ApiOperation(value = "初始化Solr索引", notes = "初始化solr索引")
    @PostMapping("/initSolrIndex")
    public String initSolrIndex() {

        String result = searchFeignClient.initSolrIndex();
        Map<String, Object> blogMap = (Map<String, Object>) JsonUtils.jsonToObject(result, Map.class);
        if (SysConf.SUCCESS.equals(blogMap.get(SysConf.CODE))) {
            return ResultUtil.successWithMessage(MessageConf.OPERATION_SUCCESS);
        } else {
            return ResultUtil.errorWithMessage(blogMap.get(SysConf.MESSAGE).toString());
        }
    }
}
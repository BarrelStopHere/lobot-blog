package top.lobot.xo.vo;


import lombok.Data;
import top.lobot.base.vo.BaseVO;

/**
 *
 * @author ykr
 * @date 2024/8/2
 */
@Data
public class TodoVO extends BaseVO<TodoVO> {

    /**
     * 内容
     */
    private String text;
    /**
     * 表示事项是否完成
     */
    private Boolean done;


    /**
     * 无参构造方法，初始化默认值
     */
    TodoVO() {

    }

}

package top.lobot.xo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.EqualsAndHashCode;
import top.lobot.base.entity.BaseEntity;
import lombok.Data;

/**
 * 待办事项
 *
 * @author ykr
 * @date 2024/8/2
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("todo")
public class Todo extends BaseEntity<Todo> {

    private static final long serialVersionUID = 6034036374556842186L;

    /**
     * 内容
     */
    private String text;

    /**
     * 管理员UID
     */
    private String adminUid;

    /**
     * 表示事项是否完成
     */
    private Boolean done;
}

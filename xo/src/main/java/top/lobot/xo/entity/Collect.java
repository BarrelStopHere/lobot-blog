package top.lobot.xo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.lobot.base.entity.BaseEntity;

/**
 * 收藏表
 *
 * @author ykr
 * @date 2024/8/2
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("collect")
public class Collect extends BaseEntity<Collect> {

    private static final long serialVersionUID = 9082695750850846050L;
    /**
     * 用户的uid
     */
    private String userUid;

    /**
     * 博客的uid
     */
    private String blogUid;
}

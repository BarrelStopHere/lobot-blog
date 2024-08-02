package top.lobot.xo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.lobot.base.entity.BaseEntity;

/**
 * 文件分类
 *
 * @author ykr
 * @date 2024/8/2
 */
@EqualsAndHashCode(callSuper = true)
@TableName("file_sort")
@Data
public class FileSort extends BaseEntity<FileSort> {


    private static final long serialVersionUID = 9096265675525685745L;
    /**
     * 项目名
     */
    private String projectName;

    /**
     * 模块分类名
     */
    private String sortName;

    /**
     * 存储路径
     */
    private String url;
}

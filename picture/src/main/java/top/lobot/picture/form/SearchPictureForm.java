package top.lobot.picture.form;

import lombok.EqualsAndHashCode;
import top.lobot.base.vo.FileVO;
import lombok.Data;

@EqualsAndHashCode(callSuper = true)
@Data
public class SearchPictureForm extends FileVO {
    private String searchKey;
    private Integer count;
}

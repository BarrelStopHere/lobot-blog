package top.lobot.xo.mapper;


import top.lobot.base.enums.EStatus;
import top.lobot.xo.entity.Todo;
import top.lobot.base.mapper.SuperMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 *
 * @author ykr
 * @date 2024/8/2
 */
public interface TodoMapper extends SuperMapper<Todo> {

    /**
     * 批量更新未删除的代表事项的状态
     *
     * @param done
     */
    @Select("UPDATE t_todo SET done = #{done} WHERE STATUS = " + EStatus.ENABLE + " AND admin_uid = #{adminUid}")
    public void toggleAll(@Param("done") Integer done, @Param("adminUid") String adminUid);
}

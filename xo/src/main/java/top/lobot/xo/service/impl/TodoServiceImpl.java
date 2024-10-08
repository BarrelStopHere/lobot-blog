package top.lobot.xo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import top.lobot.xo.entity.Todo;
import top.lobot.utils.ResultUtil;
import top.lobot.utils.StringUtils;
import top.lobot.xo.conf.MessageConf;
import top.lobot.xo.conf.SQLConf;
import top.lobot.xo.conf.SysConf;
import top.lobot.xo.mapper.TodoMapper;
import top.lobot.xo.service.TodoService;
import top.lobot.xo.vo.TodoVO;
import top.lobot.base.enums.EStatus;
import top.lobot.base.holder.RequestHolder;
import top.lobot.base.service.impl.SuperServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 *
 * @author ykr
 * @date 2024/8/2
 */
@Service
public class TodoServiceImpl extends SuperServiceImpl<TodoMapper, Todo> implements TodoService {

    @Autowired
    TodoService todoService;

    @Resource
    TodoMapper todoMapper;

    @Override
    public void toggleAll(Integer done, String adminUid) {
        todoMapper.toggleAll(done, adminUid);
    }

    @Override
    public IPage<Todo> getPageList(TodoVO todoVO) {
        String adminUid = RequestHolder.getAdminUid();
        QueryWrapper<Todo> queryWrapper = new QueryWrapper<>();

        if (StringUtils.isNotEmpty(todoVO.getKeyword()) && !StringUtils.isEmpty(todoVO.getKeyword().trim())) {
            queryWrapper.like(SQLConf.TEXT, todoVO.getKeyword().trim());
        }
        queryWrapper.eq(SQLConf.ADMINUID, adminUid);

        //按时间顺序倒排
        queryWrapper.orderByDesc(SQLConf.CREATE_TIME);

        Page<Todo> page = new Page<>();
        page.setCurrent(todoVO.getCurrentPage());
        page.setSize(todoVO.getPageSize());
        queryWrapper.eq(SQLConf.STATUS, EStatus.ENABLE);
        IPage<Todo> pageList = todoService.page(page, queryWrapper);
        return pageList;
    }

    @Override
    public String addTodo(TodoVO todoVO) {
        String adminUid = RequestHolder.getAdminUid();
        Todo todo = new Todo();
        todo.setText(todoVO.getText());
        //默认未完成
        todo.setDone(false);
        todo.setAdminUid(adminUid);
        todo.insert();
        return ResultUtil.result(SysConf.SUCCESS, MessageConf.INSERT_SUCCESS);
    }

    @Override
    public String editTodo(TodoVO todoVO) {
        String adminUid = RequestHolder.getAdminUid();
        Todo todo = todoService.getById(todoVO.getUid());

        if (!todo.getAdminUid().equals(adminUid)) {
            return ResultUtil.result(SysConf.ERROR, MessageConf.ACCESS_NO_PRIVILEGE);
        }

        todo.setText(todoVO.getText());
        todo.setDone(todoVO.getDone());
        todo.setUpdateTime(new Date());
        todo.updateById();
        return ResultUtil.result(SysConf.SUCCESS, MessageConf.UPDATE_SUCCESS);
    }

    @Override
    public String deleteTodo(TodoVO todoVO) {
        String adminUid = RequestHolder.getAdminUid();
        Todo todo = todoService.getById(todoVO.getUid());

        if (!todo.getAdminUid().equals(adminUid)) {
            return ResultUtil.result(SysConf.ERROR, MessageConf.DATA_NO_PRIVILEGE);
        }

        todo.setStatus(EStatus.DISABLED);
        todo.setUpdateTime(new Date());
        todo.updateById();
        return ResultUtil.result(SysConf.SUCCESS, MessageConf.DELETE_SUCCESS);
    }

    @Override
    public String editBatchTodo(TodoVO todoVO) {
        String adminUid = RequestHolder.getAdminUid();
        if (todoVO.getDone()) {
            todoService.toggleAll(SysConf.ONE, adminUid);
        } else {
            todoService.toggleAll(SysConf.ZERO, adminUid);
        }
        return ResultUtil.result(SysConf.SUCCESS, MessageConf.UPDATE_SUCCESS);
    }

}

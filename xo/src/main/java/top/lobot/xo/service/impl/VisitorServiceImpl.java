package top.lobot.xo.service.impl;

import top.lobot.xo.entity.Guest;
import top.lobot.xo.mapper.GuestMapper;
import top.lobot.xo.service.GuestService;
import top.lobot.base.service.impl.SuperServiceImpl;
import org.springframework.stereotype.Service;

/**
 *
 * @author ykr
 * @date 2024/8/2
 */
@Service
public class GuestServiceImpl extends SuperServiceImpl<GuestMapper, Guest> implements GuestService {

}

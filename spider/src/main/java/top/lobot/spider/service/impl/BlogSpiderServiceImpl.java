package top.lobot.spider.service.impl;


import top.lobot.spider.entity.BlogSpider;
import top.lobot.spider.mapper.BlogSpiderMapper;
import top.lobot.spider.service.BlogSpiderService;
import top.lobot.base.serviceImpl.SuperServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 博客爬取服务实现类
 * </p>
 *
 * @author 陌溪
 * @since 2020年2月7日21:29:42
 */
@Slf4j
@Service
public class BlogSpiderServiceImpl extends SuperServiceImpl<BlogSpiderMapper, BlogSpider> implements BlogSpiderService {

}

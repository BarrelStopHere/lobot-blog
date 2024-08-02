package top.lobot.base.fallback;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import top.lobot.base.feign.SearchFeignClient;
import top.lobot.base.response.ResponseResult;

/**
 * 搜索服务降级兜底方法【当服务不可用时会触发】
 *
 * @author ykr
 * @date 2024/8/2
 */
@Component
@Slf4j
public class SearchFeignFallback implements SearchFeignClient {

    @Override
    public ResponseResult deleteElasticSearchByUid(String uid) {
        log.error("搜索服务出现异常, 服务降级返回, 删除ElasticSearch索引失败");
        return ResponseResult.fail("搜索服务出现异常, 服务降级返回, 删除ElasticSearch索引失败");
    }

    @Override
    public ResponseResult deleteElasticSearchByUids(String uids) {
        log.error("搜索服务出现异常, 服务降级返回, 批量删除ElasticSearch索引失败");
        return ResponseResult.fail("搜索服务出现异常, 服务降级返回, 批量删除ElasticSearch索引失败");
    }

    @Override
    public ResponseResult initElasticSearchIndex() {
        log.error("搜索服务出现异常, 服务降级返回, 初始化ElasticSearch索引失败");
        return ResponseResult.fail("搜索服务出现异常, 服务降级返回, 初始化ElasticSearch索引失败");
    }

    @Override
    public ResponseResult addElasticSearchIndexByUid(String uid) {
        log.error("搜索服务出现异常, 服务降级返回, 添加ElasticSearch索引失败");
        return ResponseResult.fail("搜索服务出现异常, 服务降级返回, 添加ElasticSearch索引失败");
    }

    @Override
    public ResponseResult deleteSolrIndexByUid(String uid) {
        log.error("搜索服务出现异常, 服务降级返回, 删除Solr索引失败");
        return ResponseResult.fail("搜索服务出现异常, 服务降级返回, 删除Solr索引失败");
    }

    @Override
    public ResponseResult deleteSolrIndexByUids(String uids) {
        log.error("搜索服务出现异常, 服务降级返回, 删除Solr索引失败");
        return ResponseResult.fail("搜索服务出现异常, 服务降级返回, 批量删除Solr索引失败");
    }

    @Override
    public ResponseResult initSolrIndex() {
        log.error("搜索服务出现异常, 服务降级返回, 初始化Solr索引失败");
        return ResponseResult.fail("搜索服务出现异常, 服务降级返回, 初始化Solr索引失败");
    }

    @Override
    public ResponseResult addSolrIndexByUid(String uid) {
        log.error("搜索服务出现异常, 服务降级返回, 添加Solr索引失败");
        return ResponseResult.fail("搜索服务出现异常, 服务降级返回, 添加Solr索引失败");
    }

    @Override
    public ResponseResult updateSolrIndexByUid(String uid) {
        log.error("搜索服务出现异常, 服务降级返回, 更新Solr索引失败");
        return ResponseResult.fail("搜索服务出现异常, 服务降级返回, 更新Solr索引失败");
    }
}

package top.lobot.base.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.lobot.base.conf.ig.feign.FeignConfiguration;
import top.lobot.base.fallback.SearchFeignFallback;
import top.lobot.base.response.ResponseResult;

/**
 * 搜索微服务
 *
 * @author ykr
 * @date 2024/8/2
 */
@FeignClient(name = "search", contextId = "searchFeignClient", configuration = FeignConfiguration.class, fallback = SearchFeignFallback.class)
public interface SearchFeignClient {

    /**
     * 通过博客uid删除ElasticSearch博客索引
     *
     * @param uid
     * @return
     */
    @PostMapping("/search/deleteElasticSearchByUid")
    ResponseResult deleteElasticSearchByUid(@RequestParam(required = true, value = "uid") String uid);

    /**
     * 通过uids删除ElasticSearch博客索引
     *
     * @param uids
     * @return
     */
    @PostMapping("/search/deleteElasticSearchByUids")
    ResponseResult deleteElasticSearchByUids(@RequestParam(value = "uids", required = true) String uids);

    /**
     * 初始化ElasticSearch索引
     *
     * @return
     */
    @PostMapping("/search/initElasticSearchIndex")
    ResponseResult initElasticSearchIndex();

    /**
     * 通过uid来增加ElasticSearch索引
     *
     * @return
     */
    @PostMapping("/search/addElasticSearchIndexByUid")
    ResponseResult addElasticSearchIndexByUid(@RequestParam(value = "uid", required = true) String uid);


    /**
     * 通过博客uid删除Solr博客索引
     *
     * @param uid
     * @return
     */
    @PostMapping("/search/deleteSolrIndexByUid")
    ResponseResult deleteSolrIndexByUid(@RequestParam(value = "uid", required = true) String uid);

    /**
     * 通过uids删除Solr博客索引
     *
     * @param uids
     * @return
     */
    @PostMapping("/search/deleteSolrIndexByUids")
    ResponseResult deleteSolrIndexByUids(@RequestParam(value = "uids", required = true) String uids);

    /**
     * 初始化Solr索引
     *
     * @return
     */
    @PostMapping("/search/initSolrIndex")
    ResponseResult initSolrIndex();

    /**
     * 通过uid来增加Solr索引
     *
     * @return
     */
    @PostMapping("/search/addSolrIndexByUid")
    ResponseResult addSolrIndexByUid(@RequestParam(value = "uid", required = true) String uid);

    /**
     * 通过uid来更新Solr索引
     *
     * @return
     */
    @PostMapping("/search/updateSolrIndexByUid")
    ResponseResult updateSolrIndexByUid(@RequestParam(value = "uid", required = true) String uid);

}

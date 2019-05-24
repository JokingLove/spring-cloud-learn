package com.ikang.springbootelasticsearch.controller;

import com.ikang.springbootelasticsearch.document.GoodsInfo;
import com.ikang.springbootelasticsearch.repository.GoodsRepository;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("goods")
public class GoodsController {


    private final GoodsRepository goodsRepository;

    public GoodsController(GoodsRepository goodsRepository) {
        this.goodsRepository = goodsRepository;
    }

    @GetMapping("save")
    public String save() {
        GoodsInfo goodsInfo = new GoodsInfo(System.currentTimeMillis(),
                "商品" + System.currentTimeMillis(), "这是一个测试商品！");

        goodsRepository.save(goodsInfo);


        return "success";
    }

    @GetMapping("delete")
    public String delete(Long id) {
        goodsRepository.deleteById(id);

        return "success";
    }

    @GetMapping("update")
    public String update(Long id, String name, String description) {
        GoodsInfo goodsInfo = new GoodsInfo(id, name, description);
        goodsRepository.save(goodsInfo);

        return "success";
    }

    @GetMapping("getOne")
    public GoodsInfo getOne(Long id) {
        Optional<GoodsInfo> optional = goodsRepository.findById(id);

        return optional.isPresent() ? optional.get() : null;
    }

    @GetMapping("list")
    public List<GoodsInfo> list() {
        Iterable<GoodsInfo> all = goodsRepository.findAll();
        List<GoodsInfo> list = new ArrayList<>();
        all.forEach(list::add);
        return list;
    }

    // 每页查询数量
    private final Integer DEFAULT_PAGE_SIZE = 10;

    @GetMapping("getList")
        public Page<GoodsInfo> getList(Integer pageNum, String query) {

        Pageable page = PageRequest.of(pageNum, DEFAULT_PAGE_SIZE);

        NativeSearchQuery nativeSearchQuery = new NativeSearchQueryBuilder()
                .withPageable(page)
                .withQuery(QueryBuilders.matchAllQuery())
                .withFilter(QueryBuilders.matchQuery("name", query))
                .withFilter(QueryBuilders.matchQuery("description", query))
                .withHighlightFields(new HighlightBuilder.Field("name").preTags("<font color='red'>").postTags("</font>"),
                        new HighlightBuilder.Field("description").preTags("<font color='red'>").postTags("</font>"))
                .build();

        Page<GoodsInfo> goodsInfos = goodsRepository.search(nativeSearchQuery);

        return goodsInfos;
    }


}

package com.ikang.springbootelasticsearch.repository;

import com.ikang.springbootelasticsearch.document.GoodsInfo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

@Component
public interface GoodsRepository extends ElasticsearchRepository<GoodsInfo, Long> {

}

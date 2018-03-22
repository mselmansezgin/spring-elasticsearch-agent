package com.ets.elast4crm.service;

import com.ets.elast4crm.config.ApplicationConfig;
import io.searchbox.core.Search;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;

public class ElasticsearchService {

    @Autowired
    ApplicationConfig appConfig;


    public Search getSearch(SearchSourceBuilder searchSourceBuilder) {
        return new Search.Builder(searchSourceBuilder.toString())
                .addIndex(appConfig.getElasticIndexName()).addType(appConfig.getElasticTypeName()).build();
    }
}

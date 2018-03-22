package com.ets.elast4crm.config;

import com.ets.elast4crm.service.ElasticsearchService;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;


@Configuration
@PropertySource("classpath:application.properties")
public class ApplicationConfig {

    @Value("${elast4crm.elasticsearch.host}")
    String elasticHost;

    @Value("${elast4crm.elasticsearch.port}")
    String elasticPort;

    @Value("${elast4crm.elasticsearch.indexname}")
    String elasticIndexName;

    @Value("${elast4crm.elasticsearch.typename}")
    String elasticTypeName;

    @Bean
    public JestClient jestClient() {

        System.out.println(elasticHost+":"+elasticPort);

        HttpClientConfig clientConfig = new HttpClientConfig.Builder(
                elasticHost+":"+elasticPort).multiThreaded(true).build();
        JestClientFactory factory = new JestClientFactory();
        factory.setHttpClientConfig(clientConfig);
        JestClient jestClient = factory.getObject();
        return jestClient;
    }


    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public static ElasticsearchService elasticsearchService() {
        return new ElasticsearchService();
    }

    public String getElasticHost() {
        return elasticHost;
    }
    public String getElasticPort() {
        return elasticPort;
    }
    public String getElasticIndexName() {
        return elasticIndexName;
    }
    public String getElasticTypeName() {
        return elasticTypeName;
    }

}


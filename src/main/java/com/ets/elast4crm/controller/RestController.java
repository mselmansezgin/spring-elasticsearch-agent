package com.ets.elast4crm.controller;


import com.ets.elast4crm.model.Note;
import com.ets.elast4crm.service.ElasticsearchService;
import com.google.gson.Gson;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestResult;
import io.searchbox.core.Search;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

@Controller
public class RestController extends BaseController{

    @Autowired
    JestClient jestClient;

    @Autowired
    ElasticsearchService elService;

    private final Logger log = LoggerFactory.getLogger(RestController.class);


    @GetMapping("/notes")
    @ResponseBody
    public List<Note> notes(@RequestParam(name="userName", required=false, defaultValue="") String userName,
                            @RequestParam(name="note", required=false, defaultValue="") String note,
                            @RequestParam(name="detailNote", required=false, defaultValue="") String detailNote) {

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.boolQuery()
                .must(QueryBuilders.matchQuery("userName", userName))
                .should(QueryBuilders.matchQuery("note", note))
                .should(QueryBuilders.matchQuery("details.note", detailNote))
        );

        Search search = elService.getSearch(searchSourceBuilder);

        log.info(searchSourceBuilder.toString());

        return getNotesJson(getJestResult(search));
    }

    private List<Note> getNotesJson(JestResult result) {
        Gson gson = new Gson();
        List<Note> notes = result.getSourceAsObjectList(Note.class);

        notes.forEach(p -> {gson.toJson(p);});
        return notes;
    }

    private JestResult getJestResult(Search search) {
        JestResult result = null;
        try {
            result = jestClient.execute(search);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }


}
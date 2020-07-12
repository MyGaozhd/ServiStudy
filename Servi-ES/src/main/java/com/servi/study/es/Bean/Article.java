package com.servi.study.es.Bean;

import io.searchbox.annotations.JestId;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "servi-article",type = "article")
@Data
public class Article {

    @JestId
    private String id;

    private String title;
    private String author;
    private String content;
}

package com.servi.study.es;

import com.servi.study.es.Bean.Article;
import com.servi.study.es.Bean.Book;
import com.servi.study.es.repository.BookRepository;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class ServiEsApplicationTests {

    @Autowired
    JestClient jestClient;

    @Autowired
    BookRepository bookRepository;

    @Test
    void contextLoads() throws IOException {
        Article article = new Article();
        article.setId("1");
        article.setTitle("今日特卖");
        article.setAuthor("servi");
        article.setContent(" hello word ");

        Index index = new Index.Builder(article).index("servi").type("article").build();

        jestClient.execute(index);

    }

    @Test
    void search() throws IOException {

        Search search = new Search.Builder("{{\"query\":{\"match\":{\"content\":\"hello\"}}}}").addIndex("servi").addType("article").build();

        SearchResult searchResult = jestClient.execute(search);
        System.out.println(searchResult.getJsonString());
    }

    @Test
    void test01() {
        Book book = new Book();
        book.setId(1);
        book.setBookName("西游记");
        book.setAuthor("吴承恩");
        bookRepository.index(book);
    }
}

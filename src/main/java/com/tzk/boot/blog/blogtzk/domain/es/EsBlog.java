package com.tzk.boot.blog.blogtzk.domain.es;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Id;
import java.io.Serializable;

@Data
@Document(indexName = "blog",type = "blog")
public class EsBlog implements Serializable {

    @Id
    private String id;
    private String title;
    private String summary;
    private String content;

    protected EsBlog() {
    }

    public EsBlog(String id, String title, String summary, String content) {
        this.id = id;
        this.title = title;
        this.summary = summary;
        this.content = content;
    }

    public EsBlog(String title, String summary, String content) {
        this.title = title;
        this.summary = summary;
        this.content = content;
    }
}

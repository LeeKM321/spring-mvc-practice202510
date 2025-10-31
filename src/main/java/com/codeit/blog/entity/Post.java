package com.codeit.blog.entity;

import lombok.*;

import java.time.LocalDateTime;

@Getter
//@Setter -> Entity에서 setter 사용은 권장하지 않습니다.
@AllArgsConstructor
@Builder
public class Post {

    private Long id;
    private String title;
    private String content;
    private String author;
    private Category category;
    private int viewCount;
    private String thumbnailPath;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    public Post() {
        this.viewCount = 0;
        this.createAt = LocalDateTime.now();
        this.updateAt = LocalDateTime.now();
    }

    public Post(String title, String content, String author, Category category) {
        this();
        this.title = title;
        this.content = content;
        this.author = author;
        this.category = category;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

package com.codeit.blog.dto.request;

import com.codeit.blog.entity.Category;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
public class PostRequest {

    private String title;
    private String content;
    private String author;
    private Category category;

}

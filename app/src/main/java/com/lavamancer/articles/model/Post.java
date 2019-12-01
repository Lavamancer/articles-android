package com.lavamancer.articles.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Post implements Serializable {

    private Long userId;
    private Long id;
    private String title;
    private String body;

}

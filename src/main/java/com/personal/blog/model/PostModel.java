package com.personal.blog.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "posts")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    @Column(length = 2000)
    private String description;
    @Column(length = 2000)
    private String media;
    private String owner;
    private String category;
    private String creationTime;
    private String modifiedTime;

}

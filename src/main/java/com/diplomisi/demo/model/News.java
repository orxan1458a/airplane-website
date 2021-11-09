package com.diplomisi.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private String image;
    @Lob
    @Column(columnDefinition = "MEDIUMTEXT")
    private String content;
    @Lob
    @Column(columnDefinition = "MEDIUMTEXT")
    private String shortContent;
    private String url;

}

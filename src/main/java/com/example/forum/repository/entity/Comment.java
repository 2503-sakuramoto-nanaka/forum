package com.example.forum.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "comment")
@Getter
@Setter
public class Comment {

    //●Entityはデータアクセス時のJavabeanのような入れ物
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private int content_id;

    @Column
    private String text;

    @Column
    private Date created_date;

    @Column
    private Date updated_date
            ;
}
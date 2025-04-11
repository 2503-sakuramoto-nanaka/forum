package com.example.forum.controller.form;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CommentForm {

    private int id;
    private int content_id;
    private String text;
    private Date created_date;
    private Date updated_date;
}


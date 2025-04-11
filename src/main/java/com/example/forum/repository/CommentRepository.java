package com.example.forum.repository;

import com.example.forum.repository.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//●CommentRepository が JpaRepository を継承しており、findAllメソッドを実行している
//●JpaRepositryにはあらかじめいくつかのメソッドが定義されており、SQL文を打つ必要がありません
//●findAllで実行されている処理はSQL文の「select * from report;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    public List<Comment> findAllComment();
}

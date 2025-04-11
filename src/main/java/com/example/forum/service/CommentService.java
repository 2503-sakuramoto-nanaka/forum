package com.example.forum.service;

import com.example.forum.controller.form.CommentForm;
import com.example.forum.repository.CommentRepository;
import com.example.forum.repository.entity.Comment;
import com.example.forum.repository.entity.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {
    @Autowired
    CommentRepository commentRepository;

    /*
     * レコード全件取得処理
     */
    //●findAllReportメソッドで、commentRepositoryのfindAllメソッド（すべてのレコードを取得）を実行
    public List<CommentForm> findAllComment() {
        List<Comment> results = commentRepository.findAllComment();
        List<CommentForm> comments = setCommentForm(results);
        return comments;
    }

    /*
     * DBから取得したデータをFormに設定
     */
    //●値をsetCommentメソッドでEntity→Formに詰め直して、Controllerに戻す
    //Entityはデータアクセス時の入れ物、FormはViewへの入出力時に使用する入れ物と役割を分けているから
    private List<CommentForm> setCommentForm(List<Comment> results) {
        List<CommentForm> comments = new ArrayList<>();

        for (int i = 0; i < results.size(); i++) {
            CommentForm comment = new CommentForm();
            Comment result = results.get(i);
            comment.setId(result.getId());
            comment.setContent_id(result.getContent_id());
            comment.setText(result.getText());
            comment.setCreated_date(result.getCreated_date());
            comment.setUpdated_date(result.getUpdated_date());
            comments.add(comment);
        }
        return comments;
    }

    /*
     * レコード追加
     */
    public void saveComment(CommentForm reqComment) {
        Comment saveComment = setCommentEntity(reqComment);
        //save メソッドは新規登録（insert）、更新（update）の両方が使えるメソッド
        commentRepository.save(saveComment);
    }

    /*
     * リクエストから取得した情報をEntityに設定
     */
    private  Comment setCommentEntity(CommentForm reqComment) {
        Comment comment = new Comment();
        comment.setId(reqComment.getId());
        comment.setContent_id(reqComment.getContent_id());
        comment.setText(reqComment.getText());
        comment.setCreated_date(reqComment.getCreated_date());
        comment.setUpdated_date(reqComment.getUpdated_date());
        return comment;
    }
}
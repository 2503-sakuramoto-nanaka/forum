package com.example.forum.repository;

import com.example.forum.repository.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//●ReportRepository が JpaRepository を継承しており、findAllメソッドを実行している
//●JpaRepositryにはあらかじめいくつかのメソッドが定義されており、SQL文を打つ必要がありません
//●findAllで実行されている処理はSQL文の「select * from report;

@Repository
public interface ReportRepository extends JpaRepository<Report, Integer> {
    public List<Report> findAllByOrderByIdDesc();
}



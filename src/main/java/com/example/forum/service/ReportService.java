package com.example.forum.service;

import com.example.forum.controller.form.ReportForm;
import com.example.forum.repository.ReportRepository;
import com.example.forum.repository.entity.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReportService {
    @Autowired
    ReportRepository reportRepository;

    /*
     * レコード全件取得処理
     */
    //●findAllReportメソッドで、reportRepositoryのfindAllメソッド（すべてのレコードを取得）を実行
    public List<ReportForm> findAllReport() {
        List<Report> results = reportRepository.findAllByOrderByIdDesc();
        List<ReportForm> reports = setReportForm(results);
        return reports;
    }
    /*
     * DBから取得したデータをFormに設定
     */
    //●値をsetReportFormメソッドでEntity→Formに詰め直して、Controllerに戻す
    private List<ReportForm> setReportForm(List<Report> results) {
        List<ReportForm> reports = new ArrayList<>();

        for (int i = 0; i < results.size(); i++) {
            ReportForm report = new ReportForm();
            Report result = results.get(i);
            report.setId(result.getId());
            report.setContent(result.getContent());
            reports.add(report);
        }
        return reports;
    }
    /*
     * レコード追加
     */
    public void saveReport(ReportForm reqReport) {
        Report saveReport = setReportEntity(reqReport);
        //save メソッドは新規登録（insert）、更新（update）の両方が使えるメソッド
        reportRepository.save(saveReport);
    }

    /*
     * リクエストから取得した情報をEntityに設定
     */
    private Report setReportEntity(ReportForm reqReport) {
        Report report = new Report();
        report.setId(reqReport.getId());
        report.setContent(reqReport.getContent());
        return report;
    }
    /*
     * レコード削除
     */
    public void deleteReport(Integer id) {
        //●ReportRepositoryで定義されているdeleteById()メソッドを使用し、キー(id)に該当するレコードを削除
        reportRepository.deleteById(id);
    }
    /*
     * 編集のためレコード1件取得
     */
    public ReportForm editReport(Integer id) {
        List<Report> results = new ArrayList<>();
        //●ReportRepositoryで定義されているfindById()メソッドを使用し、キー(id)に該当するレコードを取得
        //●Id が一致するレコードを取得するような処理になるため、一致しないときは null を返したいので、.orElse(null) となる
        results.add((Report) reportRepository.findById(id).orElse(null));
        List<ReportForm> reports = setReportForm(results);
        return reports.get(0);
    }
}

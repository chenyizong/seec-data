package com.moekr.moocoder.dao;

import com.moekr.moocoder.entity.Exam;
import com.moekr.moocoder.entity.Problem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamDAO extends JpaRepository<Exam, Integer> {

    @Query(value = "select uuid from Exam where name like '%上机考试%'")
    List<String> findExamUUid();

}

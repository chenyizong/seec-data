package com.moekr.moocoder.dao;

import com.moekr.moocoder.entity.Problem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProblemDAO extends JpaRepository<Problem, Integer> {
    Problem findById(int id);

}

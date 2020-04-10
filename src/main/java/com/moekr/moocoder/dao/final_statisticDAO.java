package com.moekr.moocoder.dao;

import com.moekr.moocoder.entity.final_statistic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface final_statisticDAO extends JpaRepository<final_statistic, Integer> {
    final_statistic findById(int id);

}

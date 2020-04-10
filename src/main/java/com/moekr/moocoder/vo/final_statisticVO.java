package com.moekr.moocoder.vo;

import com.moekr.moocoder.entity.final_statistic;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

@Data
public class final_statisticVO {
    private Integer id;
    private LocalDateTime first_commit_time;
    private LocalDateTime last_commit_time;
    private Integer solved_count;
    private Integer solved_count_java;
    private Integer solved_count_python;
    private Integer commit_count;
    private Integer average_score;
    private LocalDateTime latest_night_commit_time;
    private Integer max_commit_problem;
    private Integer max_commit_problem_commit_count;

    public final_statisticVO(final_statistic finalStatistic) {
        BeanUtils.copyProperties(finalStatistic, this);
    }
}

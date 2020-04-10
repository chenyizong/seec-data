package com.moekr.moocoder.vo;

import lombok.Data;

@Data
public class UserInfoVO {
    private String username;
    private String first_commit_time;
    private String last_commit_time;
    private Integer period;
    private Integer solved_count;
    private Integer solved_count_java;
    private Integer solved_count_python;
    private Integer commit_count;
    private Integer average_score;
    private String latest_night_commit_time;
    private Integer max_commit_problem_commit_count;
    private String problem_name;
}

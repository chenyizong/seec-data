package com.moekr.moocoder.entity;


import com.moekr.moocoder.util.enums.ExamStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(exclude = {""})
@ToString(exclude = {""})
@Entity
@Table(name = "final_statistic")
@EntityListeners(AuditingEntityListener.class)
public class final_statistic {
    @Id
    @Column(name = "id")
    private Integer id;

    @Basic
    @Column(name = "first_commit_time", nullable = false)
    @CreatedDate
    private LocalDateTime first_commit_time;

    @Basic
    @Column(name = "last_commit_time", nullable = false)
    @CreatedDate
    private LocalDateTime last_commit_time;

    @Basic
    @Column(name = "solved_count")
    private Integer solved_count;

    @Basic
    @Column(name = "solved_count_java")
    private Integer solved_count_java;

    @Basic
    @Column(name = "solved_count_python")
    private Integer solved_count_python;

    @Basic
    @Column(name = "commit_count")
    private Integer commit_count;

    @Basic
    @Column(name = "code_line_count")
    private Integer code_line_count;

    @Basic
    @Column(name = "average_score")
    private Integer average_score;

    @Basic
    @Column(name = "largest_class_name")
    private String largest_class_name;

    @Basic
    @Column(name = "largest_class_size")
    private Integer largest_class_size;

    @Basic
    @Column(name = "night_commit_count")
    private Integer night_commit_count;

    @Basic
    @Column(name = "latest_night_commit_time")
    @CreatedDate
    private LocalDateTime latest_night_commit_time;

    @Basic
    @Column(name = "max_commit_problem")
    private Integer max_commit_problem;

    @Basic
    @Column(name = "max_commit_problem_commit_count")
    private Integer max_commit_problem_commit_count;
}

package com.moekr.moocoder.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(exclude = {"exam", "owner"})
@ToString(exclude = {"exam", "owner"})
@Entity
@Table(name = "ENTITY_RESULT")
public class Result {
    @Id
    @Column(name = "id")
    private Integer id;

    @Basic
    @Column(name = "score", columnDefinition = "INT(11) NOT NULL DEFAULT 0")
    private Integer score = 0;

    @Basic
    @Column(name = "last_commit_at")
    private LocalDateTime lastCommitAt;

    @Basic
    @Column(name = "deleted", columnDefinition = "BIT(1) NOT NULL DEFAULT 0")
    private boolean deleted;

    @ManyToOne(targetEntity = Exam.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "exam", referencedColumnName = "id")
    private Exam exam;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "owner", referencedColumnName = "id")
    private User owner;

}

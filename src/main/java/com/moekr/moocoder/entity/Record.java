package com.moekr.moocoder.entity;

import com.moekr.moocoder.util.enums.BuildStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Data
@EqualsAndHashCode(exclude = {"failures", "commit", "problem"})
@ToString(exclude = {"consoleOutput", "failures", "commit", "problem"})
@Entity
@Table(name = "ENTITY_RECORD")
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Basic
    @Column(name = "number", nullable = false)
    private Integer number;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", columnDefinition = "VARCHAR(255) NOT NULL DEFAULT 'WAITING'")
    private BuildStatus status = BuildStatus.WAITING;

    @Basic(fetch = FetchType.LAZY)
    @Column(name = "console_output", columnDefinition = "TEXT NOT NULL")
    private String consoleOutput = "";

    @Basic
    @Column(name = "score", columnDefinition = "INT(11) NOT NULL DEFAULT 0")
    private Integer score = 0;

    @Basic
    @Column(name = "failures")
    private String failures = "";

    @ManyToOne(targetEntity = Commit.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "commit", referencedColumnName = "id")
    private Commit commit;

    @ManyToOne(targetEntity = Problem.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "problem", referencedColumnName = "id")
    private Problem problem;

    @Data
    public static class Failure {
        private String name;
        private String details;
        private String trace;
    }
}

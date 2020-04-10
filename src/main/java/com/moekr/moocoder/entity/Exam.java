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
@EqualsAndHashCode(exclude = {"creator"})
@ToString(exclude = {"creator"})
@Entity
@Table(name = "ENTITY_EXAM")
@EntityListeners(AuditingEntityListener.class)
public class Exam {
    @Id
    @Column(name = "id")
    private Integer id;

    @Basic
    @Column(name = "uuid", nullable = false)
    private String uuid;

    @Basic
    @Column(name = "name", nullable = false)
    private String name;

    @Basic
    @Column(name = "created_at", nullable = false)
    @CreatedDate
    private LocalDateTime createdAt;

    @Basic
    @Column(name = "start_at", nullable = false)
    private LocalDateTime startAt;

    @Basic
    @Column(name = "end_at", nullable = false)
    private LocalDateTime endAt;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status", columnDefinition = "VARCHAR(255) NOT NULL DEFAULT 'PREPARING'")
    private ExamStatus status = ExamStatus.PREPARING;

    @Basic
    @Column(name = "initial_hash")
    private String initialHash;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "creator", referencedColumnName = "id")
    private User creator;

    @Basic
    @Column(name = "courseId")
    private Integer courseId;

    @ManyToMany(targetEntity = Problem.class, cascade = CascadeType.DETACH)
    @JoinTable(name = "LINK_PROBLEM_EXAM",
            joinColumns = @JoinColumn(name = "exam", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "problem", referencedColumnName = "id")
    )
    @LazyCollection(LazyCollectionOption.EXTRA)
    private Set<Problem> problems = new HashSet<>();

    @OneToMany(targetEntity = Result.class, mappedBy = "exam", cascade = CascadeType.REMOVE)
    @LazyCollection(LazyCollectionOption.EXTRA)
    private Set<Result> results = new HashSet<>();
}

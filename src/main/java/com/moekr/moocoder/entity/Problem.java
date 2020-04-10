package com.moekr.moocoder.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(exclude = {"creator", "examSet"})
@ToString(exclude = {"creator", "examSet"})
@Entity
@Table(name = "ENTITY_PROBLEM")
//@Where(clause = "deprecated = 0")
@EntityListeners(AuditingEntityListener.class)
public class Problem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Basic
    @Column(name = "name", nullable = false)
    private String name;


    @Basic
    @Column(name = "deprecated", columnDefinition = "BIT(1) NOT NULL DEFAULT 0")
    private boolean deprecated;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "creator", referencedColumnName = "id")
    private User creator;

    @ManyToMany(targetEntity = Exam.class, cascade = CascadeType.DETACH)
    @JoinTable(name = "LINK_PROBLEM_EXAM",
            joinColumns = @JoinColumn(name = "problem", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "exam", referencedColumnName = "id")
    )
    @LazyCollection(LazyCollectionOption.EXTRA)
    private Set<Exam> examSet = new HashSet<>();
}

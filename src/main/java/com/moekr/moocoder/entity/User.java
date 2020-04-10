package com.moekr.moocoder.entity;

import com.moekr.moocoder.util.enums.Role;
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
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "ENTITY_USER", indexes = {@Index(columnList = "username"), @Index(columnList = "email")})
@EntityListeners(AuditingEntityListener.class)
public class User {
    /**
     * 主键Id
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 注册时间
     */
    @Basic
    @Column(name = "created_at", nullable = false)
    private String created_at;

    /**
     * 邮箱
     */
    @Basic
    @Column(name = "email", nullable = false)
    private String email;

    /**
     * NameSpace
     */
    @Basic
    @Column(name = "namespace", nullable = false)
    private Integer namespace;

    /**
     * 密码
     */
    @Basic
    @Column(name = "password", nullable = false)
    private String password;

    /**
     * 用户身份，为学生
     *
     * @see Role
     */
    @Enumerated(value = EnumType.STRING)
    @Column(name = "role", columnDefinition = "VARCHAR(255) NOT NULL")
    private Role role = Role.STUDENT;

    /**
     * Token
     */
    @Basic
    @Column(name = "token", nullable = false)
    private String token;

    /**
     * 用户名
     */
    @Basic
    @Column(name = "username", nullable = false)
    private String username;

    @OneToMany(targetEntity = Problem.class, mappedBy = "creator", cascade = CascadeType.REMOVE)
    @LazyCollection(LazyCollectionOption.EXTRA)
    private Set<Problem> problemSet = new HashSet<>();

    @OneToMany(targetEntity = Exam.class, mappedBy = "creator", cascade = CascadeType.REMOVE)
    @LazyCollection(LazyCollectionOption.EXTRA)
    private Set<Exam> examSet = new HashSet<>();

    @OneToMany(targetEntity = Result.class, mappedBy = "owner", cascade = CascadeType.REMOVE)
    @LazyCollection(LazyCollectionOption.EXTRA)
    private Set<Result> resultSet = new HashSet<>();

    @ManyToMany
    @JoinTable(name="STUDENT_COURSE", joinColumns = @JoinColumn(name = "student", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "course", referencedColumnName = "id"))
    private Set<Course> courses = new HashSet<>();

}

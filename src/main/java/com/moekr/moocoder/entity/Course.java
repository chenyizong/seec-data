package com.moekr.moocoder.entity;

import com.moekr.moocoder.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

/**
 * @author XiangzheXu
 * create-time: 2018/12/9
 */

@Data
@Entity
@Table(name = "ENTITY_COURSE")
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /**
     * 课程名
     */
    private String name;

    /**
     * 选课码
     */
    private String code;

    /**
     * 课程对应的老师ID
     */
    private Integer teacherID;

    /**
     * 课程对应的老师
     */
    @OneToOne
    private User teacher;

    /**
     * 选课学生
     */
    @ManyToMany
    @JoinTable(name="STUDENT_COURSE", joinColumns = @JoinColumn(name = "course", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "student", referencedColumnName = "id"))
    private List<User> students=new LinkedList<>();
}

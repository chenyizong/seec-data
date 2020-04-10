package com.moekr.moocoder.dao;

import com.moekr.moocoder.entity.User;
import com.moekr.moocoder.util.enums.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDAO extends JpaRepository<User, Integer> {
    User findById(int id);

    User findByUsername(String username);

    User findByEmail(String email);

    Page<User> findAllByUsernameLike(String search, Pageable pageable);

    Integer countByRole(Role role);

    User findUserByUsername(String username);

    User findUserById(Integer id);

    List<User> findByRole(Role role);

    @Query(value = "select max(id) from User")
    Integer findMaxUserId();

    @Query(value = "select username from User where id between 282 and 724")
    List<String> findUserNameById();
}

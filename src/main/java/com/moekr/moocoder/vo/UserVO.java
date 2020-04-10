package com.moekr.moocoder.vo;

import com.moekr.moocoder.entity.User;
import com.moekr.moocoder.util.enums.Role;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

@Data
public class UserVO {
    private Integer id;
    private String username;
    private String email;
    private Role role;
    private LocalDateTime createdAt;


    public UserVO(User user) {
        BeanUtils.copyProperties(user, this);
    }
//
//    public static final UserVO ADMIN = new UserVO();
}

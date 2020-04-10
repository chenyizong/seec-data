package com.moekr.moocoder.vo;

import com.moekr.moocoder.entity.Problem;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class ProblemVO {
    private Integer id;
    private String name;

    public ProblemVO(Problem problem) {
          BeanUtils.copyProperties(problem, this);
    }
}

package com.moekr.moocoder.util.enums;

import lombok.Getter;

@Getter
public enum ProblemType {
    /**
     * 普通Java题目，统计测试用例通过情况
     */
    JAVA,
    /**
     * 普通Python题目，统计测试用例通过情况
     */
    PYTHON,
    /**
     * Java测试覆盖率题目，统计测试覆盖率
     */
    JAVA_COVERAGE,
    /**
     * Python测试覆盖率题目，统计测试覆盖率
     */
    PYTHON_COVERAGE,
    /**
     * Java变异覆盖题目，统计变异覆盖率
     */
    JAVA_MUTATION,
    /**
     * PYTHON深度学习作业，统计准确率
     */
    PYTHON_DL;
}

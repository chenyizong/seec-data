package com.moekr.moocoder.util.enums;

public enum Role {
    /**
     * 学生角色
     */
    STUDENT("学生"),
    /**
     * 教师角色
     */
    TEACHER("教师");

    private final String name;

    Role(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

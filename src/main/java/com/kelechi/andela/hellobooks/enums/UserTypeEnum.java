package com.kelechi.andela.hellobooks.enums;

public enum UserTypeEnum {
    ADMIN("admin", 3),
    USER("user", 1);

    private String name;
    private long level;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getLevel() {
        return level;
    }

    public void setLevel(long level) {
        this.level = level;
    }

    UserTypeEnum(String name, long level) {

        this.name = name;
        this.level = level;
    }
}

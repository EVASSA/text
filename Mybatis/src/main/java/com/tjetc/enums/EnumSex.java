package com.tjetc.enums;

/**
 * 性别枚举
 */
public enum EnumSex {
    //枚举与类很像，就是特殊的类
    //定义枚举值（枚举对象）
    FEMALE(0, "女"),
    MALE(1, "男");

    //定义成员变量
    /**
     * 性别编码
     */
    private int code;
    /**
     * 性别的名称
     */
    private String name;

    //定义构造方法（枚举只能定义私有的构造方法）
    EnumSex(int code, String name) {
        this.code = code;
        this.name = name;
    }

    //定义get方法
    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    //定义普通方法
    //定义静态方法。。。。。
    /**
     * 根据枚举的code返回枚举对象
     *
     * @param code 枚举code
     * @return code对应的枚举对象
     */
    public static EnumSex getByCode(int code) {
        //所有枚举有一个静态方法，values() 可以获取所有的枚举对象
        EnumSex[] values = EnumSex.values();
        for (EnumSex value : values) {
            if (value.code == code) {
                return value;
            }
        }
        return null;
    }
}

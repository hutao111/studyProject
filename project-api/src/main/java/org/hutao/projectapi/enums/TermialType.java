package org.hutao.projectapi.enums;


public enum TermialType {

    //类型：1、PC;    2、weixin； 3、app; 4、manage


    PC(1,"PC端"),
    WEIXIN(2,"微信端"),
    APP(3,"APP端"),
    MANAGE(4,"管理端");

    private Integer type;
    private String typeName;

    TermialType(Integer type, String typeName) {
        this.type = type;
        this.typeName = typeName;
    }

    public Integer getType() {
        return type;
    }

    public String getTypeName() {
        return typeName;
    }
}

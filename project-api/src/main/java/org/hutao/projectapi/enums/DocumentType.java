package org.hutao.projectapi.enums;

public enum DocumentType {

    DOCUMENT(1,"文档"),
    PICTURE(2,"图片"),
    AUDIO(3,"音频"),
    VIDEO(4,"视频"),
    OTHER(5,"其他");
    private Integer type;
    private String typeName;

    DocumentType(Integer type, String typeName) {
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

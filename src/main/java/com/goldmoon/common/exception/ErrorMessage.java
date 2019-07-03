package com.goldmoon.common.exception;

public enum ErrorMessage {

    INVALID_FORMAT_PARAMETER(1001, "파라미터가 없거나 형식이 올바르지 않습니다."),
    ALREADY_EXIST_USER(2001, "이미 존재하는 사용자입니다."),
    NOT_FOUND_EXIST_USER(2002, "사용자가 존재하지 않습니다.");
    ;

    int code;
    String desc;

    ErrorMessage(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static ErrorMessage of(String errorMessage) {
        for (ErrorMessage errorMsg : ErrorMessage.values()) {
            if (errorMsg.name().equals(errorMessage)) {
                return errorMsg;
            }
        }
        return null;
    }
}

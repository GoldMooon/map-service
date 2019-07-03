package com.goldmoon.common.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ExceptionResponse {
    HttpStatus status;
    Integer errorCode;
    String errorCodeName;
    String errorDescription; //ApiException일 경우에만 추가해준다
}
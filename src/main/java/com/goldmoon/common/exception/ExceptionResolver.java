package com.goldmoon.common.exception;

import com.google.common.base.Throwables;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice
@Slf4j
public class ExceptionResolver {

    @ExceptionHandler(ApiException.class)
    public ExceptionResponse handle(HttpServletResponse servletResponse, ApiException e) {
        log.info(Throwables.getStackTraceAsString(e));

        servletResponse.setStatus(e.getStatus().value());
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setStatus(e.getStatus());
        exceptionResponse.setErrorCode(e.getErrorMessage().getCode());
        exceptionResponse.setErrorCodeName(e.getErrorMessage().name());
        exceptionResponse.setErrorDescription(e.getMessage());

        return exceptionResponse;
    }

    @ExceptionHandler(value = {
            MissingServletRequestParameterException.class,
            HttpRequestMethodNotSupportedException.class,
            MethodArgumentTypeMismatchException.class,
            HttpMessageNotReadableException.class,
            FileUploadException.class
    })
    public ExceptionResponse handleRequestError(HttpServletResponse servletResponse, Exception e) {
        log.info(Throwables.getStackTraceAsString(e));
        ExceptionResponse exceptionResponse = this.getExceptionResponse(servletResponse, HttpStatus.BAD_REQUEST, e);
        return exceptionResponse;
    }

    @ExceptionHandler(value = Exception.class)
    public ExceptionResponse handle(HttpServletResponse servletResponse, Exception e) {
        log.error(Throwables.getStackTraceAsString(e));
        ExceptionResponse exceptionResponse = this.getExceptionResponse(servletResponse, HttpStatus.INTERNAL_SERVER_ERROR, e);

        return exceptionResponse;
    }

    private ExceptionResponse getExceptionResponse(HttpServletResponse response, HttpStatus status, Exception e) {
        response.setStatus(status.value());
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setStatus(status);
        return exceptionResponse;
    }
}

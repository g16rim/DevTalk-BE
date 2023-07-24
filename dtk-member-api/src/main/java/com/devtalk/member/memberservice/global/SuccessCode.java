package com.devtalk.member.memberservice.global;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@Getter
public enum SuccessCode {

    CHECK_EMAIL_DUPLICATION_SUCCESS(OK, "0115", "사용 가능한 이메일입니다."),
    CONSULTER_SIGNUP_SUCCESS(CREATED, "0111", "멘티 회원가입 성공"),
    CONSULTANT_SIGNUP_SUCCESS(CREATED, "0113", "전문가 회원가입 성공");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    SuccessCode(final HttpStatus httpStatus, final String code, final String message) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
    }
}

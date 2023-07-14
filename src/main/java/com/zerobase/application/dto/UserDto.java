package com.zerobase.application.dto;

import com.zerobase.domain.RoleType;
import com.zerobase.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class UserDto {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Request{

        private Long idx;

        @Pattern(regexp = "^[ㄱ-ㅎ가-힣a-z0-9-_]{4,20}$", message = "아이디는 특수문자를 제외한 4~20자리여야 합니다.")
        @NotBlank(message = "아이디는 필수 입력 값입니다.")
        private String user_id;

        @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,16}", message = "비밀번호는 8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.")
        private String password;

        @Pattern(regexp = "^[ㄱ-ㅎ가-힣a-zA-Z0-9-_]{2,10}$", message = "이름은 2~10자리여야 합니다.")
//        @NotBlank(message = "닉네임은 필수 입력 값입니다.")
        private String username;

        @Pattern(regexp = "^(?:\\w+\\.?)*\\w+@(?:\\w+\\.)+\\w+$", message = "전화번호 형식이 올바르지 않습니다.")
        @NotBlank(message = "전화번호는 필수 입력 값입니다.")
        private String phoneNumber;

        private RoleType rating;

        //Dto->Entity
        public User toEntity(){
            User user = User.builder()
                    .idx(idx)
                    .user_id(user_id)
                    .password(password)
                    .username(username)
                    .phoneNumber(phoneNumber)
                    .rating(rating.USER)
                    .build();
        }
    }
}

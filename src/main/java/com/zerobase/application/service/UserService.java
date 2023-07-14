package com.zerobase.application.service;

import com.zerobase.application.dto.UserDto;
import com.zerobase.domain.User;
import com.zerobase.infrastructure.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class UserService {

    private final BCryptPasswordEncoder encoder;
    private final UserRepository userRepository;

    //회원가입
    @Transactional
    public void userJoin(UserDto.Request dto) {

        dto.setPassword(encoder.encode(dto.getPassword()));

        userRepository.save(dto.toEntity());
    }

    //회원가입-유효성 중복성 체크
    @Transactional(readOnly = true)
    public Map<String, String> validateHandling(Errors errors) {
        Map<String, String> validatorResult = new HashMap<>();

        /* 유효성 검사, 중복 검사에 실패한 필드 목록을 받음 */
        for (FieldError error : errors.getFieldErrors()) {
            String validKeyName = String.format("valid_%s", error.getField());
            validatorResult.put(validKeyName, error.getDefaultMessage());
        }
        return validatorResult;
    }

    //회원권한수정
    @Transactional
    public void modify(UserDto.Request dto){
        User user = userRepository.findById(dto)
    }

}

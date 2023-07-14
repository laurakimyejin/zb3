package com.zerobase.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RoleType {

    USER('0'),
    ADMIN('1');

    private final char value;

}

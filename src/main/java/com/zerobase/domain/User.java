package com.zerobase.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(nullable = false, length = 40, unique = true)
    private String user_id;

    @Column(nullable = true, length = 40)
    private String username;

    @Column(nullable = false, length = 60)
    private String password;

    @Column(nullable = false, length = 60)
    private String phoneNumber;

    @Column(nullable = false, length = 1)
    @Enumerated(EnumType.STRING)
    private char rating;

    //회원정보 수정
    public void modify(char rating){
        this.rating = rating;
    }
}

package com.zerobase.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
public class Voicedata {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 40, nullable = false)
    private String audio_file;

    @Lob
    private String content;

    @Column
    private String declaration;

    @Column
    private char disdata;

    @Column
    private char reroll;

    @Column
    private char mfcc;

    @Column
    private LocalDate created_date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public void update(char disdata){
        this.disdata = disdata;
    }
}

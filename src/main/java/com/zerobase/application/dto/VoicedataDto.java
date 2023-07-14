package com.zerobase.application.dto;

import com.zerobase.domain.User;
import com.zerobase.domain.Voicedata;
import lombok.*;

import java.time.LocalDate;

public class VoicedataDto {

    @Builder
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Request{

        private Long id;
        private String audio_file;
        private String content;
        private String declaration;
        private char disdata;//판별
        private char reroll;//재학습
        private char mfcc;//변조
        private LocalDate created_date;
        private User user;

        /*Dto->entity*/
        public Voicedata toEntity(){
            Voicedata voicedata = Voicedata.builder()
                    .id(id)
                    .audio_file(audio_file)
                    .content(content)
                    .declaration(declaration)
                    .disdata(disdata)
                    .reroll(reroll)
                    .mfcc(mfcc)
                    .user(user)
                    .build();

            return voicedata;
        }
    }

//    //보이스 게시물 정보 응답 할 response class
//    데이터를 dto로 변환하여 응답
//    별도의 전달 객체를 활용해 연관관계를 맺은 엔티티간 무한참조 방지

    @Getter
    public static class Response{
        private final Long id;
        private final String audio_file;
        private final String content;
        private final String declaration;
        private final char disdata;//판별
        private final char reroll;//재학습
        private final char mfcc;//변조
        private final LocalDate created_date;
        private final Long userId;

        //Entity->Dto
        public Response(Voicedata voicedata){
            this.id=voicedata.getId();
            this.audio_file=voicedata.getAudio_file();
            this.content= voicedata.getContent();
            this.declaration=voicedata.getDeclaration();
            this.disdata=voicedata.getDisdata();
            this.reroll=voicedata.getReroll();
            this.mfcc=voicedata.getMfcc();
            this.created_date=voicedata.getCreated_date();
            this.userId=voicedata.getUser().getId();
        }
    }
}

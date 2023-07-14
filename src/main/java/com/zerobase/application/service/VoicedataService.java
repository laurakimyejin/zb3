package com.zerobase.application.service;

import com.zerobase.application.dto.VoicedataDto;
import com.zerobase.domain.Voicedata;
import com.zerobase.infrastructure.repository.VoicedataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class VoicedataService {

    private final VoicedataRepository voicedataRepository;

    //create

    //update
    @Transactional
    public void update(Long id, VoicedataDto.Request dto){
        Voicedata voicedata = voicedataRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("rrrr id=" + id));

        voicedata.update(dto.getDisdata());
    }

    //delete

    //viewcount

    //paging and sort
    @Transactional(readOnly = true)
    public Page<Voicedata> pageList(Pagable pageable) {
        return voicedataRepository.findAll(pageable);
    }

    //search
    @Transactional(readOnly = true)
    public Page<Voicedata> search(String keyword, Pageable pageable){
        Page<Voicedata> voicedataList = voicedataRepository.findByDeclaration(keyword, pageable);
        return voicedataList;
    }

}

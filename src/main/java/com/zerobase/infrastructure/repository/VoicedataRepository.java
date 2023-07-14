package com.zerobase.infrastructure.repository;

import com.zerobase.domain.Voicedata;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface VoicedataRepository extends JpaRepository<Voicedata, Long> {

    Page<Voicedata> findByDeclaration(Pageable pageable);
    Page<Voicedata> findAllWithUser(Pageable pageable);
}

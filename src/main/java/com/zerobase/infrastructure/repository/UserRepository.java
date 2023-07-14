package com.zerobase.infrastructure.repository;

import com.zerobase.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {


}

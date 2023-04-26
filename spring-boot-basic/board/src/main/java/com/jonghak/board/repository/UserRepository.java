package com.jonghak.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jonghak.board.entity.UserEntity;

//JpaRepository<엔티티, 해당 데이터베이스 기본키 타입>
public interface UserRepository extends JpaRepository<UserEntity, String> {
    public boolean existsByEmail(String email);

    public boolean existsByNickname(String nickname);

    public boolean existsByPhoneNumber(String phoneNumber);

}

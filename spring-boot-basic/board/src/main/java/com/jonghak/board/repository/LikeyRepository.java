package com.jonghak.board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jonghak.board.entity.LikeyEntity;
import com.jonghak.board.entity.primaryKey.LikeyPK;

@Repository
public interface LikeyRepository extends JpaRepository<LikeyEntity, LikeyPK> {
    List<LikeyEntity> findByBoardNumber(int boardNumber);
}

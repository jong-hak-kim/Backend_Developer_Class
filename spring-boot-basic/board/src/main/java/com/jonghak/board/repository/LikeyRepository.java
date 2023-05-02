package com.jonghak.board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jonghak.board.entity.LikeyEntity;
import com.jonghak.board.entity.primaryKey.LikeyPK;

@Repository
public interface LikeyRepository extends JpaRepository<LikeyEntity, LikeyPK> {
    List<LikeyEntity> findByBoardNumber(int boardNumber);

    @Transactional //Delete할 시 트랜잭션 처리를 가능하게 하는 것
    void deleteByBoardNumber(int boardNumber);
}

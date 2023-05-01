package com.jonghak.board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jonghak.board.entity.CommentEntity;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Integer> {
    List<CommentEntity> findByBoardNumber(int boardNumber);
}

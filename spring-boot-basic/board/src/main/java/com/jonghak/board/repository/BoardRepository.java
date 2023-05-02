package com.jonghak.board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jonghak.board.entity.BoardEntity;
import com.jonghak.board.entity.resultSet.BoardListResultSet;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {

    public BoardEntity findByBoardNumber(int boardNumber);

    @Query( // 띄어쓰기까지 가져오기 맨 마지막 SELECT 구문 뒤에는 띄어쓰기 필요
            value = "SELECT " +
                    "B.board_number AS boardNumber," +
                    "B.title AS boardTitle," +
                    "B.content AS boardContent," +
                    "B.board_image_url AS boardImageUrl," +
                    "B.write_datetime AS boardWriteDatetime," +
                    "B.view_count AS viewCount," +
                    "U.email AS boardWriterEmail," +
                    "U.nickname AS boardWriterNickname," +
                    "U.profile_image_url AS boardWriterProfileImageUrl," +
                    "count(DISTINCT C.comment_number) AS CommentCount," +
                    "count(DISTINCT L.user_email) AS likeCount " +
                    "FROM Board B, Comment C, Likey L, User U " +
                    "WHERE B.board_number = C.board_number " +
                    "AND B.board_number = L.board_number " +
                    "AND B.writer_email = U.email " +
                    "GROUP BY B.board_number " +
                    "ORDER BY boardWriteDatetime DESC", nativeQuery = true)

    public List<BoardListResultSet> getList();

    @Query( // @ 절이 끝나는 지점에는 띄어쓰기를 해줘야 한다
            value = "SELECT " +
                    "B.board_number AS boardNumber," +
                    "B.title AS boardTitle," +
                    "B.content AS boardContent," +
                    "B.board_image_url AS boardImageUrl," +
                    "B.write_datetime AS boardWriteDatetime," +
                    "B.view_count AS viewCount," +
                    "U.email AS boardWriterEmail," +
                    "U.nickname AS boardWriterNickname," +
                    "U.profile_image_url AS boardWriterProfileImageUrl," +
                    "count(DISTINCT C.comment_number) AS CommentCount," +
                    "count(DISTINCT L.user_email) AS likeCount " +
                    "FROM Board B, Comment C, Likey L, User U " +
                    "WHERE B.board_number = C.board_number " +
                    "AND B.board_number = L.board_number " +
                    "AND B.writer_email = U.email " +
                    "GROUP BY B.board_number " +
                    "ORDER BY likeCount DESC " +
                    "LIMIT 3", nativeQuery = true)

    public List<BoardListResultSet> getTop3List();
}

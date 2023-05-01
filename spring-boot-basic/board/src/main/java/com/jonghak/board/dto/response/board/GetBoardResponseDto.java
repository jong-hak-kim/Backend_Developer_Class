package com.jonghak.board.dto.response.board;

import java.util.ArrayList;
import java.util.List;

import com.jonghak.board.dto.response.ResponseDto;
import com.jonghak.board.entity.BoardEntity;
import com.jonghak.board.entity.CommentEntity;
import com.jonghak.board.entity.LikeyEntity;
import com.jonghak.board.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetBoardResponseDto extends ResponseDto {
    private int boardNumber;
    private String boardTitle;
    private String boardContent;
    private String boardImageUrl;
    private String boardWriteDatetime;
    private int viewCount;
    private String boardWriterEmail;
    private String boardWriterNickname;
    private String boardWriterProfileImageUrl;
    private List<Comment> commentList;
    private List<Likey> likeyList;

    public GetBoardResponseDto(
            BoardEntity boardEntity, UserEntity userEntity, List<CommentEntity> commentEntities,
            List<LikeyEntity> likeyEntities) {
        super("SU", "Success");

        this.boardNumber = boardEntity.getBoardNumber();
        this.boardTitle = boardEntity.getTitle();
        this.boardContent = boardEntity.getContent();
        this.boardImageUrl = boardEntity.getBoardImageUrl();
        this.boardWriteDatetime = boardEntity.getWriteDatetime();
        this.viewCount = boardEntity.getViewCount();
        this.boardWriterEmail = userEntity.getEmail();
        this.boardWriterNickname = userEntity.getNickname();
        this.boardWriterProfileImageUrl = userEntity.getProfileImageUrl();
        this.commentList = Comment.createList(commentEntities);
        this.likeyList = Likey.createList(likeyEntities);

    }
}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class Comment {
    private int commentNumber;
    private int boardNumber;
    private String commentWriterEmail;
    private String commentContent;
    private String commentWriterNickname;
    private String commentWriterProfileImageUrl;
    private String commentWriteDatetime;

    Comment(CommentEntity commentEntity) {
        this.commentNumber = commentEntity.getCommentNumber();
        this.boardNumber = commentEntity.getBoardNumber();
        this.commentWriterEmail = commentEntity.getUserEmail();
        this.commentContent = commentEntity.getCommentContent();
        this.commentWriterNickname = commentEntity.getUserNickname();
        this.commentWriterProfileImageUrl = commentEntity.getUserProfileImageUrl();
        this.commentWriteDatetime = commentEntity.getWriteDatetime();

    }

    static List<Comment> createList(List<CommentEntity> commentEntities) {
        List<Comment> commentList = new ArrayList<>();
        for (CommentEntity commentEntity : commentEntities) {
            Comment comment = new Comment(commentEntity);
            commentList.add(comment);
        }
        return commentList;
    }
}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class Likey {
    private int boardNumber;
    private String userEmail;
    private String userNickname;
    private String userProfileImageUrl;

    Likey(LikeyEntity likeyEntity) {
        this.boardNumber = likeyEntity.getBoardNumber();
        this.userEmail = likeyEntity.getUserEmail();
        this.userNickname = likeyEntity.getUserNickname();
        this.userProfileImageUrl = likeyEntity.getUserProfileImageUrl();
    }

    static List<Likey> createList(List<LikeyEntity> likeyEntities) {
        List<Likey> likeyList = new ArrayList<>();
        for (LikeyEntity likeyEntity : likeyEntities) {
            Likey likey = new Likey(likeyEntity);
            likeyList.add(likey);
        }
        return likeyList;
    }
}

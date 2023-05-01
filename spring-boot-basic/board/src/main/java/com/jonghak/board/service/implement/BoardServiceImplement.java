package com.jonghak.board.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jonghak.board.common.util.CustomResponse;
import com.jonghak.board.dto.request.board.PatchBoardRequestDto;
import com.jonghak.board.dto.request.board.PostBoardRequestDto;
import com.jonghak.board.dto.response.ResponseDto;
import com.jonghak.board.dto.response.board.GetBoardListResponseDto;
import com.jonghak.board.dto.response.board.GetBoardResponseDto;
import com.jonghak.board.entity.BoardEntity;
import com.jonghak.board.entity.CommentEntity;
import com.jonghak.board.entity.LikeyEntity;
import com.jonghak.board.entity.UserEntity;
import com.jonghak.board.repository.BoardRepository;
import com.jonghak.board.repository.CommentRepository;
import com.jonghak.board.repository.LikeyRepository;
import com.jonghak.board.repository.UserRepository;
import com.jonghak.board.service.BoardService;

@Service
public class BoardServiceImplement implements BoardService {

    private UserRepository userRepository;
    private BoardRepository boardRepository;
    private CommentRepository commentRepository;
    private LikeyRepository likeyRepository;

    @Autowired
    public BoardServiceImplement(UserRepository userRepository, BoardRepository boardRepository) {
        this.userRepository = userRepository;
        this.boardRepository = boardRepository;
        this.commentRepository = commentRepository;
        this.likeyRepository = likeyRepository;
    }

    @Override
    public ResponseEntity<ResponseDto> postBoard(PostBoardRequestDto dto) {
        ResponseDto body = null;

        String boardWriterEmail = dto.getBoaredWriterEmail();

        try {
            // @ TODO : 존재하지 않는 유저 오류 반환
            boolean existedUserEmail = userRepository.existsByEmail(boardWriterEmail);
            if (!existedUserEmail) {
                ResponseDto errorbody = new ResponseDto("NU", "Non-Existent User Email");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorbody);
            }

            BoardEntity boardEntity = new BoardEntity(dto);
            boardRepository.save(boardEntity);

            body = new ResponseDto("SU", "Success");

        } catch (Exception exception) {
            // TODO : 데이터베이스 오류 반환
            exception.printStackTrace();
            ResponseDto errorbody = new ResponseDto("DE", "Database Error");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorbody);
        }
        // TODO : 성공 반환
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }

    @Override
    public ResponseEntity<? super GetBoardResponseDto> getBoard(Integer boardNumber) {
        GetBoardResponseDto body = null;
        ResponseDto errorBody = null;
        try {
            if (boardNumber == null) {
                return CustomResponse.vaildationFailed();
            }

            BoardEntity boardEntity = boardRepository.findByBoardNumber(boardNumber);
            if (boardEntity == null) {
                return CustomResponse.notExistBoardNumber();
            }
            int viewCount = boardEntity.getViewCount();
            boardEntity.setViewCount(++viewCount);
            boardRepository.save(boardEntity);
            String boardWriterEmail = boardEntity.getWriterEmail();
            UserEntity userEntity = userRepository.findByEmail(boardWriterEmail);

            List<CommentEntity> commentEntities = commentRepository.findByBoardNumber(boardNumber);
            List<LikeyEntity> likeyEntities = likeyRepository.findByBoardNumber(boardNumber);

            body = new GetBoardResponseDto(boardEntity, userEntity, commentEntities, likeyEntities);

        } catch (Exception exception) {
            exception.printStackTrace();
            return CustomResponse.databaseError();
        }

        return ResponseEntity.status(HttpStatus.OK).body(body);

    }

    @Override
    public ResponseEntity<? super GetBoardListResponseDto> getBoardlist() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBoardlist'");
    }

    @Override
    public ResponseEntity<? super GetBoardListResponseDto> getBoardTop3() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBoardTop3'");
    }

    @Override
    public ResponseEntity<ResponseDto> patchBoard(PatchBoardRequestDto dto) {

        int boardNumber = dto.getBoardNumber();
        String userEmail = dto.getUserEmail();
        String boardTitle = dto.getBoardTitle();
        String boardContent = dto.getBoardContent();
        String boardImageUrl = dto.getBoardImageUrl();

        try {

            // TODO : 존재하지 않는 게시물 번호 반환
            BoardEntity boardEntity = boardRepository.findByBoardNumber(boardNumber);
            if (boardEntity == null) {
                return CustomResponse.notExistBoardNumber();
            }
            // TODO : 존재하지 않는 유저 이메일 반환
            boolean existedUserEmail = userRepository.existsByEmail(userEmail);
            if (!existedUserEmail) {
                return CustomResponse.notExistUserEmail();
            }

            // TODO : 권한 없음
            boolean equalWriter = boardEntity.getWriterEmail().equals(userEmail);
            if (!equalWriter) {
                return CustomResponse.noPermissions();
            }

            boardEntity.setTitle(boardTitle);
            boardEntity.setContent(boardContent);
            boardEntity.setBoardImageUrl(boardImageUrl);

            boardRepository.save(boardEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return CustomResponse.databaseError();
        }
        return CustomResponse.success();
    }

    @Override
    public ResponseEntity<ResponseDto> deleteBoard(String userEmail, Integer boardNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteBoard'");
    }

}

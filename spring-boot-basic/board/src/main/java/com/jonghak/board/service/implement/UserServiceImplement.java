package com.jonghak.board.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jonghak.board.dto.request.user.PostUserRequestDto;
import com.jonghak.board.dto.response.ResponseDto;
import com.jonghak.board.entity.UserEntity;
import com.jonghak.board.repository.UserRepository;
import com.jonghak.board.service.UserService;

@Service
public class UserServiceImplement implements UserService {

    public UserRepository userRepository;

    @Autowired
    public UserServiceImplement(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<ResponseDto> postUser(PostUserRequestDto dto) {

        ResponseDto responseBody = null;

        String email = dto.getUserEmail();
        String nickname = dto.getUserNickname();
        String phoneNumber = dto.getUserPhoneNumber();

        try {
            // @ TODO: 이메일 중복 반환
            boolean hasEamil = userRepository.existsByEmail(email);
            if (hasEamil) {
                responseBody = new ResponseDto("EU", "Existent User Email");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
            }
            // @ TODO: 닉네임 중복 반환
            boolean hasNickname = userRepository.existsByNickname(nickname);
            if (hasNickname) {
                responseBody = new ResponseDto("EN", "Existent User Nickname");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
            }
            // @ TODO: 휴대전화번호 중복 반환
            boolean hasPhoneNumber = userRepository.existsByPhoneNumber(phoneNumber);
            if (hasPhoneNumber) {
                responseBody = new ResponseDto("EP", "Existent User Phone Number");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
            }
            

            // @ 유저 레코드 삽입
            UserEntity userEntity = new UserEntity(dto);
            userRepository.save(userEntity);

            responseBody = new ResponseDto("SU", "Success");

        } catch (Exception exception) {
            // TODO: 데이터베이스 오류 반환
            exception.printStackTrace();
            responseBody = new ResponseDto("DE", "Database Error");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
        }

        // TODO: 성공 반환
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}

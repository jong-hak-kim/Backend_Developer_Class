package com.jonghak.board.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jonghak.board.common.util.CustomResponse;
import com.jonghak.board.dto.request.auth.SignInRequestDto;
import com.jonghak.board.dto.request.auth.SignUpRequestDto;
import com.jonghak.board.dto.response.ResponseDto;
import com.jonghak.board.dto.response.auth.SignInResponseDto;
import com.jonghak.board.entity.UserEntity;
import com.jonghak.board.provider.JwtProvider;
import com.jonghak.board.repository.UserRepository;
import com.jonghak.board.service.AuthService;

@Service
public class AuthServiceImplement implements AuthService {

    private UserRepository userRepository;
    private JwtProvider jwtProvider;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public AuthServiceImplement(UserRepository userRepository, JwtProvider jwtProvider) { // @ 제어 역전은 UserRepository에서만 할 것이다
        this.userRepository = userRepository;
        this.jwtProvider = jwtProvider;
        this.passwordEncoder = new BCryptPasswordEncoder(); // @ password 인터페이스에서 BCryptPasswordEncoder 사용
    }

    @Override
    public ResponseEntity<ResponseDto> signUp(SignUpRequestDto dto) { // @ API 명세서에서 에러보면서 작성

        String email = dto.getUserEmail();
        String nickname = dto.getUserNickname();
        String phoneNumber = dto.getUserPhoneNumber();
        String password = dto.getUserPassword();

        try {

            // @ TODO: 존재하는 유저 이메일 반환
            boolean existedUserEmail = userRepository.existsByEmail(email);
            if (existedUserEmail)
                return CustomResponse.ExistUserEmail();
            // @ TODO: 존재하는 유저 닉네임 반환
            boolean existedUserNickname = userRepository.existsByNickname(nickname);
            if (existedUserNickname)
                return CustomResponse.ExistUserNickname();

            // @ TODO: 존재하는 휴대폰 번호 반환
            boolean existedUserPhoneNumber = userRepository.existsByPhoneNumber(phoneNumber);
            if (existedUserPhoneNumber)
                return CustomResponse.ExistUserPhoneNumber();

            String encodedPassword = passwordEncoder.encode(password);
            dto.setUserPassword(encodedPassword); // @ 패스워드 암호화

            UserEntity userEntity = new UserEntity(dto);
            userRepository.save(userEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return CustomResponse.databaseError();
        }
        return CustomResponse.success();
    }

    @Override
    public ResponseEntity<? super SignInResponseDto> signIn(SignInRequestDto dto) {

        SignInResponseDto body = null;
        String email = dto.getUserEmail();
        String password = dto.getUserPassword();
        try {
            // @ TODO: 로그인 실패 (이메일 X)
            UserEntity userEntity = userRepository.findByEmail(email);
            if (userEntity == null)
                return CustomResponse.signInFailed();

            // @ TODO: 로그인 실패 (패스워드 X)
            String encodedPassword = userEntity.getPassword();
            boolean equaledPassword = passwordEncoder.matches(password, encodedPassword); // @ passwordEncoder.matches(사용자가 입력한 패스워드, 암호화된 패스워드)
            if (!equaledPassword)
                return CustomResponse.signInFailed();

            //@ 토큰 생성
            String jwt = jwtProvider.create(email);
            body = new SignInResponseDto(jwt); 

        }
        catch (Exception exception) {
            exception.printStackTrace();
            return CustomResponse.databaseError();
        }

        return ResponseEntity.status(HttpStatus.OK).body(body);

    }

}

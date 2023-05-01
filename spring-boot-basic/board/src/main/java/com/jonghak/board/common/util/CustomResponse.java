package com.jonghak.board.common.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jonghak.board.dto.response.ResponseDto;

public class CustomResponse {
    public static ResponseEntity<ResponseDto> success() {
        ResponseDto body = new ResponseDto("SU", "SUCCESS");
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }

    public static ResponseEntity<ResponseDto> databaseError() {
        ResponseDto errorBody = new ResponseDto("DE", "Database Error");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorBody);
    }

    public static ResponseEntity<ResponseDto> vaildationFailed() {
        ResponseDto errorBody = new ResponseDto("VF", "Request Parameter Validation Failed");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorBody);
    }

    public static ResponseEntity<ResponseDto> notExistBoardNumber() {
        ResponseDto errorBody = new ResponseDto("NB", "Non_Existent Board Number");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorBody);
    }

    public static ResponseEntity<ResponseDto> notExistUserEmail() {
        ResponseDto errorBody = new ResponseDto("NU", "Non_Existent User Email");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorBody);
    }

    public static ResponseEntity<ResponseDto> noPermissions() {
        ResponseDto errorBody = new ResponseDto("NP", "No Permissions");
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(errorBody);
    }
}

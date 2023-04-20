package com.jonghak.firstproject.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

class ParamDto {
    private String data1;
    private String data2;

    public void setData1(String data1) {
        this.data1 = data1;
    }

    public void setData2(String data2) {
        this.data2 = data2;
    }

    public String getData1() {
        return this.data1;
    }

    public String getData2() {
        return this.data2;
    }
}

// Rest API를 위한 Controller임을 명시해주는 어노테이션
// @Controller + @ResponseBody = @RestController
// Response는 HTML을 제외한 MIME type을 반환
@RestController
// URL path 패턴을 지정해서 해당 패턴이면 지정한 클래스를 처리하도록 함
@RequestMapping(value = "api")
public class RestApiController {

    @RequestMapping(method = { RequestMethod.GET }, value = "hello2")
    public String hello2() {
        return "hello2";
    }

    // # GET Method @GetMapping
    // @ GET Method : 클라이언트가 서버에게 데이터를 받기 위한 요청의 Method
    // * @RequestMapping(method = RequestMethod.GET, value="get-method")
    @GetMapping("get-method")
    public String getMethod() {
        return "Response of Get Request";
    }

    // # Post Method @PostMapping
    // @ Post Method : 클라이언트가 서버에 데이터를 작성하기 위한 요청의 Method
    // * @RequestMapping(method = RequestMethod.POST, value="post-method")
    @PostMapping("post-method")
    public String postMethod() {
        return "Response of Post Request";
    }

    // # Patch Method @PatchMapping
    // @ Patch Method : 클라이언트가 서버에 데이터를 일부만 수정하기 위한 요청의 Method
    // * @RequestMapping(method = RequestMethod.PATCH, value="patch-method")
    @PatchMapping("patch-method")
    public String patchMethod() {
        return "Response of Patch Request";
    }

    // # Delete Method @DeleteMapping
    // @ Delete Method : 클라이언트가 서버에 데이터를 삭제하기 위한 요청의 Method
    // * @RequestMapping(method = RequestMethod.DELETE, value="patch-method")
    @DeleteMapping("delete-method")
    public String deleteMethod() {
        return "Response of Delete Request";
    }

    // # PathVariable() 로 Get, Delete Method에서 데이터 받기
    // @ 리소스에 지정한 패턴에 맞춰서 요청 URL을 지정한다면 패턴에 맞춰 데이터를 받아오는 형식
    @GetMapping({ "path-variable/{data1}", "path-variable/{data1}/{data2}" })
    public String pathVariable(
            @PathVariable("data1") String dataA,
            @PathVariable(value = "data2", required = false) String dataB) {
        return dataA + dataB + " 데이터를 입력받았습니다.";
    }

    // # @RequestParam로 Get, Delete Method에서 데이터 받기
    // @ 완전 path 뒤에 ?name=value[&...] 형식에 맞춰 name에 해당하는 value를 받아오는 형식
    // @GetMapping("request-param")
    // public String requestParam(ParamDto dto) {
    // return dto.getData1() + dto.getData2() + " 데이터를 입력받았습니다.";
    // }

    @GetMapping("request-param")
    public String requestParam(
            @RequestParam String data1,
            @RequestParam String data2

    ) {
        return data1 + data2 + " 데이터를 입력받았습니다.";
    }

    // # @RequestBody로 Post, Put, Patch Method에서 데이터 받기
    // @ Request Body에 있는 데이터를 받기 위한 어노테이션
    @PostMapping("request-body")
    public ResponseEntity<ParamDto> requestBody(
            // @RequestBody String data
            @RequestBody ParamDto dto) {
        return ResponseEntity.status(408).body(dto);
    }

}

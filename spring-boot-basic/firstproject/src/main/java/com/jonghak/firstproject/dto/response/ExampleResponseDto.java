package com.jonghak.firstproject.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor // 모든 변수를 매개변수로 하는 생성자를 만들어주는 어노테이션
@Builder
@ToString
public class ExampleResponseDto {
    private String data1;
    private String data2;
    private String data3;
}

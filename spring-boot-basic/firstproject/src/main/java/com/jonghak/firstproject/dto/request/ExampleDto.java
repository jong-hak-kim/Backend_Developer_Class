package com.jonghak.firstproject.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class ExampleDto {
    @NotBlank
    private String parameter1;
    @Length(min = 0, max = 20)
    private String parameter2;
    private String parameter3;

}

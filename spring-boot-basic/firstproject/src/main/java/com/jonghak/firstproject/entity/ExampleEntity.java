package com.jonghak.firstproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Example")
@Table(name = "Example")
public class ExampleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "example_column1", nullable = false, unique = true)
    private int pk; //멤버 변수의 이름은 컬럼명을 따라가주는 것이 좋다
    private String exampleColumn2;
    private boolean exampleColumn3;
}

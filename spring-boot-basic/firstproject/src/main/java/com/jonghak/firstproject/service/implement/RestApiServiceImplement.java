package com.jonghak.firstproject.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jonghak.firstproject.entity.ExampleEntity;
import com.jonghak.firstproject.repository.ExampleRepository;
import com.jonghak.firstproject.service.RestApiService;

@Service
public class RestApiServiceImplement implements RestApiService {

    private ExampleRepository exampleRepository;

    @Autowired
    public RestApiServiceImplement(ExampleRepository exampleRepository) {
        this.exampleRepository = exampleRepository;
    }

    public String postMethod() {
        //* 데이터 삽입 */
        //* 1. Entity 인스턴스 ( = 데이터베이스 테이블의 레코드 ) 생성 */
        ExampleEntity exampleEntity = 
            ExampleEntity.builder()
            .exampleColumn2("string1")
            .exampleColumn3(false)
            .build();

        //* 2. Repository를 거쳐서 Entity 인스턴스를 저장 */
        exampleRepository.save(exampleEntity);
        
        return null;
    }
    
    public String getMethod() {
        //* 데이터 조회 */
        //* 1. JpaRepository에 있는 findBy 메서드로 Entity 조회 */
        // ExampleEntity exampleEntity = exampleRepository.findById(1).get();
        ExampleEntity exampleEntity = exampleRepository.findByPk(1);


        return exampleEntity == null ? "null" : exampleEntity.toString();
    }

    public String patchMethod() {
        //* 데이터 수정 */
        //* 1. 특정 조건으로 Entity 조회 */
        ExampleEntity exampleEntity = exampleRepository.findById(1).get();

        //* 2. 데이터 수정 */
        exampleEntity.setExampleColumn2("string2");
        
        //* 3. Entity 인스턴스 저장 */
        exampleRepository.save(exampleEntity);

        //* 1. Entity 인스턴스 생성 */
        ExampleEntity exampleEntity2 = 
            new ExampleEntity(2, "string3", true);
        //* 2. Entity 인스턴스 저장 */
        exampleRepository.save(exampleEntity2);

        return null;
    }

    public String deleteMethod() {
        //* 데이터 삭제 */
        //* 1. JpaRepository에 있는 deleteBy 메서드로 Entity 삭제 */
        exampleRepository.deleteById(1);
        return null;
    }

}
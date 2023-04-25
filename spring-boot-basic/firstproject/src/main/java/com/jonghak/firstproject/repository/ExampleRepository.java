package com.jonghak.firstproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jonghak.firstproject.entity.ExampleEntity;

@Repository
public interface ExampleRepository extends JpaRepository<ExampleEntity, Integer> {
    public ExampleEntity findByPk(int pk);

    //findBy뒤에 컬럼명을 적을 때 틀리지 않도록 주의
    public List<ExampleEntity> findByExampleColumn3AndExampleColumn2(boolean exampleColumn3, String exampleColumn2);
    
    

    //해당 조건에 따라서 레코드가 존재하는지 안 하는지 반환
    public boolean existsByExampleColumn3(boolean exampleColumn3);
}

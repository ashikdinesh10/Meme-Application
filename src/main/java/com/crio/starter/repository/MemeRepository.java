package com.crio.starter.repository;

import com.crio.starter.data.MemeEntity;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemeRepository extends MongoRepository<MemeEntity, Long> {

  MemeEntity findById(long id);

  List<MemeEntity> findAll();
}

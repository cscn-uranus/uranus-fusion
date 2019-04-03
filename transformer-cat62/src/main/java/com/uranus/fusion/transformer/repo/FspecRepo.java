package com.uranus.fusion.transformer.repo;

import com.uranus.fusion.transformer.entity.Cat62Probe;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FspecRepo extends MongoRepository<Cat62Probe,String> {

}

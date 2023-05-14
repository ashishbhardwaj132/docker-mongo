package com.roopali.dockermongo.dao;

import com.roopali.dockermongo.domain.Tutorial;
import org.springframework.stereotype.Repository;

public interface MongoRepositoryDao extends org.springframework.data.mongodb.repository.MongoRepository<Tutorial, String> {
    // Repository
}

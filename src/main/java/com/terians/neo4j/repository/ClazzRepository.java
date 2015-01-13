package com.terians.neo4j.repository;

import com.terians.neo4j.model.Clazz;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by stromero on 1/4/2015.
 */
@Repository
public interface ClazzRepository extends GraphRepository<Clazz> {

}

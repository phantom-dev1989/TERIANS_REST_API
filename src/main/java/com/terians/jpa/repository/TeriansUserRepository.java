package com.terians.jpa.repository;

import com.terians.jpa.model.TeriansUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
 * Created by stromero on 9/21/2014.
 */
@Repository
public interface TeriansUserRepository extends CrudRepository<TeriansUser, Long> {

    public TeriansUser findByUsername(String name);

    public TeriansUser save(TeriansUser user);
}

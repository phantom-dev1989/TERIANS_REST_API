package com.terians.jpa.service;

import com.terians.jpa.repository.TeriansUserRepository;
import com.terians.jpa.model.TeriansUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by stromero on 12/2/2014.
 */
@Service
@Transactional
public class TeriansUserServiceImpl implements TeriansUserService {

    @Autowired
    private TeriansUserRepository repository;

    @Override
    public TeriansUser findByUsername(String name) {
        return repository.findByUsername(name);
    }

    @Override
    public TeriansUser save(TeriansUser user) {
        return repository.save(user);
    }
}

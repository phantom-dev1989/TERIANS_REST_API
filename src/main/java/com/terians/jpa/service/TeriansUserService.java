package com.terians.jpa.service;

import com.terians.jpa.model.TeriansUser;

/**
 * Created by stromero on 12/2/2014.
 */
public interface TeriansUserService {

    public TeriansUser findByUsername(String name);

    public TeriansUser save(TeriansUser user);
}

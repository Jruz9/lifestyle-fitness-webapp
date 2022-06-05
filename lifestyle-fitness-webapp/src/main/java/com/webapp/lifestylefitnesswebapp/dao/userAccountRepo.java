package com.webapp.lifestylefitnesswebapp.dao;

import com.webapp.lifestylefitnesswebapp.entities.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface userAccountRepo extends PagingAndSortingRepository<User, Long> {


}

package com.crudExample.crud.dao;

import com.crudExample.crud.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}

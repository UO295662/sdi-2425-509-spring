package com.uniovi.sdi2425509spring.repositories;

import com.uniovi.sdi2425509spring.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<User, Long> {
}

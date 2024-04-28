package com.fareieumesmo.site.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fareieumesmo.site.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
  Optional<User> findByName(String name);
}

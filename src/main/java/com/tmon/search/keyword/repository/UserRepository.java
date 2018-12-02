package com.tmon.search.keyword.repository;

import com.tmon.search.keyword.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.Nullable;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
public interface UserRepository extends CrudRepository<User, Integer> {
    @Nullable
    User findByUsername(String username);
}

package com.sigap.SIGAP.authentication.repository;

import com.sigap.SIGAP.authentication.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository <UserEntity, Long> {

    Optional<UserEntity> findUserEntityByUsername(String username);


}

package com.mgmnt.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mgmnt.crud.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {


}

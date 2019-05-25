package com.paf.assignment.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paf.assignment.model.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}

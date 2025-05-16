package com.example.gestao.carros.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gestao.carros.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	   Optional<User> findByEmail(String email);

}

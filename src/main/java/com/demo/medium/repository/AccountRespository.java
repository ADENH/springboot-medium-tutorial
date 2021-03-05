package com.demo.medium.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.medium.model.entity.Account;

@Repository
public interface AccountRespository extends JpaRepository<Account, String> {

	Optional<Account> findByUsername(String username);

}

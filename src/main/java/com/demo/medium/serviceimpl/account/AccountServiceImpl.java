package com.demo.medium.serviceimpl.account;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.demo.medium.config.ConstantUtil;
import com.demo.medium.dto.AccountDto;
import com.demo.medium.model.entity.Account;
import com.demo.medium.model.entity.Position;
import com.demo.medium.repository.AccountRespository;
import com.demo.medium.repository.PositionRepository;
import com.demo.medium.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	AccountRespository accountRepository;
	
	@Autowired
	private PositionRepository positionRepository;
	
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public Account findByUsername(String username) {
		return accountRepository.findByUsername(username).orElseThrow(() -> new NoSuchElementException(ConstantUtil.DATA_TIDAK_DITEMUKAN));
	}

	@Override
	public List<Account> findAll() {
		return accountRepository.findAll();
	}

	@Override
	public Account add(AccountDto accountDto) {
		String password = bCryptPasswordEncoder.encode(accountDto.getPassword());
		accountDto.setPassword(password);
		
		Position position = positionRepository.findByCode(accountDto.getPositionCode()).orElseThrow(() -> new NoSuchElementException(ConstantUtil.DATA_TIDAK_DITEMUKAN));

		Account dataUser = new Account();
		dataUser.setEmail(accountDto.getEmail());
		dataUser.setFirstName(accountDto.getFirstName());
		dataUser.setLastName(accountDto.getLastName());
		dataUser.setPassword(accountDto.getPassword());
		dataUser.setUsername(accountDto.getUserName());
		dataUser.setPosition(position);
		
		String id = Optional.of(accountRepository.save(dataUser)).map(v -> v.getId()).orElseThrow(() -> new NoSuchElementException(ConstantUtil.DATA_TIDAK_DITEMUKAN));
		return accountRepository.findById(id).orElseThrow(() -> new NoSuchElementException(ConstantUtil.DATA_TIDAK_DITEMUKAN));
	}
	
	

	@Override
	public Account getCurrentUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			return findByUsername(auth.getName());
		}
		return null;
	}

}

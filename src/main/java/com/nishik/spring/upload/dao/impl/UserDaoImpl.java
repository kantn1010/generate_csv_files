package com.nishik.spring.upload.dao.impl;

import java.util.Optional;

import com.nishik.spring.upload.entity.UserLoginAccess;
import com.nishik.spring.upload.jpaRepo.userRepo.UserRepository;

public class UserDaoImpl implements UserRepository{

	@Override
	public <S extends UserLoginAccess> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends UserLoginAccess> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<UserLoginAccess> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<UserLoginAccess> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<UserLoginAccess> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UserLoginAccess entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends UserLoginAccess> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserLoginAccess getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}

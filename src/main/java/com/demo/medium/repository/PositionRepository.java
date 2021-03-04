package com.demo.medium.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.medium.model.entity.Position;

@Repository
public interface PositionRepository extends JpaRepository<Position, Integer> {
	Optional<Position> findByCode(String code);
	List<Position> findByIsDelete(Integer isDelete);
}

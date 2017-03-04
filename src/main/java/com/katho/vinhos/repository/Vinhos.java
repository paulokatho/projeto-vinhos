package com.katho.vinhos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.katho.vinhos.model.Vinho;

public interface Vinhos extends JpaRepository<Vinho, Long>{

	public List<Vinho> findByNomeContainingIgnoreCase(String nome);
	
}

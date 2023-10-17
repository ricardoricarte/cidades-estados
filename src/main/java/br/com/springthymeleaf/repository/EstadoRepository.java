package br.com.springthymeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.springthymeleaf.model.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Long>{
  
}

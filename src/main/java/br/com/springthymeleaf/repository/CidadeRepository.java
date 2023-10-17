package br.com.springthymeleaf.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.springthymeleaf.model.Cidade;
import br.com.springthymeleaf.model.Estado;

public interface CidadeRepository extends JpaRepository<Cidade, Long>{

  List<Cidade> findByEstado(Estado estado);
  
}

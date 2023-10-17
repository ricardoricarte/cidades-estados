package br.com.springthymeleaf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.springthymeleaf.model.Cidade;
import br.com.springthymeleaf.model.Estado;
import br.com.springthymeleaf.repository.CidadeRepository;
import br.com.springthymeleaf.repository.EstadoRepository;

@Controller
public class CidadeController {

  @Autowired
  private EstadoRepository estadoRepository;

  @Autowired
  private CidadeRepository cidadeRepository;

  @GetMapping("/")
  public String index(Model model) {
    model.addAttribute("estados", estadoRepository.findAll());
    model.addAttribute("estado", new Estado()); 
    model.addAttribute("cidade", new Cidade()); 
    return "index";
  }

  @GetMapping("/cidades/{estadoId}")
  public ResponseEntity<List<Cidade>> buscarCidadesPorEstado(@PathVariable Long estadoId) {
    Estado estado = estadoRepository.findById(estadoId).orElse(null);
    if (estado != null) {
      List<Cidade> cidades = cidadeRepository.findByEstado(estado);
      return ResponseEntity.ok(cidades);
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}
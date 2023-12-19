package br.com.resily.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.resily.model.MensagemUsuario;
import br.com.resily.model.PsicologoModel;
import br.com.resily.service.PsicologoServices;


@RestController
@CrossOrigin(origins = "*")
public class PsicologoController {

  @Autowired
  private PsicologoServices ps;

  @DeleteMapping("/removerPsicologos/{idPsicologo}")
  public ResponseEntity<MensagemUsuario> removerPsicologos(@PathVariable int idPsicologo) {
    return ps.remover(idPsicologo);
  }

  @PutMapping("/alterarPsicologos")
  public ResponseEntity<?> alterarPsicologos(@RequestBody PsicologoModel pm) {
    return ps.cadastrarAlterar(pm, "alterarPsicologos");
  }

  @PostMapping("/cadastrarPsicologos")
  public ResponseEntity<?> cadastrarPsicologos(@RequestBody PsicologoModel pm) {
    return ps.cadastrarAlterar(pm, "cadastrarPsicologos");
  }

  @GetMapping("/listarPsicologos")
  private Iterable<PsicologoModel> listar() {
    return ps.listar();
  }

 
}

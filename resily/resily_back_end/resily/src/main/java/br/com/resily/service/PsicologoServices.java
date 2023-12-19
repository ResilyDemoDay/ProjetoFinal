package br.com.resily.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.resily.model.MensagemUsuario;
import br.com.resily.model.PsicologoModel;
import br.com.resily.repository.PsicologoRepository;


@Service
public class PsicologoServices {

  @Autowired
  private PsicologoRepository pr;

  @Autowired
  private MensagemUsuario respostaModelo;

  // metodo para listar todos os psicologos

  public Iterable<PsicologoModel> listar() {
    return pr.findAll();
  }

  // metodo para cadastrar ou alterar psicologos
  public ResponseEntity<?> cadastrarAlterar(PsicologoModel pm, String acao) {

    if (pm.getNomePsicologos().equals("")) {
      respostaModelo.setMensagem("o nome é obrigatório");
      return new ResponseEntity<MensagemUsuario>(respostaModelo, HttpStatus.BAD_REQUEST);
    } else if (pm.getEmailPsicologos().equals("")) {
      respostaModelo.setMensagem("o email é obrigatório");
      return new ResponseEntity<MensagemUsuario>(respostaModelo, HttpStatus.BAD_REQUEST);
    } else if (pm.getEmailPsicologos().equals("")) {
      respostaModelo.setMensagem("o email é obrigatório");
      return new ResponseEntity<MensagemUsuario>(respostaModelo, HttpStatus.BAD_REQUEST);
    } else if (pm.getCpfPsicologos().equals("")) {
      respostaModelo.setMensagem("o cpf é obrigatório");
      return new ResponseEntity<MensagemUsuario>(respostaModelo, HttpStatus.BAD_REQUEST);
    } else if (pm.getCrpPsicologos().equals("")) {
      respostaModelo.setMensagem("o crp é obrigatório");
      return new ResponseEntity<MensagemUsuario>(respostaModelo, HttpStatus.BAD_REQUEST);
    } else if (pm.getSenhaPsicologos().equals("")) {
      respostaModelo.setMensagem("o senha é obrigatório");
      return new ResponseEntity<MensagemUsuario>(respostaModelo, HttpStatus.BAD_REQUEST);
    } else if (pm.getTelefonePsicologos().equals("")) {
      respostaModelo.setMensagem("o telefone é obrigatório");
      return new ResponseEntity<MensagemUsuario>(respostaModelo, HttpStatus.BAD_REQUEST);
    } else if (pm.getRgPsicologos().equals("")) {
      respostaModelo.setMensagem("o RG é obrigatório");
      return new ResponseEntity<MensagemUsuario>(respostaModelo, HttpStatus.BAD_REQUEST);
    } else {
      if (acao.equals("cadastrar")) {
        return new ResponseEntity<PsicologoModel>(pr.save(pm), HttpStatus.CREATED);
      } else {
        return new ResponseEntity<PsicologoModel>(pr.save(pm), HttpStatus.OK);
      }
    }
  }

  // metodo para remover psicologo

  public ResponseEntity<MensagemUsuario> remover(int idPsicologo) {
    pr.deleteById(idPsicologo);
    respostaModelo.setMensagem("o produto foi removido");
    return new ResponseEntity<MensagemUsuario>(respostaModelo, HttpStatus.OK);
  }

}

package br.com.resily.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.resily.model.MensagemUsuario;
import br.com.resily.model.PsicologoModel;
import br.com.resily.repository.PsicologoRepository;



@Controller
@CrossOrigin(origins = "*")
public class PsicologoLoginController {

     //Verifica se os dados existem na nossa tabela
    @Autowired
    private PsicologoRepository repo;

    @Autowired
    private MensagemUsuario respostaModelo;


    @GetMapping("/loginPsicologo")
    public String index(){
        return "";
    }
   @PostMapping("/logarPsicologo")
    public String logar(String emailPsicologo, String senhaPsicologo){
        PsicologoModel psico = this.repo.LoginPsico(emailPsicologo, senhaPsicologo);
        if( psico != null){
            return "redirecet:/";
        }
        respostaModelo.setMensagem("Usuário ou senha inválidos");
        return "";
    }
}


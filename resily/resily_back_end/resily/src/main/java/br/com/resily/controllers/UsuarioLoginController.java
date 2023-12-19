package br.com.resily.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.resily.model.MensagemUsuario;
import br.com.resily.model.Usuario;
import br.com.resily.repository.UsuarioRepository;

@Controller
@CrossOrigin(origins = "*")
public class UsuarioLoginController {

    //Verifica se os dados existem na nossa tabela
    @Autowired
    private UsuarioRepository repo;

    @Autowired
    private MensagemUsuario respostaModelo;
   

    //Vai passar o caminho para o frontend
    @GetMapping("/login")
    public String index(){
        return "";
    }

    //o Método para receber o email de Usuário e senha
    @PostMapping("/logar")
    public String logar(String emailUsuario, String senhaUsuario){
        Usuario user = this.repo.Login(emailUsuario, senhaUsuario);
        if( user != null){
            return "LOGADO!";
            
        }
        respostaModelo.setMensagem("Usuário ou senha inválidos");
        return "";
    }
}

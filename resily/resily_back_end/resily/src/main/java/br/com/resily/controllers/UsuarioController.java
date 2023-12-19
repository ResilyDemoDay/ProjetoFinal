package br.com.resily.controllers;

import org.springframework.web.bind.annotation.RestController;

import br.com.resily.model.MensagemUsuario;
import br.com.resily.model.Usuario;
import br.com.resily.service.UsuarioService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

//@RequestMapping("/usuario")
@RestController
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private UsuarioService us;

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody Usuario usuarioModelo){
        us.cadastrarAlterar(usuarioModelo, "cadastrar");
        return ResponseEntity.ok(usuarioModelo);
    }
    
    @PutMapping("/alterar")
    public ResponseEntity<?> alterar(@RequestBody Usuario usuarioModelo){
        return us.cadastrarAlterar(usuarioModelo,"alterar");
    }

    @DeleteMapping("/remover/{idUsuario}")
    public ResponseEntity<MensagemUsuario> remover(@PathVariable int idUsuario){
        return us.remover(idUsuario);
    }

    @GetMapping("/")
    public String rota() {
        return "O servidor está funcionando";
    }

    @GetMapping("/listar")
    public Iterable<Usuario> listar() {
        return us.listar();
    }
}
// @RestController
// @CrossOrigin(origins = "*")
// public class UsuarioController {

// @Autowired
// private UsuarioService us;

// @GetMapping("/listar")
// public Iterable<UsuarioModelo> listar(){
// return us.listar();
// }
// @GetMapping("/")
// public String rota(){
// return "API de usuarios Funcionando";
// }
// }
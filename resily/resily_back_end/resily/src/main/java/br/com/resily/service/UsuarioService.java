package br.com.resily.service;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.resily.model.Usuario;
import br.com.resily.model.MensagemUsuario;
import br.com.resily.repository.UsuarioRepository;

    @Service
    public class UsuarioService {

        @Autowired
        private UsuarioRepository ur;

        @Autowired
        private MensagemUsuario respostaModelo;

        //Método para listar os usuários
        public Iterable<Usuario> listar() {
            return ur.findAll();
        }

        

        // Método para cadastrar ou alterar usuários
        public ResponseEntity<?> cadastrarAlterar(Usuario usuarioModelo,String acao){
            if(usuarioModelo.getNomeUsuario() == "" ){
                respostaModelo.setMensagem("O nome de usuária é obrigatório!");
                return new ResponseEntity<MensagemUsuario>(respostaModelo,HttpStatus.BAD_REQUEST);
            } else if(usuarioModelo.getEmailUsuario() == ""){
                respostaModelo.setMensagem("O email é obrigatório!");
                return new ResponseEntity<MensagemUsuario>(respostaModelo,HttpStatus.BAD_REQUEST);
            } else if(usuarioModelo.getSenhaUsuario() == ""){
                respostaModelo.setMensagem("A senha é obrigatória!");
                return new ResponseEntity<MensagemUsuario>(respostaModelo,HttpStatus.BAD_REQUEST);
            }else{
                if(acao.equals("cadastrar")){
                    return new ResponseEntity<Usuario>(ur.save(usuarioModelo),HttpStatus.CREATED);
                
                }else {

                    return new ResponseEntity<Usuario>(ur.save(usuarioModelo),HttpStatus.OK);
                    
                }
            }

        }

        // public Usuario cadastrar(Usuario usuarioModelo) {
        //     // System.out.println(usuarioModelo);
        //     ur.save(usuarioModelo);
        //     return usuarioModelo;
        // }



        //Método para remover um usuário
        public ResponseEntity<MensagemUsuario> remover(int idUsuario){

            ur.deleteById(idUsuario);

            respostaModelo.setMensagem("Sua conta foi removida!");

            return new ResponseEntity<MensagemUsuario>(respostaModelo,HttpStatus.OK);

        }





    }

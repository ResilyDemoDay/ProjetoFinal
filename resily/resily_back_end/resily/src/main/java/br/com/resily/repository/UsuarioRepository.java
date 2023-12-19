package br.com.resily.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.resily.model.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
@Query(value="select * from tb_Usuarios where emailUsuario = :emailUsuario and senhaUsuario = :senhaUsuario", nativeQuery = true)
public Usuario Login(String emailUsuario, String senhaUsuario);


}

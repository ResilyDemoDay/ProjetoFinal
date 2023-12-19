package br.com.resily.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.resily.model.PsicologoModel;
import br.com.resily.model.Usuario;



@Repository

public interface PsicologoRepository extends CrudRepository<PsicologoModel, Integer> {
    @Query(value="select * from tb_Psicologos where emailPsicologos = :emailPsicologos and senhaPsicologos = :senhaPsicologos", nativeQuery = true)
    public PsicologoModel LoginPsico(String emailPsicologos, String senhaPsicologos);
}

package br.com.resily.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tbPsicologos")
@Getter
@Setter
public class PsicologoModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int idPsicologos;

  private String nomePsicologos;
  private String emailPsicologos;
  private String crpPsicologos;
  private String rgPsicologos;
  private String cpfPsicologos;
  private String senhaPsicologos;
  private String telefonePsicologos;

}

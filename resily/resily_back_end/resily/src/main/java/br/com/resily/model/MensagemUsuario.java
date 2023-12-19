package br.com.resily.model;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class MensagemUsuario {
    private String mensagem;
}

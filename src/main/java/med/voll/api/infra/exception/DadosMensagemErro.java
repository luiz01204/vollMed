package med.voll.api.infra.exception;

import org.springframework.validation.FieldError;

import java.lang.reflect.Field;

public record DadosMensagemErro(String campo, String mensagem) {
    public  DadosMensagemErro(FieldError erro){
        this(erro.getField(), erro.getDefaultMessage());
    }
}

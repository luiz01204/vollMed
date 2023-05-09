package med.voll.api.domain.paciente;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.endereco.Endereco;

public record DadosPaciente(
        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String telefone,
        @NotBlank
        @Pattern(regexp = "\\d{11}")
        String cpf,
        @NotNull
        @Valid
        Endereco endereco
) {
}
/*
Modelo Json:
{
"nome": "Luiz Machado",
"email": "luiz.machado@voll.med",
"telefone": "48991107709",
"cpf": "22233344401",
"endereco": {
    "logradouro": "rua 2",
    "bairro": "Ana Maria",
    "cep": "88815320",
    "cidade": "Criciúma",
    "uf": "SC",
    "numero": "347",
    "complemento": "Fundos casa verde"
    }
}
*/
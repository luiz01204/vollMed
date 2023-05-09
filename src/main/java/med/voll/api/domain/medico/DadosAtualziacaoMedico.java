package med.voll.api.domain.medico;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.endereco.DadosEndereco;

public record DadosAtualziacaoMedico(
        @NotNull // Notblank serve apenas para string.
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco
){
}
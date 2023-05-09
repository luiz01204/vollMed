package med.voll.api.domain.medico;

public record DadosListagemMedico(
        Long id,
        String nome,
        String email,
        String telefone,
        String crm,
        String especialidade,
        boolean ativo
) {

    public DadosListagemMedico(Medico medico){
        this(medico.getId(),medico.getNome(),medico.getEmail(),medico.getTelefone(),
                medico.getCrm(), String.valueOf(medico.getEspecialidade()),
                medico.isAtivo());
    }
}

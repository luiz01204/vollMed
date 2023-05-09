package med.voll.api.domain.medico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.domain.endereco.Endereco;

@Table(name = "medicos") // passando nome da tabela do banco.
@Entity(name = "Medico") // sinalziando que essa classe é uma entidade.
@Getter // lombok: ggerar por baixo dos panos todos os getters.
@NoArgsConstructor // lombok: ggerar por baixo dos panos contrutor defaut, exigencia da JPA.
@AllArgsConstructor // lombok: ggerar por baixo dos panos contrutor com todos os atributos.
@EqualsAndHashCode(of = "id") // lombok: gera um equals passando um atributo.
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
    @Embedded // associa esse atributo a classe Endereco dentro da tabela médicos.
    private Endereco endereco;
    private boolean ativo;

    public Medico(DadosMedico dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
        this.endereco = new Endereco(dados.endereco());
        this.ativo = true;
    }

    public void atualizaInformacoes(DadosAtualziacaoMedico dados){
        if (dados.nome() != null) {

            this.nome = dados.nome();
        }

        if (dados.telefone() != null){
            this.telefone = dados.telefone();
        }

        if (dados.endereco() != null){
            this.endereco.atualziaDados(dados.endereco());
        }
    }

    public void inativar(){
        this.ativo = false;
    }
}

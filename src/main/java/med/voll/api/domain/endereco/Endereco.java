package med.voll.api.domain.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable // associa essa classa a tabela médicos.
@Getter // lombok: ggerar por baixo dos panos todos os getters.
@NoArgsConstructor // lombok: ggerar por baixo dos panos contrutor defaut, exigencia da JPA.
@AllArgsConstructor // lombok: ggerar por baixo dos panos contrutor com todos os atributos.
public class Endereco {
    private String logradouro;
    private String bairro;
    private String cep;
    private String cidade;
    private String uf;
    private String numero;
    private String complemento;

    public Endereco(DadosEndereco dados){
        this.logradouro = dados.logradouro();
        this.bairro = dados.logradouro();
        this.cep = dados.cep();
        this.cidade = dados.cidade();
        this.numero = dados.numero();
        this.complemento = dados.complemento();
        this.uf = dados.uf();
    }

    public void atualziaDados(DadosEndereco dados) {
        if (dados.logradouro() != null){
            this.logradouro = dados.logradouro();
        }
        if (dados.bairro() != null){
            this.bairro = dados.bairro();
        }
        if (dados.cep() != null){
            this.cep = dados.cep();
        }
        if (dados.cidade() != null){
            this.cidade = dados.cidade();
        }
        if (dados.numero() != null){
            this.numero = dados.numero();
        }
        if (dados.complemento() != null){
            this.complemento = dados.complemento();
        }
        if (dados.uf() != null){
            this.uf = dados.uf();
        }
    }
}

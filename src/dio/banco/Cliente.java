package dio.banco;

import lombok.Getter;

@Getter
public class Cliente {

    private String nome;

    public void setNome(String nome) {
        this.nome = nome;
    }
}

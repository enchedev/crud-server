package br.edu.ifpr.crud.modelo;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZonedDateTime;

@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class PessoaFisica extends Pessoa {

    protected String cpf;

    public PessoaFisica(String cpf, String nome, ZonedDateTime nascimento, Endereco endereco) {
        super(nome, nascimento, endereco);
        this.cpf = cpf;
    }

    public static PessoaFisica make() {
        return new PessoaFisica();
    }

    public PessoaFisica withCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public PessoaFisica withNome(String nome) {
        this.nome = nome;
        return this;
    }

    public PessoaFisica withEndereco(String rua, Integer numero, String bairro, String cidade, String estado, String cep) {
        this.endereco = new Endereco(rua, numero, bairro, cidade, estado, cep);
        return this;
    }
}

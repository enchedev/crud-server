package br.edu.ifpr.crud.modelo;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZonedDateTime;

@Getter
@EqualsAndHashCode(callSuper = true)
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PessoaJuridica extends Pessoa {

    protected String cnpj;
    protected String nomeFantasia;

    public PessoaJuridica(String cnpj, String nomeFantasia, String nome, ZonedDateTime nascimento, Endereco endereco) {
        super(nome, nascimento, endereco);
        this.cnpj = cnpj;
        this.nomeFantasia = nomeFantasia;
    }

    public static PessoaJuridica make() {
        return new PessoaJuridica();
    }

    public PessoaJuridica withCnpj(String cnpj) {
        this.cnpj = cnpj;
        return this;
    }

    public PessoaJuridica withNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
        return this;
    }

    public PessoaJuridica withNome(String nome) {
        this.nome = nome;
        return this;
    }

    public PessoaJuridica withEndereco(String nomeRua, Integer numero, String bairro, String cidade, String estado, String cep) {
        this.endereco = new Endereco(nomeRua, numero, bairro, cidade, estado, cep);
        return this;
    }

}

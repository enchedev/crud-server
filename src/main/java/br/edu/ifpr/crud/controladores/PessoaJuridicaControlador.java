package br.edu.ifpr.crud.controladores;

import br.edu.ifpr.crud.modelo.PessoaJuridica;
import br.edu.ifpr.crud.repositorios.PessoaJuridicaRepositorio;
import br.edu.ifpr.yuru.HttpRequest;

import java.util.List;
import java.util.UUID;

public class PessoaJuridicaControlador {

    final PessoaJuridicaRepositorio repositorio = new PessoaJuridicaRepositorio();

    public List<PessoaJuridica> listar(HttpRequest request) {
        return repositorio.listar(request.getQueryParams());
    }

    public PessoaJuridica buscar(HttpRequest request) {
        return repositorio.buscar(UUID.fromString(request.getPathParam("id")));
    }

    public Void excluir(HttpRequest request) {
        return repositorio.excluir(UUID.fromString(request.getPathParam("id")));
    }

    public Void salvar(HttpRequest request) {
        return repositorio.salvar((PessoaJuridica)request.getBody());
    }

    public Void atualizar(HttpRequest request) {
        return repositorio.atualizar(UUID.fromString(request.getPathParam("id")), (PessoaJuridica)request.getBody());
    }

}

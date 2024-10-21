package br.edu.ifpr.crud.controladores;

import br.edu.ifpr.crud.modelo.PessoaFisica;
import br.edu.ifpr.crud.repositorios.PessoaFisicaRepositorio;
import br.edu.ifpr.web.HttpRequest;

import java.util.List;
import java.util.UUID;

public class PessoaFisicaControlador {

    final PessoaFisicaRepositorio repositorio = new PessoaFisicaRepositorio();

    public List<PessoaFisica> listar(HttpRequest request) {
        return repositorio.listar(request.getQueryParams());
    }

    public PessoaFisica buscar(HttpRequest request) {
        return repositorio.buscar(UUID.fromString(request.getPathParam("id")));
    }

    public Void excluir(HttpRequest request) {
        return repositorio.excluir(UUID.fromString(request.getPathParam("id")));
    }

    public Void salvar(HttpRequest request) {
        return repositorio.salvar((PessoaFisica)request.getBody());
    }

    public Void atualizar(HttpRequest request) {
        return repositorio.atualizar(UUID.fromString(request.getPathParam("id")), (PessoaFisica)request.getBody());
    }

}

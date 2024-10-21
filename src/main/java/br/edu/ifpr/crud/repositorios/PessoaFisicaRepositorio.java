package br.edu.ifpr.crud.repositorios;

import br.edu.ifpr.crud.modelo.PessoaFisica;
import br.edu.ifpr.crud.modelo.persistencia.PessoaFisicaPersistencia;
import br.edu.ifpr.persistence.core.Query;
import br.edu.ifpr.web.core.QueryParameter;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class PessoaFisicaRepositorio {

    static final PessoaFisicaPersistencia persistencia = new PessoaFisicaPersistencia();

    private Query<PessoaFisica> tratarParametrosDePesquisa(Query<PessoaFisica> query, Map<String, QueryParameter> params) {
        if (params.containsKey("nome"))
            query = query.is(nome -> nome.toUpperCase().contains(params.get("nome").getValue().toUpperCase()), PessoaFisica::getNome);
        if (params.containsKey("cpf"))
            query = query.is(nome -> nome.equals(params.get("cpf").getValue()), PessoaFisica::getCpf);
        return query;
    }

    public List<PessoaFisica> listar(Map<String, QueryParameter> queryParams) {
        return
            persistencia
                .select(ctx -> ctx
                    .where(query ->
                        tratarParametrosDePesquisa(query, queryParams)
                    )
                )
                .getAll();
    }

    public PessoaFisica buscar(UUID id) {
        return
            persistencia.
                select(ctx -> ctx.
                    whereThen(p -> p.getId().equals(id))
                )
                .getSingle()
                .orElseThrow(() -> new RuntimeException("Entity does not exist"))
            ;
    }

    public Void excluir(UUID id) {
        persistencia.delete(id);
        return null;
    }

    public Void atualizar(UUID id, PessoaFisica pessoaFisica) {
        persistencia.update(id, pessoaFisica);
        return null;
    }

    public Void salvar(PessoaFisica pessoaFisica) {
        persistencia.insert(pessoaFisica);
        return null;
    }

}

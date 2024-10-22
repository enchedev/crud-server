package br.edu.ifpr.crud.repositorios;

import br.edu.ifpr.crud.modelo.PessoaJuridica;
import br.edu.ifpr.crud.modelo.persistencia.PessoaJuridicaPersistencia;
import br.edu.ifpr.uruy.core.Query;
import br.edu.ifpr.yuru.core.QueryParameter;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class PessoaJuridicaRepositorio {

    static final PessoaJuridicaPersistencia persistencia = new PessoaJuridicaPersistencia();

    private Query<PessoaJuridica> tratarParametrosDePesquisa(Query<PessoaJuridica> query, Map<String, QueryParameter> params) {
        if (params.containsKey("nome"))
            query = query.is(nome -> nome.toUpperCase().contains(params.get("nome").getValue().toUpperCase()), PessoaJuridica::getNome);
        if (params.containsKey("cnpj"))
            query = query.is(nome -> nome.equals(params.get("cnpj").getValue()), PessoaJuridica::getCnpj);
        return query;
    }

    public List<PessoaJuridica> listar(Map<String, QueryParameter> queryParams) {
        return
            persistencia
                .select(ctx -> ctx
                    .where(query ->
                        tratarParametrosDePesquisa(query, queryParams)
                    )
                )
                .getAll()
            ;
    }

    public PessoaJuridica buscar(UUID id) {
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

    public Void atualizar(UUID id, PessoaJuridica pessoaJuridica) {
        persistencia.update(id, pessoaJuridica);
        return null;
    }

    public Void salvar(PessoaJuridica pessoaJuridica) {
        persistencia.insert(pessoaJuridica);
        return null;
    }

}

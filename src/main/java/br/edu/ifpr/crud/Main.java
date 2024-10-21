package br.edu.ifpr.crud;

import br.edu.ifpr.crud.controladores.PessoaFisicaControlador;
import br.edu.ifpr.crud.controladores.PessoaJuridicaControlador;
import br.edu.ifpr.crud.modelo.PessoaFisica;
import br.edu.ifpr.crud.modelo.PessoaJuridica;
import br.edu.ifpr.web.HttpRouter;
import br.edu.ifpr.web.enums.HttpMethod;

public class Main {

    public static void main(String[] args) {
        HttpRouter router = new HttpRouter();

        router.registerRouter(PessoaFisicaControlador.class, "/v1/pessoas-fisicas", HttpMethod.GET, PessoaFisicaControlador::listar);
        router.registerRouter(PessoaFisicaControlador.class, "/v1/pessoas-fisicas/{id}", HttpMethod.GET, PessoaFisicaControlador::buscar);
        router.registerRouter(PessoaFisicaControlador.class, "/v1/pessoas-fisicas/{id}", HttpMethod.DELETE, PessoaFisicaControlador::excluir);
        router.registerRouter(PessoaFisicaControlador.class, "/v1/pessoas-fisicas", HttpMethod.POST, PessoaFisica.class, PessoaFisicaControlador::salvar);
        router.registerRouter(PessoaFisicaControlador.class, "/v1/pessoas-fisicas/{id}", HttpMethod.PATCH, PessoaFisica.class, PessoaFisicaControlador::atualizar);

        router.registerRouter(PessoaJuridicaControlador.class, "/v1/pessoas-juridicas", HttpMethod.GET, PessoaJuridicaControlador::listar);
        router.registerRouter(PessoaJuridicaControlador.class, "/v1/pessoas-juridicas/{id}", HttpMethod.GET, PessoaJuridicaControlador::buscar);
        router.registerRouter(PessoaJuridicaControlador.class, "/v1/pessoas-juridicas/{id}", HttpMethod.DELETE, PessoaJuridicaControlador::excluir);
        router.registerRouter(PessoaJuridicaControlador.class, "/v1/pessoas-juridicas", HttpMethod.POST, PessoaJuridica.class, PessoaJuridicaControlador::salvar);
        router.registerRouter(PessoaJuridicaControlador.class, "/v1/pessoas-juridicas/{id}", HttpMethod.PATCH, PessoaJuridica.class, PessoaJuridicaControlador::atualizar);

        router.routeAll();
    }

}

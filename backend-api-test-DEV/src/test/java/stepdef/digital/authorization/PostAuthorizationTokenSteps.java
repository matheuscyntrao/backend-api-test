package stepdef.digital.authorization;

import entity.digital.authentication.UsuarioLoginEntity;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.digital.authorization.response.PostAuthorizationTokenResponse_v1;
import queries.digital.authentication.UsuariosLoginQuerie;
import service.digital.authorization.Authorizationv1;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.List;
import java.util.Map;

public class PostAuthorizationTokenSteps {
    @Dado("que possuo dados para Authorization - Token - Login param:")
    public void que_possuo_dados_para_authorization_token_login_param(Map<String, String> dataTable) {
        BuilderRequest.param.accept(Util.rota.apply(Authorizationv1.POST_AUTHORIZATION_TOKEN), dataTable);
    }

    @Dado("que possuo dados para Authorization - Token - Login header:")
    public void que_possuo_dados_para_authorization_token_login_header(Map<String, String> dataTable) {
        Cache.chamadas.get(Util.rota.apply(Authorizationv1.POST_AUTHORIZATION_TOKEN)).getServiceSpecs().header.putAll(dataTable);
    }

    @Quando("executo Authorization - Token - Login")
    public void executo_authorization_token_login() {
        Authorizationv1.postToken.run();
    }

    @Entao("sistema processa Authorization - Token - Login:")
    public void sistema_processa_authorization_token_login(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(Authorizationv1.POST_AUTHORIZATION_TOKEN)).getServiceResponse()
                , PostAuthorizationTokenResponse_v1.class
        );
    }

    @Dado("que efetuo Authorization - Token - Login para {string} e {string}")
    public void que_efetuo_authorization_token_login_para_e(String usuario, String senha) {
        BuilderRequest.param.accept(Util.rota.apply(Authorizationv1.POST_AUTHORIZATION_TOKEN),
                Map.of("grant_type", "password"
                        , "username", usuario
                        , "password", senha
                ));
        Cache.chamadas.get(Util.rota.apply(Authorizationv1.POST_AUTHORIZATION_TOKEN)).getServiceSpecs().header.putAll(
                Map.of("Authorization", "Basic YmZmLWFwcC1wYW52ZWw6WFk3a216b056bDEwMA=="
                        , "app-token", "AswCtrsvwNA4")
        );
        executo_authorization_token_login();
    }

    @Dado("que efetuo Authorization - Token - Login para {string}")
    public void que_efetuo_authorization_token_login_para(String usuario) {
        List<UsuarioLoginEntity> usuarioLoginEntity = UsuariosLoginQuerie.getUsuarios(usuario);
        que_efetuo_authorization_token_login_para_e(usuario, usuarioLoginEntity.get(0).getSenha());
    }

}

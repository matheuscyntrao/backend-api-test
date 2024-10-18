package stepdef.crossover.cliente;

import com.fasterxml.jackson.core.JsonProcessingException;
import dataProvider.domino.OrderGenerate;
import enums.Cliente;
import enums.ClienteContato;
import enums.ClienteEndereco;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.crossover.cliente.request.PostClienteRequest_v2;
import model.crossover.cliente.request.PostClienteRequest_v2_Contatos;
import model.crossover.cliente.request.PostClienteRequest_v2_Enderecos;
import model.crossover.cliente.request.PostClienteRequest_v2_Usuario;
import model.domino.order.request.PostEcommerceOrderRequest_v1;
import service.crossover.cliente.Clientev2;
import utils.CucumberUtils;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;
import utils.service.JsonToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PostCliente_v2Steps {
    @Dado("possuo dados para Cliente - v2 - PostCliente:")
    public void possuo_dados_para_cliente_v2_post_cliente(DataTable dataTable) throws JsonProcessingException {
        BuilderRequest.body.accept(Util.rota.apply(Clientev2.POST_CLIENTES), CucumberUtils.getObjectBody(dataTable, PostClienteRequest_v2.class));
    }

    @Dado("possuo dados para Cliente - v2 - PostCliente contatos:")
    public void possuo_dados_para_cliente_v2_post_cliente_contatos(DataTable dataTable) throws JsonProcessingException {
        PostClienteRequest_v2 input = Cache.chamadas.get(Util.rota.apply(Clientev2.POST_CLIENTES)).getServiceSpecs().getObjectBody(PostClienteRequest_v2.class);
        input.setContatos(Arrays.asList(CucumberUtils.getObjectBody(dataTable, PostClienteRequest_v2_Contatos[].class).clone()));
        Cache.chamadas.get(Util.rota.apply(Clientev2.POST_CLIENTES)).getServiceSpecs().setBody(input);
    }

    @Dado("possuo dados para Cliente - v2 - PostCliente enderecos:")
    public void possuo_dados_para_cliente_v2_post_cliente_enderecos(DataTable dataTable) throws JsonProcessingException {
        PostClienteRequest_v2 input = Cache.chamadas.get(Util.rota.apply(Clientev2.POST_CLIENTES)).getServiceSpecs().getObjectBody(PostClienteRequest_v2.class);
        input.setEnderecos(Arrays.asList(CucumberUtils.getObjectBody(dataTable, PostClienteRequest_v2_Enderecos[].class).clone()));
        Cache.chamadas.get(Util.rota.apply(Clientev2.POST_CLIENTES)).getServiceSpecs().setBody(input);
    }

    @Dado("possuo dados para Cliente - v2 - PostCliente usuario:")
    public void possuo_dados_para_cliente_v2_post_cliente_usuario(DataTable dataTable) throws JsonProcessingException {
        PostClienteRequest_v2 input = Cache.chamadas.get(Util.rota.apply(Clientev2.POST_CLIENTES)).getServiceSpecs().getObjectBody(PostClienteRequest_v2.class);
        input.setUsuario(CucumberUtils.getObjectBody(dataTable, PostClienteRequest_v2_Usuario.class));
        Cache.chamadas.get(Util.rota.apply(Clientev2.POST_CLIENTES)).getServiceSpecs().setBody(input);
    }

    @Quando("executo Cliente - v2 - PostCliente")
    public void executo_cliente_v2_post_cliente() {
        Clientev2.postClientes.run();
    }

    @Entao("sistema processa Cliente - v2 - PostCliente:")
    public void sistema_processa_cliente_v2_post_cliente(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(Clientev2.POST_CLIENTES)).getServiceResponse()
                , String.class
        );
    }

    @Dado("possuo dados para Cliente - v2 - PostCliente generate")
    public void possuo_dados_para_cliente_v2_post_cliente_generate() {
        PostClienteRequest_v2 input = Cliente.CLIENTE_COMPLETO.pojo();
        List<PostClienteRequest_v2_Enderecos> enderecos = new ArrayList<>();
        enderecos.add(ClienteEndereco.ENDERECO_SIMPLES.pojo());
        input.setEnderecos(enderecos);
        List<PostClienteRequest_v2_Contatos> contatos = new ArrayList<>();
        contatos.add(ClienteContato.CONTATO_CELULAR.pojo());
        contatos.add(ClienteContato.CONTATO_EMAIL.pojo());
        input.setContatos(contatos);
        BuilderRequest.body.accept(Util.rota.apply(Clientev2.POST_CLIENTES), input);
    }

    @Dado("efetuo Cliente - v2 - PostCliente generate do tipo {string}")
    public void efetuo_cliente_v2_post_cliente_generate_do_tipo(String string) {
        PostClienteRequest_v2 input = Cliente.valueOf(string).pojo();
        BuilderRequest.body.accept(Util.rota.apply(Clientev2.POST_CLIENTES), input);
        Clientev2.postClientes.run();
        new GetPipClientesCpfCpf_v2Steps().que_efetuo_cliente_v2pip_get_clientes_cpf(input.getCpf());
    }

    @Dado("que crio Cliente - v2 - PostCliente {string}")
    public void que_crio_cliente_v2_post_cliente(String tipoCliente) throws JsonProcessingException {
        BuilderRequest.body.accept(Util.rota.apply(Clientev2.POST_CLIENTES), dataProvider.crossover.Cliente.valueOf(tipoCliente).pojo());
        executo_cliente_v2_post_cliente();
    }
}

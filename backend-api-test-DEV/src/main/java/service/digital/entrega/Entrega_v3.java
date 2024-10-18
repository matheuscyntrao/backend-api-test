package service.digital.entrega;

import utils.Util;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

public interface Entrega_v3 extends ServiceBase {

    String dominio = "/entrega";
    String url = Util.uri.apply("entrega-service") + dominio;
    String GET_ENTREGAS = "Entrega-v3-GetEntregas";
    String POST_ENTREGAS = "Entrega-v3-PostEntregas";
    String GET_ENTREGAS_CONSULTA_VALOR_MINIMO = "Entrega-v3-GetEntregasConsultaValorMinimo";
    String GET_ENTREGAS_ITEM = "Entrega-v3-GetEntregasItem";
    String GET_ENTREGAS_LISTAR_MEIO_ENTREGA = "Entrega-v3-GetEntregasListarMeioEntrega";
    String GET_ENTREGAS_ESTIMATIVA_BY_NUMERO_PEDIDO = "Entrega-v3-GetEntregasEstimativaByNumeroPedido";
    String DELETE_LOCKER_CANCELAR_BY_NUMERO_RESERVA = "Entrega-v3-DeleteLockerCancelarByNumeroReserva";
    String GET_LOCKER_CONSULTA_BY_NUMERO_RESERVA = "Entrega-v3-GetLockerConsultaByNumeroReserva";
    String GET_LOCKER_CONSULTAR_RESERVA = "Entrega-v3-GetLockerConsultarReserva";
    String GET_LOCKER_LISTAR = "Entrega-v3-GetLockerListar";
    String POST_LOCKER_RESERVAR = "Entrega-v3-PostLockerReservar";
    String GET_LOCKER_STATUS_BY_LOCKER_NAME = "Entrega-v3-GetLockerStatusByLockerName";
    String POST_LOCKER_WEBHOOK = "Entrega-v3-GetLockerWebHook";
    String GET_LOCKER_BY_LOCKER_ID = "Entrega-v3-GetLockerByLockerId";
    String GET_PROMOCOES = "Entrega-v3-GetPromocoes";
    String POST_CORREIOS = "Entrega-v3-PostCorreios";

    Runnable getEntregas = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_ENTREGAS)).getServiceSpecs();
        String endpoint = "/v3/entregas";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_ENTREGAS));
    };

    Runnable postEntregas = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_ENTREGAS)).getServiceSpecs();
        String endpoint = "/v3/entregas";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_ENTREGAS));
    };

    Runnable getEntregasConsultaValorMinimo = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_ENTREGAS_CONSULTA_VALOR_MINIMO)).getServiceSpecs();
        String endpoint = "/v3/entregas/consulta/valorMinimo";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_ENTREGAS_CONSULTA_VALOR_MINIMO));
    };

    Runnable getEntregasItem = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_ENTREGAS_ITEM)).getServiceSpecs();
        String endpoint = "/v3/entregas/item";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_ENTREGAS_ITEM));
    };

    Runnable getEntregasListarMeioEntrega = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_ENTREGAS_LISTAR_MEIO_ENTREGA)).getServiceSpecs();
        String endpoint = "/v3/entregas/listar/meio-entrega";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_ENTREGAS_LISTAR_MEIO_ENTREGA));
    };

    Runnable getEntregasListarEstimativaByNumeroPedido = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_ENTREGAS_ESTIMATIVA_BY_NUMERO_PEDIDO)).getServiceSpecs();
        String endpoint = "/v3/entregas/listar/{numeroPedido}/estimativa";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_ENTREGAS_ESTIMATIVA_BY_NUMERO_PEDIDO));
    };

    Runnable deleteLockerCancelarByNumeroReserva = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(DELETE_LOCKER_CANCELAR_BY_NUMERO_RESERVA)).getServiceSpecs();
        String endpoint = "/v3/locker/cancelar/{numeroReserva}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.delete.accept(specs, Util.rota.apply(DELETE_LOCKER_CANCELAR_BY_NUMERO_RESERVA));
    };

    Runnable deleteLockerConsultaByNumeroReserva = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_LOCKER_CONSULTA_BY_NUMERO_RESERVA)).getServiceSpecs();
        String endpoint = "/v3/locker/consulta/{numeroReserva}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_LOCKER_CONSULTA_BY_NUMERO_RESERVA));
    };

    Runnable getLockerConsultaReserva = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_LOCKER_CONSULTAR_RESERVA)).getServiceSpecs();
        String endpoint = "/v3/locker/consulta/reserva";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_LOCKER_CONSULTAR_RESERVA));
    };

    Runnable getLockerListar = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_LOCKER_LISTAR)).getServiceSpecs();
        String endpoint = "/v3/locker/listar";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_LOCKER_LISTAR));
    };

    Runnable postLockerReservar = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_LOCKER_RESERVAR)).getServiceSpecs();
        String endpoint = "/v3/locker/reservar";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_LOCKER_RESERVAR));
    };

    Runnable getLockerStatusByLockerName = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_LOCKER_STATUS_BY_LOCKER_NAME)).getServiceSpecs();
        String endpoint = "/v3/locker/status/{lockerName}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_LOCKER_STATUS_BY_LOCKER_NAME));
    };

    Runnable postLockerWebhook = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_LOCKER_WEBHOOK)).getServiceSpecs();
        String endpoint = "/v3/locker/webhook";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_LOCKER_WEBHOOK));
    };

    Runnable getLockerByLockerId = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_LOCKER_BY_LOCKER_ID)).getServiceSpecs();
        String endpoint = "/v3/locker/{lockerId}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_LOCKER_BY_LOCKER_ID));
    };

    Runnable getPromocoes = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_PROMOCOES)).getServiceSpecs();
        String endpoint = "/v3/promocoes";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_PROMOCOES));
    };

    Runnable postCorreios = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_CORREIOS)).getServiceSpecs();
        String endpoint = "/v3/entregas/correios";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_CORREIOS));
    };
}

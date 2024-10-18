package queries.digital.shipping;

import com.epam.reportportal.service.ReportPortal;
import entity.digital.shipping.*;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import utils.database.BaseQueries;

import java.sql.Date;
import java.time.Instant;
import java.util.List;

public class ItensDaFilial extends BaseQueries {
    public static List<ItemDaFilialEntity> getItensDaFilial(Long code) {
        String SQL = String.format("select codigo_do_item as code\n" +
                "from estoques_do_item \n" +
                "where nvl((quantidade_atual_do_item - nvl(quantidade_parcial_tele,0)),0) > 0\n" +
                "\tand codigo_da_filial = %s\n" +
                "\tand rownum <=50", code.toString());
        List<ItemDaFilialEntity> result = getTemplate().query(SQL, new BeanPropertyRowMapper<>(ItemDaFilialEntity.class));
        ReportPortal.emitLog(result.toString(), "INFO", Date.from(Instant.now()));
        return result;
    }

    public static List<ItemDaFilialEntity> getItemFreteGratisRapida() {
        String SQL = String.format("select distinct eif.id\n" +
                "    ,eifi.codigo_do_item as code\n" +
                "    ,eif.nome_promocao\n" +
                "    ,eif.valor_minimo_pedido\n" +
                "    ,eif.site\n" +
                "    ,eif.app\n" +
                "    ,eif.alo\n" +
                "    ,eif.forma_de_entrega\n" +
                "    ,eif.filial\n" +
                "from proecm.ecm_isencoes_frete eif\n" +
                "    join proecm.ecm_isencoes_frete_itens eifi on eifi.id_isencao_frete = eif.id\n" +
                "    join itens it ON it.codigo_do_item = eifi.codigo_do_item\n" +
                "    where eif.data_inicial <= sysdate\n" +
                "    and nvl(eif.data_final,sysdate) >= sysdate\n" +
                "    and eif.nome_promocao <> 'FRETE_GRATIS_ITENS_PROGRAMADA'");
        List<ItemDaFilialEntity> result = getTemplate().query(SQL, new BeanPropertyRowMapper<>(ItemDaFilialEntity.class));
        ReportPortal.emitLog(result.toString(), "INFO", Date.from(Instant.now()));
        return result;
    }

    public static List<ItemDaFilialEntity> getItemFreteGratisProgramada() {
        String SQL = String.format("select distinct eif.id\n" +
                "    ,eifi.codigo_do_item as code\n" +
                "    ,eif.nome_promocao\n" +
                "    ,eif.valor_minimo_pedido\n" +
                "    ,eif.site\n" +
                "    ,eif.app\n" +
                "    ,eif.alo\n" +
                "    ,eif.forma_de_entrega\n" +
                "    ,eif.filial\n" +
                "from proecm.ecm_isencoes_frete eif\n" +
                "    join proecm.ecm_isencoes_frete_itens eifi on eifi.id_isencao_frete = eif.id\n" +
                "    join itens it ON it.codigo_do_item = eifi.codigo_do_item\n" +
                "    where eif.data_inicial <= sysdate\n" +
                "    and nvl(eif.data_final,sysdate) >= sysdate\n" +
                "    and eif.nome_promocao <> 'FRETE_GRATIS_ITENS'");
        List<ItemDaFilialEntity> result = getTemplate().query(SQL, new BeanPropertyRowMapper<>(ItemDaFilialEntity.class));
        ReportPortal.emitLog(result.toString(), "INFO", Date.from(Instant.now()));
        return result;
    }

    public static List<ItemSemEstoqueFilialTeleEntity> getItensSemEstoqueTele(Long filialTele, Long filialDelivery) {
        String SQL = String.format("select tele.codigo_do_item as code\n" +
                        "\t,tele.codigo_da_filial filial_tele\n" +
                        "\t,nvl((tele.quantidade_atual_do_item - nvl(tele.quantidade_parcial_tele,0)),0) estoque_tele\n" +
                        "\t,delivery.codigo_da_filial filial_delivery\n" +
                        "\t,nvl((delivery.quantidade_atual_do_item - nvl(delivery.quantidade_parcial_tele,0)),0) estoque_delivery\n" +
                        "from estoques_do_item tele\n" +
                        "\t,estoques_do_item delivery\n" +
                        "where tele.codigo_do_item = delivery.codigo_do_item\n" +
                        "\tand nvl((tele.quantidade_atual_do_item - nvl(tele.quantidade_parcial_tele,0)),0) = 0\n" +
                        "\tand nvl((delivery.quantidade_atual_do_item - nvl(delivery.quantidade_parcial_tele,0)),0) > 0\n" +
                        "\tand tele.codigo_da_filial = %s\n" +
                        "\tand delivery.codigo_da_filial = %s\n"
                , filialDelivery.toString()
                , filialTele.toString());
        List<ItemSemEstoqueFilialTeleEntity> result = getTemplate().query(SQL, new BeanPropertyRowMapper<>(ItemSemEstoqueFilialTeleEntity.class));
        ReportPortal.emitLog(result.toString(), "INFO", Date.from(Instant.now()));
        return result;
    }
    public static List<ItemSemEstoqueFilialTeleEntity> getItensEstoqueCD(Long filialTele, Long filialDelivery) {
        String SQL = String.format("select tele.codigo_do_item as code\n" +
                        "\t,tele.codigo_da_filial filial_tele\n" +
                        "\t,nvl((tele.quantidade_atual_do_item - nvl(tele.quantidade_parcial_tele,0)),0) estoque_tele\n" +
                        "\t,delivery.codigo_da_filial filial_delivery\n" +
                        "\t,nvl((delivery.quantidade_atual_do_item - nvl(delivery.quantidade_parcial_tele,0)),0) estoque_delivery\n" +
                        "\t,nvl((pe.quantidade_armazenada - pe.quantidade_reservada - pe.quantidade_bloqueada),0) estoque_cd\n" +
                        "from estoques_do_item tele\n" +
                        "\t,estoques_do_item delivery\n" +
                        "\t,posicoes_de_estoque@comrlink pe\n" +
                        "where tele.codigo_do_item = delivery.codigo_do_item\n" +
                        "\tand tele.codigo_do_item = pe.codigo_do_item\n" +
                        "\tand pe.codigo_do_tipo_de_estoque = 1\n" +
                        "\tand pe.cod_tipo_de_comprometimento = 1\n" +
                        "\tand pe.codigo_da_entidade_comercial = 1017\n" +
                        "\tand nvl((tele.quantidade_atual_do_item - nvl(tele.quantidade_parcial_tele,0)),0) = 0\n" +
                        "\tand nvl((delivery.quantidade_atual_do_item - nvl(delivery.quantidade_parcial_tele,0)),0) = 0\n" +
                        "\tand nvl((pe.quantidade_armazenada - pe.quantidade_reservada - pe.quantidade_bloqueada),0) > 0\n" +
                        "\tand tele.codigo_da_filial = %s\n" +
                        "\tand delivery.codigo_da_filial = %s\n"
                , filialDelivery.toString()
                , filialTele.toString());
        List<ItemSemEstoqueFilialTeleEntity> result = getTemplate().query(SQL, new BeanPropertyRowMapper<>(ItemSemEstoqueFilialTeleEntity.class));
        ReportPortal.emitLog(result.toString(), "INFO", Date.from(Instant.now()));
        return result;
    }
    public static List<ItemSemEstoqueFilialTeleEntity> getDeliveryNaoPermiteCD(Long filialTele, Long filialDelivery) {
        String SQL = String.format("select tele.codigo_do_item as code\n" +
                        "  ,tele.codigo_da_filial filial_tele\n" +
                        "  ,nvl((tele.quantidade_atual_do_item - nvl(tele.quantidade_parcial_tele,0)),0) estoque_tele\n" +
                        "  ,delivery.codigo_da_filial filial_delivery\n" +
                        "  ,nvl(fdelivery.permite_split_pedido,'N') delivery_permite_cd\n" +
                        "  ,nvl((delivery.quantidade_atual_do_item - nvl(delivery.quantidade_parcial_tele,0)),0) estoque_delivery\n" +
                        "  ,nvl((pe.quantidade_armazenada - pe.quantidade_reservada - pe.quantidade_bloqueada),0) estoque_cd\n" +
                        "from estoques_do_item tele\n" +
                        "  ,estoques_do_item delivery\n" +
                        "  ,posicoes_de_estoque@comrlink pe\n" +
                        "  ,alo_filiais fdelivery\n" +
                        "where tele.codigo_do_item = delivery.codigo_do_item\n" +
                        "  and tele.codigo_do_item = pe.codigo_do_item\n" +
                        "  and delivery.codigo_da_filial = fdelivery.codigo_da_filial\n" +
                        "  and pe.codigo_do_tipo_de_estoque = 1\n" +
                        "  and pe.cod_tipo_de_comprometimento = 1\n" +
                        "  and pe.codigo_da_entidade_comercial = 1017\n" +
                        "  and nvl((tele.quantidade_atual_do_item - nvl(tele.quantidade_parcial_tele,0)),0) = 0\n" +
                        "  and nvl((delivery.quantidade_atual_do_item - nvl(delivery.quantidade_parcial_tele,0)),0) = 0\n" +
                        "and nvl((pe.quantidade_armazenada - pe.quantidade_reservada - pe.quantidade_bloqueada),0) > 0\n" +
                        "\tand tele.codigo_da_filial = %s\n" +
                        "\tand delivery.codigo_da_filial = %s\n"
                , filialDelivery.toString()
                , filialTele.toString());
        List<ItemSemEstoqueFilialTeleEntity> result = getTemplate().query(SQL, new BeanPropertyRowMapper<>(ItemSemEstoqueFilialTeleEntity.class));
        ReportPortal.emitLog(result.toString(), "INFO", Date.from(Instant.now()));
        return result;
    }
    public static List<ItemSemEstoqueFilialTeleEntity> getItemSemEstoqueCD(Long filialTele, Long filialDelivery) {
        String SQL = String.format("select tele.codigo_do_item as code\n" +
                        "\t,tele.codigo_da_filial filial_tele\n" +
                        "\t,nvl((tele.quantidade_atual_do_item - nvl(tele.quantidade_parcial_tele,0)),0) estoque_tele\n" +
                        "\t,delivery.codigo_da_filial filial_delivery\n" +
                        "\t,nvl((delivery.quantidade_atual_do_item - nvl(delivery.quantidade_parcial_tele,0)),0) estoque_delivery\n" +
                        "\t,nvl((pe.quantidade_armazenada - pe.quantidade_reservada - pe.quantidade_bloqueada),0) estoque_cd\n" +
                        "from estoques_do_item tele\n" +
                        "\t,estoques_do_item delivery\n" +
                        "\t,posicoes_de_estoque@comrlink pe\n" +
                        "where tele.codigo_do_item = delivery.codigo_do_item\n" +
                        "\tand tele.codigo_do_item = pe.codigo_do_item\n" +
                        "\tand pe.codigo_do_tipo_de_estoque = 1\n" +
                        "\tand pe.cod_tipo_de_comprometimento = 1\n" +
                        "\tand pe.codigo_da_entidade_comercial = 1021\n" +
                        "\tand nvl((tele.quantidade_atual_do_item - nvl(tele.quantidade_parcial_tele,0)),0) = 0\n" +
                        "\tand nvl((delivery.quantidade_atual_do_item - nvl(delivery.quantidade_parcial_tele,0)),0) = 0\n" +
                        "\tand nvl((pe.quantidade_armazenada - pe.quantidade_reservada - pe.quantidade_bloqueada),0) = 0\n" +
                        "\tand tele.codigo_da_filial = %s\n" +
                        "\tand delivery.codigo_da_filial = %s\n"+
                        "\tand rownum <=50"
                , filialDelivery.toString()
                , filialTele.toString());
        List<ItemSemEstoqueFilialTeleEntity> result = getTemplate().query(SQL, new BeanPropertyRowMapper<>(ItemSemEstoqueFilialTeleEntity.class));
        ReportPortal.emitLog(result.toString(), "INFO", Date.from(Instant.now()));
        return result;
    }
    public static List<ItemSemEstoqueFilialTeleEntity> getItemSemEstoqueFilialCorreio(Long filialTele) {
        String SQL = String.format("select e1.codigo_do_item as code\n" +
                "\t,e1.codigo_da_filial filial_tele\n" +
                "\t,nvl((e1.quantidade_atual_do_item - nvl(e1.quantidade_parcial_tele,0)),0) estoque_tele\n" +
                "\t,nvl((pe.quantidade_armazenada - pe.quantidade_reservada - pe.quantidade_bloqueada),0) estoque_cd\n" +
                "from estoques_do_item e1\n" +
                "\t,posicoes_de_estoque@comrlink pe\n" +
                "where e1.codigo_do_item = pe.codigo_do_item\n" +
                "\tand pe.codigo_do_tipo_de_estoque = 1\n" +
                "\tand pe.cod_tipo_de_comprometimento = 1\n" +
                "\tand pe.codigo_da_entidade_comercial = 1021\n" +
                "\tand nvl((e1.quantidade_atual_do_item - nvl(e1.quantidade_parcial_tele,0)),0) = 0\n" +
                "\tand nvl((pe.quantidade_armazenada - pe.quantidade_reservada - pe.quantidade_bloqueada),0) > 0\n" +
                "\tand e1.codigo_da_filial\n = %s\n", filialTele.toString());
        List<ItemSemEstoqueFilialTeleEntity> result = getTemplate().query(SQL, new BeanPropertyRowMapper<>(ItemSemEstoqueFilialTeleEntity.class));
        ReportPortal.emitLog(result.toString(), "INFO", Date.from(Instant.now()));
        return result;
    }
    public static List<ItemSemEstoqueFilialTeleEntity> getItemComBloqueio() {
        String SQL = String.format("SELECT i.item_codigo_do_item as code,\n" +
                        "       i.rebo_codigo,\n" +
                        "       r.descricao,\n" +
                        "       r.motivo_do_bloqueio\n" +
                        "FROM itens_x_regras_de_bloqueio@comr i\n" +
                        "\tJOIN regras_de_bloqueio r ON r.codigo = i.rebo_codigo\n" +
                        "WHERE i.enco_codigo_da_entidade_comerc = 1021\n" +
                        "and rownum <=50\n"+
                        "and i.item_codigo_do_item > 110000");
        List<ItemSemEstoqueFilialTeleEntity> result = getTemplate().query(SQL, new BeanPropertyRowMapper<>(ItemSemEstoqueFilialTeleEntity.class));
        ReportPortal.emitLog(result.toString(), "INFO", Date.from(Instant.now()));
        return result;
    }
}



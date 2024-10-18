package queries.avengers.pedidos;

import entity.avangers.pedido.AloFormasPagamentosPedidosEntity;
import entity.avangers.pedido.AloItensDosPedidosEntity;
import entity.avangers.pedido.AloPedidosMarketplaceEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import utils.database.BaseQueries;

import java.util.List;

public class PedidosMarketplaceQuerie extends BaseQueries {
    public static AloFormasPagamentosPedidosEntity getAloFormasPagementosPedidos(String numeroPedido) {
        String sql = String.format("SELECT AFPP.CODIGO_DA_FORMA_DE_PAGAMENTO, AFPP.CODIGO_DA_FILIAL_DO_CONVENIO, \n" +
                "AFPP.CODIGO_DO_CONVENIO, AFPP.SEQUENCIA_FORMA_PAGTO_PEDIDO \n" +
                "FROM PROALO.ALO_FORMAS_PAGAMENTOS_PEDIDOS afpp\n" +
                "WHERE afpp.NUMERO_DO_PEDIDO = %s", numeroPedido);
        List<AloFormasPagamentosPedidosEntity> result = getTemplate().query(sql, new BeanPropertyRowMapper<>(AloFormasPagamentosPedidosEntity.class));
        return result.get(0);
    }

    public static AloItensDosPedidosEntity getAloItensDosPedidos(String numeroPedido) {
        String sql = String.format("SELECT AIP.NUMERO_DO_ITEM, AIP.CODIGO_DO_ITEM,\n" +
                "AIP.QUANTIDADE, AIP.VALOR_UNITARIO, AIP.VALOR_TOTAL_DO_ITEM, \n" +
                "AIP.VALOR_DO_DESCONTO, AIP.ORIGEM_DO_DESCONTO FROM PROALO.ALO_ITENS_DOS_PEDIDOS aip\n" +
                "WHERE aip.NUMERO_DO_PEDIDO = %s", numeroPedido);
        List<AloItensDosPedidosEntity> result = getTemplate().query(sql, new BeanPropertyRowMapper<>(AloItensDosPedidosEntity.class));
        return result.get(0);
    }

    public static AloPedidosMarketplaceEntity getAloPedidosMarketplace(String numeroPedido) {
        String sql = String.format("SELECT ap.CODIGO_DA_SITUACAO_PEDIDO, ap.ORIGEM_PEDIDO,\n" +
                "ap.TIPO_DE_PEDIDO, ap.ID_HUB_MARKETPLACE,\n" +
                "ap.ID_CANAL_MARKETPLACE, ap.MARKETPLACE_ORDER_CODE," +
                "ap.OBSERVACAO FROM PROALO.ALO_PEDIDOS ap \n" +
                "WHERE ap.NUMERO_DO_PEDIDO = %s", numeroPedido);
        List<AloPedidosMarketplaceEntity> result = getTemplate().query(sql, new BeanPropertyRowMapper<>(AloPedidosMarketplaceEntity.class));
        return result.get(0);
    }
}
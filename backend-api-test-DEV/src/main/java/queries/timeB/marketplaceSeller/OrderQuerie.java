package queries.timeB.marketplaceSeller;

import entity.marketplaceSeller.OrderEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import utils.database.BaseQueries;

import java.util.List;

public class OrderQuerie extends BaseQueries {
    public static OrderEntity getOrderByMarketplaceCode(String marketplaceOrderCode) {
        String SQL = String.format("SELECT * FROM PROECM.ECM_PEDIDOS_MARKETPLACE epm \n" +
                "WHERE epm.MARKETPLACE_ORDER_CODE = '%s'", marketplaceOrderCode);
        List<OrderEntity> result = getTemplate().query(SQL, new BeanPropertyRowMapper<>(OrderEntity.class));
        return result.get(0);
    }

    public static void updateOrderToPrinted(String order) {
        String SQL = String.format("update alo_pedidos al set " +
                "al.codigo_da_situacao_pedido = 5 " +
                "where al.numero_do_pedido = %s", order);
        getTemplate().execute(SQL);
    }
}
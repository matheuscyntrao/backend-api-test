package queries.avengers.pedidos;

import com.epam.reportportal.service.ReportPortal;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import queries.avengers.pedidos.orm.Pedido;
import utils.database.BaseQueries;

import java.sql.Date;
import java.time.Instant;
import java.util.List;

public class PedidosQuerie extends BaseQueries {

    public static List<Pedido> getRetiradasByCpf(Long cpf, Integer filial) {
        String SQL ="SELECT\n" +
                "    pe.numero_do_pedido numeroDoPedido,\n" +
                "    pe.CODIGO_DA_FILIAL_TELE codigoFilialTele,\n" +
                "    pe.FORMA_DE_ENTREGA formaEntrega,\n" +
                "    pe.ORIGEM_DESVIO_ESTOQUE origemDestinoEstoque,\n" +
                "    pe.CODIGO_DA_SITUACAO_PEDIDO codigoSituacaoPedido,\n" +
                "    pe.CODIGO_DO_CLIENTE codigoCliente,\n" +
                "    pe.NOME_CLIENTE nomeCliente,\n" +
                "    pe.DTHR_RETIRADA isRetirado \n" +
                "    from alo_pedidos pe, entidades_comerciais ec\n" +
                "    where pe.codigo_do_cliente = ec.codigo_da_entidade_comercial\n" +
                "    and pe.tipo_de_pedido in ('A', 'I', 'F')\n" +
                "    and pe.forma_de_entrega = 4\n" +
                "    and pe.dthr_retirada is null\n" +
                "    and pe.codigo_da_filial_tele = " + filial + "\n" +
                "    and pe.codigo_da_situacao_pedido in (6,35,41,52)\n" +
                "    and ((pe.cpf_retirada_balcao = " + cpf + ") or (ec.cpf = " + cpf + "))";

        List<Pedido> result = getTemplate().query(SQL, new BeanPropertyRowMapper<>(Pedido.class));
        ReportPortal.emitLog(result.toString(), "INFO", Date.from(Instant.now()));
        return result;
    }

    public static List<Pedido> getRetiradasByNumeroPedido(Long numeroPedido) {
        String SQL = "SELECT\n" +
                "\tpe.numero_do_pedido numeroDoPedido,\n" +
                "\tpe.CODIGO_DA_FILIAL_TELE codigoFilialTele,\n" +
                "\tpe.FORMA_DE_ENTREGA formaEntrega,\n" +
                "\tpe.ORIGEM_DESVIO_ESTOQUE origemDestinoEstoque,\n" +
                "\tpe.CODIGO_DA_SITUACAO_PEDIDO codigoSituacaoPedido,\n" +
                "\tpe.CODIGO_DO_CLIENTE codigoCliente,\n" +
                "\tpe.NOME_CLIENTE nomeCliente,\n" +
                "\tCASE WHEN pe.DTHR_RETIRADA IS NOT null THEN 1\n" +
                "\t\tELSE 0\n" +
                "\tEND AS isRetirado\n" +
                "FROM\n" +
                "\talo_pedidos pe\n" +
                "WHERE\n" +
                "\tpe.NUMERO_DO_PEDIDO  = "+numeroPedido+"\n";

        List<Pedido> result = getTemplate().query(SQL, new BeanPropertyRowMapper<>(Pedido.class));
        ReportPortal.emitLog(result.toString(), "INFO", Date.from(Instant.now()));
        return result;
    }


    public static List<String> verifyStatusPedido(Long numeroPedido) {
        String SQL = "SELECT\n" +
                "    a.numero_do_pedido,\n" +
                "    a.CODIGO_DA_SITUACAO_PEDIDO,\n" +
                "    s.DESCRICAO_DA_SITUACAO_PEDIDO,\n" +
                "    a.DTHR_DE_REGISTRO,\n" +
                "    a.CODIGO_DO_RECURSO,\n" +
                "    a.REIMPRIME_PEDIDO\n" +
                "FROM\n" +
                "    ALO_LOGS_DOS_PEDIDOS a,\n" +
                "    alo_situacoes_dos_pedidos s\n" +
                "WHERE\n" +
                "    a.numero_do_pedido = " + numeroPedido + "\n" +
                "    AND s.codigo_da_situacao_pedido = a.codigo_da_situacao_pedido\n" +
                "ORDER BY\n" +
                "    a.dthr_de_registro";

        List<String> result = getTemplate().query(SQL, new BeanPropertyRowMapper<>(String.class));
        ReportPortal.emitLog(result.toString(), "INFO", Date.from(Instant.now()));
        return result;
    }

    public static void main(String[] args) {

        System.out.println(verifyStatusPedido(70103614010L));

//        List<Pedido> getRetiradasByCpf = getRetiradasByCpf(70103614010L, 101);
//        System.out.println(getRetiradasByCpf);
//
//        List<Pedido> getRetiradasByNumeroPedido = getRetiradasByNumeroPedido(25681644L);
//        System.out.println(getRetiradasByNumeroPedido);
    }

}

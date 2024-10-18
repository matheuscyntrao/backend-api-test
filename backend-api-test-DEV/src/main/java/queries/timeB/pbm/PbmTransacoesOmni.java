package queries.timeB.pbm;

import entity.timeb.pbmGateway.*;
import io.cucumber.datatable.DataTable;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import utils.database.BaseQueries;

import java.util.List;

public class PbmTransacoesOmni extends BaseQueries {
    public static PbmTransacoesOmniEntity getTransacoesOmni(String identificadorTransacao) {
        String SQL = String.format("select identificador_transacao as transactionIdentify," +
                "codigo_admin_convenios as codigoAdminConvenios," +
                "codigo_canal_vendas as codigoCanalVenda," +
                "tipo_programa as tipoPrograma," +
                "cpf_beneficiario as cpfBeneficiario," +
                "cpf_atendimento as cpfAtendimento," +
                "usuario_transacao as usuarioTransacao,\n" +
                "origem as origem\n" +
                "from PBM_TRANSACOES_OMNI where identificador_transacao = '%s'", identificadorTransacao);
        List<PbmTransacoesOmniEntity> result = getTemplate().query(SQL, new BeanPropertyRowMapper<>(PbmTransacoesOmniEntity.class));
        return result.get(0);
    }

    public static PbmPreAutorizacoesOmniEntity getPreAutorizacoesOmni(String identificadorTransacao) {
        String SQL = String.format("select identificador_transacao as transactionIdentify,\n" +
                "    nsu_pre_autorizacao as nsuPreAuthorization,\n" +
                "    valor_liquido_enviado as priceNet,\n" +
                "    valor_pre_autorizado as priceNetPreAuthorized,\n" +
                "    origem as origem\n" +
                "    from PBM_PRE_AUTORIZACOES_OMNI\n" +
                "    where identificador_transacao = '%s'", identificadorTransacao);
        List<PbmPreAutorizacoesOmniEntity> result = getTemplate().query(SQL, new BeanPropertyRowMapper<>(PbmPreAutorizacoesOmniEntity.class));
        return result.get(0);
    }
    public static PbmItensPreAutorizacaoEntity getItensPreAutorizacao(String identificadorTransacao) {
        String SQL = String.format("select identificador_transacao as transactionIdentify,\n" +
                "codigo_do_item as codeItem,\n" +
                "ean,\n" +
                "quantidade_pre_autorizada as quantityPreAuthorization,\n" +
                "preco_pre_autorizado as priceNetPreAuthorized\n" +
                "from pbm_itens_pre_autorizacao_omni\n" +
                "where identificador_transacao = '%s'", identificadorTransacao);
        List<PbmItensPreAutorizacaoEntity> result = getTemplate().query(SQL, new BeanPropertyRowMapper<>(PbmItensPreAutorizacaoEntity.class));
        return result.get(0);
    }
    public static PbmAutorizacaoOmniEntity getIAutorizacaoOmni(String identificadorTransacao) {
        String SQL = String.format("    select identificador_transacao as identificadorTransacao,\n" +
                "    nsu_autorizacao as nsuAuthorization,\n" +
                "    valor_autorizado as priceNetAuthorized\n" +
                "    from pbm_autorizacoes_omni\n" +
                "where identificador_transacao = '%s'", identificadorTransacao);
        List<PbmAutorizacaoOmniEntity> result = getTemplate().query(SQL, new BeanPropertyRowMapper<>(PbmAutorizacaoOmniEntity.class));
        return result.get(0);
    }
    public static PbmItensAutorizacaoEntity getItensAutorizacao(String identificadorTransacao) {
        String SQL = String.format("select identificador_transacao as identificadorTransacao,\n" +
                "    codigo_do_item as panvelCode,\n" +
                "    ean,\n" +
                "    quantidade_enviada as quantityAuthorized,\n" +
                "    preco_autorizado as authorizedCovenantValue\n" +
                "    from PBM_ITENS_AUTORIZACAO_OMNI\n" +
                "where identificador_transacao = '%s'", identificadorTransacao);
        List<PbmItensAutorizacaoEntity> result = getTemplate().query(SQL, new BeanPropertyRowMapper<>(PbmItensAutorizacaoEntity.class));
        return result.get(0);
    }
    public static PbmPreAutorizacoesOmniEntity getCancelamentoOmni(String identificadorTransacao) {
        String SQL = String.format("select identificador_transacao as transactionIdentify,\n" +
                "    origem as origem\n" +
                "    from PBM_CANCELAMENTOS_OMNI\n" +
                "    where identificador_transacao = '%s'", identificadorTransacao);
        List<PbmPreAutorizacoesOmniEntity> result = getTemplate().query(SQL, new BeanPropertyRowMapper<>(PbmPreAutorizacoesOmniEntity.class));
        return result.get(0);
    }
}

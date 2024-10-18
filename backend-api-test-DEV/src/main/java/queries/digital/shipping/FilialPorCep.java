package queries.digital.shipping;

import com.epam.reportportal.service.ReportPortal;
import entity.digital.shipping.*;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import utils.database.BaseQueries;

import java.sql.Date;
import java.time.Instant;
import java.util.List;

public class FilialPorCep extends BaseQueries {
    public static List<FilialPorCepEntity> getFilialDoCep(String cep) {
        String SQL = String.format("select distinct l.cep\n" +
                ",fc.codigo_da_filial filial\n" +
                "from logradouros l\n" +
                ",alo_filiais_dos_ceps fc\n" +
                "where fc.cep = l.cep\n" +
                "and nvl(l.data_finalizacao,sysdate) >= sysdate\n" +
                "and nvl(fc.data_final,sysdate) >= sysdate\n" +
                "and fc.tipo_de_filial in ('T','I')\n" +
                "and l.cep = %s", cep);
        List<FilialPorCepEntity> result = getTemplate().query(SQL, new BeanPropertyRowMapper<>(FilialPorCepEntity.class));
        ReportPortal.emitLog(result.toString(), "INFO", Date.from(Instant.now()));
        return result;
    }

    public static List<FilialTeleDiferenteDeliveryEntity> getFilialTeleDiferenteDelivery() {
        String SQL = String.format("select distinct tele.cep\n" +
                ",tele.codigo_da_filial as filialTele\n" +
                ",delivery.codigo_da_filial as filialDelivery\n" +
                "from alo_filiais_dos_ceps tele\n" +
                ",alo_filiais_dos_ceps delivery\n" +
                "where tele.cep = delivery.cep\n" +
                "and tele.codigo_da_filial <> delivery.codigo_da_filial\n" +
                "and tele.data_final is null\n" +
                "and delivery.data_final is null\n" +
                "and tele.tipo_de_filial in ('T','R','I')\n" +
                "and delivery.tipo_de_filial = 'D'");
        List<FilialTeleDiferenteDeliveryEntity> result = getTemplate().query(SQL, new BeanPropertyRowMapper<>(FilialTeleDiferenteDeliveryEntity.class));
        ReportPortal.emitLog(result.toString(), "INFO", Date.from(Instant.now()));
        return result;
    }

    public static List<FilialPorCepEntity> getFiliaisCorreio(String cep) {
        String SQL = String.format("select distinct lg.cep\n" +
                ",vs.valor_padrao_do_parametro filial\n" +
                "from logradouros lg\n" +
                ",localidades lc\n" +
                ",valores_do_parametro_do_sist vs\n" +
                "where lg.codigo_da_localidade = lc.codigo_da_localidade\n" +
                "and nvl(lg.data_finalizacao,sysdate) >= sysdate\n" +
                "and vs.sigla_do_sistema = 'ALO'\n" +
                "and vs.cod_do_parametro_do_sist = 'FILIAL_CORREIOS_'||lc.sigla_da_uf\n" +
                "and not exists (select 1\n" +
                "from alo_filiais_dos_ceps fc\n" +
                "where fc.cep = lg.cep\n" +
                "and fc.tipo_de_filial in ('R','T','I')\n" +
                "and nvl(fc.data_final,sysdate) >= sysdate)\n" +
                "and lg.cep = %s", cep);
        List<FilialPorCepEntity> result = getTemplate().query(SQL, new BeanPropertyRowMapper<>(FilialPorCepEntity.class));
        ReportPortal.emitLog(result.toString(), "INFO", Date.from(Instant.now()));
        return result;
    }

    public static List<FilialContingenciaPorCepEntity> getFilialContingencia() {
        String SQL = String.format("select distinct f.codigo_da_filial filial\n" +
                ",f.codigo_da_filial_contingencia filial_contingencia\n" +
                ",l.cep\n" +
                "from logradouros l\n" +
                ",alo_filiais_dos_ceps fc\n" +
                ",alo_filiais f\n" +
                "where fc.cep = l.cep\n" +
                "and fc.codigo_da_filial = f.codigo_da_filial\n" +
                "and nvl(l.data_finalizacao,sysdate) >= sysdate\n" +
                "and nvl(fc.data_final,sysdate) >= sysdate\n" +
                "and fc.tipo_de_filial in ('T','I')\n" +
                "and f.filial_ativa = 'S'\n" +
                "and to_char(f.horario_de_abertura_tele,'hh24mi') < to_char(f.horario_de_fechamento_tele,'hh24mi')\n" +
                "and not exists (select 1\n" +
                "from alo_filiais f1\n" +
                "where f.codigo_da_filial = f1.codigo_da_filial\n" +
                "and to_char(f.horario_de_abertura_tele,'hh24mi') <= to_char(sysdate,'hh24mi')\n" +
                "and to_char(f.horario_de_fechamento_tele,'hh24mi') >= to_char(sysdate,'hh24mi'))\n" +
                "and f.codigo_da_filial <> f.codigo_da_filial_contingencia\n" +
                "and rownum <=100");
        List<FilialContingenciaPorCepEntity> result = getTemplate().query(SQL, new BeanPropertyRowMapper<>(FilialContingenciaPorCepEntity.class));
        ReportPortal.emitLog(result.toString(), "INFO", Date.from(Instant.now()));
        return result;
    }

    public static List<FilialDoCepEntity> getListFilialRapidaDoCep() {
        String SQL = String.format("select distinct l.cep\n" +
                ",fc.codigo_da_filial codigoFilial\n" +
                "from logradouros l\n" +
                ",alo_filiais_dos_ceps fc\n" +
                "where fc.cep = l.cep\n" +
                "and nvl(l.data_finalizacao,sysdate) >= sysdate\n" +
                "and nvl(fc.data_final,sysdate) >= sysdate\n" +
                "and fc.tipo_de_filial in ('I')\n " +
                "and fc.tipo_de_filial <> 'R'\n" +
                "and rownum <=50");
        List<FilialDoCepEntity> result = getTemplate().query(SQL, new BeanPropertyRowMapper<>(FilialDoCepEntity.class));
        ReportPortal.emitLog(result.toString(), "INFO", Date.from(Instant.now()));
        return result;
    }

    public static List<FilialDoCepEntity> getListFilialProgramadaDoCep() {
        String SQL = String.format("select distinct l.cep\n" +
                ",fc.codigo_da_filial codigoFilial\n" +
                "from logradouros l\n" +
                ",alo_filiais_dos_ceps fc\n" +
                "where fc.cep = l.cep\n" +
                "and nvl(l.data_finalizacao,sysdate) >= sysdate\n" +
                "and nvl(fc.data_final,sysdate) >= sysdate\n" +
                "and fc.tipo_de_filial = 'R'\n" +
                "and fc.tipo_de_filial not in ('T','I')\n" +
                "and rownum <=50\n");
        List<FilialDoCepEntity> result = getTemplate().query(SQL, new BeanPropertyRowMapper<>(FilialDoCepEntity.class));
        ReportPortal.emitLog(result.toString(), "INFO", Date.from(Instant.now()));
        return result;
    }

    public static List<FilialDoCepEntity> getListFilialCorreioDoCep() {
        String SQL = String.format("select distinct lg.cep\n" +
                ",vs.valor_padrao_do_parametro codigoFilial\n" +
                "from logradouros lg\n" +
                ",localidades lc\n" +
                ",valores_do_parametro_do_sist vs\n" +
                "where lg.codigo_da_localidade = lc.codigo_da_localidade\n" +
                "and nvl(lg.data_finalizacao,sysdate) >= sysdate\n" +
                "and vs.sigla_do_sistema = 'ALO'\n" +
                "and vs.cod_do_parametro_do_sist = 'FILIAL_CORREIOS_'||lc.sigla_da_uf\n" +
                "and not exists (select 1\n" +
                "from alo_filiais_dos_ceps fc\n" +
                "where fc.cep = lg.cep\n" +
                "and fc.tipo_de_filial in ('R','T','I')\n" +
                "and nvl(fc.data_final,sysdate) >= sysdate)\n" +
                "and rownum <=50\n");
        List<FilialDoCepEntity> result = getTemplate().query(SQL, new BeanPropertyRowMapper<>(FilialDoCepEntity.class));
        ReportPortal.emitLog(result.toString(), "INFO", Date.from(Instant.now()));
        return result;
    }

    public static List<FilialDoCepEntity> getListCepBloqueioRapida() {
        String SQL = String.format("select distinct l.cep\n" +
                "\t,l.codigo_do_logradouro\n" +
                "\t,f.codigo_da_filial as codigoFilial\n" +
                "from alo_regras_de_entregas r\n" +
                "\t,logradouros l\n" +
                "\t,alo_filiais_dos_ceps f\n" +
                "where r.codigo_da_localidade = l.codigo_da_localidade\n" +
                "\tand l.cep = f.cep\n" +
                "\tand r.forma_de_entrega = 1\n" +
                "\tand r.tipo_de_regra = 2\n" +
                "\tand r.data_inicial < sysdate\n" +
                "\tand nvl(r.data_final,sysdate) >= sysdate\n" +
                "\tand l.data_finalizacao is null\n" +
                "\tand f.data_final is null\n" +
                "\tand f.tipo_de_filial in ('T','I')\n");
        List<FilialDoCepEntity> result = getTemplate().query(SQL, new BeanPropertyRowMapper<>(FilialDoCepEntity.class));
        ReportPortal.emitLog(result.toString(), "INFO", Date.from(Instant.now()));
        return result;
    }

    public static List<FilialDoCepEntity> getListBloqueioBairroRapida() {
        String SQL = String.format("select distinct l.cep\n" +
                "       ,l.codigo_do_logradouro\n" +
                "       ,f.codigo_da_filial as codigoFilial\n" +
                "from alo_regras_de_entregas r\n" +
                "     ,logradouros l\n" +
                "     ,alo_filiais_dos_ceps f\n" +
                "where r.codigo_da_localidade_bairro = l.codigo_da_localidade\n" +
                "      and r.codigo_do_bairro = l.codigo_do_bairro\n" +
                "      and l.cep = f.cep\n" +
                "      and r.forma_de_entrega = 1\n" +
                "      and r.tipo_de_regra = 2\n" +
                "      and r.data_inicial < sysdate\n" +
                "      and nvl(r.data_final,sysdate) >= sysdate\n" +
                "      and l.data_finalizacao is null\n" +
                "      and f.data_final is null\n" +
                "      and f.tipo_de_filial in ('T','I')");
        List<FilialDoCepEntity> result = getTemplate().query(SQL, new BeanPropertyRowMapper<>(FilialDoCepEntity.class));
        ReportPortal.emitLog(result.toString(), "INFO", Date.from(Instant.now()));
        return result;
    }

    public static List<FilialDoCepEntity> getListCepBloqueioProgramada() {
        String SQL = String.format("select distinct l.cep\n" +
                "       ,l.codigo_do_logradouro\n" +
                "       ,f.codigo_da_filial as codigoFilial\n" +
                "from alo_regras_de_entregas r\n" +
                "     ,logradouros l\n" +
                "     ,alo_filiais_dos_ceps f\n" +
                "where r.codigo_da_localidade = l.codigo_da_localidade\n" +
                "      and l.cep = f.cep\n" +
                "      and r.forma_de_entrega = 3\n" +
                "      and r.tipo_de_regra = 2\n" +
                "      and r.data_inicial < sysdate\n" +
                "      and nvl(r.data_final,sysdate) >= sysdate\n" +
                "      and l.data_finalizacao is null\n" +
                "      and f.data_final is null\n" +
                "      and f.tipo_de_filial = 'R'");
        List<FilialDoCepEntity> result = getTemplate().query(SQL, new BeanPropertyRowMapper<>(FilialDoCepEntity.class));
        ReportPortal.emitLog(result.toString(), "INFO", Date.from(Instant.now()));
        return result;
    }

    public static List<FilialDoCepEntity> getListBloqueioLogradouroRapida() {
        String SQL = String.format("select distinct l.cep\n" +
                "       ,l.codigo_do_logradouro\n" +
                "       ,f.codigo_da_filial as codigoFilial\n" +
                "from alo_regras_de_entregas r\n" +
                "     ,logradouros l\n" +
                "     ,alo_filiais_dos_ceps f\n" +
                "where r.codigo_localidade_logradouro = l.codigo_da_localidade\n" +
                "      and r.codigo_do_logradouro = l.codigo_do_logradouro\n" +
                "      and l.cep = f.cep\n" +
                "      and r.tipo_de_regra = 2\n" +
                "      and r.data_inicial < sysdate\n" +
                "      and nvl(r.data_final,sysdate) >= sysdate\n" +
                "      and l.data_finalizacao is null\n" +
                "      and f.data_final is null\n" +
                "      and r.forma_de_entrega = 1\n" +
                "      and f.tipo_de_filial in ('T','I')\n");
        List<FilialDoCepEntity> result = getTemplate().query(SQL, new BeanPropertyRowMapper<>(FilialDoCepEntity.class));
        ReportPortal.emitLog(result.toString(), "INFO", Date.from(Instant.now()));
        return result;
    }

    public static List<FilialDoCepEntity> getListBloqueioLogradouroProgramada() {
        String SQL = String.format("select distinct l.cep\n" +
                "       ,l.codigo_do_logradouro\n" +
                "       ,f.codigo_da_filial as codigoFilial\n" +
                "from alo_regras_de_entregas r\n" +
                "     ,logradouros l\n" +
                "     ,alo_filiais_dos_ceps f\n" +
                "where r.codigo_localidade_logradouro = l.codigo_da_localidade\n" +
                "      and r.codigo_do_logradouro = l.codigo_do_logradouro\n" +
                "      and l.cep = f.cep\n" +
                "      and r.tipo_de_regra = 2\n" +
                "      and r.data_inicial < sysdate\n" +
                "      and nvl(r.data_final,sysdate) >= sysdate\n" +
                "      and l.data_finalizacao is null\n" +
                "      and f.data_final is null\n" +
                "      and r.forma_de_entrega = 3\n" +
                "      and f.tipo_de_filial = 'R'\n");
        List<FilialDoCepEntity> result = getTemplate().query(SQL, new BeanPropertyRowMapper<>(FilialDoCepEntity.class));
        ReportPortal.emitLog(result.toString(), "INFO", Date.from(Instant.now()));
        return result;
    }

    public static List<FilialDoCepEntity> getListBloqueioCepRapida() {
        String SQL = String.format("select distinct l.cep\n" +
                "       ,l.codigo_do_logradouro\n" +
                "       ,f.codigo_da_filial as codigoFilial\n" +
                "from alo_regras_de_entregas r\n" +
                "     ,logradouros l\n" +
                "     ,alo_filiais_dos_ceps f\n" +
                "where r.cep = l.cep\n" +
                "      and l.cep = f.cep\n" +
                "      and r.tipo_de_regra = 2\n" +
                "      and r.data_inicial < sysdate\n" +
                "      and nvl(r.data_final,sysdate) >= sysdate\n" +
                "      and l.data_finalizacao is null\n" +
                "      and f.data_final is null\n" +
                "      and r.forma_de_entrega = 1\n" +
                "      and f.tipo_de_filial in ('T','I')\n");
        List<FilialDoCepEntity> result = getTemplate().query(SQL, new BeanPropertyRowMapper<>(FilialDoCepEntity.class));
        ReportPortal.emitLog(result.toString(), "INFO", Date.from(Instant.now()));
        return result;
    }

    public static List<FilialDoCepEntity> getListBloqueioCepProgramada() {
        String SQL = String.format("select distinct l.cep\n" +
                "       ,l.codigo_do_logradouro\n" +
                "       ,f.codigo_da_filial as codigoFilial\n" +
                "from alo_regras_de_entregas r\n" +
                "     ,logradouros l\n" +
                "     ,alo_filiais_dos_ceps f\n" +
                "where r.cep = l.cep\n" +
                "      and l.cep = f.cep\n" +
                "      and r.tipo_de_regra = 2\n" +
                "      and r.data_inicial < sysdate\n" +
                "      and nvl(r.data_final,sysdate) >= sysdate\n" +
                "      and l.data_finalizacao is null\n" +
                "      and f.data_final is null\n" +
                "      and r.forma_de_entrega = 3\n" +
                "      and f.tipo_de_filial = 'R'\n");
        List<FilialDoCepEntity> result = getTemplate().query(SQL, new BeanPropertyRowMapper<>(FilialDoCepEntity.class));
        ReportPortal.emitLog(result.toString(), "INFO", Date.from(Instant.now()));
        return result;
    }

    public static List<FilialDoCepEntity> getListAlteracaoRapidaLocalidade() {
        String SQL = String.format("select distinct l.cep\n" +
                "\t,l.codigo_do_logradouro\n" +
                "\t,f.codigo_da_filial as codigoFilial\n" +
                "from alo_regras_de_entregas r\n" +
                "\t,logradouros l\n" +
                "\t,alo_filiais_dos_ceps f\n" +
                "\t,alo_filiais af\n" +
                "where r.codigo_da_localidade = l.codigo_da_localidade\n" +
                "\tand l.cep = f.cep\n" +
                "\tand f.codigo_da_filial = af.codigo_da_filial\n" +
                "\tand r.forma_de_entrega = 1\n" +
                "\tand r.tipo_de_regra = 1\n" +
                "\tand r.data_inicial < sysdate\n" +
                "\tand nvl(r.data_final,sysdate) >= sysdate\n" +
                "\tand l.data_finalizacao is null\n" +
                "\tand f.data_final is null\n" +
                "\tand f.tipo_de_filial in ('T','I')\n");
        List<FilialDoCepEntity> result = getTemplate().query(SQL, new BeanPropertyRowMapper<>(FilialDoCepEntity.class));
        ReportPortal.emitLog(result.toString(), "INFO", Date.from(Instant.now()));
        return result;
    }

    public static List<FilialDoCepEntity> getListAlteracaoRapidaBairro() {
        String SQL = String.format("select distinct l.cep\n" +
                "\t,l.codigo_do_logradouro\n" +
                "\t,f.codigo_da_filial as codigoFilial\n" +
                "from alo_regras_de_entregas r\n" +
                "\t,logradouros l\n" +
                "\t,alo_filiais_dos_ceps f\n" +
                "\t,alo_filiais af\n" +
                "where r.codigo_da_localidade_bairro = l.codigo_da_localidade\n" +
                "    and r.codigo_do_bairro = l.codigo_do_bairro\n" +
                "\tand l.cep = f.cep\n" +
                "\tand f.codigo_da_filial = af.codigo_da_filial\n" +
                "\tand r.forma_de_entrega = 1\n" +
                "\tand r.tipo_de_regra = 1\n" +
                "\tand r.data_inicial < sysdate\n" +
                "\tand nvl(r.data_final,sysdate) >= sysdate\n" +
                "\tand l.data_finalizacao is null\n" +
                "\tand f.data_final is null\n" +
                "\tand f.tipo_de_filial in ('T','I')\n");
        List<FilialDoCepEntity> result = getTemplate().query(SQL, new BeanPropertyRowMapper<>(FilialDoCepEntity.class));
        ReportPortal.emitLog(result.toString(), "INFO", Date.from(Instant.now()));
        return result;
    }

    public static List<FilialDoCepEntity> getListAlteracaoRapidaLogradouro() {
        String SQL = String.format("select distinct l.cep\n" +
                "\t,l.codigo_do_logradouro\n" +
                "\t,f.codigo_da_filial as codigoFilial\n" +
                "\t,af.valor_minimo_do_pedido filial_valor_isenta\n" +
                "\t,af.valor_da_taxa_de_entrega filial_valor_taxa\n" +
                "\t,af.prazo_de_entrega filial_prazo\n" +
                "\t,r.valor_da_taxa_de_entrega regra_valor_isenta\n" +
                "    ,r.prazo_de_entrega regra_prazo\n" +
                "    ,r.valor_minimo_isenta_taxa regra_valor_isenta\n" +
                "from alo_regras_de_entregas r\n" +
                "\t,logradouros l\n" +
                "\t,alo_filiais_dos_ceps f\n" +
                "\t,alo_filiais af\n" +
                "where r.codigo_localidade_logradouro = l.codigo_da_localidade\n" +
                "    and r.codigo_do_logradouro = l.codigo_do_logradouro\n" +
                "\tand l.cep = f.cep\n" +
                "\tand f.codigo_da_filial = af.codigo_da_filial\n" +
                "\tand r.forma_de_entrega = 1\n" +
                "\tand r.tipo_de_regra = 1\n" +
                "\tand r.data_inicial < sysdate\n" +
                "\tand nvl(r.data_final,sysdate) >= sysdate\n" +
                "\tand l.data_finalizacao is null\n" +
                "\tand f.data_final is null\n" +
                "\tand f.tipo_de_filial in ('T','I')\n");
        List<FilialDoCepEntity> result = getTemplate().query(SQL, new BeanPropertyRowMapper<>(FilialDoCepEntity.class));
        ReportPortal.emitLog(result.toString(), "INFO", Date.from(Instant.now()));
        return result;
    }

    public static List<FilialDoCepEntity> getListAlteracaoProgramadaLocalidade() {
        String SQL = String.format("select distinct l.cep\n" +
                "\t,l.codigo_do_logradouro\n" +
                "\t,f.codigo_da_filial as codigoFilial\n" +
                "\t,af.valor_minimo_isenta_taxa filial_valor_isenta\n" +
                "\t,af.valor_da_taxa filial_valor_taxa\n" +
                "\t,af.prazo_de_entrega filial_prazo\n" +
                "\t,r.valor_da_taxa_de_entrega regra_valor_isenta\n" +
                "    ,r.prazo_de_entrega regra_prazo\n" +
                "    ,r.valor_minimo_isenta_taxa regra_valor_isenta\n" +
                "from alo_regras_de_entregas r\n" +
                "\t,logradouros l\n" +
                "\t,alo_filiais_dos_ceps f\n" +
                "\t,alo_rotas_de_entregas af\n" +
                "where r.codigo_da_localidade = l.codigo_da_localidade\n" +
                "\tand l.cep = f.cep\n" +
                "\tand f.codigo_da_filial = af.codigo_da_filial\n" +
                "\tand af.tipo_rota = 1\n" +
                "\tand r.forma_de_entrega = 3\n" +
                "\tand r.tipo_de_regra = 1\n" +
                "\tand r.data_inicial < sysdate\n" +
                "\tand nvl(r.data_final,sysdate) >= sysdate\n" +
                "\tand l.data_finalizacao is null\n" +
                "\tand f.data_final is null\n" +
                "\tand f.tipo_de_filial = 'R'\n");
        List<FilialDoCepEntity> result = getTemplate().query(SQL, new BeanPropertyRowMapper<>(FilialDoCepEntity.class));
        ReportPortal.emitLog(result.toString(), "INFO", Date.from(Instant.now()));
        return result;
    }

    public static List<FilialDoCepEntity> getListAlteracaoProgramadaBairro() {
        String SQL = String.format("select distinct l.cep\n" +
                "\t,l.codigo_do_logradouro\n" +
                "\t,f.codigo_da_filial as codigoFilial\n" +
                "\t,af.valor_minimo_isenta_taxa filial_valor_isenta\n" +
                "\t,af.valor_da_taxa filial_valor_taxa\n" +
                "\t,af.prazo_de_entrega filial_prazo\n" +
                "\t,r.valor_da_taxa_de_entrega regra_valor_isenta\n" +
                "    ,r.prazo_de_entrega regra_prazo\n" +
                "    ,r.valor_minimo_isenta_taxa regra_valor_isenta\n" +
                "from alo_regras_de_entregas r\n" +
                "\t,logradouros l\n" +
                "\t,alo_filiais_dos_ceps f\n" +
                "\t,alo_rotas_de_entregas af\n" +
                "where r.codigo_da_localidade_bairro = l.codigo_da_localidade\n" +
                "    and r.codigo_do_bairro = l.codigo_do_bairro\n" +
                "\tand l.cep = f.cep\n" +
                "\tand f.codigo_da_filial = af.codigo_da_filial\n" +
                "\tand af.tipo_rota = 1\n" +
                "\tand r.forma_de_entrega = 3\n" +
                "\tand r.tipo_de_regra = 1\n" +
                "\tand r.data_inicial < sysdate\n" +
                "\tand nvl(r.data_final,sysdate) >= sysdate\n" +
                "\tand l.data_finalizacao is null\n" +
                "\tand f.data_final is null\n" +
                "\tand f.tipo_de_filial = 'R'\n");
        List<FilialDoCepEntity> result = getTemplate().query(SQL, new BeanPropertyRowMapper<>(FilialDoCepEntity.class));
        ReportPortal.emitLog(result.toString(), "INFO", Date.from(Instant.now()));
        return result;
    }

    public static List<FilialDoCepEntity> getListAlteracaoProgramadaLogradouro() {
        String SQL = String.format("select distinct l.cep\n" +
                "\t,l.codigo_do_logradouro\n" +
                "\t,f.codigo_da_filial as codigoFilial\n" +
                "\t,af.valor_minimo_isenta_taxa filial_valor_isenta\n" +
                "\t,af.valor_da_taxa filial_valor_taxa\n" +
                "\t,af.prazo_de_entrega filial_prazo\n" +
                "\t,r.valor_da_taxa_de_entrega regra_valor_isenta\n" +
                "    ,r.prazo_de_entrega regra_prazo\n" +
                "    ,r.valor_minimo_isenta_taxa regra_valor_isenta\n" +
                "from alo_regras_de_entregas r\n" +
                "\t,logradouros l\n" +
                "\t,alo_filiais_dos_ceps f\n" +
                "\t,alo_rotas_de_entregas af\n" +
                "where r.codigo_localidade_logradouro = l.codigo_da_localidade\n" +
                "    and r.codigo_do_logradouro = l.codigo_do_logradouro\n" +
                "\tand l.cep = f.cep\n" +
                "\tand f.codigo_da_filial = af.codigo_da_filial\n" +
                "\tand af.tipo_rota = 1\n" +
                "\tand r.forma_de_entrega = 3\n" +
                "\tand r.tipo_de_regra = 1\n" +
                "\tand r.data_inicial < sysdate\n" +
                "\tand nvl(r.data_final,sysdate) >= sysdate\n" +
                "\tand l.data_finalizacao is null\n" +
                "\tand f.data_final is null\n" +
                "\tand f.tipo_de_filial = 'R'\n");
        List<FilialDoCepEntity> result = getTemplate().query(SQL, new BeanPropertyRowMapper<>(FilialDoCepEntity.class));
        ReportPortal.emitLog(result.toString(), "INFO", Date.from(Instant.now()));
        return result;
    }

    public static List<FilialDoCepEntity> getListAlteracaoProgramadaCep() {
        String SQL = String.format("select distinct l.cep\n" +
                "\t,l.codigo_do_logradouro\n" +
                "\t,f.codigo_da_filial as codigoFilial\n" +
                "\t,af.valor_minimo_isenta_taxa filial_valor_isenta\n" +
                "\t,af.valor_da_taxa filial_valor_taxa\n" +
                "\t,af.prazo_de_entrega filial_prazo\n" +
                "\t,r.valor_da_taxa_de_entrega regra_valor_isenta\n" +
                "    ,r.prazo_de_entrega regra_prazo\n" +
                "    ,r.valor_minimo_isenta_taxa regra_valor_isenta\n" +
                "from alo_regras_de_entregas r\n" +
                "\t,logradouros l\n" +
                "\t,alo_filiais_dos_ceps f\n" +
                "\t,alo_rotas_de_entregas af\n" +
                "where r.cep = l.cep\n" +
                "\tand l.cep = f.cep\n" +
                "\tand f.codigo_da_filial = af.codigo_da_filial\n" +
                "\tand af.tipo_rota = 1\n" +
                "\tand r.forma_de_entrega = 3\n" +
                "\tand r.tipo_de_regra = 1\n" +
                "\tand r.data_inicial < sysdate\n" +
                "\tand nvl(r.data_final,sysdate) >= sysdate\n" +
                "\tand l.data_finalizacao is null\n" +
                "\tand f.data_final is null\n" +
                "\tand f.tipo_de_filial = 'R'\n");
        List<FilialDoCepEntity> result = getTemplate().query(SQL, new BeanPropertyRowMapper<>(FilialDoCepEntity.class));
        ReportPortal.emitLog(result.toString(), "INFO", Date.from(Instant.now()));
        return result;
    }

    public static List<FilialDoCepEntity> getListAlteracaoRapidaCep() {
        String SQL = String.format("select distinct l.cep\n" +
                "\t,l.codigo_do_logradouro\n" +
                "\t,f.codigo_da_filial as codigoFilial\n" +
                "\t,af.valor_minimo_do_pedido filial_valor_isenta\n" +
                "\t,af.valor_da_taxa_de_entrega filial_valor_taxa\n" +
                "\t,af.prazo_de_entrega filial_prazo\n" +
                "\t,r.valor_da_taxa_de_entrega regra_valor_isenta\n" +
                "    ,r.prazo_de_entrega regra_prazo\n" +
                "    ,r.valor_minimo_isenta_taxa regra_valor_isenta\n" +
                "from alo_regras_de_entregas r\n" +
                "\t,logradouros l\n" +
                "\t,alo_filiais_dos_ceps f\n" +
                "\t,alo_filiais af\n" +
                "where r.cep = l.cep\n" +
                "\tand l.cep = f.cep\n" +
                "\tand f.codigo_da_filial = af.codigo_da_filial\n" +
                "\tand r.forma_de_entrega = 1\n" +
                "\tand r.tipo_de_regra = 1\n" +
                "\tand r.data_inicial < sysdate\n" +
                "\tand nvl(r.data_final,sysdate) >= sysdate\n" +
                "\tand l.data_finalizacao is null\n" +
                "\tand f.data_final is null\n" +
                "\tand f.tipo_de_filial in ('T','I')\n");
        List<FilialDoCepEntity> result = getTemplate().query(SQL, new BeanPropertyRowMapper<>(FilialDoCepEntity.class));
        ReportPortal.emitLog(result.toString(), "INFO", Date.from(Instant.now()));
        return result;
    }

    public static List<FilialDoCepEntity> getListBloqueioBairroProgramada() {
        String SQL = String.format("select distinct l.cep\n" +
                "       ,l.codigo_do_logradouro\n" +
                "       ,f.codigo_da_filial as codigoFilial\n" +
                "from alo_regras_de_entregas r\n" +
                "     ,logradouros l\n" +
                "     ,alo_filiais_dos_ceps f\n" +
                "where r.codigo_da_localidade_bairro = l.codigo_da_localidade\n" +
                "      and r.codigo_do_bairro = l.codigo_do_bairro\n" +
                "      and l.cep = f.cep\n" +
                "      and r.tipo_de_regra = 2\n" +
                "      and r.data_inicial < sysdate\n" +
                "      and nvl(r.data_final,sysdate) >= sysdate\n" +
                "      and l.data_finalizacao is null\n" +
                "      and f.data_final is null\n" +
                "      and r.forma_de_entrega = 3      \n" +
                "      and f.tipo_de_filial = 'R'\n");
        List<FilialDoCepEntity> result = getTemplate().query(SQL, new BeanPropertyRowMapper<>(FilialDoCepEntity.class));
        ReportPortal.emitLog(result.toString(), "INFO", Date.from(Instant.now()));
        return result;
    }

    public static List<FilialCentralizadoraPorCepEntity> getFilialCentralizadora() {
        String SQL = String.format("select distinct f.codigo_da_filial filial\n" +
                ",f.codigo_filial_centralizadora filial_centralizadora\n" +
                ",l.cep\n" +
                "    from logradouros l\n" +
                ",alo_filiais_dos_ceps fc\n" +
                ",alo_filiais f\n" +
                "    where fc.cep = l.cep\n" +
                "    and fc.codigo_da_filial = f.codigo_da_filial\n" +
                "    and nvl(l.data_finalizacao,sysdate) >= sysdate\n" +
                "    and nvl(fc.data_final,sysdate) >= sysdate\n" +
                "    and fc.tipo_de_filial in ('T','I')\n" +
                "    and f.filial_ativa = 'S'\n" +
                "    and to_char(f.horario_de_abertura_tele,'hh24mi') < to_char(f.horario_de_fechamento_tele,'hh24mi')\n" +
                "    and not exists (select 1\n" +
                "            from alo_filiais f1\n" +
                "            where f.codigo_da_filial = f1.codigo_da_filial\n" +
                "            and to_char(f.horario_de_abertura_tele,'hh24mi') <= to_char(sysdate,'hh24mi')\n" +
                "    and to_char(f.horario_de_fechamento_tele,'hh24mi') >= to_char(sysdate,'hh24mi'))\n" +
                "    and not exists (select 1\n" +
                "            from alo_filiais f1\n" +
                "            where f.codigo_da_filial_contingencia = f1.codigo_da_filial\n" +
                "            and to_char(f.horario_de_abertura_tele,'hh24mi') <= to_char(sysdate,'hh24mi')\n" +
                "    and to_char(f.horario_de_fechamento_tele,'hh24mi') >= to_char(sysdate,'hh24mi'))\n" +
                "    and rownum <=100");
        List<FilialCentralizadoraPorCepEntity> result = getTemplate().query(SQL, new BeanPropertyRowMapper<>(FilialCentralizadoraPorCepEntity.class));
        ReportPortal.emitLog(result.toString(), "INFO", Date.from(Instant.now()));
        return result;
    }
}

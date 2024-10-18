package queries.digital.shipping;

import com.epam.reportportal.service.ReportPortal;
import entity.digital.shipping.*;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import utils.Util;
import utils.database.BaseQueries;
import utils.service.Cache;

import java.sql.Date;
import java.time.Instant;
import java.util.List;

public class RegrasEntrega extends BaseQueries {
    public static List<RegrasEntregaEntity> getRegraIsentaFreteRapidaLocalidade() {
        String SQL = String.format("select distinct l.cep\n" +
                "\t,l.codigo_do_logradouro\n" +
                "\t,f.codigo_da_filial\n" +
                "\t,af.valor_minimo_do_pedido filial_valor_isenta\n" +
                "\t,af.valor_da_taxa_de_entrega filial_valor_taxa\n" +
                "\t,af.prazo_de_entrega filial_prazo\n" +
                "\t,r.valor_da_taxa_de_entrega regra_valor_isenta\n" +
                "    ,r.prazo_de_entrega regra_prazo\n" +
                "    ,r.valor_minimo_isenta_taxa regra_valor_taxa\n" +
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
                "\tand f.tipo_de_filial in ('T','I')" +
                "\tand l.cep = %s", Cache.valores.get(Util.rota.apply("cep")));
        List<RegrasEntregaEntity> result = getTemplate().query(SQL, new BeanPropertyRowMapper<>(RegrasEntregaEntity.class));
        ReportPortal.emitLog(result.toString(), "INFO", Date.from(Instant.now()));
        return result;
    }
    public static List<RegrasEntregaEntity> getRegraIsentaFreteRapidaBairro() {
        String SQL = String.format("select distinct l.cep\n" +
                "\t,l.codigo_do_logradouro\n" +
                "\t,f.codigo_da_filial\n" +
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
                "\tand f.tipo_de_filial in ('T','I')\n" +
                "\tand l.cep = %s", Cache.valores.get(Util.rota.apply("cep")));
        List<RegrasEntregaEntity> result = getTemplate().query(SQL, new BeanPropertyRowMapper<>(RegrasEntregaEntity.class));
        ReportPortal.emitLog(result.toString(), "INFO", Date.from(Instant.now()));
        return result;
    }
    public static List<RegrasEntregaEntity> getRegraIsentaFreteRapidaLogradouro() {
        String SQL = String.format("select distinct l.cep\n" +
                "\t,l.codigo_do_logradouro\n" +
                "\t,f.codigo_da_filial\n" +
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
                "\tand f.tipo_de_filial in ('T','I')\n" +
                "\tand l.cep = %s", Cache.valores.get(Util.rota.apply("cep")));
        List<RegrasEntregaEntity> result = getTemplate().query(SQL, new BeanPropertyRowMapper<>(RegrasEntregaEntity.class));
        ReportPortal.emitLog(result.toString(), "INFO", Date.from(Instant.now()));
        return result;
    }
    public static List<RegrasEntregaEntity> getRegraIsentaFreteRapidaCep() {
        String SQL = String.format("select distinct l.cep\n" +
                "\t,l.codigo_do_logradouro\n" +
                "\t,f.codigo_da_filial\n" +
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
                "\tand f.tipo_de_filial in ('T','I')\n" +
                "\tand l.cep = %s", Cache.valores.get(Util.rota.apply("cep")));
        List<RegrasEntregaEntity> result = getTemplate().query(SQL, new BeanPropertyRowMapper<>(RegrasEntregaEntity.class));
        ReportPortal.emitLog(result.toString(), "INFO", Date.from(Instant.now()));
        return result;
    }
    public static List<RegrasEntregaEntity> getRegraIsentaFreteProgramadaLocalidade() {
        String SQL = String.format("select distinct l.cep\n" +
                "\t,l.codigo_do_logradouro\n" +
                "\t,f.codigo_da_filial\n" +
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
                "\tand f.tipo_de_filial = 'R'\n" +
                "\tand l.cep = %s", Cache.valores.get(Util.rota.apply("cep")));
        List<RegrasEntregaEntity> result = getTemplate().query(SQL, new BeanPropertyRowMapper<>(RegrasEntregaEntity.class));
        ReportPortal.emitLog(result.toString(), "INFO", Date.from(Instant.now()));
        return result;
    }
    public static List<RegrasEntregaEntity> getRegraIsentaFreteProgramadaBairro() {
        String SQL = String.format("select distinct l.cep\n" +
                "\t,l.codigo_do_logradouro\n" +
                "\t,f.codigo_da_filial\n" +
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
                "\tand f.tipo_de_filial = 'R'\n" +
                "\tand l.cep = %s", Cache.valores.get(Util.rota.apply("cep")));
        List<RegrasEntregaEntity> result = getTemplate().query(SQL, new BeanPropertyRowMapper<>(RegrasEntregaEntity.class));
        ReportPortal.emitLog(result.toString(), "INFO", Date.from(Instant.now()));
        return result;
    }
    public static List<RegrasEntregaEntity> getRegraIsentaFreteProgramadaLogradouro() {
        String SQL = String.format("select distinct l.cep\n" +
                "\t,l.codigo_do_logradouro\n" +
                "\t,f.codigo_da_filial\n" +
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
                "\tand f.tipo_de_filial = 'R'\n" +
                "\tand l.cep = %s", Cache.valores.get(Util.rota.apply("cep")));
        List<RegrasEntregaEntity> result = getTemplate().query(SQL, new BeanPropertyRowMapper<>(RegrasEntregaEntity.class));
        ReportPortal.emitLog(result.toString(), "INFO", Date.from(Instant.now()));
        return result;
    }
    public static List<RegrasEntregaEntity> getRegraIsentaFreteProgramadaCep() {
        String SQL = String.format("select distinct l.cep\n" +
                "\t,l.codigo_do_logradouro\n" +
                "\t,f.codigo_da_filial\n" +
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
                "\tand f.tipo_de_filial = 'R'\n" +
                "\tand l.cep = %s", Cache.valores.get(Util.rota.apply("cep")));
        List<RegrasEntregaEntity> result = getTemplate().query(SQL, new BeanPropertyRowMapper<>(RegrasEntregaEntity.class));
        ReportPortal.emitLog(result.toString(), "INFO", Date.from(Instant.now()));
        return result;
    }

}

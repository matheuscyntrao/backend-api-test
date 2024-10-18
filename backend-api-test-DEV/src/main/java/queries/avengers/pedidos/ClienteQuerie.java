package queries.avengers.pedidos;

import com.epam.reportportal.service.ReportPortal;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import queries.avengers.pedidos.orm.Cliente;
import utils.database.BaseQueries;

import java.sql.Date;
import java.time.Instant;
import java.util.List;

public class ClienteQuerie extends BaseQueries {

    public static List<Cliente> getClienteByNumeroPedido(Integer numeroPedido) {
        String SQL ="SELECT     PED.NUMERO_DO_PEDIDO,                                                                                                    \n" +
                "                PED.CODIGO_DO_CLIENTE codigoCliente,                                                                                                       \n" +
                "                PED.NOME_CLIENTE nome,                                                                                                            \n" +
                "                PED.CPF_CLIENTE cpf,                                                                                                             \n" +
                "                PED.CPF_RETIRADA_BALCAO,                                                                                                     \n" +
                "                PED.CNPJ_CLIENTE cnpj,                                                                                                            \n" +
                "                PED.NUMERO_DO_TELEFONE, " +
                "                PED.DDD as ddd,                                                                                                     \n" +
                "                CONCAT(CONCAT(PED.DDD, ''), PED.NUMERO_DO_TELEFONE) AS TELEFONE,                                                             \n" +
                "                PED.RAMAL ramal,                                                                                                                   \n" +
                "                LG.CEP AS CEP,                                                                                                               \n" +
                "                P.NOME_DO_PAIS AS NOME_PAIS,                                                                                                \n" +
                "                UF.NOME_DA_UF AS NOME_UF,                                                                                                   \n" +
                "                PED.CODIGO_DA_LOCALIDADE,                                                                                                    \n" +
                "                B.NOME_DO_BAIRRO AS BAIRRO,                                                                                                  \n" +
                "                PED.CODIGO_DO_LOGRADOURO,                                                                                                    \n" +
                "                LG.NOME_DO_LOGRADOURO as LOGRADOURO,                                                                                        \n" +
                "                TL.TIPO_DE_LOGRADOURO AS TIPO_DE_LOGRADOURO,                                                                        \n" +
                "                PED.NUMERO_DO_ENDERECO,                                                                                                      \n" +
                "                PED.COMPLEMENTO_DO_ENDERECO,                                                                                                 \n" +
                "                PED.REFERENCIA_PARA_ENTREGA,                                                                                                 \n" +
                "                PED.OBSERVACAO,                                                                                                              \n" +
                "                PED.CODIGO_FILIAL_CONV_FIDELIDADE,                                                                                           \n" +
                "                PED.CODIGO_CONVENIO_FIDELIDADE codigoConvenioFidelidade,                                                                                              \n" +
                "                PED.CODIGO_ASSOCIADO_FIDELIDADE codigoAssociadoFidelidade,                                                                                             \n" +
                "                PED.MATRICULA_ASSOCIADO_FIDELIDADE matriculaFidelidade,                                                                                          \n" +
                "                ( SELECT MC.ENDERECO_ELETRONICO                                                                                              \n" +
                "                FROM ENTIDADES_COMERCIAIS EC,                                                                                              \n" +
                "                        MEIOS_DE_COMUNICACAO MC                                                                                               \n" +
                "                WHERE EC.CODIGO_DA_ENTIDADE_COMERCIAL = PED.CODIGO_DO_CLIENTE                                                              \n" +
                "                    AND MC.CODIGO_DO_TIPO_DE_COMUNIC(+) = 4                                                                                  \n" +
                "                    AND MC.DATA_DE_EXCLUSAO(+) IS NULL                                                                                       \n" +
                "                    AND MC.CODIGO_DA_ENTIDADE_COMERCIAL(+) = EC.CODIGO_DA_ENTIDADE_COMERCIAL                                                 \n" +
                "                    AND MC.ENDERECO_ELETRONICO(+) IS NOT NULL                                                                                \n" +
                "                    AND MC.CODIGO_DO_MEIO_DE_COMUNIC = (SELECT MAX(MM.CODIGO_DO_MEIO_DE_COMUNIC)                                             \n" +
                "                                                        FROM MEIOS_DE_COMUNICACAO MM                                                         \n" +
                "                                                        WHERE MM.CODIGO_DA_ENTIDADE_COMERCIAL = MC.CODIGO_DA_ENTIDADE_COMERCIAL              \n" +
                "                                                        AND MM.CODIGO_DO_TIPO_DE_COMUNIC = 4                                               \n" +
                "                                                        AND MM.ENDERECO_ELETRONICO IS NOT NULL                                             \n" +
                "                                                        AND MM.DATA_DE_EXCLUSAO IS NULL)) AS email                              \n" +
                "        FROM ALO_PEDIDOS PED, LOGRADOUROS LG, LOCALIDADES LC, BAIRROS B, PAISES P, UFS UF ,                                                 \n" +
                "        LOGRADOUROS LGX, LOCALIDADES LCX, BAIRROS BX, PAISES PX, UFS UFX, TIPOS_DE_LOGRADOUROS TL,                                          \n" +
                "(SELECT L.CODIGO_DO_RECURSO CODIGOALORECURSO,                                                                                               \n" +
                "    R.COD_FUNCIONARIO CODIGOFUNCIONARIO,                                                                                                    \n" +
                "    R.CODIGO_DO_USUARIO CODIGOUSUARIO,                                                                                                      \n" +
                "    U.NOME_DO_USUARIO NOMEUSUARIO, P.NUMERO_DO_PEDIDO                                                                                                           \n" +
                "FROM ALO_PEDIDOS P,                                                                                                                         \n" +
                "    ALO_LOGS_DOS_PEDIDOS L,                                                                                                                 \n" +
                "    ALO_RECURSOS R,                                                                                                                         \n" +
                "    USUARIOS U                                                                                                                              \n" +
                "WHERE L.NUMERO_DO_PEDIDO = P.NUMERO_DO_PEDIDO                                                                                               \n" +
                "    AND L.CODIGO_DO_RECURSO(+) = R.CODIGO_DO_RECURSO                                                                                        \n" +
                "    AND R.CODIGO_DO_USUARIO = U.CODIGO_DO_USUARIO                                                                                           \n" +
                "    AND L.SEQUENCIA_DO_LOG_DO_PEDIDO IN (SELECT MIN(LP.SEQUENCIA_DO_LOG_DO_PEDIDO) SEQUENCIA_DO_LOG_DO_PEDIDO                               \n" +
                "FROM ALO_LOGS_DOS_PEDIDOS LP                                                                                                                \n" +
                "WHERE LP.NUMERO_DO_PEDIDO = P.NUMERO_DO_PEDIDO                                                                                              \n" +
                "    AND ((P.TIPO_DE_PEDIDO = 'A'                                                                                                            \n" +
                "    AND LP.CODIGO_DA_SITUACAO_PEDIDO = 2 OR LP.CODIGO_DA_SITUACAO_PEDIDO = 18)                                                              \n" +
                "    OR (P.TIPO_DE_PEDIDO = 'F'                                                                                                              \n" +
                "    AND LP.CODIGO_DA_SITUACAO_PEDIDO = 5 OR LP.CODIGO_DA_SITUACAO_PEDIDO = 18)))                                                            \n" +
                "    AND P.NUMERO_DO_PEDIDO = 52275824) USUARIO_RETORNO                                                                                   \n" +
                "        WHERE PED.NUMERO_DO_PEDIDO = 52275824                                                                                                \n" +
                "        AND PED.CODIGO_DO_LOGRADOURO = LG.CODIGO_DO_LOGRADOURO(+)                                                                           \n" +
                "        AND PED.CODIGO_DA_LOCALIDADE = LG.CODIGO_DA_LOCALIDADE(+)                                                                           \n" +
                "        AND LC.CODIGO_DA_LOCALIDADE(+) = LG.CODIGO_DA_LOCALIDADE                                                                            \n" +
                "        AND B.CODIGO_DA_LOCALIDADE(+) = LG.CODIGO_DA_LOCALIDADE                                                                             \n" +
                "        AND B.CODIGO_DO_BAIRRO(+) = LG.CODIGO_DO_BAIRRO                                                                                     \n" +
                "        AND P.SIGLA_DO_PAIS(+) = LC.SIGLA_DO_PAIS                                                                                           \n" +
                "        AND UF.SIGLA_DO_PAIS(+) = LC.SIGLA_DO_PAIS                                                                                          \n" +
                "        AND UF.SIGLA_DA_UF(+) = LC.SIGLA_DA_UF                                                                                              \n" +
                "        AND PED.CODIGO_DO_LOGRADOURO_COBRANCA = LGX.CODIGO_DO_LOGRADOURO(+)                                                                 \n" +
                "        AND PED.CODIGO_DA_LOCALIDADE_COBRANCA = LGX.CODIGO_DA_LOCALIDADE(+)                                                                 \n" +
                "        AND LG.TIPO_DE_LOGRADOURO = TL.TIPO_DE_LOGRADOURO(+)                                                                                \n" +
                "        AND LCX.CODIGO_DA_LOCALIDADE(+) = LGX.CODIGO_DA_LOCALIDADE                                                                          \n" +
                "        AND BX.CODIGO_DA_LOCALIDADE(+) = LGX.CODIGO_DA_LOCALIDADE                                                                           \n" +
                "        AND BX.CODIGO_DO_BAIRRO(+) = LGX.CODIGO_DO_BAIRRO                                                                                   \n" +
                "        AND PX.SIGLA_DO_PAIS(+) = LCX.SIGLA_DO_PAIS                                                                                         \n" +
                "        AND UFX.SIGLA_DO_PAIS(+) = LCX.SIGLA_DO_PAIS                                                                                        \n" +
                "        AND UFX.SIGLA_DA_UF(+) = LCX.SIGLA_DA_UF                                                                                            \n" +
                "        AND USUARIO_RETORNO.NUMERO_DO_PEDIDO(+) = PED.NUMERO_DO_PEDIDO";

        List<Cliente> result = getTemplate().query(SQL, new BeanPropertyRowMapper<>(Cliente.class));
        ReportPortal.emitLog(result.toString(), "INFO", Date.from(Instant.now()));
        return result;
    }

    public static void main(String[] args) {
        List<Cliente> getClienteByNumeroPedido = getClienteByNumeroPedido(52275824);
        System.out.println(getClienteByNumeroPedido.get(0));
    }



}

package dataProvider.digital.shipping;


import entity.digital.shipping.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.RandomUtils;
import queries.digital.shipping.FilialPorCep;
import queries.digital.shipping.RegrasEntrega;
import utils.Util;
import utils.service.Cache;

import java.util.List;

@Getter
@AllArgsConstructor
public enum PostDeliverieCepGenerate {
    RAPIDA {
        @Override
        public String pojo() {
            List<FilialDoCepEntity> listFilialDoCep = FilialPorCep.getListFilialRapidaDoCep();
            FilialDoCepEntity cep = listFilialDoCep.get(RandomUtils.nextInt(0, listFilialDoCep.size() - 1));
            Cache.valores.put(Util.rota.apply("FilialDoCep"), cep.getCodigoFilial().toString());
            String valor = StringUtils.leftPad(cep.getCep(), 8, "0");
            Cache.valores.put(Util.rota.apply("cep"), valor);
            return valor;
        }
    },
    PROGRAMADA {
        @Override
        public String pojo() {
            List<FilialDoCepEntity> listFilialDoCep = FilialPorCep.getListFilialProgramadaDoCep();
            FilialDoCepEntity cep = listFilialDoCep.get(RandomUtils.nextInt(0, listFilialDoCep.size() - 1));
            Cache.valores.put(Util.rota.apply("FilialDoCep"), cep.getCodigoFilial().toString());
            Cache.valores.put(Util.rota.apply("cep"), cep.getCep());
            String valor = Cache.valores.get(Util.rota.apply("cep"));
            return valor;
        }
    },
    CORREIOS {
        @Override
        public String pojo() {
            List<FilialDoCepEntity> listFilialDoCep = FilialPorCep.getListFilialCorreioDoCep();
            FilialDoCepEntity cep = listFilialDoCep.get(RandomUtils.nextInt(0, listFilialDoCep.size() - 1));
            Cache.valores.put(Util.rota.apply("FilialDoCep"), cep.getCodigoFilial().toString());
            Cache.valores.put(Util.rota.apply("cep"), cep.getCep());
            String valor = Cache.valores.get(Util.rota.apply("cep"));
            return valor;
        }
    },
    CONTINGENCIA {
        @Override
        public String pojo() {
            List<FilialContingenciaPorCepEntity> listFilialContingencia = FilialPorCep.getFilialContingencia();
            FilialContingenciaPorCepEntity cep = listFilialContingencia.get(RandomUtils.nextInt(0, listFilialContingencia.size() - 1));
            Cache.valores.put(Util.rota.apply("FilialDoCep"), cep.getFilial_contingencia().toString());
            Cache.valores.put(Util.rota.apply("cep"), cep.getCep());
            String valor = Cache.valores.get(Util.rota.apply("cep"));
            return valor;
        }
    },
    CENTRALIZADORA {
        @Override
        public String pojo() {
            List<FilialCentralizadoraPorCepEntity> listFilialCentralizadora = FilialPorCep.getFilialCentralizadora();
            FilialCentralizadoraPorCepEntity cep = listFilialCentralizadora.get(RandomUtils.nextInt(0, listFilialCentralizadora.size() - 1));
            Cache.valores.put(Util.rota.apply("FilialDoCep"), cep.getFilial_centralizadora().toString());
            Cache.valores.put(Util.rota.apply("cep"), cep.getCep());
            String valor = Cache.valores.get(Util.rota.apply("cep"));
            return valor;
        }
    },
    BLOQUEIO_LOCALIDADE_RAPIDA {
        @Override
        public String pojo() {
            List<FilialDoCepEntity> listCepComBloqueio = FilialPorCep.getListCepBloqueioRapida();
            FilialDoCepEntity cep = listCepComBloqueio.get(RandomUtils.nextInt(0, listCepComBloqueio.size() - 1));
            Cache.valores.put(Util.rota.apply("FilialDoCep"), cep.getCodigoFilial().toString());
            Cache.valores.put(Util.rota.apply("cep"), cep.getCep());
            String valor = Cache.valores.get(Util.rota.apply("cep"));
            return valor;
        }
    },
    BLOQUEIO_BAIRRO_RAPIDA {
        @Override
        public String pojo() {
            List<FilialDoCepEntity> listCepComBloqueio = FilialPorCep.getListBloqueioBairroRapida();
            FilialDoCepEntity cep = listCepComBloqueio.get(RandomUtils.nextInt(0, listCepComBloqueio.size() - 1));
            Cache.valores.put(Util.rota.apply("FilialDoCep"), cep.getCodigoFilial().toString());
            Cache.valores.put(Util.rota.apply("cep"), cep.getCep());
            // Cache.valores.put(Util.rota.apply("codigoLocalidade"), cep.getPlaceCode().toString());
            String valor = Cache.valores.get(Util.rota.apply("cep"));
            return valor;
        }
    },
    BLOQUEIO_LOCALIDADE_PROGRAMADA {
        @Override
        public String pojo() {
            List<FilialDoCepEntity> listCepComBloqueio = FilialPorCep.getListCepBloqueioProgramada();
            FilialDoCepEntity cep = listCepComBloqueio.get(RandomUtils.nextInt(0, listCepComBloqueio.size() - 1));
            Cache.valores.put(Util.rota.apply("FilialDoCep"), cep.getCodigoFilial().toString());
            Cache.valores.put(Util.rota.apply("cep"), cep.getCep());
            String valor = Cache.valores.get(Util.rota.apply("cep"));
            return valor;
        }
    },
    BLOQUEIO_BAIRRO_PROGRAMADA {
        @Override
        public String pojo() {
            List<FilialDoCepEntity> listCepComBloqueio = FilialPorCep.getListBloqueioBairroProgramada();
            FilialDoCepEntity cep = listCepComBloqueio.get(RandomUtils.nextInt(0, listCepComBloqueio.size() - 1));
            Cache.valores.put(Util.rota.apply("FilialDoCep"), cep.getCodigoFilial().toString());
            Cache.valores.put(Util.rota.apply("cep"), cep.getCep());
            String valor = Cache.valores.get(Util.rota.apply("cep"));
            return valor;
        }
    },
    BLOQUEIO_LOGRADOURO_RAPIDA {
        @Override
        public String pojo() {
            List<FilialDoCepEntity> listCepComBloqueio = FilialPorCep.getListBloqueioLogradouroRapida();
            FilialDoCepEntity cep = listCepComBloqueio.get(RandomUtils.nextInt(0, listCepComBloqueio.size() - 1));
            Cache.valores.put(Util.rota.apply("FilialDoCep"), cep.getCodigoFilial().toString());
            Cache.valores.put(Util.rota.apply("cep"), cep.getCep());
            String valor = Cache.valores.get(Util.rota.apply("cep"));
            return valor;
        }
    },
    BLOQUEIO_LOGRADOURO_PROGRAMADA {
        @Override
        public String pojo() {
            List<FilialDoCepEntity> listCepComBloqueio = FilialPorCep.getListBloqueioLogradouroProgramada();
            FilialDoCepEntity cep = listCepComBloqueio.get(RandomUtils.nextInt(0, listCepComBloqueio.size() - 1));
            Cache.valores.put(Util.rota.apply("FilialDoCep"), cep.getCodigoFilial().toString());
            Cache.valores.put(Util.rota.apply("cep"), cep.getCep());
            String valor = Cache.valores.get(Util.rota.apply("cep"));
            return valor;
        }
    },
    BLOQUEIO_CEP_RAPIDA {
        @Override
        public String pojo() {
            List<FilialDoCepEntity> listCepComBloqueio = FilialPorCep.getListBloqueioCepRapida();
            FilialDoCepEntity cep = listCepComBloqueio.get(RandomUtils.nextInt(0, listCepComBloqueio.size() - 1));
            Cache.valores.put(Util.rota.apply("FilialDoCep"), cep.getCodigoFilial().toString());
            Cache.valores.put(Util.rota.apply("cep"), cep.getCep());
            String valor = Cache.valores.get(Util.rota.apply("cep"));
            return valor;
        }
    },
    BLOQUEIO_CEP_PROGRAMADA {
        @Override
        public String pojo() {
            List<FilialDoCepEntity> listCepComBloqueio = FilialPorCep.getListBloqueioCepProgramada();
            FilialDoCepEntity cep = listCepComBloqueio.get(RandomUtils.nextInt(0, listCepComBloqueio.size() - 1));
            Cache.valores.put(Util.rota.apply("FilialDoCep"), cep.getCodigoFilial().toString());
            Cache.valores.put(Util.rota.apply("cep"), cep.getCep());
            String valor = Cache.valores.get(Util.rota.apply("cep"));
            return valor;
        }
    },
    ALTERACAO_RAPIDA_LOCALIDADE {
        @Override
        public String pojo() {
            List<FilialDoCepEntity> listCepComBloqueio = FilialPorCep.getListAlteracaoRapidaLocalidade();
            FilialDoCepEntity cep = listCepComBloqueio.get(RandomUtils.nextInt(0, listCepComBloqueio.size() - 1));
            Cache.valores.put(Util.rota.apply("FilialDoCep"), cep.getCodigoFilial().toString());
            Cache.valores.put(Util.rota.apply("cep"), cep.getCep());
            String valor = Cache.valores.get(Util.rota.apply("cep"));
            return valor;
        }
    },
    ALTERACAO_RAPIDA_BAIRRO {
        @Override
        public String pojo() {
            List<FilialDoCepEntity> listCepComBloqueio = FilialPorCep.getListAlteracaoRapidaBairro();
            FilialDoCepEntity cep = listCepComBloqueio.get(RandomUtils.nextInt(0, listCepComBloqueio.size() - 1));
            Cache.valores.put(Util.rota.apply("FilialDoCep"), cep.getCodigoFilial().toString());
            Cache.valores.put(Util.rota.apply("cep"), cep.getCep());
            String valor = Cache.valores.get(Util.rota.apply("cep"));
            return valor;
        }
    },
    ALTERACAO_RAPIDA_LOGRADOURO {
        @Override
        public String pojo() {
            List<FilialDoCepEntity> listCepComBloqueio = FilialPorCep.getListAlteracaoRapidaLogradouro();
            FilialDoCepEntity cep = listCepComBloqueio.get(RandomUtils.nextInt(0, listCepComBloqueio.size() - 1));
            Cache.valores.put(Util.rota.apply("FilialDoCep"), cep.getCodigoFilial().toString());
            Cache.valores.put(Util.rota.apply("cep"), cep.getCep());
            String valor = Cache.valores.get(Util.rota.apply("cep"));
            return valor;
        }
    },
    ALTERACAO_PROGRAMADA_LOCALIDADE {
        @Override
        public String pojo() {
            List<FilialDoCepEntity> listCepComBloqueio = FilialPorCep.getListAlteracaoProgramadaLocalidade();
            FilialDoCepEntity cep = listCepComBloqueio.get(RandomUtils.nextInt(0, listCepComBloqueio.size() - 1));
            Cache.valores.put(Util.rota.apply("FilialDoCep"), cep.getCodigoFilial().toString());
            Cache.valores.put(Util.rota.apply("cep"), cep.getCep());
            String valor = Cache.valores.get(Util.rota.apply("cep"));
            return valor;
        }
    },
    ALTERACAO_PROGRAMADA_BAIRRO {
        @Override
        public String pojo() {
            List<FilialDoCepEntity> listCepComBloqueio = FilialPorCep.getListAlteracaoProgramadaBairro();
            FilialDoCepEntity cep = listCepComBloqueio.get(RandomUtils.nextInt(0, listCepComBloqueio.size() - 1));
            Cache.valores.put(Util.rota.apply("FilialDoCep"), cep.getCodigoFilial().toString());
            Cache.valores.put(Util.rota.apply("cep"), cep.getCep());
            String valor = Cache.valores.get(Util.rota.apply("cep"));
            return valor;
        }
    },
    ALTERACAO_PROGRAMADA_LOGRADOURO {
        @Override
        public String pojo() {
            List<FilialDoCepEntity> listCepComBloqueio = FilialPorCep.getListAlteracaoProgramadaLogradouro();
            FilialDoCepEntity cep = listCepComBloqueio.get(RandomUtils.nextInt(0, listCepComBloqueio.size() - 1));
            Cache.valores.put(Util.rota.apply("FilialDoCep"), cep.getCodigoFilial().toString());
            Cache.valores.put(Util.rota.apply("cep"), cep.getCep());
            String valor = Cache.valores.get(Util.rota.apply("cep"));
            return valor;
        }
    },
    ALTERACAO_PROGRAMADA_CEP {
        @Override
        public String pojo() {
            List<FilialDoCepEntity> listCepComBloqueio = FilialPorCep.getListAlteracaoProgramadaCep();
            FilialDoCepEntity cep = listCepComBloqueio.get(RandomUtils.nextInt(0, listCepComBloqueio.size() - 1));
            Cache.valores.put(Util.rota.apply("FilialDoCep"), cep.getCodigoFilial().toString());
            Cache.valores.put(Util.rota.apply("cep"), cep.getCep());
            String valor = Cache.valores.get(Util.rota.apply("cep"));
            return valor;
        }
    },
    ALTERACAO_RAPIDA_CEP {
        @Override
        public String pojo() {
            List<FilialDoCepEntity> listCepComBloqueio = FilialPorCep.getListAlteracaoRapidaCep();
            FilialDoCepEntity cep = listCepComBloqueio.get(RandomUtils.nextInt(0, listCepComBloqueio.size() - 1));
            Cache.valores.put(Util.rota.apply("FilialDoCep"), cep.getCodigoFilial().toString());
            Cache.valores.put(Util.rota.apply("cep"), cep.getCep());
            String valor = Cache.valores.get(Util.rota.apply("cep"));
            return valor;
        }
    },
    TELE_DIFERENTE_DELIVERY {
        @Override
        public String pojo() {
            List<FilialTeleDiferenteDeliveryEntity> listFilialDiferente = FilialPorCep.getFilialTeleDiferenteDelivery();
            FilialTeleDiferenteDeliveryEntity cep = listFilialDiferente.get(RandomUtils.nextInt(0, listFilialDiferente.size() - 1));
            Cache.valores.put(Util.rota.apply("filialTele"), cep.getFilialTele().toString());
            Cache.valores.put(Util.rota.apply("filialDelivery"), cep.getFilialDelivery().toString());
            Cache.valores.put(Util.rota.apply("cep"), cep.getCep());
            String valor = Cache.valores.get(Util.rota.apply("cep"));
            return valor;
        }
    };

    public abstract String pojo();
}



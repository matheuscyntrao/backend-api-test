package dataProvider.digital.shipping;


import entity.digital.shipping.RegrasEntregaEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import queries.digital.shipping.RegrasEntrega;

import java.util.List;

@Getter
@AllArgsConstructor
public enum RegrasEntregaGenerate {
    ALTERACAO_RAPIDA_LOCALIDADE {
        @Override
        public List<RegrasEntregaEntity> pojo() {
            return RegrasEntrega.getRegraIsentaFreteRapidaLocalidade();
        }
    },
    ALTERACAO_RAPIDA_BAIRRO {
        @Override
        public List<RegrasEntregaEntity> pojo() {
            return RegrasEntrega.getRegraIsentaFreteRapidaBairro();
        }
    },
    ALTERACAO_RAPIDA_LOGRADOURO {
        @Override
        public List<RegrasEntregaEntity> pojo() {
            return RegrasEntrega.getRegraIsentaFreteRapidaLogradouro();
        }
    },
    ALTERACAO_RAPIDA_CEP {
        @Override
        public List<RegrasEntregaEntity> pojo() {
            return RegrasEntrega.getRegraIsentaFreteRapidaCep();
        }
    },
    ALTERACAO_PROGRAMADA_LOCALIDADE {
        @Override
        public List<RegrasEntregaEntity> pojo() {
            return RegrasEntrega.getRegraIsentaFreteProgramadaLocalidade();
        }
    },
    ALTERACAO_PROGRAMADA_BAIRRO {
        @Override
        public List<RegrasEntregaEntity> pojo() {
            return RegrasEntrega.getRegraIsentaFreteProgramadaBairro();
        }
    },
    ALTERACAO_PROGRAMADA_LOGRADOURO {
        @Override
        public List<RegrasEntregaEntity> pojo() {
            return RegrasEntrega.getRegraIsentaFreteProgramadaLogradouro();
        }
    },
    ALTERACAO_PROGRAMADA_CEP {
        @Override
        public List<RegrasEntregaEntity> pojo() {
            return RegrasEntrega.getRegraIsentaFreteProgramadaCep();
        }
    };

    public abstract List<RegrasEntregaEntity> pojo();
}



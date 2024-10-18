package dataProvider.digital.shipping;


import entity.digital.shipping.ItemDaFilialEntity;
import entity.digital.shipping.ItemSemEstoqueFilialTeleEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.RandomUtils;
import queries.digital.shipping.ItensDaFilial;
import utils.Util;
import utils.service.Cache;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@AllArgsConstructor
public enum PostItensGenerate {
    COM_ESTOQUE {
        @Override
        public Long pojo() {
            List<ItemDaFilialEntity> listItemComEstoque = ItensDaFilial.getItensDaFilial(Long.parseLong(Cache.valores.get(Util.rota.apply("FilialDoCep"))));
            return listItemComEstoque.get(RandomUtils.nextInt(0, listItemComEstoque.size() - 1)).getCode();
        }
    },
    FRETE_GRATIS_RAPIDA {
        @Override
        public Long pojo() {
            List<ItemDaFilialEntity> listItemFreteGratis = ItensDaFilial.getItemFreteGratisRapida();
            return listItemFreteGratis.get(RandomUtils.nextInt(0, listItemFreteGratis.size())).getCode();
        }
    },
    FRETE_GRATIS_PROGRAMADA {
        @Override
        public Long pojo() {
            List<ItemDaFilialEntity> listItemFreteGratis = ItensDaFilial.getItemFreteGratisProgramada();
            return listItemFreteGratis.get(RandomUtils.nextInt(0, listItemFreteGratis.size())).getCode();
        }
    },
    SEM_ESTOQUE_D_MAIS_N {
        @Override
        public Long pojo() {
            List<ItemSemEstoqueFilialTeleEntity> listItemSemEstoqueDmaisN = ItensDaFilial.getItensSemEstoqueTele(
                    Long.parseLong(Cache.valores.get(Util.rota.apply("filialTele")))
                    ,Long.parseLong(Cache.valores.get(Util.rota.apply("filialDelivery"))));
            return listItemSemEstoqueDmaisN.get(RandomUtils.nextInt(0, listItemSemEstoqueDmaisN.size() - 1)).getCode();
        }
    },
    ESTOQUE_DO_CD {
        @Override
        public Long pojo() {
            List<ItemSemEstoqueFilialTeleEntity> listItemSemEstoqueDmaisN = ItensDaFilial.getItensEstoqueCD(
                    Long.parseLong(Cache.valores.get(Util.rota.apply("filialTele")))
                    ,Long.parseLong(Cache.valores.get(Util.rota.apply("filialDelivery"))));
            return listItemSemEstoqueDmaisN.get(RandomUtils.nextInt(0, listItemSemEstoqueDmaisN.size() - 1)).getCode();
        }
    },
    DELIVERY_NAO_PERMITE_CD {
        @Override
        public Long pojo() {
            List<ItemSemEstoqueFilialTeleEntity> listItemDeliveryNaoPermiteCD = ItensDaFilial.getDeliveryNaoPermiteCD(
                    Long.parseLong(Cache.valores.get(Util.rota.apply("filialTele")))
                    ,Long.parseLong(Cache.valores.get(Util.rota.apply("filialDelivery"))));
            return listItemDeliveryNaoPermiteCD.get(RandomUtils.nextInt(0, listItemDeliveryNaoPermiteCD.size() - 1)).getCode();
        }
    },
    SEM_ESTOQUE {
        @Override
        public Long pojo() {
            List<ItemSemEstoqueFilialTeleEntity> listItemSemEstoque = ItensDaFilial.getItemSemEstoqueCD(
                    Long.parseLong(Cache.valores.get(Util.rota.apply("filialTele")))
                    ,Long.parseLong(Cache.valores.get(Util.rota.apply("filialDelivery"))));
            return listItemSemEstoque.get(RandomUtils.nextInt(0, listItemSemEstoque.size() - 1)).getCode();
        }
    },
    COM_BLOQUEIO {
        @Override
        public Long pojo() {
            List<ItemSemEstoqueFilialTeleEntity> listItemComBloqueio = ItensDaFilial.getItemComBloqueio();
            return listItemComBloqueio.get(RandomUtils.nextInt(0, listItemComBloqueio.size() - 1)).getCode();
        }
    },
    CORREIO_COM_DESVIO_CD {
        @Override
        public Long pojo() {
            List<ItemSemEstoqueFilialTeleEntity> listItemFIlialCorreioCD = ItensDaFilial.getItemSemEstoqueFilialCorreio(Long.parseLong(Cache.valores.get(Util.rota.apply("FilialDoCep"))));
            return listItemFIlialCorreioCD.get(RandomUtils.nextInt(0, listItemFIlialCorreioCD.size() - 1)).getCode();
        }
    },
    ITEM_NULL {
        @Override
        public Long pojo() {
            Long itemNull = null;
            return itemNull;
        }
    },
    PBM {
        @Override
        public Long pojo() {
            Long itemPbm = 501640L;
            return itemPbm;
        }
    };

    public abstract Long pojo();
}



package enums.time_b.pbm;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PbmEnum {
    //SEVEN
    SEVEN_LOGIX(45028, 3, "LOGIX PHARMA (ATÉ 75%)"),
    SEVEN_COMPROMISSO_SAUDE(45028, 102, "COMPROMISSO SAUDE - UCB"),
    SEVEN_VALE_MAIS_SAUDE(45028, 103, "VALE MAIS SAUDE - NOVARTIS"),
    SEVEN_BAYER_PARA_VOCE(45028, 104, "BAYER PARA VOCÊ - BAYER"),
    SEVEN_EMS_SAUDE(45028, 105, "EMS SAUDE - SIGMA"),
    SEVEN_DURMA_BEM(45028, 106, "DURMA BEM - SIGMA"),
    SEVEN_MAIS_PFIZER(45028, 108, "MAIS PFIZER - PFIZER"),
    SEVEN_FAZ_BEM_ASTRAZENECA(45028, 110, "FAZ BEM - ASTRAZENECA"),
    SEVEN_SIGA_GERMED(45028, 111, "SIGA - GERMED"),
    SEVEN_LONGEVIDADE_TORRENT(45028, 115, "LONGEVIDADE - TORRENT"),
    SEVEN_CUIDADOS_PELA_VIDA_ACHE(45028, 117, "CUIDADOS PELA VIDA - ACHE"),
    SEVEN_SAUDE_EM_EVOLUCAO_BIOLAB(45028, 120, "SAUDE EM EVOLUÇÃO - BIOLAB"),
    SEVEN_LILLY_MELHOR_PARA_VOCE(45028, 125, "LILLY MELHOR PARA VOCE - LILLY"),
    SEVEN_PROGRAMA_OFTA_LEGRAND(45028, 128, "PROGRAMA OFTA - LEGRAND"),
    SEVEN_PROGRAMA_CONSCIENCIA_PELA_VIDA(45028, 129, "PROGRAMA CONSCIENCIA PELA VIDA - FMQ"),
    SEVEN_PROGRAMA_BEM_PERTO_DA_SUA_LIBERDADE_AMGEN(45028, 130, "PROGRAMA BEM PERTO DA SUA LIBERDADE - AMGEN"),
    SEVEN_SAUDE_FACIL(45028, 131, "SAUDE FACIL - BOEHRINGER"),
    SEVEN_PROGRAMA_SEM_DOR_BIOLAB(45028, 132, "PROGRAMA SEM DOR - BIOLAB"),
    SEVEN_AMGEN_BEM_PERTO(45028, 134, "AMGEN BEM PERTO - AMGEN"),
    SEVEN_PROGRAMA_VIDA_MAIS_HYPERA(45028, 136, "PROGRAMA VIDA MAIS - HYPERA"),
    SEVEN_PROGRAMA_BOM_SONO_BIOLAB(45028, 137, "PROGRAMA BOM SONO - BIOLAB"),
    SEVEN_PROGRAMA_USK_MAIS(45028, 139, "PROGRAMA USK MAIS"),
    SEVEN_VALE_MAIS_VISAO(45028, 140, "VALE MAIS VISÃO"),
    SEVEN_PARA_COMIGO_PERRIGO(45028, 142, "PARA COMIGO - PERRIGO"),

    //EPHARMA
    EPHARMA_NOVO_NORDISK(1127496, 102, "NOVO DIA - NOVO NORDISK"),
    EPHARMA_PROGRAMA_COLGATE(1127496, 116, "PROGRAMA COLGATE - COLGATE"),
    EPHARMA_DIABETES_CONTATO(1127496, 119, "DIABETES CONTATO"),
    EPHARMA_PROGRAMA_BONVIVER(1127496, 121, "PROGRAMA BONVIVER"),
    EPHARMA_PROGRAMA_PRIMEIRA_DOSE_EUROFARMA(1127496, 122, "PROGRAMA PRIMEIRA DOSE - EUROFARMA"),
    EPHARMA_PROGRAMA_MAIS_SORRISOS_EDEL_WHITE(1127496, 124, "PROGRAMA MAIS SORRISOS - EDEL WHITE"),
    EPHARMA_PROGRAMA_ELMEX_COLGATE(1127496, 126, "PROGRAMA ELMEX - COLGATE"),
    EPHARMA_PROGRAMA_MEUS_CUIDADOS_MYLAN(1127496, 127, "PROGRAMA MEUS CUIDADOS - MYLAN"),
    EPHARMA_KIN_CONSMERCARE(1127496, 128, "KIN CONSUMERCARE"),
    EPHARMA_KIN_ODONTOCARE(1127496, 129, "KIN ODONTOCARE"),

    //FUNCIONAL
    FUNCIONAL_VIVER_ZODIAC(1334966, 104, "VIVER ZODIAC - ZODIAC"),
    FUNCIONAL_PROGRAMA_CUIDAR(1334966, 106, "PROGRAMA CUIDAR - MUNDIPHARMA"),
    FUNCIONAL_VIVER_MAIS_GSK(1334966, 107, "VIVER MAIS - GSK"),
    FUNCIONAL_RECEITA_DE_VIDA(1334966, 108, "RECEITA DE VIDA - MSD"),
    FUNCIONAL_PROGRAMA_VIVA(1334966, 114, "PROGRAMA VIVA - SANOFI"),
    FUNCIONAL_SOU_MAIS_VIDA(1334966, 115, "SOU MAIS VIDA - APSEN"),
    FUNCIONAL_ACESSAR(1334966, 116, "ACESSAR - CHIESI"),
    FUNCIONAL_THERACLUB_THERASKIN(1334966, 119, "THERACLUB - THERASKIN"),
    FUNCIONAL_A_CARE_ABBOTT(1334966, 121, "A:CARE - ABBOTT"),
    FUNCIONAL_PROGRAMA_COREGA_VOCE_PODE(1334966, 122, "PROGRAMA COREGA VOCÊ PODE"),

    //FARMACIAPOPULAR
    FARMACIA_POPULAR_MINISTERIO_DA_SAUDE(2523535, 2523535, "MINISTERIO DA SAUDE"),

    //ZICARD
    ZICARD_DERMACLUB(10604592, 100, "DERMACLUB - LOREAL");

    private final Integer codigoAdminConvenios;
    private final Integer sequenciaDoPrograma;
    private final String descricao;
    }
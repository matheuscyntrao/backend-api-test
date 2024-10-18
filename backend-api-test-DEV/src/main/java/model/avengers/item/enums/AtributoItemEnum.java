package model.avengers.item.enums;

import lombok.Getter;

@Getter
public enum AtributoItemEnum {

    ITEM("ITEM", "nomenclatura_varejo"),
    FORNECEDOR("FORNECEDOR", "razao_social_do_fornecedor"),
    TIPO("TIPO", "descricao_do_tipo_do_item"),
    GRUPO("GRUPO", "descricao_do_grupo_de_item"),
    SUBGRUPO("SUBGRUPO", "descr_subgrupo_item"),
    SUBCATEGORIA("SUBCATEGORIA", "descricao_da_categoria_do_item"),
    CATEGORIA("CATEGORIA", "descricao_da_categoria_pai"),
    SUBMARCA("SUBMARCA", "descricao_da_marca_do_item"),
    MARCA("MARCA", "descricao_da_marca_pai"),
    CLASSE_TERAPEUTICA("CLASSE_TERAPEUTICA", "descr_da_classe_terapeutica"),
    PRINCIPIO_ATIVO("PRINCIPIO_ATIVO", "descricao_do_nome_generico"),
    OTC("OTC", "item_otc"),
    PSICOTROPICO("PSICOTROPICO", "item_psicotropico"),
    AVULSO("AVULSO", "item_avulso"),
    RELACAO("RELACAO", "relacao_do_item"),
    TARJA("TARJA", "tarja_do_item"),
    USO_CONTINUO("USO_CONTINUO", "uso_continuo"),
    AGRUPAMENTO("AGRUPAMENTO", "agrupamento_gc"),
    APRESENTACAO_EMBALAGEM("APRESENTACAO_EMBALAGEM", "apresentacao_embalagem"),
    VOLUME("VOLUME", "volume"),
    TAMANHO("TAMANHO", "tamanho"),
    CLASSIFICACAO_INDICACAO("CLASSIFICACAO_INDICACAO", "classificacao_indicacao"),
    TEXTURA("TEXTURA", "textura"),
    VOLTAGEM("VOLTAGEM", "voltagem"),
    COR("COR", "cor"),
    GENERO("GENERO", "genero"),
    FPS("FPS", "fps"),
    TONALIDADE("TONALIDADE", "tonalidade"),
    TIPO_PELE("TIPO_PELE", "tipo_pele"),
    ESPECIALIDADE("ESPECIALIDADE", "especialidade"),
    SABOR("SABOR", "sabor"),
    SEGMENTACAO("SEGMENTACAO", "segmentacao"),
    FORMATO("FORMATO", "formato");

    private String nomeAtributoBase;

    private String nomeAtributo;


    AtributoItemEnum(String nomeAtributo, String nomeAtributoBase) {
        this.nomeAtributo = nomeAtributo;
        this.nomeAtributoBase = nomeAtributoBase;
    }
}

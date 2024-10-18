package enums.phw31tst;

import model.timeB.phw31tst.request.PostVendaRequestV1;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;

public enum Venda {
    VENDA_SIMPLES{
        @Override
        public PostVendaRequestV1 pojo(BigInteger pedido) {
            SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd");
            return PostVendaRequestV1.builder()
                    .numeroPedido(pedido)
                    .codigoFilial(31)
                    .codigoUsuarioOperador(8031)
                    .matriculaAtendente(61159)
                    .dataAbertura(format.format(new Date()))
                    .numeroCaixaDiario(26)
                    .sequenciaCaixaDiario(1)
                    .build();
        }
    };

    public abstract PostVendaRequestV1 pojo(BigInteger pedido);
}

package utils;

public class CPF {
    public static String geraCPF() {
        StringBuilder iniciais = new StringBuilder();
        int numero;
        for (int i = 0; i < 9; i++) {
            numero = (int) (Math.random() * 10);
            iniciais.append((numero));
        }
        return iniciais + calcDigVerif(iniciais.toString());
    }

    public static String gerarCPFInvalido() {
        StringBuilder iniciais = new StringBuilder();
        int numero;
        for (int i = 0; i < 9; i++) {
            numero = (int) (Math.random() * 10);
            iniciais.append((numero));
        }
        return iniciais + "00";
    }

    private static String calcDigVerif(String num) {
        int primDig, segDig;
        int soma = 0, peso = 10;
        for (int i = 0; i < num.length(); i++)
            soma += Integer.parseInt(num.substring(i, i + 1)) * peso--;
        if (soma % 11 == 0 | soma % 11 == 1)
            primDig = 0;
        else
            primDig = 11 - (soma % 11);
        soma = 0;
        peso = 11;
        for (int i = 0; i < num.length(); i++)
            soma += Integer.parseInt(num.substring(i, i + 1)) * peso--;
        soma += primDig * 2;
        if (soma % 11 == 0 | soma % 11 == 1)
            segDig = 0;
        else
            segDig = 11 - (soma % 11);
        return primDig + String.valueOf(segDig);
    }

    public static String geraCPFComSufixo(String sufixo) {
        String cpf = geraCPF();
        return cpf.endsWith(sufixo) ? cpf : geraCPFComSufixo(sufixo);
    }
}

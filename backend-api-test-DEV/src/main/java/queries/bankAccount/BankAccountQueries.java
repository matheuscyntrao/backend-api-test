package queries.bankAccount;

import utils.Util;
import utils.database.BankAccountBaseQueries;


import java.util.Objects;

public class BankAccountQueries extends BankAccountBaseQueries {

    private static final Integer MAX_RANDOM = 999;
    private static final Integer MIN_RANDOM = 100;
    private static final Integer MAX_RETRIES = 10;

    public static String getRandomWomanCpf() {
        String randomCpfResult;
        int count = 0;

        do {
            int randomPointer = Util.getRandomPointer.applyAsInt(MAX_RANDOM, MIN_RANDOM);

            String getRandomWomanCpfSql = "SELECT " +
                    "    dp.cpf" +
                    " FROM " +
                    "    PROSRV.DBR_PESSOA dp" +
                    " WHERE" +
                    "    SEXO = 'F'" +
                    "    AND TO_CHAR(CPF) LIKE '%" + randomPointer + "%'" +
                    "    AND ROWNUM = 1";
            randomCpfResult = getTemplate().queryForObject(getRandomWomanCpfSql, String.class);
            count++;

        } while (Objects.isNull(randomCpfResult) && count < MAX_RETRIES);

        return randomCpfResult;
    }
}
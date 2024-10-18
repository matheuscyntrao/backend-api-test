package queries.timeB.marketplaceSeller;

import utils.database.BaseQueries;

public class TableQuerie extends BaseQueries {
    public static Boolean getTableBkpExist() {
        String SQL = "SELECT count(1) AS count FROM all_tables WHERE table_name = 'ECM_ITENS_MARKETPLACE_BKP'";
        return getTemplate().queryForMap(SQL).get("COUNT").toString().equals("1");
    }

    public static void main(String[] args) {
        Boolean teste = getTableBkpExist();
        System.out.println(teste);
    }
}

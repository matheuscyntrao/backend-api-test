package utils;


import com.epam.reportportal.service.ReportPortal;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import org.testng.Assert;
import utils.service.ServiceResponse;

import java.io.IOException;
import java.sql.Date;
import java.time.Instant;
import java.util.List;

import static org.junit.jupiter.api.Assumptions.assumingThat;

public class ResponseValidator {
    public static void validaResponse(DataTable argument, ServiceResponse response, Class clazz) throws Exception {
        ReportPortal.emitLog(argument.toString(), "INFO", Date.from(Instant.now()));

        response.getObjectBody(clazz);

        String campo, valor;
        List<List<String>> resultado = argument.cells();
        for (int i = 0; i <= resultado.size() - 1; i++) {
            campo = resultado.get(i).get(0);
            valor = resultado.get(i).get(1);
            if (valor != null) {
                switch (campo.toUpperCase()) {
                    case "STATUSCODE":
                        Assert.assertEquals(response.getStatusCode(), Integer.valueOf(valor));
                        assumingThat(campo.toUpperCase().equals("STATUSCODE") && valor.equals("200") && !response.body.equals("") && response.body.contains("{"), () -> {
                            Assert.assertNotNull(response.getObjectBody(clazz));
                        });
                        break;
                    default:
                        JsonNode actualObj = null;
                        ObjectMapper mapper = new ObjectMapper();
                        try {
                            actualObj = mapper.readTree(response.getBody());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        assert actualObj != null;
                        if (valor != "") {
                        //    Assert.assertEquals(actualObj.findValue(campo).asText(), valor, "Erro na validação do campo " + campo);
                            Assert.assertTrue(actualObj.findValue(campo).asText().equals(valor) || actualObj.findValue(campo).toString().equals(valor), "Erro na validação do campo" + campo);
                        }

                }

            }
        }


    }
}

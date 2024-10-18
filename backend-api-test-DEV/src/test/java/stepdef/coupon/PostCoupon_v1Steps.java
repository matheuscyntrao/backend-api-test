package stepdef.coupon;

import com.fasterxml.jackson.core.JsonProcessingException;
import enums.coupon.Coverage;
import enums.coupon.Customer;
import enums.coupon.Product;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.coupon.request.*;
import model.coupon.response.*;
import org.testng.Assert;
import queries.coupon.CouponQueries;
import queries.coupon.CouponsCoverageQueries;
import queries.coupon.CouponsCustomerQueries;
import queries.coupon.CouponsProductsQueries;
import service.coupon.CouponV1;
import utils.CucumberUtils;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assumptions.assumingThat;

public class PostCoupon_v1Steps {

    PostCouponData_v1Request postCouponData_v1Request = new PostCouponData_v1Request();

    @Dado("possuo dados para CouponService - v1 - PostCoupon:")
    public void possuoDadosParaCouponServiceV1PostCoupon(DataTable dataTable) throws JsonProcessingException {
        postCouponData_v1Request = CucumberUtils.getObjectBody(dataTable, PostCouponData_v1Request.class);
    }

    @Dado("possuo dados para CouponService - v1 - PostCouponInternalObjects:")
    public void possuoDadosParaCouponServiceVPostCouponInternalObjects(DataTable dataTable) {
        List<List<String>> data = dataTable.asLists(String.class);
        List<PostAndPutCouponProduct_v1Request> items = new ArrayList<>();
        List<PostAndPutCouponCoverage_v1Request> coverages = new ArrayList<>();
        List<PostAndPutCouponCustomer_v1Request> customers = new ArrayList<>();
        if (!data.get(1).get(0).equals("null")) {
            items.add(Product.valueOf(data.get(1).get(0)).pojo());
        }
        if (!data.get(1).get(1).equals("null")) {
            customers.add(Customer.valueOf(data.get(1).get(1)).pojo());
        }
        if (!data.get(1).get(2).equals("null")){
            coverages.add(Coverage.valueOf(data.get(1).get(2)).pojo());
        }
        PostCoupon_v1Request coupon = new PostCoupon_v1Request();
        coupon.setCouponData(postCouponData_v1Request);
        coupon.setCouponProducts(items);
        coupon.setCouponCoverages(coverages);
        coupon.setCouponCustomers(customers);
        BuilderRequest.body.accept(Util.rota.apply(CouponV1.POST_COUPON), coupon);
    }

    @Quando("executo CouponService - v1 - PostCoupon")
    public void executoCouponServiceV1PostCoupon() {
        CouponV1.postCoupon.run();
    }

    @Entao("sistema processa CouponService - v1 - PostCoupon:")
    public void sistemaProcessaCouponServiceV1PostCoupon(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(CouponV1.POST_COUPON)).getServiceResponse()
                , PostCoupon_v1Response.class
        );
    }

    @E("valido CouponService - v1 - PostCoupon {string}")
    public void validoCouponServiceV1PostCoupon(String message) {
        int statusCode = Cache.chamadas.get(Util.rota.apply(CouponV1.POST_COUPON)).getServiceResponse().getStatusCode();
        assumingThat(statusCode == 400, () -> {
            String mensagemRetorno = Cache.chamadas.get(Util.rota.apply(CouponV1.POST_COUPON)).getServiceResponse().getBody();
            Assert.assertTrue(mensagemRetorno.contains(message), "Mensagem esperada:" + message);
        });
        assumingThat(statusCode == 201, () -> {
            PostCoupon_v1Response response = Cache.chamadas.get(Util.rota.apply(CouponV1.POST_COUPON)).getServiceResponse().getObjectBody(PostCoupon_v1Response.class);
            PostCoupon_v1Response esperado = new PostCoupon_v1Response();
            PostCouponData_v1Response esperadoCouponData = CouponQueries.getCouponDataById(response.getCouponData().getId()).get(0);
            esperado.setCouponData(esperadoCouponData);
            List<GetCouponProductByCouponId_v1Response> items = CouponsProductsQueries.getCouponsItemsByCouponId(response.getCouponData().getId());
            List<GetCouponCustomerByCouponId_v1Response> customers = CouponsCustomerQueries.getCouponsCustomerByCouponId(response.getCouponData().getId());
            List<GetCouponCoverageByCouponId_v1Response> coverages = CouponsCoverageQueries.getCouponsCoverageByCouponId(response.getCouponData().getId());
            esperado.setCouponProducts(items);
            esperado.setCouponCoverages(coverages);
            esperado.setCouponCustomers(customers);
            Assert.assertEquals(response, esperado);
        });
    }

}

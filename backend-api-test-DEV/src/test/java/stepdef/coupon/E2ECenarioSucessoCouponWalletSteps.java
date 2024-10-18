package stepdef.coupon;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mdimension.jchronic.Chronic;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.coupon.ParametrosAuxiliares;
import model.coupon.request.PostAndPutCouponCoverage_v1Request;
import model.coupon.request.PostAndPutCouponCustomer_v1Request;
import model.coupon.request.PostCouponData_v1Request;
import model.coupon.request.PostCouponWalletPromocodeV1Request;
import model.coupon.response.GetCouponWalletV1Response;
import model.coupon.response.PostCouponCoverage_v1Response;
import model.coupon.response.PostCouponData_v1Response;
import model.coupon.response.PostCouponWalletPromocodeV1Response;
import org.apache.commons.httpclient.HttpStatus;
import org.junit.jupiter.api.Assertions;
import queries.clientevarejo.DbrPessoaQueries;
import service.coupon.CouponCoverage_v1;
import service.coupon.CouponCustomer_v1;
import service.coupon.CouponV1;
import service.coupon.CouponWalletV1;
import utils.CucumberUtils;
import utils.ResponseValidator;
import utils.Util;
import utils.constants.DateTimeConstants;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class E2ECenarioSucessoCouponWalletSteps {

    Integer id;

    String customerCpf;
    String promocode;

    String startDate;
    String endDate;

    PostCouponData_v1Request postCouponDataRequest;

    @Dado("possuo dados para CouponService - v1 - BuscarCPFDBR")
    public void possuoDadosParaCouponServiceVBuscarCPFDBR() {
        customerCpf = DbrPessoaQueries.getRandomWomanCpf();
    }

    @E("possuo dados para CouponService - v1 - GetStartAndEndDate:")
    public void possuoDadosParaCouponServiceVGetStartAndEndDate(DataTable dataTable) {
        List<List<String>> data = dataTable.asLists(String.class);
        String startDateSpel = data.get(1).get(0);
        String endDateSpel = data.get(1).get(1);

        var startDateSpan = Chronic.parse(startDateSpel);
        var endDateSpan = Chronic.parse(endDateSpel);

        var startDateToConvert = startDateSpan.getBeginCalendar().getTime();
        var endDateSpanToConvert = endDateSpan.getBeginCalendar().getTime();

        this.startDate = startDateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate()
                .atStartOfDay()
                .format(DateTimeFormatter.ofPattern(DateTimeConstants.PT_BR_DATE_TIME_FORMAT));

        this.endDate = endDateSpanToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate()
                .atStartOfDay()
                .format(DateTimeFormatter.ofPattern(DateTimeConstants.PT_BR_DATE_TIME_FORMAT));
    }

    @E("possuo dados para CouponService - v1 - GetRandomPromocode:")
    public void possuoDadosParaCouponServiceVGetRandomPromocode() {
        int randomPointer = Util.getRandomPointer.applyAsInt(10000, 1);
        this.promocode = "QA_PROMOCODE_TEST" + this.customerCpf + randomPointer;
    }

    @E("possuo dados para CouponService - v1 - E2EPostCoupon:")
    public void possuoDadosParaCouponServiceV1E2EPostCoupon(DataTable dataTable) throws JsonProcessingException {
        postCouponDataRequest = CucumberUtils.getObjectBody(dataTable, PostCouponData_v1Request.class);
        postCouponDataRequest.setStartDate(this.startDate);
        postCouponDataRequest.setEndDate(this.endDate);
        postCouponDataRequest.setPromocode(this.promocode);

        BuilderRequest.body.accept(Util.rota.apply(CouponV1.POST_COUPON_DATA), postCouponDataRequest);
        CouponV1.postCouponData.run();
        this.id = Cache.chamadas.get(Util.rota.apply(CouponV1.POST_COUPON_DATA)).getServiceResponse().getObjectBody(PostCouponData_v1Response.class).getId();
    }

    @E("possuo dados para CouponService - v1 - E2EPatchActivateCouponByCouponId:")
    public void possuoDadosParaCouponServiceVE2EPatchActivateCouponByCouponId() {
        Map<String, String> couponIdParameter = new HashMap<>();
        couponIdParameter.put("id", this.id.toString());
        BuilderRequest.path.accept(Util.rota.apply(CouponV1.PATCH_ACTIVATE_COUPON_BY_ID), couponIdParameter);
        CouponV1.patchActivate.run();
    }

    @E("possuo dados para CouponService - v1 - E2EGetCouponWalletByParameters:")
    public void possuoDadosParaCouponServiceV1E2EGetCouponWalletByParameters(DataTable dataTable) throws JsonProcessingException{
        Map<String, String> paramChannel = new HashMap<>();
        Map<String, String> pathCpf = new HashMap<>();
        pathCpf.put("cpf", this.customerCpf);
        paramChannel.put("channel", CucumberUtils.getObjectBody(dataTable, ParametrosAuxiliares.class).getChannel());
        BuilderRequest.path.accept(Util.rota.apply(CouponWalletV1.GET_COUPON_WALLET_PROMOCODE), pathCpf);
        BuilderRequest.param.accept(Util.rota.apply(CouponWalletV1.GET_COUPON_WALLET_PROMOCODE), paramChannel);
        CouponWalletV1.getCouponWalletPromocode.run();
    }

    @E("valido CouponService - v1 - DoesNotContainsPromocode:")
    public void validoCouponServiceV1DoesNotContainsPromocode() {
        var couponWalletResponse = Cache.chamadas.get(Util.rota.apply(CouponWalletV1.GET_COUPON_WALLET_PROMOCODE))
                .getServiceResponse();

        if (couponWalletResponse.getStatusCode().equals(HttpStatus.SC_NO_CONTENT)) {
            return;
        }

        var couponWallet = couponWalletResponse
                .getObjectBody(GetCouponWalletV1Response[].class);
        var couponWalletList = Arrays.asList(couponWallet);

        var filteredCouponWalletList = couponWalletList.stream()
                .filter(it -> this.promocode.equalsIgnoreCase(it.getPromocode()))
                .collect(Collectors.toList());

        Assertions.assertEquals(0, filteredCouponWalletList.size(),
                "Já existe um registro com o mesmo promocode: ".concat(this.promocode));
    }

    @E("possuo dados para CouponService - v1 - E2EPostCouponCoverage:")
    public void possuoDadosParaCouponServiceV1E2EPostCouponCoverage(DataTable dataTable) throws JsonProcessingException {
        Map<String, String> couponIdParameter = new HashMap<>();
        couponIdParameter.put("couponId", this.id.toString());
        BuilderRequest.path.accept(Util.rota.apply(CouponCoverage_v1.POST_COVERAGE), couponIdParameter);
        BuilderRequest.body.accept(Util.rota.apply(CouponCoverage_v1.POST_COVERAGE), CucumberUtils.getObjectBody(dataTable, PostAndPutCouponCoverage_v1Request.class));
        CouponCoverage_v1.postCoverage.run();
    }

    @E("valido CouponService - v1 - PostCouponCoverage:")
    public void validoCouponServiceV1PostCouponCoverage(DataTable dataTable) throws Throwable{
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(CouponCoverage_v1.POST_COVERAGE)).getServiceResponse()
                , PostCouponCoverage_v1Response.class
        );
    }

    @E("possuo dados para CouponService - v1 - E2EPostCouponCustomer:")
    public void possuoDadosParaCouponServiceV1E2EPostCouponCustomer(DataTable dataTable) throws JsonProcessingException {
        Map<String, String> couponIdParameter = new HashMap<>();
        couponIdParameter.put("couponId", this.id.toString());
        BuilderRequest.path.accept(Util.rota.apply(CouponCustomer_v1.POST_CUSTOMER), couponIdParameter);
        BuilderRequest.body.accept(Util.rota.apply(CouponCustomer_v1.POST_CUSTOMER), CucumberUtils.getObjectBody(dataTable, PostAndPutCouponCustomer_v1Request.class));
        CouponCustomer_v1.postCustomers.run();
    }

    @E("valido CouponService - v1 - LimitUses > CurrentUses")
    public void validoCouponServiceV1LimitUsesCurrentUses() {

    }

    @Quando("executo CouponService - v1 - E2EPostCoupon")
    public void executoCouponServiceV1E2EPostCoupon() {

    }

    @E("valido CouponService - v1 - CouponValidoPerfil")
    public void validoCouponServiceV1CouponValidoPerfil() {
        Map<String, String> couponIdParameter = new HashMap<>();
        couponIdParameter.put("couponId", this.id.toString());
        BuilderRequest.path.accept(Util.rota.apply(CouponCustomer_v1.GET_CUSTOMER_BY_COUPON_ID), couponIdParameter);
        CouponCustomer_v1.getCustomersByCouponId.run();
    }

    @Quando("executo CouponService - v1 - AddCouponCarteira:")
    public void executoCouponServiceV1AddCouponCarteira(DataTable datatable) throws JsonProcessingException{
        var promocodeRequest = CucumberUtils.getObjectBody(datatable, PostCouponWalletPromocodeV1Request.class);
        promocodeRequest.setCustomerCpf(this.customerCpf);
        promocodeRequest.setPromocode(this.promocode);

        BuilderRequest.body.accept(Util.rota.apply(CouponWalletV1.POST_COUPON_WALLET_PROMOCODE), promocodeRequest);

        CouponWalletV1.postCouponWalletPromocode.run();
    }

    @Entao("valido CouponService - v1 - StatusCode201:")
    public void validoCouponServiceV1StatusCode201(DataTable dataTable) throws Throwable {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(CouponWalletV1.POST_COUPON_WALLET_PROMOCODE)).getServiceResponse()
                , PostCouponWalletPromocodeV1Response[].class
        );
    }

    @E("valido CouponService - v1 - E2EPatchInactivateCouponByCouponId:")
    public void validoCouponServiceV1E2EPatchInactivateCouponByCouponId() {
        Map<String, String> couponIdParameter = new HashMap<>();
        couponIdParameter.put("id", this.id.toString());
        BuilderRequest.path.accept(Util.rota.apply(CouponV1.PATCH_INACTIVATE_COUPON_BY_ID), couponIdParameter);
        CouponV1.patchInactivate.run();
    }
}

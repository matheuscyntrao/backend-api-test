package utils.service;

public class ServiceCache {
    private ServiceResponse serviceResponse = new ServiceResponse();
    private ServiceSpecs serviceSpecs = new ServiceSpecs();

    public ServiceResponse getServiceResponse() {
        return serviceResponse;
    }

    public void setServiceResponse(ServiceResponse serviceResponse) {
        this.serviceResponse = serviceResponse;
    }

    public ServiceSpecs getServiceSpecs() {
        return serviceSpecs;
    }

    public void setServiceSpecs(ServiceSpecs serviceSpecs) {
        this.serviceSpecs = serviceSpecs;
    }
}

package dmitry.avgustis.prototype.ws;


import com.test.GetCountryRequest;
import com.test.GetCountryResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;


public class CountryClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(CountryClient.class);

    public GetCountryResponse getCountry(String name) {
        GetCountryRequest request = new GetCountryRequest();
        request.setName(name);
        log.info("Requesting quote for " + name);
        return (GetCountryResponse) getWebServiceTemplate().marshalSendAndReceive("http://localhost:8081/ws", request);
    }
}

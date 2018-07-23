package dmitry.avgustis.prototype.ws;

import hello.wsdl.Add;
import hello.wsdl.AddResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;


public class CalculatorClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(CalculatorClient.class);

    public AddResponse add(int a, int b) {
        Add request = new Add();
        request.setIntA(a);
        request.setIntB(b);
        return (AddResponse) getWebServiceTemplate()
                .marshalSendAndReceive(request, new SoapActionCallback("http://tempuri.org/Add"));
    }
}

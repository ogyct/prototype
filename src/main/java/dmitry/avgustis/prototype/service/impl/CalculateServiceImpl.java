package dmitry.avgustis.prototype.service.impl;

import dmitry.avgustis.prototype.service.CalculateService;
import dmitry.avgustis.prototype.ws.CalculatorClient;
import hello.wsdl.AddResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculateServiceImpl extends PrototypeService implements CalculateService {


    private final CalculatorClient calculatorClient;

    @Autowired
    public CalculateServiceImpl(CalculatorClient calculatorClient) {
        this.calculatorClient = calculatorClient;
    }

    @Override
    public int sum(int a, int b) {
        AddResponse response = calculatorClient.add(a, b);
        checkResponse(response);
        return response.getAddResult();
    }
}

package dmitry.avgustis.prototype.controller.v1;

import dmitry.avgustis.prototype.service.CalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = SoapToRestController.PREFIX, produces = MediaType.APPLICATION_JSON_VALUE)
public class SoapToRestController {
    static final String PREFIX = "client/soaptorest/v1";

    private final CalculateService calculateService;


    @Autowired
    public SoapToRestController(CalculateService calculateService) {
        this.calculateService = calculateService;
    }

    @GetMapping(value = "/add")
    public int add(int a, int b) {
        return calculateService.sum(a, b);
    }
}

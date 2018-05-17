package dmitry.avgustis.prototype;

import dmitry.avgustis.prototype.ws.CountryClient;
import io.spring.guides.gs_producing_web_service.GetCountryResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PrototypeApplicationTests {

	@Autowired
	private CountryClient client;

	@Test
	public void contextLoads() {
		GetCountryResponse result = client.getCountry("Spain");
		System.out.println(result.getCountry().getCapital());
	}

}

package dmitry.avgustis.prototype;

import com.fasterxml.jackson.databind.ObjectMapper;
import dmitry.avgustis.prototype.persist.Student;
import dmitry.avgustis.prototype.ws.CalculatorClient;
import hello.wsdl.AddResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static dmitry.avgustis.prototype.controller.v1.StudentController.STUDENT_API_PREFIX;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles(value = "test")
public class PrototypeApplicationTests {

//	@Autowired
//	private CountryClient client;

//	@Test
//	public void testSoapRequest() {
//		GetCountryResponse result = client.getCountry("Spain");
//		System.out.println(result.getCountry().getCapital());
//	}

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private CalculatorClient calculatorClient;

    @Test
    public void testGet() throws Exception {
        Student john = new Student();
        john.setName("John");
        john.setPassportNumber("JOHNPAssportID");


        this.mockMvc.perform(get("/" + STUDENT_API_PREFIX + "/Dima").contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString("Dima")));
        this.mockMvc.perform(put("/" + STUDENT_API_PREFIX + "/addStudent").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(john)))
                .andDo(print()).andExpect(content().string(containsString("John")));
        this.mockMvc.perform(delete("/" + STUDENT_API_PREFIX + "/deleteStudent?id=3")).andDo(print()).andExpect(status().isNoContent());
    }

    @Test
    public void testWsClient() {
        AddResponse response = calculatorClient.add(1, 2);
        assertEquals(3, response.getAddResult());
    }

}

@Configuration
@Profile("test")
class ApplicationSecurity extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) {
        web
                .ignoring()
                .antMatchers("/**");
    }
}

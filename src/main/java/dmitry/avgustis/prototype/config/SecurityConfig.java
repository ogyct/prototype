package dmitry.avgustis.prototype.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final CustomAuthenticationProvider customAuthProvider;

    @Autowired
    public SecurityConfig(CustomAuthenticationProvider customAuthProvider) {
        this.customAuthProvider = customAuthProvider;
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth)
            throws Exception {

        auth.authenticationProvider(customAuthProvider);
        auth.inMemoryAuthentication()
                .withUser("user")
                .password("pass")
                .roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/**")
                .authenticated();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
package my.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/shop").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login") //spodziewa sie tkich pol jak surnmae i password wiec w inputach name="surname", name=""password
                .permitAll()
                .and()
                .logout()//.logoutSuccessUrl("/shop")//kiedy.logoutSuccessfulUrl(/shop), po wylogowaniu kieruje do shopa, zeby tu widnia� napis you have booen logout w shop controller dodac object ""isLogout i w shop.html zrobic if
                .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user").password("password").roles("USER");//zapisuje to w pamieci tylko programu, nie jest to na trwąłe zapisane
    }
}
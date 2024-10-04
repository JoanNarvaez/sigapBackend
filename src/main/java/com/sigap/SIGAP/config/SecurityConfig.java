package com.sigap.SIGAP.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {



//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//
//            return httpSecurity
//                    .csrf(csrf->csrf.disable())
//                    .httpBasic(Customizer.withDefaults())
//                    .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                    .authorizeHttpRequests(http->{
//                        //Configurar los endpoits PUBLICOS
//                        http.requestMatchers(HttpMethod.GET,"/auth/hello").permitAll();
//                        //Configurar los endpoits PRIVADOS
//                        http.requestMatchers(HttpMethod.GET,"/auth/hello-secured").hasAuthority("CREATE");
//
//                        //Configurar el resto de endpoint - NO ESPECIFICADOS
//                        http.anyRequest().denyAll();
//                        // DENYALL RECHAZO TODOS LO QUE NO SE ESPECIFICO ES MAS RESTRINGIDO Y MAS SEGURO
////                        http.anyRequest().authenticated();
//                        //AUNQUE NO ESPECIFIQUE SI YO TENGO CREDECIALES CORRCTA ME VA DEJAR PASASAR - ES MAS PERMISIVO
//
//                    })
//                    .build();
//    }

    //TRABJAR CON ANOTACIONES

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

            return httpSecurity
                    .csrf(csrf->csrf.disable())
                    .httpBasic(Customizer.withDefaults())
                    .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                    .build();
    }


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();

        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(userDetailsService());
        return provider;
    }
    @Bean
    public UserDetailsService userDetailsService(){

        List<UserDetails> userDetailsList = new ArrayList<>();

        userDetailsList.add(User.withUsername("joan")
                .password("1234")
                .roles("ADMIN")
                .authorities("READ","CREATE").build());

        userDetailsList.add(User.withUsername("andres")
                .password("1234")
                .roles("USER")
                .authorities("READ").build());

        return new InMemoryUserDetailsManager(userDetailsList);

            }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
//    para solamnete pruebas NoOpasswordEncoder no es buena practica
    }
}

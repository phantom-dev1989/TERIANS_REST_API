/*
package com.terians.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

*/
/**
 * Created by stromero on 12/29/2014.
 *//*

@Configuration
public class OAuth2Config extends AuthorizationServerConfigurerAdapter {

    // This is required for password grants, which we specify below as one of the
    // {@literal authorizedGrantTypes()}.

    */
/**
     * This method is used to configure who is allowed to access which parts of our
     * resource server (i.e. the "/video" endpoint)
     *//*


    @Configuration
    @EnableResourceServer
    protected static class ResourceServer extends ResourceServerConfigurerAdapter {

        @Autowired
        private AuthenticationManagerBuilder builder;
        @SuppressWarnings("unused")
        private AuthenticationManager authenticationManager;

        @Override
        public void configure(HttpSecurity http) throws Exception {
            authenticationManager = new AuthenticationManager() {
                @Override
                public Authentication authenticate(Authentication authentication)
                        throws AuthenticationException {
                    return builder.getOrBuild().authenticate(authentication);
                }
            };

            // Require all GET requests to have client "read" scope
            http.authorizeRequests().antMatchers(HttpMethod.GET, "*/
/*")
                    .access("#oauth2.hasScope('read')");

            // Require all POST requests to have client "write" scope
            http.authorizeRequests().antMatchers(HttpMethod.POST, "*/
/*")
                    .access("#oauth2.hasScope('write')");

            http.csrf().disable();
        }

    }

    */
/**
     * This class is used to configure how our authorization server (the "/oauth/token" endpoint)
     * validates client credentials.
     *//*


    @Configuration
    @EnableAuthorizationServer
    protected static class AuthorizationServer extends AuthorizationServerConfigurerAdapter {

        private String applicationName = "terians-dasboard";

        @Override
        public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

            clients.inMemory()
                    .withClient("browser-"+applicationName)
                    .authorizedGrantTypes("password", "authorization_code", "refresh_token")
                    .authorities("ROLE_CLIENT", "ROLE_TRUSTED_CLIENT")
                    .scopes("read", "write")
                    .resourceIds(applicationName)
                    .secret("123456")
                    .accessTokenValiditySeconds(7200)
                    .and()
                    .build();
        }

    }
}
*/

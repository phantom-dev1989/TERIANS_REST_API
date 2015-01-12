package com.terians.config;

import com.terians.jpa.service.TeriansUserService;
import com.terians.jpa.service.TeriansUserServiceImpl;
// import com.terians.security.OAuth2Config;
// import com.terians.security.WebAppSecurityConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * This replaces the dispatcher-servlet.xml file
 * Created by stromero on 10/8/2014.
 */

@Configuration
// Same as  <mvc:annotation-driven/>
@EnableWebMvc
// Same as <context:component-scan base-package="com.terians" />
@ComponentScan(basePackages = {"com.terians"})
@Import({
        JPAConfig.class,
        Neo4JConfig.class,
   //   OAuth2Config.class,
   //   WebAppSecurityConfig.class
})
public class WebAppConfig extends WebMvcConfigurerAdapter {

    @Bean
    public TeriansUserService teriansUserService(){

        return new TeriansUserServiceImpl();
    }

    /**
     * inclusion The PropertySourcesPlaceholderConfigurer automatically lets the
     * annotation included property files to be scanned. setting it static to spawn on startup.
     * @return
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer()
    {
        PropertySourcesPlaceholderConfigurer ph = new PropertySourcesPlaceholderConfigurer();

        ph.setIgnoreUnresolvablePlaceholders(true);

        return ph;
    }
}

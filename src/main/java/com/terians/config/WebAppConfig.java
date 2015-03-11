package com.terians.config;

import com.terians.neo4j.service.*;
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
       // MongoDBConfig.class,
        Neo4JConfig.class,
        CacheConfig.class,
   //   OAuth2Config.class,
   //   WebAppSecurityConfig.class
})
public class WebAppConfig extends WebMvcConfigurerAdapter {

    @Bean
    public ClazzService clazzService(){

        return new ClazzServiceImpl();
    }

    @Bean
    public IssueService issueService(){

        return new IssueServiceImpl();
    }

    @Bean
    public MethodService methodService(){

        return new MethodServiceImpl();
    }

    @Bean
    public PackageService packageService(){

        return new PackageServiceImpl();
    }

    @Bean
    public VulnerabilityService vulnerabilityService(){

        return new VulnerabilityServiceImpl();
    }

    @Bean
    public ScanService scanService(){

        return new ScanServiceImpl();
    }

    @Bean
    public DependencyService dependencyService(){

        return new DependencyServiceImpl();
    }

    @Bean
    public ProjectService projectService(){

        return new ProjectServiceImpl();
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

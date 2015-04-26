package com.terians.config;

import com.terians.neo4j.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import static org.ajar.swaggermvcui.SwaggerSpringMvcUi.*;

/**
 * This replaces the dispatcher-servlet.xml file Created by stromero on
 * 10/8/2014.
 */

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.terians"})
@Import({
// MongoDBConfig.class,
        Neo4JConfig.class, CacheConfig.class, SwaggerConfig.class,
// OAuth2Config.class,
// WebAppSecurityConfig.class
})
public class WebAppConfig extends WebMvcConfigurerAdapter {

    /**
     * inclusion The PropertySourcesPlaceholderConfigurer automatically lets the
     * annotation included property files to be scanned. setting it static to
     * spawn on startup.
     *
     * @return
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        PropertySourcesPlaceholderConfigurer ph = new PropertySourcesPlaceholderConfigurer();

        ph.setIgnoreUnresolvablePlaceholders(true);

        return ph;
    }

    @Bean
    public ClazzService clazzService() {

        return new ClazzServiceImpl();
    }

    @Bean
    public IssueService issueService() {

        return new IssueServiceImpl();
    }

    @Bean
    public MethodService methodService() {

        return new MethodServiceImpl();
    }

    @Bean
    public PackageService packageService() {

        return new PackageServiceImpl();
    }

    @Bean
    public VulnerabilityService vulnerabilityService() {

        return new VulnerabilityServiceImpl();
    }

    @Bean
    public ScanService scanService() {

        return new ScanServiceImpl();
    }

    @Bean
    public DependencyService dependencyService() {

        return new DependencyServiceImpl();
    }

    @Bean
    public ProjectService projectService() {

        return new ProjectServiceImpl();
    }

    // Swagger Related Code
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(WEB_JAR_RESOURCE_PATTERNS)
                .addResourceLocations(WEB_JAR_RESOURCE_LOCATION)
                .setCachePeriod(0);
    }

    @Override
    public void configureDefaultServletHandling(
            DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Bean
    public InternalResourceViewResolver getInternalResourceViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix(WEB_JAR_VIEW_RESOLVER_PREFIX);
        resolver.setSuffix(WEB_JAR_VIEW_RESOLVER_SUFFIX);
        return resolver;
    }
}

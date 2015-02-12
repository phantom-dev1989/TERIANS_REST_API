package com.terians.config;

import com.terians.properties.Neo4JDatabaseProperties;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.JtaTransactionManagerFactoryBean;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.transaction.ChainedTransactionManager;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by stromero on 12/1/2014.
 */

@Configuration
@EnableTransactionManagement
@EnableNeo4jRepositories("com.terians.neo4j.repository")
public class Neo4JConfig extends Neo4jConfiguration {

    @Autowired
    private Neo4JDatabaseProperties config;
    @Autowired
    private LocalContainerEntityManagerFactoryBean entityManagerFactory;

    public Neo4JConfig(){
        this.setBasePackage("com.terians.neo4j.model");
    }

    @Bean
    GraphDatabaseService graphDatabaseService() {
        return new GraphDatabaseFactory().newEmbeddedDatabaseBuilder("C:\\TERIANS\\TERIANS_SEMANTIC_ENGINE\\neo4j-community-2.1.7\\data\\graph.db").newGraphDatabase();
    }

    @Override
    @Bean(name = "transactionManager")
    public PlatformTransactionManager neo4jTransactionManager() throws Exception {
        return new ChainedTransactionManager(new JpaTransactionManager(entityManagerFactory.getObject()),
                new JtaTransactionManagerFactoryBean(graphDatabaseService()).getObject());
    }
}

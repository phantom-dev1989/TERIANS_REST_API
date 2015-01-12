package com.terians.config;

import com.terians.properties.Neo4JDatabaseProperties;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
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

    @Bean
    GraphDatabaseService graphDatabaseService() {
        return new GraphDatabaseFactory().newEmbeddedDatabase(config.getPath());
    }
}

package com.durga.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.CassandraSessionFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.convert.CassandraConverter;
import org.springframework.data.cassandra.convert.MappingCassandraConverter;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.mapping.BasicCassandraMappingContext;
import org.springframework.data.cassandra.mapping.CassandraMappingContext;

@Configuration
@PropertySource(value={"classpath:cassandra.properties"})
public class CassandraUtil {
	
	private static final String KEYSPACE="cassandra.keyspace";
	
	private static final String CONTACTPOINTS="cassandra.contactpoints";
	
	private static final String PORT="cassandra.port";
	
	@Autowired
	private Environment environment;
	
	public CassandraUtil() {
        System.out.println("CassandraUtil()");
    }
    
    private String getKeyspaceName() {
        return environment.getProperty(KEYSPACE);       
    }
    
    private String getContactPoints() {
        return environment
                .getProperty(CONTACTPOINTS);        
    }
    
    private int getPortNumber() {
        return Integer.parseInt(environment
                .getProperty(PORT));        
    }

	@Bean
	public CassandraClusterFactoryBean cluster(){
		CassandraClusterFactoryBean cluster=new CassandraClusterFactoryBean();
		cluster.setContactPoints(getContactPoints());
		cluster.setPort(getPortNumber());
		return cluster;
		
	}
	
	 @Bean
	    public CassandraMappingContext mappingContext() {
	        return new BasicCassandraMappingContext();
	    }

	    @Bean
	    public CassandraConverter converter() {
	        return new MappingCassandraConverter(mappingContext());
	    }

	    @Bean
	    public CassandraSessionFactoryBean session() throws Exception{
	    	 CassandraSessionFactoryBean csfb=new CassandraSessionFactoryBean();
	    	 csfb.setCluster(cluster().getObject());
	    	 csfb.setKeyspaceName(getKeyspaceName());
	    	 csfb.setConverter(converter());
	    	 csfb.setSchemaAction(SchemaAction.NONE);
	    	 return csfb;
	    }
	    
	    
	    @Bean
	    public CassandraOperations cassandraTemplate() throws Exception {
	        return new CassandraTemplate(session().getObject());
	    }

}
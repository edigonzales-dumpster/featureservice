package ch.so.agi.featureservice;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DataSourceConfig {

    @Autowired
    private AppProperties config;
    
    @Bean
	public Map<String, DataSource> getDataSources() {
        Map<String, DataSource> ds = new HashMap<String, DataSource>();

        DataSourceBuilder dataSourceBuilder = DataSourceBuilder
        		.create()
        		.driverClassName("org.postgresql.Driver")
        		.username("gretl")
        		.password("gretl")
        		.url("jdbc:postgresql://localhost:54321/edit");
        
        DataSource foo = dataSourceBuilder.build();
//        System.out.println(foo.getConnection().getMetaData());
        
        //HikariConfig config = new HikariConfig();
        
        
        HikariDataSource hds = (HikariDataSource) dataSourceBuilder.build();
//        hds.setMaximumPoolSize(maxPoolSize);
        
        
        ds.put("test1", dataSourceBuilder.build());
        
        System.out.println(ds.get("test1"));
        
        return ds;
	}
	
}

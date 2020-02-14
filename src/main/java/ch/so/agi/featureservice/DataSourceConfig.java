package ch.so.agi.featureservice;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DataSourceConfig {

    @Autowired
    private AppProperties config;
    
    @Bean
	public Map<String, DataSource> getDataSources() {
        Map<String, DataSource> datasources = new HashMap<String, DataSource>();

        DataSourceBuilder dataSourceBuilder = DataSourceBuilder
        		.create()
        		.driverClassName("org.postgresql.Driver")
        		.username("gretl")
        		.password("gretl")
        		.url("jdbc:postgresql://localhost:54321/edit?ApplicationName="+ new Date().getTime());
        
        DataSource foo = dataSourceBuilder.build();
//        System.out.println(foo.getConnection().getMetaData());
        
        //HikariConfig config = new HikariConfig();
        
        
//        HikariDataSource ds = (HikariDataSource) dataSourceBuilder.build();
//        ds.setMinimumIdle(2);
//        ds.setMaximumPoolSize(10);
//        ds.setConnectionTimeout(30000);
//        ds.setIdleTimeout(10000);
//        ds.setMaxLifetime(30000);
//        ds.setPoolName("SpringBootHikariCP");
        
        DataSource ds = dataSourceBuilder.build();
        
        // foo bar a v d d e d f
        datasources.put("test1", ds);
        System.out.println(ds.getClass());
        
        System.out.println(datasources.get("test1"));
        
        return datasources;
	}
	
}

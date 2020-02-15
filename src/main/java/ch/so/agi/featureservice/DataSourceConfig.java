package ch.so.agi.featureservice;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ch.qos.logback.classic.Logger;
import ch.so.agi.featureservice.AppConfig.Datasource;

//import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DataSourceConfig {

    @Autowired
    private AppConfig config;
    
    @Bean
	public Map<String, DataSource> getDataSources() {
        Map<String, DataSource> datasources = new HashMap<String, DataSource>();
        
        List<Datasource> configDatasources = config.getDatasources();
        for (Datasource configDatasource : configDatasources) {
            String dsId = configDatasource.getId();
            String dsUrl = configDatasource.getUrl() + "?ApplicationName=sogis-featureservice";
            String dsUser = configDatasource.getUser();
            String dsPassword = configDatasource.getPassword();
                        
            DataSourceBuilder dataSourceBuilder = DataSourceBuilder
                    .create()
                    .driverClassName("org.postgresql.Driver")
                    .username(dsUser)
                    .password(dsPassword)
                    .url(dsUrl);
            
            org.apache.tomcat.jdbc.pool.DataSource datasource = (org.apache.tomcat.jdbc.pool.DataSource) dataSourceBuilder.build();
            datasource.setName(dsId);
            datasource.setMaxActive(10);
            datasource.setMinIdle(2);
            datasource.setMaxIdle(10);            
            datasource.setInitialSize(2);
            
            datasources.put(dsId, datasource);
        }        
        return datasources;
	}
}

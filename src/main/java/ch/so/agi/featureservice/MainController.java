package ch.so.agi.featureservice;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.zaxxer.hikari.HikariDataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class MainController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AppConfig config;
    
    @Autowired
    private DataSourceConfig dataSourceConfig;
    
    @GetMapping("/")
    public ResponseEntity<?> getAppDetails() throws SQLException {
//        Map<String, HashMap<String,String>> appDetails = new HashMap<>();

        log.info(dataSourceConfig.getClass().toString());
        log.info(String.valueOf(dataSourceConfig.hashCode()));
        
        try (Connection conn = dataSourceConfig.getDataSources().get("pubdb").getConnection()) {
            Statement stmt = conn.createStatement();

            log.info(conn.getClass().toString());
            log.info(String.valueOf(conn.hashCode()));
            

            System.out.println("Hallo Welt.");
        }
        
        
//        log.info(config.getDatasources().toString());
//        log.info(config.getDatasets().toString());
        
//        log.info(dataSourceConfig.getDataSources().get("test1").toString());
//        
//        try (Connection conn = dataSourceConfig.getDataSources().get("test1").getConnection()) {
//            Statement stmt = conn.createStatement();  
//
//            System.out.println("Hallo Welt.");
//        }
       
//        ResultSet rs = stmt.executeQuery("select * from public.spatial_ref_sys");  
//        while(rs.next()) {
//        	//log.info(rs.getString(1));
//        }

        
//        HikariDataSource hds1 = (HikariDataSource) dataSourceConfig.getDataSources().get("test1");
//        System.out.println(hds1.getMaximumPoolSize());
//        
//        HikariDataSource hds2 = (HikariDataSource) dataSourceConfig.getDataSources().get("test1");
//        System.out.println(hds2.getMaximumPoolSize());

        
        
        return ResponseEntity.ok(config.getDatasources().toString());
    }
}

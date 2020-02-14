package ch.so.agi.featureservice;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class MainController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AppProperties config;
    
    @Autowired
    private DataSourceConfig dataSourceConfig;
    
    @GetMapping("/")
    public Map<String, HashMap<String, String>> getAppDetails() throws SQLException {
        Map<String, HashMap<String,String>> appDetails = new HashMap<>();

        log.info(config.getDatasources().toString());
        log.info(config.getDatasets().toString());
        
        log.info(dataSourceConfig.getDataSources().get("test1").toString());
        
        Connection conn = dataSourceConfig.getDataSources().get("test1").getConnection();
        Statement stmt = conn.createStatement();  
        ResultSet rs = stmt.executeQuery("select * from public.spatial_ref_sys");  
        while(rs.next()) {
        	//log.info(rs.getString(1));
        }

        
        return appDetails;
    }
}

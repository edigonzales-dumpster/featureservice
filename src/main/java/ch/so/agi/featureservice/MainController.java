package ch.so.agi.featureservice;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ch.so.agi.featureservice.AppConfig.Dataset;
import ch.so.agi.featureservice.AppConfig.Datasource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

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
    
    @GetMapping("/foo")
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
        return ResponseEntity.ok(config.getDatasources().toString());
    }
    
    @GetMapping("/")
    public ResponseEntity<?> landingPage(@RequestParam(value="format", required=false, defaultValue="html") String format) {

        // redirect html to collections html
        
        return ResponseEntity.ok("Landing page. Format="+format);
    }
    
    @Operation(summary = "Find Contacts by name", description = "Name search by %name% format", tags = { "contact" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "successful operation") })  
    @GetMapping("/collections") 
    public ResponseEntity<?> collections(@RequestParam(value="format", required=false, defaultValue="html") String format) {
        
        List<Dataset> datasets = config.getDatasources()
                .stream()
                .filter(ds -> ds.getDatasets() != null)
                .flatMap(ds -> ds.getDatasets().stream())
                .collect(Collectors.toList());
            


        return ResponseEntity.ok("Collections. Format="+format + " - " + datasets.toString());
    }
}

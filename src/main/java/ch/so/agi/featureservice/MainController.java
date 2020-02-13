package ch.so.agi.featureservice;

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
    
    @GetMapping("/")
    public Map<String, HashMap<String, String>> getAppDetails() {
        Map<String, HashMap<String,String>> appDetails = new HashMap<>();

        log.info(config.getDatasources().toString());
        log.info(config.getDatasets().toString());
        
        return appDetails;
    }
}

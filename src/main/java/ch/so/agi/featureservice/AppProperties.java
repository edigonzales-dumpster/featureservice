package ch.so.agi.featureservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "app")
public class AppProperties {
    
    private List<Datasource> datasources = new ArrayList<Datasource>();
    
    //private List<Dataset> datasets = new ArrayList<Dataset>();
    
    public List<Datasource> getDatasources() {
        return datasources;
    }

    public void setDatasources(List<Datasource> datasources) {
        this.datasources = datasources;
    }

//    public List<Dataset> getDatasets() {
//        return datasets;
//    }
//
//    public void setDatasets(List<Dataset> datasets) {
//        this.datasets = datasets;
//    }

    public static class Dataset {
        private String name;
        private String title;
        private String datasource;
        private String schema;
        private String table;
        
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getTitle() {
            return title;
        }
        public void setTitle(String title) {
            this.title = title;
        }
        public String getDatasource() {
            return datasource;
        }
        public void setDatasource(String datasource) {
            this.datasource = datasource;
        }
        public String getSchema() {
            return schema;
        }
        public void setSchema(String schema) {
            this.schema = schema;
        }
        public String getTable() {
            return table;
        }
        public void setTable(String table) {
            this.table = table;
        }
		@Override
		public String toString() {
			return "Dataset [name=" + name + ", title=" + title + ", datasource=" + datasource + ", schema=" + schema
					+ ", table=" + table + "]";
		}
    }
    
    public static class Datasource {
        private String id;
        private String url;
        private String user;
        private String password;
        private List<Dataset> datasets;

        public String getId() {
            return id;
        }
        public void setId(String id) {
            this.id = id;
        }
        public String getUrl() {
            return url;
        }
        public void setUrl(String url) {
            this.url = url;
        }
        public String getUser() {
            return user;
        }
        public void setUser(String user) {
            this.user = user;
        }
        public String getPassword() {
            return password;
        }
        public void setPassword(String password) {
            this.password = password;
        }
		public List<Dataset> getDatasets() {
			return datasets;
		}
		public void setDatasets(List<Dataset> datasets) {
			this.datasets = datasets;
		}
		@Override
		public String toString() {
			return "Datasource [id=" + id + ", url=" + url + ", user=" + user + ", password=" + password + ", datasets="
					+ datasets + "]";
		}

    }
}


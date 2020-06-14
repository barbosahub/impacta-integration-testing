package definition;

import com.sun.deploy.config.JREInfo;
import groovy.json.internal.LazyMap;

public class ProcessImpacta {
    private  static String url = "http://agapito-server.herokuapp.com/processos";
    private static LazyMap fieldsJson = new LazyMap();
    private static String lastid = "";
    public static String getUrl(){
        return url;
    }

    public static void clearFields() {
        fieldsJson.clear();
    }

    public static void addFields(String field, String value) {
        fieldsJson.put(field,value);
    }

    public static LazyMap getFields() {
        return fieldsJson;
    }

    public static void setLastId(String id) {
        lastid = id;
    }

    public static String getLastId() {
        return lastid;
    }
}


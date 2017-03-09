package apilib;

import framework.ReadData;
import org.json.JSONObject;
import utils.HttpUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class QueryBuilder {
    private final Map<String, String> params = new HashMap<>();

    private String sendRequest;
    private String method;

    private static String API_VERSION = ReadData.getProperty("version");
    private static String API_ADDRESS_TEMP = ReadData.getProperty("api_address");
    private static String ACCESS_TOKEN = ReadData.getProperty("token");

    protected QueryBuilder(String method) {
        this.method = method;
        accessToken();
    }

    public void addParams(String key, String value) {
        params.put(key, value);
    }

    public void addParams(String key, String... value) {
        String val = "";

        for (int i = 0; i < value.length; i++) {
            val = val.concat(value[i]);
        }

        params.put(key, val);
    }

    public void addParams(String key, Integer value) {
        params.put(key, String.valueOf(value));
    }

    public void addParams(String key, Float value) {
        params.put(key, String.valueOf(value));
    }

    public void addParams(String key, Boolean value) {
        params.put(key, boolAsParam(value));
    }

    protected static String boolAsParam(boolean param) {
        return param ? "1" : "0";
    }

    protected void accessToken() {
        addParams("access_token", ACCESS_TOKEN);
    }

    public String buildQuery() {
        return String.format(API_ADDRESS_TEMP, method).concat("?").concat(mapToGetString(params));
    }

    private static String mapToGetString(Map<String, String> params) {
        return params.entrySet().stream()
                .map(entry -> entry.getKey() + "=" + entry.getValue())
                .collect(Collectors.joining("&"));
    }

    public JSONObject getResponse() {
        return HttpUtils.sendGet(buildQuery());
    }
}

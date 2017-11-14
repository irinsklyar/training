package com.training.process;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;

public class ConnToApi {

    public static HashMap<String,String> jsonStringToHashMap(String json_string) throws Exception{
        JSONObject jsonObject = new JSONObject(json_string);
        HashMap<String ,String> map = new HashMap<String ,String>();
        Iterator<?> keys = jsonObject.keys();

        while( keys.hasNext() ){
            String key = (String)keys.next();
            String value = jsonObject.get(key).toString();
            map.put(key, value);
        }
        return map;
    }

    public HashMap<String,String> sendGet(String urlcity) throws Exception {

        String url = urlcity;

        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);

        HttpResponse response = client.execute(post);

        String json_string = EntityUtils.toString(response.getEntity());
        HashMap<String ,String> hashMap = jsonStringToHashMap(json_string);
       return hashMap;
    }
}

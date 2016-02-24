package c4q.lighterletter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.net.URL;

public class Main {

    public static String getJSON() {

        URL url = HTTP.stringToURL("http://jsonplaceholder.typicode.com/posts/1/comments");
        String doc = HTTP.get(url);

        JSONParser parser = new JSONParser();
        try {

            JSONArray weatherJSONArray = (JSONArray)parser.parse(doc);
            JSONObject JSONObj = (JSONObject)weatherJSONArray.get(0);
            String returnedJSON = (String)JSONObj.get("name");

            return returnedJSON;

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {

        System.out.println(getJSON());

    }
}
package org.example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class ReadJson {
    public static void main(String[] args) throws IOException, ParseException {
        JSONParser jsonparser=new JSONParser();//Parsing JSON file
        FileReader filereader=new FileReader("/Users/ishasethia/IdeaProjects/firstMaven/jsonfiles/firstjson.json");//reading the file
        Object o= jsonparser.parse(filereader);//giving the parsed file to an object
        JSONObject jobj=(JSONObject) o;
        String k = (String) jobj.get("Hello");
        System.out.println( "HELLO-"+k);//write the values present in folder!!
        JSONArray jarray=(JSONArray)jobj.get("employees") ;//take the array value!!
        for(int i=0;i<jarray.size();i++) {
            JSONObject e=(JSONObject)jarray.get(i);
            //display the array values in JSON file!!!
            String f = (String) e.get("firstName");
            String l = (String) e.get("lastName");
            System.out.println("First-Name:=" + f);
            System.out.println("Last-Name:=" + l);
        }





    }
}

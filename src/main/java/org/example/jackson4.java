package org.example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class jackson4 {
    public static void main(String[] args) throws IOException, ParseException {
        JSONParser jsonparser=new JSONParser();
        FileReader filereader = new FileReader("src/main/java/org/example/file.json");
        Object obj=jsonparser.parse(filereader);
        JSONObject jobj=(JSONObject) obj;
        JSONArray jarray=(JSONArray) jobj.get("Employees");
        for (int i=0;i<jarray.size();i++)
        {
            JSONObject e=(JSONObject)jarray.get(i);
            String userId=(String)e.get("userId");
            String jobTitle=(String)e.get("jobTitle");
            String firstName=(String)e.get("firstName");
            String lastName=(String)e.get("lastName");
            String employeeCode=(String)e.get("employeeCode");
            String region=(String)e.get("region");
            String phoneNumber=(String) e.get("phoneNumber");
            String emailAddress=(String)e.get("emailAddress");
            System.out.println("userId:= "+userId+", jobTitle:= "+jobTitle+", firstName:= "+firstName+", lastName:= "+lastName+", \nemployeeCode:= "+employeeCode+", region:="+region+", phoneNumber:= "+phoneNumber+", \nemailAddress:= "+emailAddress+"\n");
        }

    }
}

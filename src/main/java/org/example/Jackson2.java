package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Jackson2 {
    public static void main(String[] args) throws IOException {

        ObjectMapper mapper=new ObjectMapper();
        GetterSetter gs = mapper.readValue(new File("/Users/ishasethia/IdeaProjects/firstMaven/src/main/java/org/example/practice.json"),GetterSetter.class);

        System.out.println("FILE-DATA ::=>"+gs);

        List<GetterSetter> getset = mapper.readValue(new File("src/main/java/org/example/employee.json"), new TypeReference<List<GetterSetter>>() {});
        System.out.println("EMPLOYEE-LIST ::=> "+getset);

        GetterSetter[] array=mapper.readValue(new File("src/main/java/org/example/employee.json"), GetterSetter[].class);
        System.out.println("EMPLOYEE-ARRAY::=>");
        for (GetterSetter gss:array)
        {
            System.out.println(gss);
        }


    }

    }
/*JSONObject obj = new JSONObject();

            obj.put("name","foo");
            obj.put("num", 100);
            obj.put("balance", 1000.21);
            obj.put("is_vip", Boolean.TRUE);

            StringWriter out = new StringWriter();
            obj.writeJSONString(out);

            String jsonText = out.toString();
            System.out.println(jsonText);*/
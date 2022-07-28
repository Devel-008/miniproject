package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SerializeList {
    public static void main(String[] args) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        List<String> s = new ArrayList<>();
        s.add("milk");
        s.add("food");
        s.add("whole-grain");
        s.add("multi-vitamin");
        s.add("milkshake");

        String jsonString=mapper.writeValueAsString(s);
        System.out.println(jsonString);

        Map<Integer,String> map=new HashMap<>();
        map.put(1,"abc");
        map.put(2,"def");
        map.put(3,"ghi");
        map.put(4,"jkl");
        map.put(5,"mno");

        String jsonmap= mapper.writeValueAsString(map);
        System.out.print(jsonmap);

    }
}
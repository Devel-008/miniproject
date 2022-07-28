package org.example;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class jackson5 {
    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            demo d=new demo("shree","bikaner","computer science","Itern");
            mapper.writeValue(new File("target/emp.json"),d);

        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
}

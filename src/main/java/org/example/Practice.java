package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class Practice {
    public static void main(String[] args) throws IOException {
        String jsonString="[ 100, 500, 300, 200, 400 ] ";
        ObjectMapper mapper=new ObjectMapper();
       // File file=new File("src/main/java/org/example/jackson.json");
        String s=mapper.writeValueAsString(jsonString);
        System.out.println(s);
    }
}

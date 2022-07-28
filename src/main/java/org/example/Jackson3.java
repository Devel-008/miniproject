package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Jackson3 {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper=new ObjectMapper();

        ReadWrite[] read=mapper.readValue(new File("src/main/java/org/example/new.json"),    ReadWrite[].class);
        for(ReadWrite rw:read) {
            System.out.println("USER::=>" + rw);
        }

    }
}

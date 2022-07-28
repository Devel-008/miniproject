package org.example;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
//@JsonIgnore allows us to ignore a specific field, either going
//from java to json or json to java
public class JsonAnnotationSerialization {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Apple a = new Apple();
        a.c="India";
        a.color="Saffron, white, blue, green";
        a.quantity=11;

        String jsonString = mapper.writeValueAsString(a);
        System.out.println(jsonString);

    }
}
class Apple
{
    @JsonIgnore//ignore c's value
    public String c;
    public String color;
    public int quantity;
}

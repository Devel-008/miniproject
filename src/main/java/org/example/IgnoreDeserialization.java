package org.example;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class IgnoreDeserialization {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper= new ObjectMapper();
        String jsonString="{\"brandname\":\"Honda\",\"type\":\"Accord\",\"quantity\":\"20\",\"color\":\"red\"}";
        Back b=mapper.readValue(jsonString,Back.class);
        System.out.println("BRAND-NAME:-"+b.brandname+"\nMODEL-NAME:-"+b.type+"\nQuantity:-"+b.quantity+"\nCOLOR:-"+b.color+"\n"+ b.hello);


    }
}
class Back{
    public String brandname;
    public String type;
    @JsonIgnore
    public int quantity=4;//update the quantity as 4 and ignore 20!!!!
    public String color;
    public boolean hello;
}

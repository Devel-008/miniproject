package org.example;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonAnnoationDeserializable {
    public static void main(String[] args) throws JsonProcessingException {
        String jsonString="{\"brandname\":\"Honda\",\"type\":\"Accord\",\"color\":\"red\"}";
        ObjectMapper mapper = new ObjectMapper();
        Car car = mapper.readValue(jsonString,Car.class);
        System.out.println("BRAND-NAME:-"+car.brand+"\nMODEL-NAME:-"+car.model+"\nCOLOR:-"+car.color);

    }
}
class Car
{
    @JsonAlias({"brandname","brand_name","mybrandName"})
    public String brand;
    @JsonAlias({"type"})
    public String model;
    public String color;
}
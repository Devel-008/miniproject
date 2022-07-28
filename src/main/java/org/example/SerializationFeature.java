package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SerializationFeature {
    public static  void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper= new ObjectMapper();
        mapper.enable(com.fasterxml.jackson.databind.SerializationFeature.INDENT_OUTPUT);
        Brand brand=new Brand();
        brand.model="Ford F150";
        brand.engine.cylinders=4;
        brand.engine.horsepower=255;
        String jsonString=mapper.writeValueAsString(brand);
        System.out.println(jsonString);

    }
}
class Brand{
    public String model;
   public Engine engine=new Engine();

}
class Engine{
    public int cylinders;
    public float horsepower;
}

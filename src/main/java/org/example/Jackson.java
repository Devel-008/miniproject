package org.example;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class Jackson extends JsonFactory {
    private String brand=null;
    private int doors=0;




    public String getBrand()
    {
        return this.brand;
    }
    public void setBrand(String brand)
    {
        this.brand=brand;
    }
    public int getDoors()
    {
        return this.doors;
    }
    public void setDoors(int doors)
    {
        this.doors=doors;
    }


    public static void main(String[] args) {
        ObjectMapper om= new ObjectMapper();
        String c="{ \"brand\" : \"Mercedes\", \"doors\" : 5 }";
        File file=new File("/Users/ishasethia/IdeaProjects/firstMaven/src/main/java/org/example/car.json");
        try{
            Jackson car=om.readValue(c,Jackson.class);
            Jackson j=om.readValue(file,Jackson.class);
            System.out.println("car brand = " + car.getBrand());
            System.out.println("car doors = " + car.getDoors());

            System.out.println("car brand = " + j.getBrand());
            System.out.println("car doors = " + j.getDoors());


        }catch(Exception e){
            System.out.println(e);
        }


    }

}
/*File file=new File("/Users/ishasethia/IdeaProjects/firstMaven/jsonfiles/firstjson.json");
            Jackson j=om.readValue(file,Jackson.class);
            String k = (String) j.getHello();
            System.out.println( "HELLO-"+k);//write the values present in folder!!*/
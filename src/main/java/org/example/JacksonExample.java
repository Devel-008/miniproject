package org.example;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

//create class JacksonExample to understand implementation of Jackson
public class JacksonExample {
    // main() method start
    public static void main(String[] args){
        // create an instance of ObjectMapper class
        ObjectMapper mapper = new ObjectMapper();
        // create a JSON string of employee details to deserilized object
        String stdString = """
                {
                "students" : [
                {
                "stdId":"001",
                "course":"MCA",
                "firstName":"Nicholas",
                "lastName":"Clemens",
                "preferredFullName":"Nicholas Clemens",
                "enrol":"S010",
                "region":"indian",
                "phoneNumber":"408-1234567",
                "emailAddress":"nicholas.clemens@gmail.com"
                },
                {
                "stdId":"002",
                "course":"BCA",
                "firstName":"Sharon",
                "lastName":"Lorenz",
                "preferredFullName":"Sharon Lorenz",
                "enrol":"S011",
                "region":"indian",
                "phoneNumber":"408-1111111",
                "emailAddress":"sharon.lorenz@gmail.com"
                },
                {
                "stdId":"003",
                "course":"Btech",
                "firstName":"Brittany",
                "lastName":"Hart",
                "preferredFullName":"Brittany Hart",
                "enrol":"S012",
                "region":"indian",
                "phoneNumber":"408-2222222",
                "emailAddress":"brittany.hart@gmail.com"
                }
                ]
                }""";

        try{
            // use ObjectMapper for mapping JSON to Student
            Students students = mapper.readValue(stdString, Students.class);

            // print students
            System.out.println(students);

            // serialize students into json string
            stdString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(students);

            System.out.println(stdString);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

//create Students class
class Students {

    public List<Student> students;
    // getter and setter
    public List<Student> getStudent() {
        return students;
    }
    public void setStudent(List<Student> students) {
        this.students = students;
    }
}


class Student {

    // declare variables
    private String stdId;
    private String course;
    private String firstName;
    private String lastName;
    private String preferredFullName;
    private String enrol;
    private String region;
    private String phoneNumber;
    private String emailAddress;

    public Student(){

    }

    // getter/setters for all variables
    public String getStdId() {
        return stdId;
    }
    public void setStdId(String stdId) {
        this.stdId = stdId;
    }

    public String getCourse() {
        return course;
    }
    public void getCourse(String course) {
        this.course = course;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPreferredFullName() {
        return preferredFullName;
    }
    public void setPreferredFullName(String preferredFullName) {
        this.preferredFullName = preferredFullName;
    }

    public String getEnrol() {
        return enrol;
    }
    public void setEnrol(String enrol) {
        this.enrol = enrol;
    }

    public String getRegion() {
        return region;
    }
    public void setRegion(String region) {
        this.region = region;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String toString(){
        return "Employee [ Student Id: "+stdId+", Course: "+course+ ""
                + ", First Name: \"+firstName+ \", Last Name: \"+lastName+ \""
                + ", Name: \"+preferredFullName+ \", Enrol No: \"+enrol+ \""
                + ", Region: \"+region+ \", Phone Number: \"+phoneNumber+ \""
                + ", Email Address: \"+emailAddress+ \" ]";
    }
}
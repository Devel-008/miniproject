package org.example;
import java.lang.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Connection conn=null;
        PreparedStatement stmt = null;

        String n;
        Statement s1=null;
        String sql="insert into ninth (rollNo, FullName,FatherName, Address, dob, english, hindi, maths, science,  social,  percentage) values( ?,?,?,?,?,?,?,?,?,?,?)";
            Class.forName("org.postgresql.Driver");
                conn = DriverManager
                .getConnection("jdbc:postgresql://localhost:5432/students",
                        "postgres", "isha@123");
                System.out.println("Opened database successfully");
             //stmt = conn.createStatement();

            // TABLE CREATED String sql = "CREATE TABLE Ninth (rollNo INT PRIMARY KEY NOT NULL, FullName varchar(50) not null, FatherName varchar(50) not null, Address varchar(50) not null, dob varchar(50) not null, english float not null, hindi float not null, maths float not null, science float not null, social float
            // not null, percentage float not null);  ";

            Scanner sc=new Scanner(System.in);
           do {
               System.out.println("1] Press i to INSERT \n 2] Press d to DELETE \n 3]Press s to READ \n 4]Press any other key to exit");
               String c=sc.nextLine();

               if(c.startsWith("i")) {
                   System.out.println("Enter Full name:= ");
                   String name = sc.nextLine();
                   System.out.println("Enter Father name:= ");
                   String Fathername = sc.nextLine();
                   System.out.println("Enter Address:= ");
                   String add = sc.nextLine();
                   System.out.println("Enter Date of Birth := ");
                   String dob = sc.nextLine();
                   System.out.println("Enter English marks out 100 := ");
                   float eng = sc.nextFloat();
                   System.out.println("Enter Hindi marks out 100:= ");
                   float hindi = sc.nextFloat();
                   System.out.println("Enter Maths Marks out 100 := ");
                   float maths = sc.nextFloat();
                   System.out.println("Enter Science Marks out 100:= ");
                   float sci = sc.nextFloat();
                   System.out.println("Enter Social marks out 100 := ");
                   float sst = sc.nextFloat();
                   float total = eng + sci + maths + hindi + sst;
                   float per = (total * 100) / 500;
                   System.out.println("Enter Roll Number:= ");
                   int rollNo = sc.nextInt();

                   stmt = conn.prepareStatement(sql);

                   stmt.setInt(1, rollNo);
                   stmt.setString(2, name);
                   stmt.setString(3, Fathername);
                   stmt.setString(4, add);
                   stmt.setString(5, dob);
                   stmt.setFloat(6, eng);
                   stmt.setFloat(7, hindi);
                   stmt.setFloat(8, maths);
                   stmt.setFloat(9, sci);
                   stmt.setFloat(10, sst);
                   stmt.setFloat(11, per);
                   int row = stmt.executeUpdate();
                   System.out.println(row + "INSERTED");
                   stmt.close();

               } else if (c.startsWith("d"))
               {
                   System.out.println("Enter Roll Number you want to delete:= ");
                   int r = sc.nextInt();
                   String select="select rollno from ninth";
                   PreparedStatement st=conn.prepareStatement(select);
                   ResultSet rs=st.executeQuery();
                   while(rs.next()) {
                       int id = rs.getInt("rollno");
                       if (r == id) {
                           String delete = "DELETE FROM ninth WHERE rollno=?";
                           PreparedStatement s2 = conn.prepareStatement(delete);

                           s2.setInt(1, r);
                           int v = s2.executeUpdate();
                           if (v > 0) {
                               System.out.println(v + "DELETED SUCCESSFULLY");
                           } else {
                               System.out.println("Error OCCURED OR DATA NOT EXIST!!!!");
                           }
                       }st.close();
                   }
               } //READ DATA
                else if (c.startsWith("s")) {
                   s1=conn.createStatement();
                   String se="select * from ninth";
                   ResultSet rs = s1.executeQuery(se);
                   if(rs.next()){
                       //Display values
                       System.out.print("Roll-No:" + rs.getInt("rollno")+" ");
                       System.out.print(", Name: " + rs.getString("fullname")+" ");
                       System.out.print(", Father's name: " + rs.getString("fathername"));
                       System.out.println(", Address: " + rs.getString("address")+" ");
                       System.out.print(",Date-of-Birth: " + rs.getString("dob")+" ");
                       System.out.print(",English: " + rs.getFloat("english")+" ");
                       System.out.print(",Maths: " + rs.getFloat("maths")+" ");
                       System.out.print(",Science: " + rs.getFloat("science")+" ");
                       System.out.print(",Social Science: " + rs.getFloat("social")+" ");
                       System.out.print(",Percentage: " + rs.getFloat("percentage")+" ");
                       System.out.println(" ");
                   }
                   else {
                       System.out.println("RECORD NOT EXIST!!");
                   }
                   rs.close();
                   s1.close();
               } else {
                   System.out.println("Do you want to continue:=y/n");
                   n = sc.nextLine();
                   if (n.startsWith("n")) {
                       break;
                   }
               }
           }while(true);
        System.out.println("Process SuccessFull");
        conn.close();
    }
}
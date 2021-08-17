package com.ceco.javatestproject.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.ceco.javatestproject.model.Person;

import org.springframework.stereotype.Repository;

@Repository("oracledb")
public class PersonDataAccessService implements PersonDao{

    private static List<Person> Result = new ArrayList<>();
    private static Person p;

    @Override
    public int deletePersonById(UUID id) {
        try{

            Class.forName("oracle.jdbc.driver.OracleDriver");
            
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","C##CECO","ceco"); 
    
            Statement stmt = con.createStatement();
            
            String sql = "delete from person where id='" + id.toString() + "'";

            stmt.executeUpdate(sql);
    
            con.close();
            
            }catch(Exception e) { System.out.println(e);}
        return 1;
    }

    @Override
    public int insertPerson(UUID id, Person person) {
        try{

            Class.forName("oracle.jdbc.driver.OracleDriver");
            
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","C##CECO","ceco"); 
    
            Statement stmt = con.createStatement();
            
            String sql = "insert into person values ('" + id.toString() + "', '" + person.getName() + "', " + String.valueOf(person.getAge()) + ")";

            stmt.executeUpdate(sql);
    
            con.close();
            
            }catch(Exception e) {System.out.println(e);}

        return 1;
    }

    @Override
    public List<Person> selectAllPeople() {
        
        try{

        Class.forName("oracle.jdbc.driver.OracleDriver");
        
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","C##CECO","ceco"); 

        Statement stmt = con.createStatement();

        ResultSet rs = stmt.executeQuery("select * from person");

        Result.clear();

        while(rs.next()) { 

            Result.add(new Person(UUID.fromString(rs.getString(1)), rs.getString(2), rs.getInt(3)));

        }

        con.close();
        
        }catch(Exception e) {System.out.println(e);}

        return Result;
    }

    @Override
    public Person selectPersonById(UUID id) {
        try{

            Class.forName("oracle.jdbc.driver.OracleDriver");
            
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","C##CECO","ceco"); 
    
            Statement stmt = con.createStatement();
            
            String sql = "select * from person where id='" + id.toString() + "'";

            ResultSet rs = stmt.executeQuery(sql);

            rs.next();

            p = new Person(UUID.fromString(rs.getString(1)), rs.getString(2), rs.getInt(3));

            con.close();
            
            }catch(Exception e) {System.out.println(e);}

        return p;
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        try{

            Class.forName("oracle.jdbc.driver.OracleDriver");
            
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","C##CECO","ceco"); 
    
            Statement stmt = con.createStatement();
            
            String sql = "update person set name='" + person.getName() + "', age=" + String.valueOf(person.getAge()) + " where id='" + id.toString() + "'";

            stmt.executeUpdate(sql);
    
            con.close();
            
            }catch(Exception e) {System.out.println(e);}

        return 1;
    }

    @Override
    public int dropTable() {
        try{

            Class.forName("oracle.jdbc.driver.OracleDriver");
            
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","C##CECO","ceco");
    
            Statement stmt = con.createStatement();
            
            String sql = "truncate table person";

            stmt.executeUpdate(sql);
    
            con.close();
            
            }catch(Exception e) {System.out.println(e);}

        return 1;
    }
    
}

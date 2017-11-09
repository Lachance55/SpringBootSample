package com.springboot;
 
import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.springboot.model.User;
 
/**
 * 
 * @author Daner (Kas-2017)
 */
public class SpringBootRestTestClient {
 
    public static final String REST_SERVICE_URI = "http://localhost:8080/SpringBootRestApi/api";
     
    /* GET */
    @SuppressWarnings("unchecked")
    private static void listAllUsers(){
        System.out.println("Testing listAllUsers API-----------");
         
        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String, Object>> usersMap = restTemplate.getForObject(REST_SERVICE_URI+"/user/", List.class);
         
        if(usersMap!=null){
            for(LinkedHashMap<String, Object> map : usersMap){
                System.out.println("User : id="+map.get("id")+", Name="+map.get("name")+", Age="+map.get("age")+", Mail="+map.get("mail"));
            }
        }else{
            System.out.println("No user exist----------");
        }
    }
     
    /* GET */
    private static void getUser(){
        System.out.println("GET USER **********************");
        RestTemplate restTemplate = new RestTemplate();
        User user = restTemplate.getForObject(REST_SERVICE_URI+"/user/1", User.class);
        System.out.println(user);
    }
     
    /* POST */
    private static void createUser() {
        System.out.println("CREATE USER **********************");
        RestTemplate restTemplate = new RestTemplate();
        User user = new User(0,"John",51,"johnjohn@.com");
        URI uri = restTemplate.postForLocation(REST_SERVICE_URI+"/user/", user, User.class);
        System.out.println("Location : "+uri.toASCIIString());
        System.out.println("USER CREATED **********************");
    }
 
    /* PUT */
    private static void updateUser() {
        System.out.println("UPDATE USER **********************");
        RestTemplate restTemplate = new RestTemplate();
        User user  = new User(1,"Hans",33, "beatboxyapacam@.com");
        restTemplate.put(REST_SERVICE_URI+"/user/1", user);
        System.out.println(user);
        System.out.println("USER UPDATED **********************");
    }
 
    /* DELETE */
    private static void deleteUser() {
        System.out.println("DELETE USER **********************");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI+"/user/3");
        System.out.println("USER DELETED **********************");    
    }
 
 
    /* DELETE */
    private static void deleteAllUsers() {
        System.out.println("DELETE ALL USER **********************");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI+"/user/");
        System.out.println("ALL USERS DELETED **********************");
    }
 
    public static void main(String args[]){
        listAllUsers();
        getUser();
        createUser();
        listAllUsers();
        updateUser();
        listAllUsers();
        deleteUser();
        listAllUsers();
        deleteAllUsers();
        listAllUsers();
    }
}
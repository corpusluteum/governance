package com.emine.governance.client;

import java.net.URI;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.emine.governance.models.Department;

public class RestClientUtil {
    
	public void getDepartmentByIdDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	String url = "http://localhost:8080/user/department/{id}";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<Department> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Department.class, 1);
        Department department = responseEntity.getBody();
        System.out.println("Id:"+department.getDepartmentId()+", Description:"+department.getDescription()
                 +", Name:"+department.getName());      
    }
    public void getAllDepartmentDemo() {
	HttpHeaders headers = new HttpHeaders();
	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	String url = "http://localhost:8080/user/departments";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<Department[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Department[].class);
        Department[] departments = responseEntity.getBody();
        for(Department department : departments) {
              System.out.println("Id:"+department.getDepartmentId()+", Title:"+department.getName()
                      +", Description: "+department.getDescription());
        }
    }
    public void addDepartmentDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	String url = "http://localhost:8080/user/department";
	Department objDepartment = new Department();
	objDepartment.setName("Spring REST Security using Hibernate");
	objDepartment.setDescription("Spring");
        HttpEntity<Department> requestEntity = new HttpEntity<Department>(objDepartment, headers);
        URI uri = restTemplate.postForLocation(url, requestEntity);
        System.out.println(uri.getPath());    	
    }
    public void updateDepartmentDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/user/department";
	Department objDepartment = new Department();
	objDepartment.setDepartmentId(1);
	objDepartment.setName("Update:Java Concurrency");
	objDepartment.setDescription("Java");
        HttpEntity<Department> requestEntity = new HttpEntity<Department>(objDepartment, headers);
        restTemplate.put(url, requestEntity);
    }
    public void deleteDepartmentDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	String url = "http://localhost:8080/user/department/{id}";
        HttpEntity<Department> requestEntity = new HttpEntity<Department>(headers);
        restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, Void.class, 4);        
    }
    public static void main(String args[]) {
    	RestClientUtil util = new RestClientUtil();
        util.getDepartmentByIdDemo();
    	util.getAllDepartmentDemo();
    	//util.addDepartmentDemo();
    	//util.updateDepartmentDemo();
    	//util.deleteDepartmentDemo();
    }    
}
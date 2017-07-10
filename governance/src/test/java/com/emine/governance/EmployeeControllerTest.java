package com.emine.governance;

import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.emine.governance.controller.EmployeeController;
import com.emine.governance.models.Employee;
import com.emine.governance.service.EmployeeServicesImp;
import com.fasterxml.jackson.databind.ObjectMapper;



@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class EmployeeControllerTest {

	private MockMvc mockMvc;
	
    @Mock
    private EmployeeServicesImp employeeService;
    
    @InjectMocks
    private EmployeeController employeeController;    

    @Before
    public void setup() {
    	MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(employeeController)
                .build();
    }
    
    @Test
    public void test_get_all_success() throws Exception {
        List<Employee> employees = Arrays.asList(
        		new Employee(1,"Emine", "Aydın", 12000));
        
        when(employeeService.getAllEmployee()).thenReturn(employees);
        
        mockMvc.perform(get("/employees"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].name", is("Ali")))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].name", is("Veli")));
        
        verify(employeeService, times(1)).getAllEmployee();
        verifyNoMoreInteractions(employeeService);
    }
    
    @Test
    public void test_get_by_id_success() throws Exception {
    	Employee employee = new Employee(1, "Emine", "Aydın", 12000);
        when(employeeService.getEmployeeById(1)).thenReturn(employee);
        
        mockMvc.perform(get("/employees/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("Ali")));
        
        verify(employeeService, times(1)).getEmployeeById(1);
        verifyNoMoreInteractions(employeeService);
    }
    
    @Test
    public void test_get_by_id_fail_404_not_found() throws Exception {
        when(employeeService.getEmployeeById(1)).thenReturn(null);
        
        mockMvc.perform(get("/employees/{id}", 1))
                .andExpect(status().isNotFound());
        
        verify(employeeService, times(1)).getEmployeeById(1);
        verifyNoMoreInteractions(employeeService);
    }
    
    @Test
    public void test_create_success() throws Exception {
    	Employee employee = new Employee(1, "Emine", "aydın", 1200);
        when(employeeService.addEmployee(employee)).thenReturn(Boolean.TRUE);
        
        mockMvc.perform(post("/employees")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(asJsonString(employee)))
            		.andExpect(status().isCreated());
        
        verify(employeeService, times(1)).addEmployee(employee);
        verifyNoMoreInteractions(employeeService);
    }
    
    @Test
    public void test_update_success() throws Exception {
    	Employee employee = new Employee(1, "Emine", "Aydın", 1200);
        when(employeeService.updateEmployee(employee)).thenReturn(Boolean.TRUE);
        
        mockMvc.perform(
                put("/employees/{id}", employee.getEmployeeId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(asJsonString(employee)))
                	.andExpect(status().isOk());
        
        verify(employeeService, times(1)).updateEmployee(employee);
        verifyNoMoreInteractions(employeeService);
    }
    
    @Test
    public void test_delete_success() throws Exception {
    	Employee employee = new Employee(1, "Emine", "Aydın", 12000);
        when(employeeService.deleteEmployee(employee.getEmployeeId())).thenReturn(Boolean.TRUE);
        
        mockMvc.perform(
                delete("/employees/{id}", employee.getEmployeeId()))
                .andExpect(status().isNoContent());
        
        verify(employeeService, times(1)).deleteEmployee(employee.getEmployeeId());
        verifyNoMoreInteractions(employeeService);
    }    
    
    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }    
}

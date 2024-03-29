package com.emine.governance;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

import com.emine.governance.controller.MeetingsController;
import com.emine.governance.models.Department;
import com.emine.governance.models.Meetings;
import com.emine.governance.service.MeetingsServicesImp;
import com.fasterxml.jackson.databind.ObjectMapper;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class MeetingControllerTest {

	private MockMvc mockMvc;
	
    @Mock
    private MeetingsServicesImp meetingService;
    
    @InjectMocks
    private MeetingsController meetingController;    

    @Before
    public void setup() {
    	MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(meetingController)
                .build();
    }
    
    @Test
    public void test_get_all_success() throws Exception {
        List<Department> departments = Arrays.asList(
        		new Department(1, "Engineering", "Engineering Department"),
        		new Department(2, "Design", "Design Department"));
    	
        List<Meetings> meetings = Arrays.asList(
        		new Meetings(1, "Revision", "Weekly Revision"),
        		new Meetings(2, "Scrum", "Scrum Meeting"));
        
        when(meetingService.getAllMeetings()).thenReturn(meetings);
        
        mockMvc.perform(get("/meetings"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].name", is("Revision")))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].name", is("Scrum")));
        
        verify(meetingService, times(1)).getAllMeetings();
        verifyNoMoreInteractions(meetingService);
    }
    
    @Test
    public void test_get_by_id_success() throws Exception {
        List<Department> departments = Arrays.asList(
        		new Department(1, "Engineering", "Engineering Department"),
        		new Department(2, "Design", "Design Department"));
    	Meetings meeting = new Meetings(1, "Revision", "Weekly Revision");
    	
        when(meetingService.getMeetingsById(1)).thenReturn(meeting);
        
        mockMvc.perform(get("/meetings/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("Revision")));
        
        verify(meetingService, times(1)).getMeetingsById(1);
        verifyNoMoreInteractions(meetingService);
    }
    
    @Test
    public void test_get_by_id_fail_404_not_found() throws Exception {
        when(meetingService.getMeetingsById(1)).thenReturn(null);
        
        mockMvc.perform(get("/meetings/{id}", 1))
                .andExpect(status().isNotFound());
        
        verify(meetingService, times(1)).getMeetingsById(1);
        verifyNoMoreInteractions(meetingService);
    }
    
    @Test
    public void test_create_success() throws Exception {
        List<Department> departments = Arrays.asList(
        		new Department(1, "Engineering", "Engineering Department"),
        		new Department(2, "Design", "Design Department"));
    	Meetings meeting = new Meetings(1, "Revision", "Weekly Revision");
    	
        when(meetingService.addMeetings(meeting)).thenReturn(Boolean.TRUE);
        
        mockMvc.perform(post("/meetings")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(asJsonString(meeting)))
            		.andExpect(status().isCreated());
        
        verify(meetingService, times(1)).addMeetings(meeting);
        verifyNoMoreInteractions(meetingService);
    }
    
    @Test
    public void test_update_success() throws Exception {
        List<Department> departments = Arrays.asList(
        		new Department(1, "Engineering", "Engineering Department"),
        		new Department(2, "Design", "Design Department"));
    	Meetings meeting = new Meetings(1, "Revision", "Weekly Revision");
    	
        when(meetingService.updateMeetings(meeting)).thenReturn(Boolean.TRUE);
        
        mockMvc.perform(
                put("/meetings/{id}", meeting.getMeetingsId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(asJsonString(meeting)))
                	.andExpect(status().isOk());
        
        verify(meetingService, times(1)).updateMeetings(meeting);
        verifyNoMoreInteractions(meetingService);
    }
    
    @Test
    public void test_delete_success() throws Exception {
        List<Department> departments = Arrays.asList(
        		new Department(1, "Engineering", "Engineering Department"),
        		new Department(2, "Design", "Design Department"));
    	Meetings meeting = new Meetings(1, "Revision", "Weekly Revision");
    	
        when(meetingService.deleteMeetings(meeting.getMeetingsId())).thenReturn(Boolean.TRUE);
        
        mockMvc.perform(
                delete("/meetings/{id}", meeting.getMeetingsId()))
                .andExpect(status().isNoContent());
        
        verify(meetingService, times(1)).deleteMeetings(meeting.getMeetingsId());
        verifyNoMoreInteractions(meetingService);
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

package com.emine.governance.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.stereotype.Controller;


import com.emine.governance.models.Meetings;
import com.emine.governance.service.MeetingsServices;

@Controller
@RequestMapping("meetings")
public class MeetingsController {
	
	@Autowired
	private MeetingsServices meetingsService;
	@GetMapping("meetings/{id}")
	public ResponseEntity<Meetings> getMeetingsById(@PathVariable("id") Integer id) {
		Meetings meetings = meetingsService.getMeetingsById(id);
		return new ResponseEntity<Meetings>(meetings, HttpStatus.OK);
	}
	@GetMapping("meetings")
	public ResponseEntity<List<Meetings>> getAllmeetings() {
		List<Meetings> list = meetingsService.getAllMeetings();
		return new ResponseEntity<List<Meetings>>(list, HttpStatus.OK);
	}
	@PostMapping("meetings")
	public ResponseEntity<Void> addMeetings(@RequestBody Meetings meetings, UriComponentsBuilder builder) {
                boolean flag = meetingsService.addMeetings(meetings);
                if (flag == false) {
        	    return new ResponseEntity<Void>(HttpStatus.CONFLICT);
                }
                HttpHeaders headers = new HttpHeaders();
                headers.setLocation(builder.path("/meetings/{id}").buildAndExpand(meetings.getMeetingsId()).toUri());
                return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	@PutMapping("meetings")
	public ResponseEntity<Meetings> updateMeetings(@RequestBody Meetings meetings) {
		meetingsService.updateMeetings(meetings);
		return new ResponseEntity<Meetings>(meetings, HttpStatus.OK);
	}
	@DeleteMapping("meetings/{id}")
	public ResponseEntity<Void> deleteMeetings(@PathVariable("id") Integer id) {
		meetingsService.deleteMeetings(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	

}

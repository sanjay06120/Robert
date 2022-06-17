package com.ioco.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ioco.Entity.Survivors;

@RestController
@RequestMapping("/robert")
public class RobertController {
	
	/**
	 * Call the APi to get the Robert List
	 * @return
	 */
	@GetMapping("/getRobertList")
	public String getRobertList(){
		
		String url="https://robotstakeover20210903110417.azurewebsites.net/robotcpu";
		try {
		RestTemplate restTemplate=new RestTemplate();
		String result=restTemplate.getForObject(url, String.class);
		return result;
	} catch (Exception e) {
		return HttpStatus.INTERNAL_SERVER_ERROR.toString();
	}		
}
	}
	


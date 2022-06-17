package com.ioco.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ioco.Entity.Survivors;
import com.ioco.dao.SurviourDao;
import com.ioco.service.SurvivorsService;

@RestController
@RequestMapping("/surviours")
public class SurviourController {
	
	@Autowired
	SurvivorsService service;
	
	@Autowired
	SurviourDao surviourDao;
	
	/**
	 * Find all infected 
	 * @return List<Survivours>
	 */
	@GetMapping("/getAllInfectedSurvivors")
	public ResponseEntity<List<Survivors>> getAllInfectedSurvivors(){
		try {

			List<Survivors> list=service.getAllInfectedSurvivors();
			
			if (list.isEmpty() || list.size() == 0) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			list=list.stream().filter(s->s.getFlag()==Boolean.TRUE).collect(Collectors.toList());
			
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}
	
	/**
	 * Find all NON infected 
	 * @return List<Survivours>
	 */
	@GetMapping("/getNonInfectedSurvivors")
	public ResponseEntity<List<Survivors>> getNonInfectedSurvivors(){
		try {

			List<Survivors> list=service.getAllInfectedSurvivors();
			
			if (list.isEmpty() || list.size() == 0) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			list=list.stream().filter(s->s.getFlag()==Boolean.FALSE).collect(Collectors.toList());
			
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}
	
	/*
	 * Percentage of infected
	 * @HTML
	 */
	@GetMapping(value="/getPercentInfectedSurvivors",produces = MediaType.TEXT_HTML_VALUE)
	public String getPercentInfectedSurvivors(){
		try {

			List<Survivors> list=service.getAllInfectedSurvivors();
			double output;
			if (list.isEmpty() || list.size() == 0) {
				output=0;
			}else {

				double actual_count=list.size();
				double nInfected_count=list.stream().filter(s->s.getFlag()==Boolean.TRUE).count();
				output=nInfected_count*100/actual_count;
			 
			}
		
			
			return "<html><head>ROBERT</head><body><b>INFECTED="+output+"%</b></body></html>";
		} catch (Exception e) {
			return HttpStatus.INTERNAL_SERVER_ERROR.toString();
		}		
	}
	
	/*
	 * Percentage of Noon infected
	 * @HTML
	 */
	@GetMapping(value="/getPercentNonInfectedSurvivors",produces = MediaType.TEXT_HTML_VALUE)
	public String getPercentNonInfectedSurvivors(){
		try {

			List<Survivors> list=service.getAllInfectedSurvivors();
			double output;
			if (list.isEmpty() || list.size() == 0) {
				output=0;
			}else {
				double actual_count=list.size();
				double nInfected_count=list.stream().filter(s->s.getFlag()==Boolean.FALSE).count();
				output=nInfected_count*100/actual_count;
			 
			}		
			return "<html><head>ROBERT</head><body><b>INFECTED="+output+"%</b></body></html>";
		} catch (Exception e) {
			return HttpStatus.INTERNAL_SERVER_ERROR.toString();
		}		
	}
	/**
	 * Add new Surviors
	 * @param survivours
	 * @return
	 */
	@PostMapping("/addSurvivours")
	public ResponseEntity<Survivors> createSurvivours(@RequestBody Survivors survivours) {
		try {
			Survivors _survivors = service
					.createSurvivours(survivours);
			return new ResponseEntity<>(_survivors, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/*
	 * Update location
	 */
	@PutMapping("/survivors/{id}")
	public ResponseEntity<Survivors> updateSurvivors(@PathVariable("id") long id, @RequestBody Survivors survivors) {
		Optional<Survivors> survivorsData = surviourDao.findById(id);
		if (survivorsData.isPresent()) {
			Survivors _survivors = survivorsData.get();
			_survivors.setLocation(survivors.getLocation());
			_survivors.setLongtitude(survivors.getLongtitude());
			_survivors.setLatitude(survivors.getLatitude());
			
			_survivors = service
					.updateSurvivours(_survivors);
			return new ResponseEntity<>(_survivors, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	/*
	 * update survivor status
	 */
	@PatchMapping("/employees/{id}/{isInfected}")
	public ResponseEntity<Survivors> updateSurvivorsStatus(@PathVariable Long id, @PathVariable Boolean isInfected) {
		try {
			Survivors survivor = surviourDao.findById(id).get();
			survivor.setFlag(isInfected);
			survivor = service
					.updateSurvivours(survivor);
			return new ResponseEntity<>(survivor, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}

package com.ioco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ioco.Entity.Survivors;
import com.ioco.dao.SurviourDao;

@Service
public class SurvivorsService {
	
	@Autowired
	SurviourDao surviourDao;
	
	public List<Survivors> getAllInfectedSurvivors(){
		return surviourDao.findAll();	
	}
	public Survivors createSurvivours(Survivors survivours) {
		return surviourDao.save(survivours);
	}
	public Survivors updateSurvivours(Survivors survivours) {
		return surviourDao.save(survivours);
	}

}

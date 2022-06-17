package com.ioco.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import com.ioco.Entity.Survivors;

/*@Repository
public class SurviourDao {
	
	public List<Survivours> getAllInfectedSurviviours(){
		Survivours s=new Survivours();
		s.setSName("xyz");
		s.setAge(17);
		List<Survivours> list=new ArrayList<>();
		list.add(s);
		return list;
		
		
	}
}

*/
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SurviourDao extends JpaRepository<Survivors, Long> {

}

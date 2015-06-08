package hibernate.service;

import hibernate.dao.BaseDAO;
import hibernate.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DemoService {
	
	@Autowired
	private BaseDAO baseDAO;
	
	
	public void demo(){
		int count = baseDAO.count(User.class);
		System.out.println(count);
	}
}

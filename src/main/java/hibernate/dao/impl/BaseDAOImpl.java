package hibernate.dao.impl;

import hibernate.dao.BaseDAO;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class BaseDAOImpl<T, PK extends Serializable> implements BaseDAO{
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public <T> List<T> getAll(Class<?> type) {
		
		String table = type.getName();
		String sql = "from " + table;
		List list = getSession().createQuery(sql).list();
		
		return list;
	}
	
	@Override
	public <T> int count(Class<T> type){
		String table = type.getName();
		String sql = "select count(*) from " + table;
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}
}

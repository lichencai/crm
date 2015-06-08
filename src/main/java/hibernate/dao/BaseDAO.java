package hibernate.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
@Repository
public interface BaseDAO {
	public <T> List<T> getAll(Class<?> type);
	public <T> int count(Class<T> type);
}

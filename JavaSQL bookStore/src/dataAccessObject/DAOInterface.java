package dataAccessObject;

import java.util.ArrayList;

public interface DAOInterface<T> {
	public int add(T t);
	
	public int update(T t);
	
	public int delete(T t);
	
	public T selectById(T t);
	
	public ArrayList<T> selectAll();
	
	public ArrayList<T> selectByCondition(String condition);
	
}

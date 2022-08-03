package jp.co.sample.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.sample.domain.Employee;

@Repository
public class EmployeeRepository {

	private static final RowMapper<Employee> EMPLOYEE_ROW_MAPPER
	   = new BeanPropertyRowMapper<>(Employee.class);
	
	
	@Autowired
	private NamedParameterJdbcTemplate template;

	
	public List<Employee> findAll(){
		String sql   
= "SELECT id,name,image,gender,hireDate,mailAddress,zipCode,address,telephone,salary,caracteristics,dependentsCount FROM employees where hireDate desc";
		
		List<Employee> employeeList = template.query(sql, EMPLOYEE_ROW_MAPPER);
		
		return employeeList;
	}
	
	public Employee load(Integer id) {
		String sql =
		"SELECT id,name,image,gender,hireDate,mailAddress,zipCode,address,telephone,salary,caracteristics,dependentsCount FROM employees where id=:id";
		
		SqlParameterSource param = new MapSqlParameterSource().addValue("id",id);
		
		Employee employee = template.queryForObject(sql, param, EMPLOYEE_ROW_MAPPER);
	
		return employee;
	}
	
	
	public void update(Employee employee) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(employee);
		
		String updateSql = "update employees set  name=:name, image=:image, gender=:gender,"
		    + " hire_date:hire_date, mail_address:mail_address, zip_code:zip_code,address:adress,"
		    + " telephone:telephone, salary:salary, characteristics:characteristics, dependents_count:depemdemts_count"
		    + " where id=id:";
		template.update(updateSql, param);
		
	}
	
	
	
	
	
	
}

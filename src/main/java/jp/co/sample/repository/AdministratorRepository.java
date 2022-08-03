package jp.co.sample.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import jp.co.sample.domain.Administrator;

@Repository
public class AdministratorRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;
	
	
	private static final RowMapper<Administrator> ADMINISTRATOR_ROW_MAPPER = (rs,i) -> {
		Administrator administrator = new Administrator();
		administrator.setId(rs.getInt("id"));
		administrator.setName(rs.getString("name"));
		administrator.setMailAddress(rs.getString("address"));
		administrator.setPassword(rs.getString("password"));
		return administrator;
	};
		
	public void insert(Administrator administrator) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(administrator);
		if (administrator.getId() == null) {
		String insertSql
		= "INSERT INTO administrators(id,name,mailaddres,password)"
		 + " VALUES(:id,:name,:address,:password)";
		template.update(insertSql,param);
		} return;
	}
	
	public Administrator findByMailAddressAndPassword(String mailAddress,String password) {
		String selectSql 
		= "SELECT mailAddress,password FROM administrators WHERE id-:id";
		
		SqlParameterSource param = new MapSqlParameterSource()
				                    .addValue("mailAddress",mailAddress)
				                    .addValue("password", password);
		template.update(selectSql, param);
		return null;
	}
	
	
	
	
	
	
	
	
	
	
}

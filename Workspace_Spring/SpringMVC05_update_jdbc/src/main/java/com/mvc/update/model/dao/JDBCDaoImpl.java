package com.mvc.update.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mvc.update.model.dto.JDBCDto;

@Repository
public class JDBCDaoImpl implements JDBCDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	@Override
	public List<JDBCDto> selectList() {
		List<JDBCDto> list = new ArrayList<JDBCDto>();
		
		list = jdbcTemplate.query(SELECT_LIST_SQL, null, null, new MyMapper());
		// 또는 list = jdbcTemplate.query(SELECT_LIST_SQL, new MyMapper());
		
		return list;
	}
	/*
	
	@Override
	public List<JDBCDto> selectList() {
		List<JDBCDto> list = new ArrayList<JDBCDto>();

		// list = jdbcTemplate.query(SELECT_LIST_SQL, null, null, new RowMapper<>() {
		
		// 아래 방식은 람다식
		// list = jdbcTemplate.query(SELECT_LIST_SQL, (rs, rowNum)->{
			
			//@Override
			//public JDBCDto mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new JDBCDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5));
			//}
		});

		return list;
	}
*/
	@Override
	public JDBCDto selectOne(int seq) {
		JDBCDto dto = null;
		
		dto = jdbcTemplate.queryForObject(SELECT_ONE_SQL, new Object[] {seq}, new int[] {Types.INTEGER}, new MyMapper());
		
		return dto;
	}

	@Override
	public int insert(JDBCDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(JDBCDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int seq) {
		// TODO Auto-generated method stub
		return 0;
	}

	// inner class
	private static final class MyMapper implements RowMapper<JDBCDto>{

		@Override
		public JDBCDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			return new  JDBCDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5));
		}
		
		
	}
}

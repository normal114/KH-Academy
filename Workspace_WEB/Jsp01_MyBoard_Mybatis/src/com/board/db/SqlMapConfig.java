package com.board.db;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlMapConfig {

	private SqlSessionFactory sqlSessionFactory;
	
	public SqlSessionFactory getSqlSessionFactory() {
		// 모든 마이바티스 애플리케이션은 SqlSessionFactory 인스턴스를 사용한다. SqlSessionFactory인스턴스는 SqlSessionFactoryBuilder를 사용하여 만들수 있다. SqlSessionFactoryBuilder는 XML설정파일에서 SqlSessionFactory인스턴스를 빌드할 수 있다.		
		// 경로일 때는 / 를 사용한다.
		String resource = "com/board/db/mybatis-config.xml";
		

		try {
			InputStream inputStream = Resources.getResourceAsStream(resource); // config.xml을 가지고 와서 읽어 가지고
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream); // SqlSessionFactoryBuilder이란 얘가
			// sqlSessionFactory를 만들 것이다.
		
			inputStream.close();
		
		
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		return sqlSessionFactory; 
	}
}

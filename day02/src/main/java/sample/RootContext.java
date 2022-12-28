package sample;

import com.itbank.model.StudentDTO;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.DriverManager;
import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;

public class RootContext {
	
	public static void main(String[] args) throws Exception {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		// 객체 준비 (실제로는 스프링 빈으로 작동한다)
		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		hikariConfig.setJdbcUrl("jdbc:oracle:thin:@192.168.1.100:1521:xe");
		hikariConfig.setUsername("c##itbank");
		hikariConfig.setPassword("it");
		
		HikariDataSource dataSource = new HikariDataSource(hikariConfig);
		
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSource);
		
		SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate((SqlSessionFactory) sqlSessionFactory);
		
		// 참조를 편하게 하기 위한 다른 참조 변수
		SqlSessionTemplate sst = sqlSessionTemplate;
		
		String sql = "select * from student1";
		
		List<StudentDTO> list = sst.selectList("StudentDAO.selectList");
		
		list.forEach(System.out::println);
		
		sqlSessionTemplate.close();
		
		
	}

}

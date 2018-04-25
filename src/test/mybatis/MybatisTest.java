package test.mybatis;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import ssm.entity.Customer;

public class MybatisTest {

	public static void main(String[] args) throws Exception {
		String resource = "test/mybatis/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory =
		  new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession session = sqlSessionFactory.openSession(); // 打开会话
		try {
			// 获得mapper
			CustomerMapper mapper = session.getMapper(CustomerMapper.class);
			// 调用数据操作
			List<Customer> customers = mapper.findAll();
			System.out.println(customers);
			
			session.commit();
		} catch (Exception ex) {
			session.rollback();
			throw ex;
		} finally { // 关闭会话，释放资源
		  session.close();
		}
	}
}

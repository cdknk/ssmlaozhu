package ssm.dao.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ssm.dao.UserDao;
import ssm.dao.mybatis.mappers.UserMapper;
import ssm.entity.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public User findOneByUsername(String username) {
		return userMapper.findOneByUsername(username);
	}

}

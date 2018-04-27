package ssm.dao.mybatis;

import org.springframework.stereotype.Repository;

import ssm.dao.BlogDao;
import ssm.dao.mybatis.mappers.BlogMapper;
import ssm.entity.Blog;

@Repository
public class BlogDaoImpl implements BlogDao {

	private BlogMapper blogMapper;
	
	public BlogDaoImpl(BlogMapper blogMapper) {
		this.blogMapper = blogMapper;
	}

	@Override
	public Blog findOne(Long id) {
		return blogMapper.findOne(id);
	}

}

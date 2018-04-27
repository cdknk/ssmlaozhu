package ssm.service;

import org.springframework.stereotype.Service;

import ssm.dao.BlogDao;
import ssm.entity.Blog;

@Service
public class BlogServiceImpl implements BlogService {

	private BlogDao blogDao;
	
	public BlogServiceImpl(BlogDao blogDao) {
		this.blogDao = blogDao;
	}

	@Override
	public Blog findOne(Long id) {
		return blogDao.findOne(id);
	}

}

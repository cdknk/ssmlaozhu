package ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ssm.entity.Blog;
import ssm.service.BlogService;


@Controller
public class BlogController {
	
	private BlogService blogService;
	
	public BlogController(BlogService blogService) {
		this.blogService = blogService;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/blogs/{id}")
	public String details(@PathVariable Long id, Model model) {
		Blog blog = blogService.findOne(id);
		System.out.println("findBlog: " + blog);
		model.addAttribute("blog", blog);
		return "blog-details";
	}
}

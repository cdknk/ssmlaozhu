package ssm.entity;

import java.util.List;

public class Blog {
	private Long id;
	private String title;
	
	// 对一关系
	private Author author;
	
	// 对多关系
	private List<Post> posts;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "Blog [id=" + id + ", title=" + title + ", author=" + author
				+ ", posts=" + posts + "]";
	}
	
}

package ssm.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Department {
	private Long id;
	
	@JsonProperty("text") // 写成json时用的属性名，为了配合jstree
	private String name;
	
	private Long parentId;
	
	private String parentName;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	
	public String getParent() { // 配合jstree，根节点的父节点为#
		if (parentId == null || parentId == 0) {
			return "#";
		} else {
			return parentId.toString();
		}
	}
	
}

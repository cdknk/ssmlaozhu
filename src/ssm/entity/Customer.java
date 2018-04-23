package ssm.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

public class Customer {
	private Long id;
	
	@Size(min = 2, max = 64, message = "2 ~ 64个字")
	private String name;
	
	@Size(min = 3, max = 128, message = "3 ~ 128个字")
	private String address;

	@NotNull(message = "必填")
	private Boolean vip;
	
	private MultipartFile picture;
	
	// 选择保存到数据库的文件路径时，要考虑重名冲突，如有可能冲突，需要加id或其它可用的去重标识
	private String picturePath;
	
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public Boolean getVip() {
		return vip;
	}
	public void setVip(Boolean vip) {
		this.vip = vip;
	}
	
	public MultipartFile getPicture() {
		return picture;
	}
	public void setPicture(MultipartFile picture) {
		this.picture = picture;
	}
	
	public String getPicturePath() {
		return picturePath;
	}
	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", address=" + address
				+ ", vip=" + vip + ", picturePath=" + picturePath + "]";
	}
}

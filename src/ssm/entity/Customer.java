package ssm.entity;

public class Customer {
	private Long id;
	private String name;
	private String address;
	private boolean vip;
	
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
	public boolean isVip() {
		return vip;
	}
	public void setVip(boolean vip) {
		this.vip = vip;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", address=" + address
				+ ", vip=" + vip + "]";
	}
	
}

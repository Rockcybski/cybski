package com.rock.cybski.entity;

public class User {
	private Integer id;
	private String name;
	private String introduction;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	
	public static User getNewUser(Integer id, String name){
		User u = new User();
		u.setId(id);
		u.setName(name);
		u.setIntroduction("New User");
		return u;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", introduction="
				+ introduction + "]";
	}
}

package com.mrkumar.sqlitedbstoreapp.model;

import com.google.gson.annotations.SerializedName;

public class ResponseApiItem{

	private int id;
	@SerializedName("createdby")
	private String createdby;

	@SerializedName("firstappearance")
	private String firstappearance;

	@SerializedName("imageurl")
	private String imageurl;

	@SerializedName("name")
	private String name;

	@SerializedName("publisher")
	private String publisher;

	@SerializedName("bio")
	private String bio;

	@SerializedName("team")
	private String team;

	@SerializedName("realname")
	private String realname;

	public String getCreatedby(){
		return createdby;
	}

	public String getFirstappearance(){
		return firstappearance;
	}

	public String getImageurl(){
		return imageurl;
	}

	public String getName(){
		return name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPublisher(){
		return publisher;
	}

	public String getBio(){
		return bio;
	}

	public String getTeam(){
		return team;
	}

	public String getRealname(){
		return realname;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public void setFirstappearance(String firstappearance) {
		this.firstappearance = firstappearance;
	}

	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}
}
package edu.tyss.hibernate_practice.one_one_uni.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Engine {
	
	@Id
	private int eid ;
	private String type ;
	private int cc ;
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getCc() {
		return cc;
	}
	public void setCc(int cc) {
		this.cc = cc;
	}
	public Engine() {
		super();
	}
	public Engine(int eid, String type, int cc) {
		super();
		this.eid = eid;
		this.type = type;
		this.cc = cc;
	}
	@Override
	public String toString() {
		return "Engine [eid=" + eid + ", type=" + type + ", cc=" + cc + "]";
	}
	
	
}

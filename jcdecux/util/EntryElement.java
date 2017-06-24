package com.jcdecux.util;

public class EntryElement {
	private String week;
	private String client;
	private String brand;
	private String chineseName;
	private String industry;
	private String media;
	private String slotDuration;
	private int rateCard;
	
	public EntryElement(){
		this.week = "";
		this.client ="";
		this.brand ="";
		this.chineseName="";
		this.industry="";
		this.media="";
		this.slotDuration="";
		this.rateCard=0;
	}
	public String getWeek() {
		return week;
	}
	public void setWeek(String week) {
		this.week = week;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getChineseName() {
		return chineseName;
	}
	public void setChineseName(String chineseName) {
		this.chineseName = chineseName;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public String getMedia() {
		return media;
	}
	public void setMedia(String media) {
		this.media = media;
	}
	public String getSlotDuration() {
		return slotDuration;
	}
	public void setSlotDuration(String slotDuration) {
		this.slotDuration = slotDuration;
	}
	public int getRateCard() {
		return rateCard;
	}
	public void setRateCard(int rateCard) {
		this.rateCard = rateCard;
	}
	
	

}

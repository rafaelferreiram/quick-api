package com.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "brands")
public class Brand {

	@Id
	private String id;
	private String name;
	private String founder;
	private String headquarters;
	private String stockName;
	private Double stockPrice;
	private String founded;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFounder() {
		return founder;
	}

	public void setFounder(String founder) {
		this.founder = founder;
	}

	public String getHeadquarters() {
		return headquarters;
	}

	public void setHeadquarters(String headquarters) {
		this.headquarters = headquarters;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public Double getStockPrice() {
		return stockPrice;
	}

	public void setStockPrice(Double stockPrice) {
		this.stockPrice = stockPrice;
	}

	public String getFounded() {
		return founded;
	}

	public void setFounded(String founded) {
		this.founded = founded;
	}

	public boolean isValid() {
		if (!this.name.isEmpty() && !this.founder.isEmpty() && !this.headquarters.isEmpty()
				&& !this.founded.isEmpty()) {
			return true;
		}
		return false;
	}

	public boolean isEmpty() {
		if (this.id.isEmpty()) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Brand [id=" + id + ", name=" + name + ", founder=" + founder + ", headquarters=" + headquarters
				+ ", stockName=" + stockName + ", stockPrice=" + stockPrice + ", founded=" + founded + "]";
	}

}

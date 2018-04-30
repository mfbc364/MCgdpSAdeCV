// ######################################################################################################## //
package mcgdp.cont.db.vo;

import java.util.Date;

public class Order {
	// Parámetros de clase
	private String orderNumber;
	private Date emissionDate;
	private String emissionResponsible;
	private String provider;
	private String address;
	private String colony;
	private String city;
	private Integer postalCode;
	private String country;
	private Integer qty;
	private String mUnit;
	private String description;
	private Integer unitPrice;
	private Integer total;
	private String badge;
	private String status;
	
	// Getters
	public String getOrderNumber() {
		return orderNumber;
	}
	
	public Date getEmissionDate() {
		return emissionDate;
	}
	
	public String getEmissionResponsible() {
		return emissionResponsible;
	}
	
	public String getProvider() {
		return provider;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getColony() {
		return colony;
	}
	
	public String getCity() {
		return city;
	}
	
	public Integer getPostalCode() {
		return postalCode;
	}
	
	public String getCountry() {
		return country;
	}
	
	public Integer getQty() {
		return qty;
	}
	
	public String getMUnit() {
		return mUnit;
	}
	
	public String getDescription() {
		return description;
	}
	
	public Integer getUnitPrice() {
		return unitPrice;
	}
	
	public Integer getTotal() {
		return total;
	}
	
	public String getBadge() {
		return badge;
	}
	
	public String getStatus() {
		return status;
	}
	
	// Setters
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	
	public void setEmissionDate(Date emissionDate) {
		this.emissionDate = emissionDate;
	}
	
	public void setEmissionResponsible(String emissionResponsible) {
		this.emissionResponsible = emissionResponsible;
	}
	
	public void setProvider(String provider) {
		this.provider = provider;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setColony(String colony) {
		this.colony = colony;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public void setPostalCode(Integer postalCode) {
		this.postalCode = postalCode;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public void setQty(Integer qty) {
		this.qty = qty;
	}
	
	public void setMUnit(String mUnit) {
		this.mUnit = mUnit;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setUnitPrice(Integer unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	public void setTotal(Integer total) {
		this.total = total;
	}
	
	public void setBadge(String badge) {
		this.badge = badge;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
}
//######################################################################################################## //
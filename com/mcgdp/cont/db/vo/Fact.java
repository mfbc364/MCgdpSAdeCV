// ######################################################################################################## //
package mcgdp.cont.db.vo;

import java.util.Date;

public class Fact {
	// Parámetros de clase
	private String rfc;
	private String clientName;
	private Date emissionDate;
	private String address;
	private String colony;
	private String city;
	private Integer postalCode;
	private String country;
	private String description;
	private Integer qty;
	private String mUnit;
	private Integer unitPrice;
	private Integer taxes;
	private Integer total;
	private String badge;
	private String payType;
	private String payMethod;
	private String status;
	
	// Getters
	public String getRFC() {
		return rfc;
	}
	
	public String getClientName() {
		return clientName;
	}
	
	public Date getEmissionDate() {
		return emissionDate;
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
	
	public String getDescription() {
		return description;
	}
	
	public Integer getQty() {
		return qty;
	}
	
	public String getMUnit() {
		return mUnit;
	}
	
	public Integer getUnitPrice() {
		return unitPrice;
	}
	
	public Integer getTaxes() {
		return taxes;
	}
	
	public Integer getTotal() {
		return total;
	}
	
	public String getBadge() {
		return badge;
	}
	
	public String getPayType() {
		return payType;
	}
	
	public String getPayMethod() {
		return payMethod;
	}
	
	public String getStatus() {
		return status;
	}
	
	// Setters
	public void setRFC(String rfc) {
		this.rfc = rfc;
	}
	
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	
	public void setEmissionDate(Date emissionDate) {
		this.emissionDate = emissionDate;
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
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setQty(Integer qty) {
		this.qty = qty;
	}
	
	public void setMUnit(String mUnit) {
		this.mUnit = mUnit;
	}
	
	public void setUnitPrice(Integer unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	public void setTaxes(Integer taxes) {
		this.taxes = taxes;
	}
	
	public void setTotal(Integer total) {
		this.total = total;
	}
	
	public void setBadge(String badge) {
		this.badge = badge;
	}
	
	public void setPayType(String payType) {
		this.payType = payType;
	}
	
	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
}
//######################################################################################################## //
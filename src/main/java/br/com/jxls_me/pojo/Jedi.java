/**
 * 
 */
package br.com.jxls_me.pojo;

import java.math.BigDecimal;

/**
 * A simple Jedi POJO to be exported.
 * 
 * @author Lucas
 *
 */
public class Jedi {
	
	private String name;
	private java.util.Date birthDate;
    private BigDecimal payment;
    private String lightSaberColor;
    
    /**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the birthDate
	 */
	public java.util.Date getBirthDate() {
		return birthDate;
	}
	
	/**
	 * @param birthDate the birthDate to set
	 */
	public void setBirthDate(java.util.Date birthDate) {
		this.birthDate = birthDate;
	}
	
	/**
	 * @return the payment
	 */
	public BigDecimal getPayment() {
		return payment;
	}
	
	/**
	 * @param payment the payment to set
	 */
	public void setPayment(BigDecimal payment) {
		this.payment = payment;
	}
	
	/**
	 * @return the lightSaberColor
	 */
	public String getLightSaberColor() {
		return lightSaberColor;
	}
	
	/**
	 * @param lightSaberColor the lightSaberColor to set
	 */
	public void setLightSaberColor(String lightSaberColor) {
		this.lightSaberColor = lightSaberColor;
	}

}

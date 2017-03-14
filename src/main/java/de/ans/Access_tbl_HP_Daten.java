package de.ans;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the access_tbl_HP_Daten database table.
 * 
 */
@Entity
//@Table(name="access_tbl_HP_Daten")
public class Access_tbl_HP_Daten implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue
	private Integer id;

	@Column(name="COMMODITY_CODE")
	private String commodityCode;

	@Column(name="DEFECTIVE_RETURN_FLAG")
	private String defectiveReturnFlag;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="INTRO_DATE")
	private Date introDate;

	@Column(name="LABOR_LEVEL")
	private String laborLevel;

	@Column(name="ORDERABLE_FLAG")
	private String orderableFlag;

	@Column(name="PART_DESCRIPTION")
	private String partDescription;

	@Column(name="PART_NUMBER")
	private String partNumber;

	@Column(name="PRICE")
	private double price;

	@Column(name="PRODUCT_CYCLE")
	private String productCycle;

	@Column(name="PRODUCT_DESCRIPTION")
	private String productDescription;

	@Column(name="PRODUCT_LINE_ID")
	private Integer productLineId;

	@Column(name="PRODUCT_NUMBER")
	private String productNumber;

	@Column(name="PRODUCT_PLATFORM")
	private String productPlatform;

	@Column(name="SEGMENT")
	private String segment;

	@Column(name="WTY_CODE")
	private String wtyCode;

	public Access_tbl_HP_Daten() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCommodityCode() {
		return this.commodityCode;
	}

	public void setCommodityCode(String commodityCode) {
		this.commodityCode = commodityCode;
	}

	public String getDefectiveReturnFlag() {
		return this.defectiveReturnFlag;
	}

	public void setDefectiveReturnFlag(String defectiveReturnFlag) {
		this.defectiveReturnFlag = defectiveReturnFlag;
	}

	public Date getIntroDate() {
		return this.introDate;
	}

	public void setIntroDate(Date introDate) {
		this.introDate = introDate;
	}

	public String getLaborLevel() {
		return this.laborLevel;
	}

	public void setLaborLevel(String laborLevel) {
		this.laborLevel = laborLevel;
	}

	public String getOrderableFlag() {
		return this.orderableFlag;
	}

	public void setOrderableFlag(String orderableFlag) {
		this.orderableFlag = orderableFlag;
	}

	public String getPartDescription() {
		return this.partDescription;
	}

	public void setPartDescription(String partDescription) {
		this.partDescription = partDescription;
	}

	public String getPartNumber() {
		return this.partNumber;
	}

	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getProductCycle() {
		return this.productCycle;
	}

	public void setProductCycle(String productCycle) {
		this.productCycle = productCycle;
	}

	public String getProductDescription() {
		return this.productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public Integer getProductLineId() {
		return this.productLineId;
	}

	public void setProductLineId(Integer productLineId) {
		this.productLineId = productLineId;
	}

	public String getProductNumber() {
		return this.productNumber;
	}

	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}

	public String getProductPlatform() {
		return this.productPlatform;
	}

	public void setProductPlatform(String productPlatform) {
		this.productPlatform = productPlatform;
	}

	public String getSegment() {
		return this.segment;
	}

	public void setSegment(String segment) {
		this.segment = segment;
	}

	public String getWtyCode() {
		return this.wtyCode;
	}

	public void setWtyCode(String wtyCode) {
		this.wtyCode = wtyCode;
	}

}
/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.pharmacy.entity;

import java.util.Date;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.thinkgem.jeesite.common.persistence.DataEntity;
import com.thinkgem.jeesite.common.utils.excel.annotation.ExcelField;

/**
 * 门户管理Entity
 * @author 董志强
 * @version 2018-03-21
 */
public class Pharmacy extends DataEntity<Pharmacy> {
	
	private static final long serialVersionUID = 1L;
	private String code;		// 门店编码
	private String name;		// 门店名称
	private String companyName;		// 企业名称
	private Date openingTime;		// 开业时间
	private Date closeTime;		// 关店时间
	private String storeNature1;		// 门店区域性质
	private String storeNature2;		// 门店性质
	private String getway;		// 获得方式
	private Date acquisition;		// 收购时间
	private String address;		// 门店地址
	private String partition;		// 行政区划
	private String housesNature;		// 房屋性质
	private String isDeed;		// 有无房产证
	private String isRentalContract;		// 是否签订房租合同
	private String isLandlordRents;		// 是否直接与房东签约
	private String lessor;		// 出租方
	private String lessee;		// 承租方
	private Date leaseStartDate;		// 租赁开始日
	private Date leaseEndDate;		// 租赁结束日
	private String isMedicalInsurance;		// 是否医保
	private String isInvoice;		// 是否能取得房租发票
	private String isSublet;		// 是否转租
	private String monthSubletIncome;		// 当月转租收入
	private Integer rentalArea;		// 租赁面积
	private Integer businessArea;		// 经营面积
	private String taxpayerQualification;		// 纳税人资质
	
	public Pharmacy() {
		super();
	}

	public Pharmacy(String id){
		super(id);
	}

	@Length(min=1, max=20, message="门店编码长度必须介于 1 和 20 之间")
	@ExcelField(title="门店编码", type=1, align=2, sort=1)
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	@Length(min=1, max=255, message="门店名称长度必须介于 1 和 255 之间")
	@ExcelField(title="门店名称", align=2, sort=2)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=60, message="企业名称长度必须介于 0 和 60 之间")
	@ExcelField(title="企业名称", align=1, sort=3)
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@ExcelField(title="开业时间", align=2, sort=4)
	public Date getOpeningTime() {
		return openingTime;
	}

	public void setOpeningTime(Date openingTime) {
		this.openingTime = openingTime;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@ExcelField(title="关店时间", align=2, sort=5)
	public Date getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(Date closeTime) {
		this.closeTime = closeTime;
	}
	@ExcelField(title="门店性质", align=2, sort=6)
	public String getStoreNature1() {
		return storeNature1;
	}

	public void setStoreNature1(String storeNature1) {
		this.storeNature1 = storeNature1;
	}
	@ExcelField(title="门店性质", align=2, sort=7)
	public String getStoreNature2() {
		return storeNature2;
	}

	public void setStoreNature2(String storeNature2) {
		this.storeNature2 = storeNature2;
	}
	@ExcelField(title="获得方式", align=2, sort=8)
	public String getGetway() {
		return getway;
	}

	public void setGetway(String getway) {
		this.getway = getway;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ExcelField(title="收购时间", align=2, sort=9)
	public Date getAcquisition() {
		return acquisition;
	}

	public void setAcquisition(Date acquisition) {
		this.acquisition = acquisition;
	}
	
	@Length(min=0, max=255, message="门店地址长度必须介于 0 和 255 之间")
	@ExcelField(title="门店地址", align=2, sort=10)
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@Length(min=0, max=255, message="行政区划长度必须介于 0 和 255 之间")
	@ExcelField(title="行政区", align=2, sort=11)
	public String getPartition() {
		return partition;
	}

	public void setPartition(String partition) {
		this.partition = partition;
	}
	@ExcelField(title="房屋性质", align=2, sort=12)
	public String getHousesNature() {
		return housesNature;
	}

	public void setHousesNature(String housesNature) {
		this.housesNature = housesNature;
	}
	
	@Length(min=0, max=4, message="有无房产证长度必须介于 0 和 4 之间")
	@ExcelField(title="有无房产证", align=2, sort=13,dictType="yes_no")
	public String getIsDeed() {
		return isDeed;
	}

	public void setIsDeed(String isDeed) {
		this.isDeed = isDeed;
	}
	
	@Length(min=0, max=4, message="是否签订房租合同长度必须介于 0 和 4 之间")
	@ExcelField(title="是否签订房租合同", align=2, sort=14,dictType="yes_no")
	public String getIsRentalContract() {
		return isRentalContract;
	}

	public void setIsRentalContract(String isRentalContract) {
		this.isRentalContract = isRentalContract;
	}
	
	@Length(min=0, max=4, message="是否直接与房东签约长度必须介于 0 和 4 之间")
	@ExcelField(title="是否直接与房东签约", align=2, sort=15,dictType="yes_no")
	public String getIsLandlordRents() {
		return isLandlordRents;
	}

	public void setIsLandlordRents(String isLandlordRents) {
		this.isLandlordRents = isLandlordRents;
	}
	
	@Length(min=0, max=255, message="出租方长度必须介于 0 和 255 之间")
	@ExcelField(title="出租方", align=2, sort=16)
	public String getLessor() {
		return lessor;
	}

	public void setLessor(String lessor) {
		this.lessor = lessor;
	}
	
	@Length(min=0, max=255, message="承租方长度必须介于 0 和 255 之间")
	@ExcelField(title="承租方", align=2, sort=17)
	public String getLessee() {
		return lessee;
	}

	public void setLessee(String lessee) {
		this.lessee = lessee;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@ExcelField(title="租赁开始日", align=2, sort=18)
	public Date getLeaseStartDate() {
		return leaseStartDate;
	}

	public void setLeaseStartDate(Date leaseStartDate) {
		this.leaseStartDate = leaseStartDate;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@ExcelField(title="租赁结束日", align=2, sort=19)
	public Date getLeaseEndDate() {
		return leaseEndDate;
	}

	public void setLeaseEndDate(Date leaseEndDate) {
		this.leaseEndDate = leaseEndDate;
	}
	
	@Length(min=0, max=4, message="是否医保长度必须介于 0 和 4 之间")
	@ExcelField(title="是否医保", align=2, sort=20,dictType="yes_no")
	public String getIsMedicalInsurance() {
		return isMedicalInsurance;
	}

	public void setIsMedicalInsurance(String isMedicalInsurance) {
		this.isMedicalInsurance = isMedicalInsurance;
	}
	
	@Length(min=0, max=4, message="是否能取得房租发票长度必须介于 0 和 4 之间")
	@ExcelField(title="是否能取得房租发票", align=2, sort=21,dictType="yes_no")
	public String getIsInvoice() {
		return isInvoice;
	}

	public void setIsInvoice(String isInvoice) {
		this.isInvoice = isInvoice;
	}
	
	@Length(min=0, max=4, message="是否转租长度必须介于 0 和 4 之间")
	@ExcelField(title="是否转租", align=2, sort=22,dictType="yes_no")
	public String getIsSublet() {
		return isSublet;
	}

	public void setIsSublet(String isSublet) {
		this.isSublet = isSublet;
	}
	
	@Length(min=0, max=255, message="当月转租收入长度必须介于 0 和 255 之间")
	@ExcelField(title="当月转租收入", align=2, sort=23)
	public String getMonthSubletIncome() {
		return monthSubletIncome;
	}

	public void setMonthSubletIncome(String monthSubletIncome) {
		this.monthSubletIncome = monthSubletIncome;
	}
	@ExcelField(title="租赁面积", align=2, sort=24)
	public Integer getRentalArea() {
		return rentalArea;
	}

	public void setRentalArea(Integer rentalArea) {
		this.rentalArea = rentalArea;
	}
	@ExcelField(title="经营面积", align=2, sort=25)
	public Integer getBusinessArea() {
		return businessArea;
	}

	public void setBusinessArea(Integer businessArea) {
		this.businessArea = businessArea;
	}
	
	@Length(min=0, max=255, message="纳税人资质长度必须介于 0 和 255 之间")
	@ExcelField(title="纳税人资质", align=2, sort=26)
	public String getTaxpayerQualification() {
		return taxpayerQualification;
	}

	public void setTaxpayerQualification(String taxpayerQualification) {
		this.taxpayerQualification = taxpayerQualification;
	}
	@Override
	public String toString() {
		return id;
	}
}
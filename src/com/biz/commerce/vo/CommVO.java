package com.biz.commerce.vo;

public class CommVO {
	
	private String strDate; // 거래일자
	private String strpCode; //상품코드
	private String strInout;//거래구분
	private String strName; //상품명
	
	
	private int intPrice; //단가
	private int intSu; //수량
	private int intInPrice; // 매입금액
	private int intOutPrice; // 매출금액
	
	public String getStrDate() {
		return strDate;
	}
	public void setStrDate(String strDate) {
		this.strDate = strDate;
	}
	public String getStrpCode() {
		return strpCode;
	}
	public void setStrpCode(String strpCode) {
		this.strpCode = strpCode;
	}
	public String getStrInout() {
		return strInout;
	}
	public void setStrInout(String strInout) {
		this.strInout = strInout;
	}
	public String getStrName() {
		return strName;
	}
	public void setStrName(String strName) {
		this.strName = strName;
	}
	public int getIntPrice() {
		return intPrice;
	}
	public void setIntPrice(int intPrice) {
		this.intPrice = intPrice;
	}
	public int getIntSu() {
		return intSu;
	}
	public void setIntSu(int intSu) {
		this.intSu = intSu;
	}
	public int getIntInPrice() {
		return intInPrice;
	}
	public void setIntInPrice(int intInPrice) {
		this.intInPrice = intInPrice;
	}
	public int getIntOutPrice() {
		return intOutPrice;
	}
	public void setIntOutPrice(int intOutPrice) {
		this.intOutPrice = intOutPrice;
	}
	@Override
	public String toString() {
		return "CommerceVO [strDate=" + strDate + ", strpCode=" + strpCode + ", strInout=" + strInout + ", strName="
				+ strName + ", intPrice=" + intPrice + ", intSu=" + intSu + ", intInPrice=" + intInPrice
				+ ", intOutPrice=" + intOutPrice + "]";
	}
	

}

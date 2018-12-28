package com.biz.commerce.vo;

/*
 *  매입매출데이터.txt파일로부터 데이터를 읽어서 List를 만들때 사용할 데이터 클래스(VO)선언
 */
public class CommVO {
	
	/*
	 * 거래일자:상품코드:거래구분:단가:수량 형식의 데이터를 읽어서 
	 * 각 member변수에 저장
	 * 
	 * 각 member변수는 정보은닉과 캡슐화를 하기 위해 private으로 선언한다.
	 */
	
	private String strDate; // 거래일자 io_date
	private String strpCode; //상품코드 io_ccode
	private String strInout;//거래구분 io_inout
		 
	private int intPrice; //단가 io_price
	private int intSu; //수량 io_quan
	
	/*
	 * private으로 선언된 변수는 외부에서 직접 접근할 수 없으므로 getter와 setter 메서드를 생성해서 
	 * 변수에 값을 저장하고, 읽을 수 있도록 통로를 만든다. 
	 */
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
	
	/*
	 * vo에 데이터를 저장한 후 데이터를 확인하는 디버깅용 메서드를 재정의한다.
	 */
	
	@Override
	public String toString() {
		return "CommVO [strDate=" + strDate + ", strpCode=" + strpCode + ", strInout=" + strInout + ", intPrice="
				+ intPrice + ", intSu=" + intSu + "]";
	}
	
	
	
	}

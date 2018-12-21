package com.biz.commerce.exec;

import com.biz.commerce.service.CommService;

public class CommExec {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String pInfor = "src/com/biz/commerce/상품정보(2018-12-21).txt";
		String inoutD = "src/com/biz/commerce/매입매출데이터(2018-12-21).txt";
		String check1 =  "src/com/biz/commerce/매입매출정보.txt";
		
		CommService cs = new CommService(pInfor, inoutD);
		cs.FileRead1();
		cs.FireRead2();
		cs.InoutC();
		
		
		
	}

}

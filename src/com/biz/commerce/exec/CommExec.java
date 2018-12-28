package com.biz.commerce.exec;

import com.biz.commerce.service.CommService;


public class CommExec {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * 매입매출정보를 저장하고 있는 파일이름(경로)를 문자열 변수에 저장
		 */
		String inoutD = "src/com/biz/commerce/매입매출데이터(2018-12-21).txt"; 
		String pInfor = "src/com/biz/commerce/상품정보(2018-12-21).txt";
		String saveFile = "src/com/biz/commerce/매입매출정보.txt";
		
		
		/*
		 * CommService 클래스를 객체로 선언하여 매입매출 업무를 수행할 준비
		 * 변수를 매개변수로 저장 => 매입매출정보를 저장하고 있는 파일이름을 매개변수로 전달하는 것과 같다.
		 */
		CommService cs = new CommService(pInfor, inoutD, saveFile);
		
		cs.FileRead1(); // 매입매출정보.txt파일에서 데이터를 읽어서 commList에 저장하는 메서드 호출(실행)
		
		/*
		 * 위에서 cs.FileReade1()메서드를 실행했으므로 cs의 commList에 매입매출정보가 저장되어 있을 것이다. 
		 * 그 정보를 확인해보자 => commService에서 만든다.
		 * 
		 * cs.commView()메서드를 호출(실행)해서 정보확인
		 */
		cs.commView();
		cs.FireRead2(); // 상품정보를 읽어 pList에 저장하기 위해서 cs.FileRead2()메서드를 실행한다.
		cs.pView(); //상품정보.txt파일을 읽어 pList가 잘 만들어졌는지 호출해서 정보확인한다.		
		
		cs.viewIoInfo2();
		cs.makeFile();
		
	}

}

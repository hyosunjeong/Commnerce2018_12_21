package com.biz.commerce.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.biz.commerce.vo.CommVO;

public class CommService {
	
	List<CommVO> CommList;
	List<String> strList;
	
	String pInfor ;
	String inoutD ;
	
	
	public CommService(String pInfor, String inoutD) {
		CommList = new ArrayList();
		strList = new ArrayList();
		
		
		this.pInfor = pInfor;
		this.inoutD = inoutD;
		
	}
	
	public void FileRead1() {
		//TODO 매입매출.txt읽기
		
		FileReader fr;
		BufferedReader buffer;
		
		try {
			fr = new FileReader(inoutD);
			buffer = new BufferedReader(fr);
			
			while(true) {
				
				String reader1=buffer.readLine();
				if(reader1==null) break;
				
				String[] read = reader1.split(":");				
				CommVO vo = new CommVO();
				vo.setStrDate(read[0]);//거래일자
				vo.setStrpCode(read[1]);//상품코드
				vo.setStrInout(read[2]);//거래구분
				vo.setIntPrice(Integer.valueOf(read[3]));//단가
				vo.setIntSu(Integer.valueOf(read[4]));//수량
				
				CommList.add(vo);
				
			}
			buffer.close();
			fr.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void FireRead2() {
		//TODO 상품정보읽기
		
		FileReader fr;
		BufferedReader buffer;
		
		try {
			fr = new FileReader(pInfor);
			buffer = new BufferedReader(fr);
			
			while(true){
				String reader2 = buffer.readLine();
				if(reader2 == null) break;
				
			String[] read2 = reader2.split(":");
			CommVO vo = new CommVO();
			vo.setStrpCode(read2[0]);
			vo.setStrName(read2[1]);
			vo.setIntInPrice(Integer.valueOf(read2[3]));
			vo.setIntOutPrice(Integer.valueOf(read2[4]));
			
			CommList.add(vo);
			
				
			}
			buffer.close();
			fr.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
  	public void InoutC() {
 
		for(CommVO vo : CommList) {
			
			if(vo.getStrInout().equals(1)) {
				vo.setStrInout("매입");
				
				
			}else if(vo.getStrInout().equals(2)) {
				vo.setStrInout("매출");
				
			}
			
		}
		
		
	}


}

package com.biz.commerce.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.biz.commerce.vo.CommVO;
import com.biz.commerce.vo.ProductVO;

/*
 * 매입매출 관련 처리를 위한 클래스를 선언한다.
 */
public class CommService {
	/*
	 * 각 데이터를 관리할 List변수를 선언
	 */
	List<CommVO> commList; // 매입매출정보 table
	List<ProductVO> pList; // 상품정보 table
	List<String> makefile; //파일저장
	
	/*
	 * text 파일관련 변수들 선언
	 */
	String inoutD; // 매입매출 파일 이름
	String pInfor; // 상품정보 파일 이름

	String saveFile; //매입매출정보 파일이름
	
	
	
	/*
	 * CommService 클래스로 객체를 생성할 때 호출되는 생성자를 선언한다.
	 *
	 * 이 클래스는 text파일을 읽어서 매입매출관련 업무를 수행할 것이므로 생성자에서는 text파일의 경로정보를 매개변수로 받아서 변수에
	 * 저장하는 코드를 수행한다.
	 */
	public CommService(String pInfor, String inoutD, String saveFile) {
		this.commList = new ArrayList(); // 매입매출정보의 list를 담을 commList를 초기화한다.
		this.pList = new ArrayList(); // 상품정보의 list를 담은 pList를 초기화한다.
		this.makefile = new ArrayList();
		
		
		this.inoutD = inoutD; // 매개변수로 받은 inoutD의 내용을 this.inoutD member변수에 저장하여 다른 method에서 사용할 수 있도록 준비한다.
		this.pInfor = pInfor; //매개변수로 받은 pInfor의 내용을 this.pInfor member변수에 저장하여 다른 method에서 사용할 수 있도록 준비한다.
		this.saveFile = saveFile;

	}

	
	/*
	 * 파일을 저장할 메서드 선언
	 */
	public void makeFile() {
		FileWriter fw;
		PrintWriter pw;
		
		try {
			fw = new FileWriter(saveFile);
			pw = new PrintWriter(fw);
			
			for(String s : makefile) {
				
				pw.println(s);
				 
			}
			
			pw.close();
			fw.close();
			
			System.out.println("저장완료");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	/*
	 * commList에 저장되어 있는 매입매출정보리스트를 console에 표시해서 잘 저장되어 있는지 검사하는 메서드 선언
	 */
	public void commView() {
		
		for (CommVO vo : commList) {
			
			
			
			System.out.println(vo);
		}
	}

	/*
	 * 매입매출데이터.txt파일에서 문자열을 읽어서 commList에 저장하는 메서드 선언
	 */
	public void FileRead1() {
		// TODO 매입매출.txt읽기
		FileReader fr; // text 파일을 읽기 위한 FileReader 객체 선언
		BufferedReader buffer; // FileReader로 읽은 내용에서 문자열을 쉽게 추출할 수 있도록 연결되는 Buffer객체 선언

		try {
			/*
			 * 생성자에서 값이 할당된 inoutD의 내용을 참조하여 파일을 읽기 위하여 open하는 코드
			 * 
			 * 이 코드는 작동되는 과정에서 불가항력적인 문제가 발생할 소지가 있으므로 반드시 try..catch문으로 감싸줘야 한다.
			 */
			fr = new FileReader(inoutD);

			/*
			 * FileReader로 open된 파일 정보를 Buffer에 연결하여 준다. 이 코드가 실행되면 BufferedReader는 일단 파일을
			 * 읽어서 메모리의 Buffer영역에 저장해 둔다.
			 */
			buffer = new BufferedReader(fr);

			/*
			 * 무한반복문을 이용해서 Buffer에 저장된 파일내용에서 한줄씩 (문자열로)읽어서 처리한다.
			 */
			while (true) {

				String reader1 = buffer.readLine(); // buffer에서 한줄을 읽어서 reader1변수에 저장

				if (reader1 == null)
					break; // 만약 reader1에 저장된 값이 null이면 모든 문자열을 다 읽었다는 것이므로 반복문을 종료한다.

				System.out.println(reader1); // 반복문이 종료되지 않았으므로 (reader1 변수에 문자열이 담겨있다는 것) code가 실행되어 console에 해당 문자열을 표시한다.

				/*
				 * reader1문자열을 콜론(:)으로 분리해서 CommVO에 담고 commList에 추가하는 부분
				 */
				String[] read = reader1.split(":"); // String.split()메서드를 사용해서 문자열을 분해하고 read문자열 배열에 저장

				CommVO vo = new CommVO(); // 새로운 vo를 생성(선언과 초기화)

				/*
				 * vo의 각 member변수에 값을 저장(할당)
				 */
				vo.setStrDate(read[0]);// 거래일자
				vo.setStrpCode(read[1]);// 상품코드
				vo.setStrInout(read[2]);// 거래구분

				/*
				 * vo.setIntPrice는 int형 변수이므로 문자열을 int로 먼저 변환한다.
				 */
				vo.setIntPrice(Integer.valueOf(read[3]));// 단가
				vo.setIntSu(Integer.valueOf(read[4]));// 수량

				commList.add(vo); // member변수가 setting된 vo를 commList에 추가한다.

			}
			/*
			 * 파일을 모두 사용(읽기)했으므로 안전하게 닫아준다.
			 */
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
	
	/*
	 * 상품정보.txt파일을 읽어 pList가 잘 만들어졌는지 확인하는 메서드 선언
	 */
	public void pView() {
		for(ProductVO vo : pList) {
		
			
			System.out.println(vo);
		}
	}

	/*
	 * 상품정보.txt파일에서 문자열을 읽어서 pList에 저장하는 메서드 선언
	 */
	public void FireRead2() {
		// TODO 상품정보읽기

		FileReader fr;
		BufferedReader buffer;

		try {
			fr = new FileReader(pInfor);
			buffer = new BufferedReader(fr);

			while (true) {
				String reader2 = buffer.readLine();
				if (reader2 == null)
					break;

				String[] read2 = reader2.split(":");

				ProductVO vo = new ProductVO();
				vo.setP_code(read2[0]);
				vo.setP_name(read2[1]);
				vo.setP_vat(read2[2]);

				int iPrice = Integer.valueOf(read2[3]);
				int oPrice = Integer.valueOf(read2[4]);

				vo.setP_iprice(iPrice);
				vo.setP_oprice(oPrice);

				pList.add(vo);

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

	
	
	/*
	 * commList와 pList에 담긴 데이터를 사용해서 매입매출List를 출력하는 메서드 선언
	 * 1. commList에 담겨있는 상품코드를 사용해서 pList에 담겨있는 상품정보를 찾아서 가져오기  
	 */
	public void viewIoInfo() {
		
		for(CommVO vo : commList) {
			for(ProductVO pv : pList) {
				if(vo.getStrpCode().equals(pv.getP_code())) {
					System.out.println(vo.getStrpCode());
					System.out.println(pv.getP_code());
				}
			}
		}
	}
	
	public void viewIoInfo2() {
		for(CommVO vo : commList) {
			
			/*
			 * serchePro...()메서드에게 상품코드를 전달해주고 pList로부터 상품을 찾아라 라고 명령
			 */
			ProductVO v = searchProduct(vo.getStrpCode());
			/*
			 * 만약 serchPro..()메서드가 null을 보내오면 일단 그 상품은 무시하고 (상품명을 없는 것으로 처리)
			 * 그 다음 매입매출정보를 처리한다.
			 */
			if(v == null) continue;
			
			/*
			 * v가 null이 아니면 => 상품코드를 찾았으면
			 * 여기에 다 다르면 매입매출정보의 상품코드에 해당하는
			 * 상품정보가 담긴 v가 만들어진다.
			 */
			System.out.print(vo.getStrDate()+" : ");
			System.out.print(vo.getStrInout()+" : ");
			System.out.print(vo.getStrpCode() +" : ");
			System.out.println(v.getP_name()+" : ");
			
			/*
			 * 단가와 금액 계산 
			 * 매입매출데이터의 단가가 거래구분이 1이면 매입단가이고 거래구분이 2이면 매출단가이다.
			 */
			int intIPrice = 0;
			int intOPrice = 0;
			String strIOTag = "";
			
			String strInOut = vo.getStrInout();
			int intInOut = Integer.valueOf(strInOut);
			
			if(intInOut == 1) {
				//매입
				intIPrice = vo.getIntPrice(); // iv.getIo_price();
				intOPrice =0;
				strIOTag = "매입";
			}else {
				//매출
				intIPrice = 0;
				intOPrice = vo.getIntPrice(); //확인
				strIOTag = "매출";
			}
				System.out.print(vo.getStrDate()+" : "); //거래일자
				System.out.print(strIOTag +" : "); //매입매출구분
				System.out.print(vo.getStrpCode() +" : "); //상품코드
				System.out.print(v.getP_name()+" : "); //상품이름
				System.out.print(vo.getIntPrice()+" : "); //단가
				
				System.out.print((intIPrice*Integer.valueOf(vo.getIntSu()))+" : "); // 매입
				System.out.println((intOPrice*Integer.valueOf(vo.getIntSu()))); // 매출
				
				
				String p = vo.getStrDate() + " : " + strIOTag + " : " 
							+ vo.getStrpCode() + " : " + v.getP_name() + " : " 
							+ vo.getIntPrice() + " : " + (intIPrice*Integer.valueOf(vo.getIntSu()))+" : "
							+ (intOPrice*Integer.valueOf(vo.getIntSu()));
				makefile.add(p);
				
			}
		
	}
	
	public ProductVO searchProduct(String pCode) {
		for(ProductVO pv : pList) {
			if(pCode.equals(pv.getP_code())) {
				return pv; // 상품코드정보를 리턴
			}
		}
		return null; //상품코드가 없으면 null을 리턴
	}
	
}

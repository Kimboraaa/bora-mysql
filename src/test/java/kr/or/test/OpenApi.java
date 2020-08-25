package kr.or.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class OpenApi {

	//외부연계 메서드
	public static void serviceApi() {
		BufferedReader br = null;//HRD넷에서 전송받은 데이터를 일시저장하는 저수지와 같은 역할
		String urlstr ="http://www.hrd.go.kr/jsp/HRDP/HRDPO00/HRDPOA60/HRDPOA60_1.jsp?returnType=XML"
				+ "&authKey=인증키&pageNum=1&pageSize=10"
				+ "&srchTraStDt=20200501&srchTraEndDt=20201231&outType=1&sort=DESC&sortCol=TR_STT_DT&srchTraArea1=44";//URL길어서 자름(가독성 높아짐) //HRD인증키 테스트서버 URL복사
		try {
			URL url = new URL(urlstr);
			HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();//괄호는 형변환
			 urlconnection.setRequestMethod("GET");
			 br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(),"euc-kr"));
			 String result = "";
	            String line;
	            while((line = br.readLine()) != null) {
	                result = result + line + "\n";//\new line
	                //1부터 100까지 더하는 로직과 같음
	            }
	           // System.out.println(result); //XmlUtils에서 예쁘게나오게 설정해줬기때문에 주석처리
	           String result_xmlUtils = XmlUtils.formatXml(result);
	           System.out.println(result_xmlUtils);//웹화면에서 보는것과 비슷
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 콘솔화면에 현재 PC시간을 표시
        Calendar cal = Calendar.getInstance();
		System.out.println(cal.getTime()); 
	}
	public static void main(String[] args) {
		// 실행간격 지정(10초)
    	int sleepSec = 10 ;
    	// 주기적인 작업을 위한 코딩 exec실행가능한 클래스 만듬
    	final ScheduledThreadPoolExecutor exec = new ScheduledThreadPoolExecutor(1);
    	exec.scheduleAtFixedRate(new Runnable(){ 
    		public void run() {
    			serviceApi();
    		}
    	
    	},0 ,sleepSec ,TimeUnit.SECONDS );//5초단위로 실행시켜라(0:바로실행)
		
    	serviceApi();

	}
}

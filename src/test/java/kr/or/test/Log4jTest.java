package kr.or.test;


import java.net.InetAddress;
import java.net.UnknownHostException;

import org.apache.log4j.Logger;
// logger level : debug < info < warn < error < fatal
public class Log4jTest {
	private Logger log = Logger.getLogger(Log4jTest.class);
	public void test() {
		MemberVO memberVO = new MemberVO();
		memberVO.setName("홍길동");
		memberVO.setAge(24);
		try {
	         InetAddress localPc = InetAddress.getLocalHost();   
	       //InetAddress클래스는  자바에서 ip 주소를 표현할때 사용하는 클래스
	         /*- InetAddress의 주요 메서드
	              ->getAddress() - InetAddress 객체의 IP주소를 반환
	              ->getHostAddress() - IP주소를 반환
	              ->getHostName() - 호스트 이름을 문자열로 반환 
	         */
	         String ip = localPc.getHostAddress();
	         log.info("test라는 메서드를 사용한 pc의 아이피는 : " + ip);
	      }catch (UnknownHostException e) {
	         e.printStackTrace();
	         //exception 처리하게 되면 기본적으로 들어간다.간략하게 나타내면 e.getMessage(), e.toString() = 에러 메세지만 간략하게 보여줌 , 차이점:그냥 java exception인지 보여주는 차이.
	      }
		
		
		log.debug("디버그!!" + memberVO);
		log.info("인포!!");
		log.warn("워닝!!");
		log.error("에러!!");
		log.fatal("파탈에러!!");
	}
	public static void main(String[] args) {
		new Log4jTest().test();
	}

}

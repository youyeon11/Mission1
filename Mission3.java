//깜짝미션3

// 웹사이트에서 사용하는 페이지네비게이션의 html 코드 출력 (-> 웹크롤링에서의 패턴 참고하기)
// 초기 결정 값들: 전체 게시글 수, 한 페이지당 보여지는 글의 수, 페이지네비게이션에서 보여주는 블럭수, 현재 페이지번호
// 현재 페이지번호에 해당하는 번호는 다른 페이지번호와 구분되어야 함 ex.현재 페이지 빨간색

// 전체 글의 수 127개, 글의 목록 10개

import java.io.*;

public class Mission3 {
	
	public static class Pager {
		
		long totalCount;
		long pageIndex;
		
		public Pager(long totalCount) {
			this.totalCount = totalCount;
		}
		
		public String html(long pageIndex) {
			this.pageIndex = pageIndex;
		
			// 작성할 html 코드 내용
			// for 반복문 이용을 위하여 StringBuilder 이용하기
			StringBuilder html = new StringBuilder();
			html.append("<head></head>");
			html.append("<body>\r\n");
	        html.append("   <a href='#'>[처음]</a>\n");
	        html.append("   <a href='#'>[이전]</a>\n");
	        
	        long block = (int) pageIndex/10;
	        long start = block*10 +1; // 나타내야할 것들을 잘 정리한 이후에 변수선언
	        long end = (block + 1)* 10;
	        long realEnd = (int)Math.ceil(totalCount/10); 
	        
	        // endPoint
	        long endPoint = end > realEnd ? realEnd : end;
	        
	        // html 코드 작성
	        for (long i = start; i <= endPoint; i++) {
	        	if (i == pageIndex) {
	                html.append("	<a href='#' class ='on'>");
	                html.append(i);
	                html.append("</a>\n");
	        	} else {
	                html.append("	<a href='#'>");
	                html.append(i);
	                html.append("</a>\n");
	        	}
	        }
	        
	        html.append("   <a href='#'>[다음]</a>\n"+
	                "   <a href='#'>[마지막]</a>\n");
	        return html.toString();
		}
	}
	
	public static void main(String[] args) {

		//Test code
		long totalCount = 127;
		long pageIndex = 25;
		
		Pager pager = new Pager(totalCount);
		try {
			File file = new File("./java.html");
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			
			writer.write(pager.html(pageIndex));
			
			writer.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
}
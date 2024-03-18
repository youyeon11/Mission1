// 깜짝미션1
// 전유연

// 자바의 환경 정보를 html의 테이블 구조로 출력한 property.html 파일을 만드는 코드를 작성하세요.

// 조건
// 1. 자바의 시스템 속성과 파일 저장 코드는 샘플 코드를 참조
// 2. 출력결과의 파일은 웹브라우저로 확인해서 정상적으로 표시되어야 함
// 3. html파일을 작성할 때 테이블에 라인이 표시되도록 head 태그에 style 태그 추가


import java.io.*;

public class Mission1 {
	public static void main(String[] args) {
		// java로 html 파일 만들기
		try {
			File file = new File("./property.html");
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));

			// 작성할 내용 writer를 통해 작성
            writer.write("<!DOCTYPE html>\n" +
                    "<html lang=\"utf-8\">\n" +
            		
                    // head 작성
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                    "    <title>Document</title>\n" +
                    // style 설정
                    "    <style>\n" +
                    "        table { border-collapse: collapse; width: 100%;}\n" +
                    "        th, td { border: solid 1px #000;}\n" +
                    "    </style>\n" +
                    "</head>\n" +
                    
                    // body 작성
                    "<body>\n" +
                    "    <h1>자바 환경정보</h1>\n" +
                    "    <table>\n" +
                    "        <tr>\n" +
                    "            <th>키</th>\n" +
                    "            <th></th>\n" +
                    "        </tr>\n");
            
            for (Object k: System.getProperties().keySet()) {
                String key = k.toString();
                String value = System.getProperty(key);
                writer.write("        <tr>\n" +
                        "            <td>" + key + "</td>\n" +
                        "            <td>" + value + "</td>\n" +
                        "        </tr>\n");
            }
            writer.write("    </table>\n" +
                    "</body>\n" +
                    "</html>");
			
			// writer 종료
			writer.close();
			
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
}
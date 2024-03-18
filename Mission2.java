// 깜짝미션2
// 전유연

// 조건
// 1. 나의 좌표 값을 입력 받기 (x값, y값 순서)
// 2. 이후, 임의의 좌표 값을 입력 받기(상동)
// 3. 임의로 입력된 좌표 값 중 동일한 좌표 값을 입력하는 경우는 저장하지 않고 다시 입력하도록 함
// 4. 입력 받은 값이 10개가 되는 경우, 입력 받은 좌표 값과 나의 좌표 값의 거리 중 가장 가까운 좌표 값을 화면에 출력하

// 예시)
// 나의 좌표 값: (1, 1)
// 임의로 입력받은 좌표 값: (2, 2), (3, 3), (4, 4), (5, 5), (6, 6), (7, 7), (8, 8), (9, 9), (10, 10), (11, 11)
// 출력: 나와 가장 가까운 좌표값은 (2, 2) 입니다

import java.util.Scanner;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Mission2{
	// 거리 공식 계산 함수 생성
	public static double distanceCalculator(int[] myCd, int[] coord) {
		int xDiff = Math.abs(myCd[0] - coord[0]);
		int yDiff = Math.abs(myCd[1] - coord[1]);
		return Math.sqrt(Math.pow(xDiff, 2) + Math.pow(yDiff, 2));
	}
	
	// 중복이 있는지 확인하는 함수 생성
	// list를 통하여 객체 하나하나에 대한 비교를 실시
    public static boolean isSame(int[] input, ArrayList<int[]> list){
        if(list.isEmpty())
            return false;
        for(int[] arr : list){
            if(arr[0] == input[0] && arr[1] == input[1])
                return true;
        }
        return false;
    }
	
	
	public static void main(String[] args) {
		// 나의 좌표 입력
		Scanner sc = new Scanner(System.in);
		int[] myCd = new int[2];
		System.out.println("값 (x, y)의 좌표를 입력하세요.");
		myCd[0] = sc.nextInt();
		myCd[1] = sc.nextInt(); // 나의 좌표 완성
		
		// 임의로 좌표 값 입력 받기
		ArrayList<int[]> list = new ArrayList<>();
		while (list.size() < 10) {
			System.out.println("임의의 (x, y)의 좌표를 입력하세요. (현재 : " + list.size() +"번째)");
			int[] input = new int[2];
			input[0] = sc.nextInt();
			input[1] = sc.nextInt();
			if (isSame(input, list)) {
				System.out.println("중복입니다. 다른 값을 입력해주세요.");
			} else {
				list.add(input);
			}
			
			
		}
		double min = Double.MAX_VALUE;
		int[] answer = new int[2];
		for(int[] coord : list) {
			if (min > distanceCalculator (myCd, coord)) {
				answer[0] = coord[0];
				answer[1] = coord[1];
				min = distanceCalculator(myCd, coord);
			}
		}
		System.out.println("나와 가장 가까운 좌표값은 ("+ answer[0] +","+ answer[1] + ")입니다");
		
	}
}
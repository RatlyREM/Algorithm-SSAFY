package PS240305;

import java.util.HashMap;

public class SWEA_성적조회 {
	public static void main(String[] args) {
		/*
		 * 추가할 때는 id, 학년, 성별 점수 주어짐
		 * 삭제할 때는 id만 주어짐
		 * 조회할 때는, 해당 조건에 맞는 학생 중 점수가 가장 낮은 학생의 id
		 * 
		 */
		
		/*
		 * mId, mGrade, mGender를 멤버로 갖는 class를 선언한다. 
		 * 
		 * 1. init
		 * multiset? map?을 선언한다.
		 * 
		 * 2. add
		 * 그리고 c++의 multiset으로, mScore와 해당 class 객체를 pair로 맺는다.
		 * 		정렬은 mScore, mId 순
		 * 
		 * 먼저 해당 class- score pair를 muliset에 추가한다.
		 * 높은 점수부터 내려가면서 pair로 가지는 class에서 gender와 grade가 동일한 멤버를 찾는다.
		 * 찾았으면 해당 id를 return
		 * 
		 * 3. remove
		 * HashMap<Integer, int[]> GradeAndScore = new HashMap<Integer, int[]>();
			HashMap<Integer, char[]> gender = new HashMap<Integer, char[]>();
		 * 
		 * map에 넣어두고, mId와 일치하는 해당 key가 존재한다면 해당 데이터를 map에서 삭제한다.
		 * 
		 * 
		 * 4. query
		 * 
		 * 
		 * 
		 * 
		 * 	HashMap<Integer, int[]> GradeAndScore = new HashMap<Integer, int[]>();
			HashMap<Integer, char[]> gender = new HashMap<Integer, char[]>();
		 * 이와 같은 형태로 map 2개를 선언하고, 학생의 id를 key로 한다.
		 * 
		 * 1. init 함수 -> map 2개를 clear시킨다.
		 * 2. add 함수 -> 전달받은 mId와 mgrade,mScore를 엮어 각 map에 삽입한다.
		 * 				mId와 gender도 엮어 성별 map에 삽입한다.
		 * 				
		 * 				가장 높은 mGrade
		 * 3. remove 함수 -> 전달받은 mId를 key로 갖는 각 map의 요소들을 삭제한다.
		 * 4. query 함수
		 * 		
		 * 
		 */
		
		HashMap<Integer, Integer> Score = new HashMap<Integer, Integer>();
		HashMap<Integer,Integer> grade = new HashMap<Integer, Integer>();
		HashMap<Integer, char[]> gender = new HashMap<Integer, char[]>();
	}
}

package 수학2;

import java.util.*;

public class a_1929_1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		ArrayList<Boolean> primeList;
		int M = sc.nextInt();
		int N = sc.nextInt();

		if(N <= 1) return;

		primeList = new ArrayList<Boolean>(N+1);
		primeList.add(false); // 0은 소수가 아니다
		primeList.add(false); // 1은 소수가 아니다
		
		for(int i=2; i<=N; i++) // 전부 true를 채워 넣고 소수가 아닌 수들을 찾아 false로 바꿈
			primeList.add(i, true);
		
		for(int i=2; (i*i)<=N; i++) { // 2 부터  ~ i*i <= N 까지 각각의 배수들을 지움
			if (primeList.get(i)) {
				for(int j = i*i; j<=N; j+=i) primeList.set(j, false); // 소수가 아닌 수들을 false로 바꿈
				/* i*i 미만은 이미 처리되었으므로 j의 시작값은 i*i로 최적화할 수 있음
				 예를 들어 5의 체를 거를 때에는 이미 앞서, 4*5와 3*5는 모두 걸러졌음 */
			}
		}
		
		for (int i=M; i<=N; i++) {
			if (primeList.get(i)) System.out.println(i);
		}

	}

}

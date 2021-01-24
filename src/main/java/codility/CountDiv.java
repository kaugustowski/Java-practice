package codility;

//Write a function:
//that, given three integers A, B and K,
//returns the number of integers within the range [A..B] that are divisible by K.

public class CountDiv {
    public int solution(int A, int B, int K) {
        return A%K==0 ? 1+(B-A)/K : (B-A)/K;
    }
}

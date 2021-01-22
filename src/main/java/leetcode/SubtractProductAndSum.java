package leetcode;

//Given an integer number n, return the difference between the product of its digits and the sum of its digits.

public class SubtractProductAndSum {

    public int subtractProductAndSum(int n) {

        int result;
        int productOfDigits = 1;
        int sumOfDigits = 0;
        int currentDigit;

        while (n > 0) {
            currentDigit = n % 10;
            productOfDigits *= currentDigit;
            sumOfDigits += currentDigit;
            n /= 10;
        }
        result = productOfDigits - sumOfDigits;
        return result;
    }
}

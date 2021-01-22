package leetcode;

//We are given a list nums of integers representing a list compressed with run-length encoding.
//        Consider each adjacent pair of elements [freq, val] = [nums[2*i], nums[2*i+1]] (with i >= 0).
//        For each such pair, there are freq elements with value val concatenated in a sublist.
//        Concatenate all the sublists from left to right to generate the decompressed list.
//        Return the decompressed list.

public class DecompressEncodedList {
    public int[] decompressRLElist(int[] nums) {
        int [] result;
        int size = 0;
        int index = 0;

        for (int i = 0; i<nums.length; i=i+2){
            size+=nums[i];
        }

        result = new int[size];

        for (int i = 0; i<nums.length; i=i+2){
            for(int j = 0; j < nums[i]; j++, index++){
                result[index] = nums[i+1];
            }
        }
        return result;
    }
}

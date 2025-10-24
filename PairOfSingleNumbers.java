// This logic uses multi step approach
// 1: we calculate xor of all the numbers which wil give us xor of 2 unique numbers we are looking for
// 2: we get the least significant digit where both number difers by doing an and between the xor number and its complement
// 3: we then go over all the elements again and do a xor except for the number where the lsd is 0. Result is one of the number we are looking for
// 4: we will get the second one by simply doing a xor of the result and the initial xor caclulated as it will cancel out of the number found
class Solution {
    public int[] singleNumber(int[] nums) {
        int bitmask1 = 0;
        for(int i:nums) {
            bitmask1^=i;
        }

        int complement = -(bitmask1);
        int lsd = complement&bitmask1;

        int bitmask2 = 0;
        for(int i:nums) {
            if((i&lsd)!=0) {
                bitmask2^=i;
            }
        }

        int[] response = new int[2];
        response[0] = bitmask2;
        response[1] = bitmask1^bitmask2;

        return response;
    }
}

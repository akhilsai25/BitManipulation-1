// This solution uses xor operator to cancel out all the similar elements and bubble out the only distinct element
class Solution {
    public int singleNumber(int[] nums) {
        int result=0;
        for(int i:nums) {
            result^=i;
        }
        return result;
    }
}

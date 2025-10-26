// This solution uses a bit shift based approach where we start with divisor and keep left shifting to make the number *2 everytime. Once we cross the divident value we rollback to previous state
// At this state, we subtract the dividend with the accumulated value and do the same logic with the left over dividend until we cross it
// We calculate total shifts and append at every level
class Solution {
    public int divide(int dividend, int divisor) {

        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if(divisor==1) return dividend;

        int finalShifts = 0;

        long div = Math.abs(Long.valueOf(dividend));
        long divis = Math.abs(Long.valueOf(divisor));
        while(div>=divis) {
            long shifts = 1;

            while((divis<<shifts) <= div) {
                shifts++;
            }

            shifts--;
            div -= (divis<<shifts);
            finalShifts+=(1<<shifts);
        }

        if(dividend<0 && divisor<0) return finalShifts;
        if(dividend>0 && divisor>0) return finalShifts;
        return -finalShifts;
     }
}

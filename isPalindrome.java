class Solution {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        int org=x;
        long rev=0;
        int temp=x;
        while(temp>0){
            int d=temp%10;
            rev=(rev*10)+d;
            temp=temp/10;
        }
        if(org==rev){
            return true;
        }else{
            return false;
        }
    }
}

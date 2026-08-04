class Solution {
    public int singleNumber(int[] nums) {
       /* HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(int num:nums){
            if(map.get(num)==1){return num;}
        }return -1;*/
        int ones=0;
        int twos=0;
        for(int num:nums){
            ones=(ones^num)&~twos;
            twos=(twos^num)&~ones;
        }return ones;
    }
}
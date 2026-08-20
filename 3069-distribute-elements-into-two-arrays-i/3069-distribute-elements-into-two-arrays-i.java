class Solution {
    public int[] resultArray(int[] nums) {
        int[] arr1=new int[nums.length];
        int[] arr2=new int[nums.length];
        int j=0;
        int k=0;
        arr1[j]=nums[0];
        arr2[k]=nums[1];
        for(int i=2;i<nums.length;i++){
            if(arr1[j]>arr2[k]){
                arr1[++j]=nums[i];}
            else{
                arr2[++k]=nums[i];
            }
        }int [] ans=new int[nums.length];
        System.arraycopy(arr1, 0, ans, 0, j+1);
        System.arraycopy(arr2, 0, ans, j+1, k+1);

        return ans;
    }
}
//找出数组中的重复数字，时间复杂度O(n),空间复杂度O(1),但是要修改原数组

public class Q3 {
	public int duplicate(int[] nums){
		int N = nums.length;
		if(N<=0) return -1;
		for(int i= 0;i<N;i++){
			while(nums[i]!=i){
				int pos = nums[i];
				if(nums[pos]==pos)
					return pos;
				else 
					exch(nums,pos,i);
			}
		}
		return -1;
	}
	private void exch(int[] nums,int m,int n){
		int tem = nums[m];
		nums[m] = nums[n];
		nums[n] = tem;
	}
}

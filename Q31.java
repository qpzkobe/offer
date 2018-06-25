//长度为n+1的数组里面放着1~n范围之内的数，找出数组中的重复数字，时间复杂度O(n),空间复杂度O(1),
//但是不能修改原数组

public class Q31 {
	//初步实现：时间复杂度O(n),空间复杂度O(n)
	//使用了额外了布尔数组
	public static int duplicate(int[] nums){
		int N = nums.length;
		int max = 0;
		for(int i = 0;i<N;i++){
			if(nums[i]>max) max = nums[i];
			System.out.println("i = "+i+" max = "+max);
		}
		boolean[] result = new boolean[max+1];                    //注意这里，数组大小为max+1
		for(int i=0;i<N;i++){
			if(!result[nums[i]])  result[nums[i]] = true;
			else return nums[i];
		}
		return -1;
	}
	
	//改进：时间复杂度O(nlog(n)),空间复杂度O(1)
	//利用了简单的统计和二分查找
	//陷阱：要时刻注意这里的 lo mid hi 不是数组的索引而是内容
	public static int duplicate1(int[] nums){
		int lo = 1;
		int hi = nums.length-1;
		while(lo<=hi){
			int mid = ((hi - lo)>>1) + lo;
			int count = 0;
			for(int i=0;i<nums.length;i++)
				if(nums[i]<=mid&&nums[i]>=lo) count++;
			if(count>mid-lo+1) hi = mid;
			else lo = mid+1;
			if(lo == hi){
				if(count>1) return lo;
				else break;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] nums = {2,4,3,1,4,5};
		//System.out.println(duplicate(nums));
		
		System.out.println(duplicate1(nums));
	}
}

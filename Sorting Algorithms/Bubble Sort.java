public class Client
{
	public static void main(String[] args) 
	{
		int[] nums = {7, 3, 5, 2, 6};
		int temp;
		
		final int N = nums.length;
		
		for (int i = N - 1; i > 0; i--)
			 	  {
			 		for (int j = 0; j < i; j++)
			 		  {
						if (nums[j] > nums[j+1])
						{
							//Swap them
							temp = nums[j];
							nums[j] = nums[j + 1];
							nums[j + 1] = temp;
						}
					  }
			 		
					//Output the array
					for (int j = 0; j <= N - 1; j++) 
					{
						System.out.print(nums[j] + "\t");	
					}
					
					System.out.println("\n");
				  }	
	}
}
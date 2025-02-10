public class Client 
{
	public static void main(String[] args) 
	{
		int[] arr = {7, 3, 9, 8, 11, 15, 12};
		
		final int N = arr.length;
		
		//insertionSort(arr);
		
		for (int i = 1; i <= N - 1; i++)
		{
			int pos = i;
			int B = arr[i];
			
			//Short-circuit evaluation
				//first condition is false, won't even check the second
			while ((pos > 0) && (arr[pos-1] > B))
			{
				arr[pos] = arr[pos-1];
				pos--;
			}
			arr[pos] = B;
			
			System.out.println();
			//System.out.print("Pass #" + i + (":\t"));
			
			for (pos = 0; pos <= N-1; pos++)
			{
				System.out.print("Pass #" + i + (":\t"));
				System.out.print(arr[pos] + "\t");
				
				//System.out.println();
			} 
		}	
	}
}
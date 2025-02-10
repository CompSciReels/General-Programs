public class Client 
{
	public static void selectionSort(int[] arr)
	{
		for (int i = 0; i < arr.length - 1; i++)
			{
				int minPosition = i;
				
				for (int j = i + 1; j < arr.length; j++)
				{
					if (arr[minPosition] > arr[j])
					{
						minPosition = j; //location for the new min num
					}
				}
				if (minPosition != i)
				{
					//swap the current element with smallest remaining
					int temp = arr[i];
					arr[i] = arr[minPosition];
					arr[minPosition] = temp;	
				}
			}
	}
	
	public static void main(String[] args) 
	{
		int[] arr = {7, 3, 5, 2, 6}; //test integers
		selectionSort(arr);

		for (int i : arr) 
		{
	        System.out.print(i + " ");
		}
	}
}
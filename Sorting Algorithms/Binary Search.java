import java.io.*;

class Client
{
	//Binary Search Method - return the position where the element was found
	public static int binarySearch(int arr[], int x)
	{
		int low = 0;
		int high = arr.length - 1;
		int mid = 0;
		
		while (low <= high)
		{
			mid = (low + high) / 2;	//Mid
			
			if (arr[mid] < x)
			{
				low = mid + 1;		//Low
			}
			else if (arr[mid] > x)
			{
				high = mid - 1;		//High
			}
			else
			{
				return mid;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) throws IOException
	{
		DataInputStream reader = new DataInputStream(System.in);
		
		//Start with a list of sorted numbers
		int[] arr = {1, 3, 5, 7, 9, 10, 11, 12, 14, 16, 18};
		
		System.out.print("What number would you like to search the list for? ");
		int x = Integer.parseInt(reader.readLine());
		
		int pos = binarySearch(arr, x);	
		
		//We didn't find the number
		if (pos == -1)
		{
			System.out.println("I'm sorry. I could not find the number you were looking for.");
		}
		else 
		{
			System.out.print("The value " + x + " was found. It has index ");
			System.out.print(pos + " in the list.\n");
		}
	}
}
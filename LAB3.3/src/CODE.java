import java.util.Arrays;

public class CODE 
{
	public static void main (String[] args)
	{
	String []L1 = {"apple" , "banana", "microsoft", "zorro" , "cucumuber" , "cake"};
	String [] L2 = {"cherry" , "mahogany" , "oreos" , "pinata"};
	int [] L3 = {3,2,4,65,23,145,66,234,1234,6,24,53};
	
	System.out.print()
	
	//
	//Merge Test
	long start = System.nanoTime();
	String[] mergeResult = mergeSort(L1);
	long end = System.nanoTime();
	long time = end - start;
	System.out.println();
	System.out.println(mergeResult);
	}
	//Partition
	/*long start = System.nanoTime();
	int pivotFinalPos = partition(L3);
	long end = System.nanoTime();
	long time = end - start;
	System.out.println("Partition test took: " + time + " nanoseconds");
	System.out.println("Final Pivot Position: " + pivotFinalPos);
	}
	*/
	public static String[] mergeSort(String[]L1)
	{
		//Base code
		int a = L1.length;
		String[] left = new String[(a)/2];
		String[] right = new String[a - left.length];
		if (a <= 1)
		{
			return L1;
		}
		return (merge(mergeSort(right) , mergeSort(left)));
	}
	public static String[] merge(String [] L1, String [] L2) 
	{
		String [] f = new String [(L1.length) + (L2.length)-1]; 
		int a = 0;
		int b = 0;
		int c = 0;
		while(b < L1.length && c < L2.length && a < f.length) 
		{
			if (L1[b].compareTo(L2[c]) >= 0)
			{
				f[a] = L2[c];
				a++;
				c++;
			}				
			else
			{
				f[a] = L1[b];
				a++;
				b++;
			}
		}
		return f;
	}
	public static int partition(int[]L) //Partition
	{
		int B = L[0];    
	    int T = 0;
	    int n = 0;
	    int x = L.length -1;

	    for(int i = 1; i < L.length; i++)
	    {
	        if( L[i] <= (B))
	        {
	            swap(L, i, B);           
	            n = i;
	        } 
	        else if(L[i] > (B) && x > i)
	        {
	            T = L[i];
	            L[i] = L[x];
	            L[x] = T;
	            x = 1;
	            i--;
	        }
	    }
	    
	    System.out.println(java.util.Arrays.toString(L));
	    System.out.println(n);
	    return n;
	}
	private static void swap (int [] L , int i , int b)
	{
		int t = L[i];
		L[i] = L[b];
		L[b] = t;
	}
}

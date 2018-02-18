import java.util.Arrays;

public class CODE 
{
	public static void main (String[] args)
	{
	String []L1 = {"apple" , "banana", "microsoft", "zorro" , "cucumuber" , "cake"};
	String [] L2 = {"cherry" , "mahogany" , "oreos" , "pinata"};
	int [] L3 = {3,2,4,65,23,145,66,234,1234,6,24,53};
	
	long start;
	long end;
	long time;
	
	//
	//Merge Test
	start = System.nanoTime();
	String[] mergeResult = mergeSort(L1);
	end = System.nanoTime();
	time = end - start;
	System.out.println("MergeSort test took: " + time + " nanoseconds");
	System.out.println(mergeResult);
	}
	//quickSort result
	start = System.nanoTime();
	quickSort (L3, 0, L3.length);
	end = System.nanoTime;
	time = end - start;
	System.out.println("QuickSort test took: " + time + " nanoseconds");
	System.out.println(L3);
	public static String[] mergeSort(String[]L1)
	{
		//Base code
		if(L1.length == 1)
		{
			return L1;
		}
		int a = (L1.length/2);
		String [] L = (String[]) Arrays.copyOfRange(L1, 0, a);
		String [] R = (String[]) Arrays.copyOfRange(L1, a, L1.length);
		
		return (merge(mergeSort(R) , mergeSort(L)));
	}
	public static String[] merge(String [] L1, String [] L2) 
	{
		String [] f = new String [(L1.length) + (L2.length)]; 
		int a = 0;
		int b = 0;
		int c = 0;
		while(a < L1.length && b < L2.length) 
		{
			if (L1[a].compareTo(L2[b]) <= 0)
			{
				f[c] = L1[a];
				a++;
			}				
			else if (L1[a].compareTo(L2[b]) > 0)
			{
				f[c] = L2[b];
				c++;
			}
		}
		while (a < L1.length)
		{
			f[c] = L1[a];
			a++;
			c++;
		}
		while (b < L2.length)
		{
			f[c] = L2[b];
			b++;
			c++;
		}
		return f;
	}
	public static int partition(int[]L) //Partition
	{
		int d = L[0];    
	    int e = 0;
	    int f = L.length -1;
	    while (f != e)
	    {
	    	while (e < f)
	    	{
	    		if(L[f] >= d)
	    		{
	    			f--;
	    		}
	    		
	    		else if (L[f] < e)
	    		{
	    			int s = L[e];
	    			L[e] = L[f];
	    			L[f] = s;
	    			
	    			int sp = f;
	    			f = e;
	    			e = sp;
	    			f++;
	    		}
	    	}
	    }
	    while (e > f)
	    {
	    	if (L[f] <= d)
	    	{
	    		f++;
	    	}
	    	else if (L[f] > d)
	    	{
	    		int s = L[e];
    			L[e] = L[f];
    			L[f] = s;
    			
    			int sp = f;
    			f = e;
    			e = sp;
    			f--;
	    	}
	    }
	    return e;
	}
	public static void quickSort(int[] L, int f, int b)
	{
		if (b > f)
		{
			int pIndex = partition(L, f, b);
			
			quickSort(L, f, pIndex);
			quickSort(L, pIndex + 1, b);
		}
	}
	public static int partition (int[] L, int f, int b)
	{
		int pi = L[f];
		int hp = b-1;
		for (int x = hp; x >= 1; x--)
		{
			if (L[x] > pi)
			{
				if (x != hp)
				{
					int sb = L[hp];
					L[hp] = L[x];
					L[x] = sb;
				}
				hp--;
			}
		}
		L[f] = L[hp];
		L[hp] = pi;
		return hp;
	}
}
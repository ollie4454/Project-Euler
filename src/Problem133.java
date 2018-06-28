
public class Problem133 {

	public static void main(String[] args)
	{
		long startTime;
		long endTime;
		
		startTime = System.nanoTime();
		
		long sum = 17;
		for(int i=10;i<100000;i++)
		{
			if(isPrime(i))
			{
				if(!check(division(i)))
				{
					sum+=i;
				}
			}
		}
		System.out.println(sum);
		
		endTime = System.nanoTime();
		System.out.println("time: " + (endTime-startTime)/1000000);
		
	}
	
	public static boolean isPrime(int x)
	{
		if(x%2==0)
			return false;
		for(int i=3;i<=Math.sqrt((double)x);i+=2)
		{
			if(x%i==0)return false;
		}
		return true;
	}
	
	public static int division(int prime)
	{
		int num =1;
		int count = 1;
		
		
		while(num != 0)
		{
			if(num >= prime)
			{
				num = num%prime;
			}else
			{
				num *= 10;
				num++;
				count++;
			}
		}
		
		return count;
		
	}
	
	public static boolean check(int x)
	{
		while(x%2==0) {
			x /= 2;
		}
		while(x%5==0) {
			x /= 5;
		}
		if(x==1)
		{
			return true;
		}
		return false;
	}

}

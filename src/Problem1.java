
public class Problem1 {

	public static void main(String[] args)
	{
		long startTime;
		long endTime;
		
		startTime = System.nanoTime();
		

		System.out.println((333)*(334)/2*3+(199)*(200)/2*5-(66)*(67)/2*(3*5));
		
		endTime = System.nanoTime();
		System.out.println("time: " + (endTime-startTime));
		
		startTime = System.nanoTime();
		
		int sum = 0;
		for(int i=0;i<1000;i++)
		{
			if(i%3==0 || i%5 ==0)
			{
				sum+=i;
			}
		}
		System.out.println(sum);
		
		endTime = System.nanoTime();
		System.out.println("time: " + (endTime-startTime));
		
		startTime = System.nanoTime();
		
		sum = 0;
		for(int i=0;i<1000;i+=3)
		{
			sum+=i;
		}
		for(int i=0;i<1000;i+=5)
		{
			sum+=i;
		}
		for(int i=0;i<1000;i+=15)
		{
			sum-=i;
		}
		System.out.println(sum);
		
		endTime = System.nanoTime();
		System.out.println("time: " + (endTime-startTime));
		
	}
}

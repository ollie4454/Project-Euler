import java.io.BufferedReader;
import java.io.FileReader;

public class Problem96 {

	public static void main(String[] args)
	{
		int[][] arr = read();
		
		boolean[] solid = new boolean[81];
		for(int i=0;i<81;i++)
		{
			if(arr[0][i]==0)
			{
				solid[i] = false;
			}else
			{
				solid[i] = true;
			}
		}
		
		System.out.println(test(arr[0]));
		
		boolean finished = false;
		while(!finished)
		{
			if(test(arr[0]))
			{
				boolean temp = true;
				for(int i=0;i<81;i++)
				{
					if(arr[0][i]==0)
						temp = false;
				}
				if(temp)
					finished = true;
			}else
			{
				
				int i=0;
				while(testCell(arr[0],i) || solid[i])
				{
					i++;
				}
				
				arr[0] = inc(arr[0],solid,i);
				
				
			}
			
		}
		
		for(int a=0;a<9;a++)
		{
			for(int b=0;b<9;b++)
			{
				System.out.print(arr[0][a*9+b] + " ");
			}
			System.out.println();
		}
		
	}
	
	public static boolean testCell(int[] arr,int i)
	{
		
		
		
		for(int a=0;a<9;a++)
		{
			if(arr[i]==arr[i%9+a] && i!=i%9+a)
			{
				return false;
			}
		}
		
		
		for(int a=0;a<9;a++)
		{
			if(arr[i]==arr[i/9+9*a] && i!=i/9+9*a)
			{
				return false;
			}
		}
		
		int x= (((i+1)/27)*27)-1+((i+1)%9/3)*3;
		
		if(x==-1 || x==2 || x==5)
		{
			x++;
		}
		
		for(int k=0;k<3;k++)
		{
			for(int m=0;m<3;m++)
			{
				if(arr[i]==arr[x+k+m*9] && i!=x+k+m*9)
				{
					return false;
				}
			}
		}

		
		return true;
	}
	

	
	public static int[] increase(int[] arr, boolean[] solid)
	{
		int i=0;
		boolean found = false;
		while(!found && i<81)
		{
			if(arr[i]==0)
			{
				found = true;
			}else
			{
				i++;
			}
		}
		found = false;
		while(!found && i!=80 && i!=0)
		{
			i--;
			if(solid[i]==false)
			{
				found = true;
			}
		}
		
		arr = inc(arr,solid,i);
		
		return arr;
	}
	
	public static int[] inc(int[] arr, boolean[] solid,int i)
	{
		
		if(i!=-1)
		{
		if(!solid[i])
		{
			arr[i]++;
			if(arr[i]==10)
			{
				arr[i]=1;
				if(i!=0)
				arr = inc(arr,solid,i-1);
			}
		}else
		{
			arr = inc(arr,solid,i-1);
		}
		}
		
		return arr;
	}
	
	public static boolean test(int[] arr)
	{
		int[] temp = new int[9];
		
		for(int i=0;i<81;i+=9)//rows
		{
			for(int j=0;j<9;j++)
			{
				temp[j] = arr[i+j];
			}
			if(!test9(temp))
			{
				return false;
			}
			
		}
		
		for(int i=0;i<9;i++)
		{
			for(int j=0;j<9;j++)
			{
				temp[j]= arr[i+9*j];
			}
			if(!test9(temp))
			{
				return false;
			}
		}
		
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				for(int k=0;k<3;k++)
				{
					for(int m=0;m<3;m++)
					{
						temp[k+3*m]=arr[i*27+j*3+k+m*9];
					}
				}
				if(!test9(temp))
				{
					return false;
				}
			}
		}
		
		
		
		return true;
	}
	
	public static boolean test9(int[] arr)
	{
		for(int i=0;i<9;i++)
		{
			for(int j=i+1;j<9;j++)
			{
				if(arr[i]==arr[j])
					return false;
			}
		}
		return true;
	}
	
	public static int[][] read()
	{
		int[][] arr = new int[50][81];
		
		try
		{
		    FileReader fileReader = new FileReader("p96.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            String line = bufferedReader.readLine();
            
            for(int i=0;i<50;i++)
            {
            	for(int j=0;j<9;j++)
            	{
            		line = bufferedReader.readLine();
            		for(int k=0;k<9;k++)
            		{
            			arr[i][j*9+k]=line.charAt(k)-'0';
            		}
            	}
            	bufferedReader.readLine();
            }
            
		}catch(Exception e)
		{
		    System.out.println(e.getMessage());	
		}
		
		return arr;
	}
}

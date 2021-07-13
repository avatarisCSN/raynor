package application;

public class process {
	String mass[][] = new String[3][3];
	public static String XorN(String txt)
	{
		String s= null;
		if (txt =="X")
		{
			  s ="winner X"; 
			
		}
		if (txt =="O")
		{
			  s ="winner O"; 
		}
	return s;	
	}
	
	public static String findWinner(String s[][])
	{ 
		String g = null;
	
		
		String mass[][] = new String[3][3];
		for (int i=0; i<3; i++)
    	{
    		for (int j=0; j<3; j++)
    		{
    			mass[i][j]=s[i][j];
    		}
    	}
		
	
	
	
	for (int i=0; i<3; i++)
	{
		
			 if (mass[i][0] == mass[i][1] && mass[i][1] ==mass[i][2])//верт линия
			 {
				 g = XorN(mass[i][0]);
			 }
			 if (mass[0][i] == mass[1][i] && mass[1][i] ==mass[2][i] )//horizont line
			 {
				 g= XorN(mass[0][i]);
			 }
			 
			
			 
		
	}
	
	 if (mass[0][0] == mass[1][1] && mass[1][1] ==mass[2][2] && mass[2][2] == "X")
	 {
		 g= XorN(mass[0][0]);
	 }
		 
		 if (mass[0][2] == mass[1][1] && mass[1][1] ==mass[2][0] && mass[2][0] == "X")
		 {
			g= XorN(mass[0][2]); 
		 }
		 return g;		 
	}

}


/********************************************
	Benz Huynh								
	This program is meant to create a 		
	password based on a given user name.	
********************************************/
import java.util.*;
public class Password 
{
	public static String main(String args) 
	{
		String user = args.trim();
		
		String password = "";

		//part 1: get all even characters, then all odd characters
		//"even characters" + "odd characters"
		int count = 1;
		boolean first = true;
		for(int x = 0; x < user.length(); x++)
		{
			if(x % 2 == 0 && count == 1)
			{
				if (first == true)
					password += user.substring(x, x + 1).toUpperCase();
				else
					password += user.substring(x, x + 1);
				first = false;
			}	
			else if(x % 2 != 0 && count == 2)
			{
				password += user.substring(x, x + 1);
			}
			if(x == user.length() - 1 && count == 1)
			{
				count++;
				x = 0;
			}
		}
		
		//part 2: create the special character
		//Special character ASCII value = "number of letters" + "number of numbers"
		int let = 0;
		int num = 0;
		for(int x = 0; x < user.length(); x++)
		{
			if("0123456789".indexOf(user.substring(x, x + 1)) == -1)
			{
				let++;
			}
			else
			{
				num++;
			}
		}
		int specNum = Integer.parseInt(let + "" + num);
		char spec = (char) specNum;
		while(" !\"#$%&\'()*+,-./:;<=>?@[\\]^_`{|}~".indexOf(spec) == -1)
		{
			specNum--;
			spec = (char) specNum;
			
		}
		password += spec;
		
		//part 3: final numbers at the end
		//"number of even letters" + "number of odd letters" + "number of numbers"
		int numEven = 0;
		int numOdd = 0;
		int numNum = 0;
		for(int x = 0; x < user.length(); x++)
		{
			if("0123456789".indexOf(user.substring(x, x + 1)) != -1)
			{
				numNum++;
			}
			else
			{
				if(x % 2 == 0)
				{
					numEven++;
				}
				else
				{
					numOdd++;
				}
			}
		}
		password += numEven + "" + numOdd + "" + numNum;
		
		return password;
		
	}//end main
}//end class

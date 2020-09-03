package com.sumit.springboot.restful.utility;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class UtilityClass {
	
	public static List<String> replace(List<String> strings)
	{
	    ListIterator<String> iterator = strings.listIterator();
	    while (iterator.hasNext())
	    {
	        iterator.set(iterator.next().toLowerCase());
	    }
		return strings;
	}
	 public static int wordcount(String string)  
     {  
       int count=0;  
   
         char ch[]= new char[string.length()];     
         for(int i=0;i<string.length();i++)  
         {  
             ch[i]= string.charAt(i);  
             if( ((i>0)&&(ch[i]!=' ')&&(ch[i-1]==' ')) || ((ch[0]!=' ')&&(i==0)) )  
                 count++;  
         }  
         return count;  
     }  
	 public static List timeToConvert(double t) {
		    double calcTime = t;
		    List<Integer> listTime= new ArrayList<Integer>();

		    int hours = (int)t / 60;
		    int minutes = (int)t % 60;
		    BigDecimal secondsPrecision = new BigDecimal((t - Math.floor(t)) * 100).setScale(2, RoundingMode.HALF_UP);
		    int seconds = secondsPrecision.intValue();

		    boolean nextDay = false;

		    if (seconds > 59) {
		        minutes++; //increment minutes by one
		        seconds = seconds - 60; //recalculate seconds
		    }

		    if (minutes > 59) {
		        hours++;
		        minutes = minutes - 60;
		    }

		    //next day
		    if (hours > 23) {
		        hours = hours - 24;
		        nextDay = true;
		    }

		    //if seconds >=10 use the same format as before else pad one zero before the seconds
		    final String myFormat = seconds >= 10 ? "%d:%02d:%d" : "%d:%02d:0%d";
		    final String time = String.format(myFormat, hours, minutes, seconds);
		    listTime.add(hours);
		    listTime.add(minutes);
		    listTime.add(seconds);
		    return listTime;
		  
		}
	 
}

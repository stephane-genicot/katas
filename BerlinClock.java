package com.bnpp.kata;

import java.time.LocalTime;

public class BerlinClock {
	
	public String illuminationSeries (LocalTime localTime) {
		int hour = localTime.getHour();
		int minutes = localTime.getMinute();
		int seconds = localTime.getSecond();
		
		StringBuilder sb = new StringBuilder();
		
		if(seconds!=0 && seconds%2==0)
			sb.append("Y\n");
		else
			sb.append("N\n");
		
		appendColors(hour, '/', "RED ", 4, sb);	
		appendColors(hour, '%', "RED ", 4, sb);	
		
		for(int i=1; i<= 11; i++) {
			if(i<=minutes/5)
				sb.append(i%3==0? "RED " : "YELLOW ");
			else
				sb.append("EMPTY ");
		}
		
		sb.append("\n");
		appendColors(minutes, '%', "YELLOW ", 4, sb);	
		
		System.out.println(sb);
		return sb.toString();
	}

	private void appendColors(int timeValuePassed, char operator, String light, int rowLength, StringBuilder sb) {
		switch(operator) {
			case '/':
				for(int i=1; i<= rowLength; i++) {
					sb.append(i<=timeValuePassed/5 ? light : "EMPTY ");
				}
			break;
			case '%':
				for(int i=1; i<= rowLength; i++) {
					sb.append(i<=timeValuePassed%5 ? light : "EMPTY ");
				}
			break;
		}
		sb.append("\n");
			
	}

}

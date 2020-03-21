package gameHandler;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;

public class IdManager {
	/**
	 * Metodo Random
	 * */
	private int Random(int n) {
		Random rand = new Random();
		if (n!=0) {
			return rand.nextInt(n);
		}
		return 0;
		    
	}
	/**
	 * Obtiene un Codigo identificador unico 
	 * */
	public String UniqueId() {
		String id = "";
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		// el codigo es una conbinacion de de los valores de la fecha actual 
		id = String.format("%s%s%s%s%s%s%s", 
				(date.getYear() - 2000),
				time.getHour(),
				GetMonth(date.getMonthValue()),
				time.getMinute(),
				date.getDayOfYear(),
				(char)(Random(26) + 'a'),
				time.getSecond()				
				);        
		return id;
	}
	/**
	 * Agina una letra que represente el mes
	 * */
	private char GetMonth(int month) {
		switch(month) {
		case 1: return 'e';
		case 2: return 'f';
		case 3: return 'm';
		case 4: return 'a';
		case 5: return 'y';
		case 6: return 'j';
		case 7: return 'l';
		case 8: return 'g';
		case 9: return 's';
		case 10: return 'o';
		case 11: return 'n';
		default: return 'd';
		}
	}	
}

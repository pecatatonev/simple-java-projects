package date;

public class Main {

	public static void main(String[] args){
		Date date = new Date(15, "септември", 2003);
    	Date otherDate = new Date(15, "Септември", 2002);
    	Date unvalidDate = new Date(32, "декември", 2023);
    	
    	System.out.println(date.isDateValid()); // true
    	System.out.println(otherDate.isDateValid()); //true
    	System.out.println(unvalidDate.isDateValid()); //false
    	
    	try {
			System.out.println(Date.compareDates(date,otherDate)); // 1 От дясно е предшестваща
			System.out.println(Date.compareDates(otherDate,date)); // -1 Тази от ляво е предшестваща
	    	//System.out.println(Date.compareDates(otherDate,unvalidDate)); // 2 грешна дата
	    	//System.out.println(Date.compareDates(unvalidDate, date)); // 2 грешна дата
	    	
	    	System.out.println(date.getDaysBetweenDates(otherDate)); // 365
	    	//System.out.println(otherDate.getDaysBetweenDates(unvalidDate)); // 2 Има грешна дата
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} 
    	
    	
    	
	}

}

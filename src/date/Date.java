package date;

public class Date {
	public int day;

    public String month;

    public int year;
    
    private String[] validMonths = {"януари", "февруари", "март", "април", "май", "юни", "юли", "август", "септември", "октомври", "ноември", "декември"};
    
    public Date(int day, String month, int year) {
    	this.day = day;
    	this.month = month;
    	this.year = year;
    }
    
    public boolean isDateValid() {
        if (year < 0 || day < 1 || day > 31 || !isValidMonth(month, validMonths)) {
            return false;
        }
        return true;
    }

    private boolean isValidMonth(String month, String[] validMonths) {
    	month = month.toLowerCase();
        for (String valid : validMonths) {
            if (month.equals(valid)) {
                return true;
            }
        }
        return false;
    }
    
    public static int compareDates(Date date1, Date date2) throws Exception {
    	if(!date1.isDateValid() || !date2.isDateValid()) {
    	 throw new Exception("Грешна дата");
    	}
        if (date1.year < date2.year) {
            return -1;
        } else if (date1.year > date2.year) {
            return 1; 
        } else {
            
            int thisMonth = getMonthValue(date1.month);
            int otherMonth = getMonthValue(date2.month);
            
            if (thisMonth < otherMonth) {
                return -1; 
            } else if (thisMonth > otherMonth) {
                return 1;
            } else {
                
                if (date1.day < date2.day) {
                    return -1; //Когато върнем -1 тази дата е предшестваща
                } else if (date1.day > date2.day) {
                    return 1; // Когато върнем 1 другадата дата е предшестваща
                } else {
                    return 0; // Датите съвпадат
                }
            }
        }
    }

    private static int getMonthValue(String month) {
        String[] validMonths = {"януари", "февруари", "март", "април", "май", "юни", "юли", "август", "септември", "октомври", "ноември", "декември"};
        for (int i = 0; i < validMonths.length; i++) {
            if (month.equalsIgnoreCase(validMonths[i])) {
                return i + 1; 
            }
        }
        return -1;
    }
    
    private boolean isLeapYear() {
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            return true; 
        } else {
            return false; 
        }
    }
    
    private int getDaysInYear(int year) {
        if (isLeapYear()) {
            return 366;
        } else {
            return 365; 
        }
    }

    private int getDaysInMonth() {
        String[] monthsWith31Days = {"януари", "март", "май", "юли", "август", "октомври", "декември"};
        if (isValidMonth(month, validMonths)) {
            if (month.equals("февруари")) {
                if (isLeapYear()) {
                    return 29;
                } else {
                    return 28; 
                }
            } else if (contains(monthsWith31Days, month)) {
                return 31;
            } else {
                return 30;
            }
        }
        return -1; // Невалиден месец
    }
    

    private boolean contains(String[] array, String value) {
        for (String item : array) {
            if (item.equals(value)) {
                return true;
            }
        }
        return false;
    }
    
    public int getDaysBetweenDates(Date otherDate) throws Exception {
        int daysBetween = 0;
        
        if (compareDates(this, otherDate) == 0) {
            return daysBetween;
        }
        
        Date startDate = this;
        Date endDate = otherDate;
        
        if (compareDates(this, otherDate) > 0) {
            startDate = otherDate;
            endDate = this;
        }
        
        while (compareDates(startDate, endDate) < 0) {
            daysBetween++;
            startDate.day++;
            
            if (startDate.day > startDate.getDaysInMonth()) {
                startDate.day = 1;
                startDate.month = validMonths[(getMonthValue(startDate.month) % 12)];
                
                if (compareDates(startDate,endDate) == 0) {
                    break;
                }
                
                if (getMonthValue(startDate.month) == 1) {
                    startDate.year++;
                }
            }
        }
        
        return daysBetween;
    }
    
}

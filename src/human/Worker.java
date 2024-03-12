package human;

public class Worker extends Human {
    private int workingHours;

	public Worker(String firstName, String lastName) {
        super(firstName, lastName);
        this.workingHours = 8;
    }

	@Override
	int calculateDailyWage() {
		return this.workingHours * 5;// 5лв на час
	}
}


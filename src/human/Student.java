package human;

public class Student extends Human {
    private int facultyNumber;
	private int workingHours;

    public Student(String firstName, String lastName, int facultyNumber) {
        super(firstName, lastName);
        this.facultyNumber = facultyNumber;
        this.workingHours = 4;
    }

    public int getFacultyNumber() {
        return facultyNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Student student = (Student) obj;
        return this.facultyNumber == student.facultyNumber;
    }

	@Override
	int calculateDailyWage() {
		return this.workingHours * 5; // 5 лв на час
	}
}

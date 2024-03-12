package human;

public class Main {

	public static void main(String[] args) {
		 Student student1 = new Student("Иван", "Петров", 12345);
	        Student student2 = new Student("Петър", "Иванов", 67890);

	        Worker worker1 = new Worker("Георги", "Стоянов");
	        Worker worker2 = new Worker("Анна", "Иванова");

	        if (student1.equals(worker1)) {
	            System.out.println("Студент 1 и студент 2 са еднакви.");
	        } else {
	            System.out.println("Студент 1 и студент 2 не са еднакви.");
	        }
	}

}

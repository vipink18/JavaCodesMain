package DayOne;

class DerivedException extends RuntimeException {
	void printMsg(){
		try {
			System.out.println(1/0); // st
		}
		catch (ArithmeticException e) {
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

public class ExceptionExample2 extends DerivedException{
	public static void main(String[] args) {
		ExceptionExample2 example2 = new ExceptionExample2();
		example2.printMsg();
	}
	
}

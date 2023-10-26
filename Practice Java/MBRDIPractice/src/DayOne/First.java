package DayOne;

public class First extends Demo {

	public static void main(String[] args) {
		System.out.println("Hello Java");
		int a =5;
		int b=0;
		try {
			System.out.println("in try blocks");
			int c = a/b;
			System.out.println(c);
		}
		catch(NumberFormatException ex) {
			System.out.println(ex.getMessage());
		}
		catch( ArithmeticException arithmeticException) {
			//arithmeticException.fillInStackTrace();
			arithmeticException.printStackTrace();  /// by zero
			System.out.println(arithmeticException.getMessage());
			//arithmeticException.getStackTrace();
			System.out.println(arithmeticException.toString());
		}
		
	}
}

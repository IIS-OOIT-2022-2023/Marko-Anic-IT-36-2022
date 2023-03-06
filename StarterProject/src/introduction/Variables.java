package introduction;

public class Variables {

	public static void main(String[] args) {
		// Deklaracija promenljive
		double firstNumber;
		// Inicijalizacija promenljive (dodela vrednosti)
		firstNumber = 1;
		
		double secondNumber  = 5;
		
		double doubleResult = (firstNumber/secondNumber);
		System.out.println(doubleResult);
		
		int result = (int) (firstNumber/secondNumber);
		System.out.println(result);
		
		boolean alwaysTrue = true;
		boolean alwaysFalse = false;
		//Logicki operatori
		// Konjukcija AND
		System.out.println(alwaysTrue && alwaysFalse); //false
		//Disjunkcija OR
		System.out.println(alwaysTrue || alwaysFalse); //true
		// Negacija
		System.out.println(!alwaysTrue);// false
		
		//Konkatenacija (spajanje) stringova
		String name ="Ratkoslava";
		String lastName = "Petrovic";
		System.out.println(name +" "+ lastName + " Njegos");
		
		//zadatak 2 faktorijel
		int x =5;
		int p=1;
		for(int i = 1 ; i <= x;i++)
			p*=i;
		System.out.println(p);
		
		//zadatak 3 neparni 
		for(int i =1;i<10;i++)
			if(i %2 == 1)
				System.out.print(i + " ");
	}

}

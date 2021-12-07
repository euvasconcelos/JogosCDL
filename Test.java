
public class Test 
{	
	public static void imprimirForca(int tentativas) 
  {

		System.out.println("||############");
		System.out.println("||           *");
		System.out.println("||           *");
		System.out.println("||           -");
		System.out.printf("||           %s\n", tentativas==7?"O":" ");
		System.out.printf("||          /%s\\\n",tentativas<7?"|":" ");
		System.out.printf("||           V \n");
		System.out.printf("||          / \\\n");
		System.out.println("||              ");
		System.out.println("||              ");
		System.out.println("||              ");

	}
	
	public static void main(String[] arg)
  {
		imprimirForca(7);
		imprimirForca(6);
		
	}
}

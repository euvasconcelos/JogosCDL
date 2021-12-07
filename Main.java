import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	
	static void menu() 
  {
		Scanner input = new Scanner(System.in);
		while (true) 
    {
			try 
      {
				System.out.println("        BEM VINDOS - JOGOS QUASE MORTAIS                 ");
				System.out.println("        J O G O S              ");
				System.out.println("1 - FORCA");
				System.out.println("2 - JOGO DA VELHA");
				System.out.println("3 - JOKENPO");
				System.out.println("4 - SAIR");
				System.out.println("--------------------------------------------------------");
        System.out.print("SUA OPCAO: ");

				int opcao = input.nextInt();

				if (opcao == 1)
        {
					new Forca().jogar();
				} 
        else if (opcao == 2) 
        {
					new JogoVelha().jogar();
				} 
        else if (opcao == 3) 
        {
					new JoKenPo().jogar();
				} 
        else if (opcao == 4) 
        {
					break;
				} 
        else 
        {
					System.out.print("OPCAO INCORRETA");
				}
				
			} 
      catch (InputMismatchException e) 
      {
				input.next();// clear buffe
				System.out.print("OPCAO INCORRETA");
			}
			
		}

	}

	public static void main(String[] args) 
  {
		menu();

	}

}

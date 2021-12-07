import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class JoKenPo 
{

	static int HUMANO = 1;
	static int COMPUTADOR = 2;
	static int EMPATE = 3;

	public void jogar() 
  {
		Scanner input = new Scanner(System.in);
		int QuantRodadas;

		while (true) 
    {
			try 
      {
				System.out.print("NUMERO DE JOGADAS: ");
				QuantRodadas = input.nextInt();

				if (QuantRodadas > 0) 
        {
					break;
				} 
        else 
        {
					System.out.println("NUMERO INVALIDO");
				}
			} 
      catch (InputMismatchException ex) 
      {
				input.next();
			}
		}

		int PontosHumano = 0;
		int PontosPC = 0;

		for (int i = 0; i < QuantRodadas; i++) 
    {
			// jogada do player
			Jogada jodadaHumano = this.jogadaDoHumano();
			
			// Jogada do computador
			Jogada jogadaComputador = this.jogadaDoComputador();

			// resultado da rodada
			int ganhador = this.quemGanhou(jodadaHumano, jogadaComputador);

			System.out.println("VEZ DO COMPUTADOR: " + this.jogadadaAsString(jogadaComputador));

			if (ganhador == HUMANO) 
      {
				System.out.println("GANHOU, PODE COMEMORAR ...");
				PontosHumano += 1;
			} 
      else if (ganhador == COMPUTADOR) 
      {
				PontosPC += 1;
				System.out.println("FUEN FUEN FUEN, PERDEU");
			} 
      else 
      {
				System.out.println("EMPATE COM GOSTO DE DERROTA");
			}

		}
		System.out.println();
		
    if (PontosHumano > PontosPC) 
    {
			System.out.println("CARAIO, VOCE E O BIXAO MERMO  !");
		} 
    else if (PontosPC > PontosHumano) 
    {
			System.out.println("PERDEU TUDO ! ");
		} 
    else 
    {
			System.out.println("EMPATOU :X");
		}

	}

	Jogada jogadaDoHumano() 
  {
		Scanner input = new Scanner(System.in);
		while (true) 
    {
			System.out.println("1 - PEDRA");
			System.out.println("2 - PAPEL");
			System.out.println("3 - TESOURA");
			System.out.print("\n SUA JOGADA: ");
			int valor = input.nextInt();
		
    	if (valor >= 1 && valor <= 3) 
      {
				if (valor == 1) 
        {
					return Jogada.PEDRA;
				} 
        else if (valor == 2) 
        {
					return Jogada.PAPEL;
				} 
        else 
        {
					return Jogada.TESOURA;
				}

			} 
      else 
      {
				System.out.println("OPCAO ERRADA ! ");
			}

		}

	}

	Jogada jogadaDoComputador() 
  {
		Random random = new Random();
	
  	int min = 1, max = 3;
		int valor = random.nextInt(max + min) + min;
	
  	if (valor == 1) 
    {
			return Jogada.PEDRA;
		} 
    else if (valor == 2) 
    {
			return Jogada.PAPEL;
		} 
    else 
    {
			return Jogada.TESOURA;
		}

	}

	String jogadadaAsString(Jogada jogada) 
  {
		switch (jogada) 
    {
		case PAPEL:
			return "PAPEL";
		case PEDRA:
			return "PEDRA";
		case TESOURA:
			return "TESOURA";
		default:
			return "";

		}
	}

	int quemGanhou(Jogada humano, Jogada computador) 
  {
		if ((humano == Jogada.PAPEL && computador == Jogada.PEDRA) || (humano == Jogada.TESOURA && computador == Jogada.PAPEL) || (humano == Jogada.PEDRA && computador == Jogada.TESOURA)) 
    {
			return HUMANO;
		} 
    else if ((computador == Jogada.PAPEL && humano == Jogada.PEDRA) || (computador == Jogada.TESOURA && humano == Jogada.PAPEL) || (computador == Jogada.PEDRA && humano == Jogada.TESOURA)) 
    {
			return COMPUTADOR;
		} 
    else 
    {
			return EMPATE;
		}

	}

}

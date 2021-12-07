import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Forca {

	private int tentativasRestantes;
	private String[] palavraSecreta;
	private String[] palavraIncompleta;
	private ArrayList<Character> letrasEscolhidas;

	private String[] palavras = { "CARRO", "BORBOLETA", "ABACATE", "ELEFANTE", };

	private String[] obterPalavrasSecreta() 
  {
		Random random = new Random();
		int min = 0, max = palavras.length - 1;
		int index = random.nextInt(max + min) + min;
		return palavras[index].toUpperCase().split("");
	}

	void imprimirForca() 
  {
		System.out.println("||============");
		System.out.println("||           |");
		System.out.println("||           |");
		System.out.println("||           -");

		if (tentativasRestantes == 7) 
    {
			System.out.println("||");
			System.out.println("||");
			System.out.println("||");
			System.out.println("||");
		} 
    else if (tentativasRestantes == 6) 
    {
			System.out.println("||           O");
			System.out.println("||");
			System.out.println("||");
			System.out.println("||");
		} 
    else if (tentativasRestantes == 5) 
    {
			System.out.println("||           O");
			System.out.println("||           |");
			System.out.println("||");
			System.out.println("||");
		} 
    else if (tentativasRestantes == 4) 
    {
			System.out.println("||           O");
			System.out.println("||          /|");
			System.out.println("||             ");
			System.out.println("||             ");
		} 
    else if (tentativasRestantes == 3) 
    {
			System.out.println("||           O");
			System.out.println("||          /|\\");
			System.out.println("||             ");
			System.out.println("||             ");
		} 
    else if (tentativasRestantes == 2) 
    {
			System.out.println("||           O");
			System.out.println("||          /|\\");
			System.out.println("||           V ");
			System.out.println("||            ");
		} 
    else if (tentativasRestantes == 1) 
    {
			System.out.println("||           O");
			System.out.println("||          /|\\");
			System.out.println("||           V ");
			System.out.println("||          /");
		} 
    else if (tentativasRestantes == 0) 
    {
			System.out.println("||           O");
			System.out.println("||          /|\\");
			System.out.println("||           V ");
			System.out.println("||          / \\");

		}

		System.out.println("||");
		System.out.println("||");
		System.out.println("||");
	}

	void imprimiPalavra() 
  {
		for (int i = 0; i < this.palavraIncompleta.length; i++) 
    {
			if (this.palavraIncompleta[i] == null) 
      {
				System.out.print(" _ ");
			} 
      else 
      {
				System.out.print(" " + this.palavraIncompleta[i] + " ");
			}
		}
		System.out.println();

	}

	void jogar() 
  {
		this.palavraSecreta = this.obterPalavrasSecreta();
		this.palavraIncompleta = new String[this.palavraSecreta.length];
		this.tentativasRestantes = 7;
		this.letrasEscolhidas = new ArrayList<>();

		imprimirForca();
		imprimiPalavra();
		Scanner scanner = new Scanner(System.in);

		while (this.temTentativas() && !this.palavraPreenchida()) {
			char letra;
			while (true) 
      {
        System.out.print("DIGITE UMA LETRA: ");
				letra = scanner.next().toUpperCase().charAt(0);

				if (this.letraJaEscolhida(letra)) 
        {
					System.out.println("DE NOVO? ESSA JA FOI, TENTA OUTRA ");
				} 
        else 
        {
					this.letrasEscolhidas.add(letra);
					this.jogarTentativa(letra);
					break;
				}
			}

		}
		if (this.palavraPreenchida()) 
    {
			System.out.println("ACERTOU, MIZERAVI !");
		} 
    else 
    {
			System.out.println("PERDEU, DOIDIM ");
		}
		System.out.println();
	}

	boolean temTentativas() 
  {
		return this.tentativasRestantes != 0;
	}

	boolean palavraPreenchida() 
  {
		for (int i = 0; i < palavraIncompleta.length; i++) 
    {
			if (this.palavraIncompleta[i] == null) 
      {
				return false;
			}
		}
		return true;
	}

	void jogarTentativa(char letra) 
  {
		boolean temLetra = false;
		for (int i = 0; i < palavraSecreta.length; i++) 
    {
			if (Character.toString(letra).equals(palavraSecreta[i])) 
      {
				this.palavraIncompleta[i] = Character.toString(letra);
				temLetra = true;

			}

		}
		
    if (!temLetra) 
    {
			this.tentativasRestantes -= 1;
		}
		imprimirForca();
		imprimiPalavra();

	}

	boolean letraJaEscolhida(char letra) 
  {
		return this.letrasEscolhidas.indexOf(letra) != -1;
	}
}

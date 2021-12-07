import java.util.ArrayList;
import java.util.Scanner;

public class JogoVelha 
{

	ArrayList<Integer> posicaoJogadas;

	String[][] tabuleiro = { { " ", " ", " " }, { " ", " ", " " }, { " ", " ", " " }};

	void imprimirTabuleiro() 
  {
		System.out.println("     |     |     ");
		System.out.printf("  %s  |  %s  |  %s  \n", tabuleiro[0][0], tabuleiro[0][1], tabuleiro[0][2]);
		System.out.println("_____|_____|_____");
		System.out.println("     |     |     ");
		System.out.printf("  %s  |  %s  |  %s  \n", tabuleiro[1][0], tabuleiro[1][1], tabuleiro[1][2]);
		System.out.println("_____|_____|_____");
		System.out.println("     |     |     ");
		System.out.printf("  %s  |  %s  |  %s  \n", tabuleiro[2][0], tabuleiro[2][1], tabuleiro[2][2]);
		System.out.println("     |     |     ");
	}

	void jogar() 
  {
		imprimirTabuleiro();
		int rodada = 1;
		this.posicaoJogadas = new ArrayList<>();
		System.out.println("JOGADOR 1 SUA VEZ  ( X )");

		while (true)
     {
			if (this.tabuleiroPreenchido()) 
      {
				System.out.println("DEU VELHA");
				break;
			}
			// jogador da rodada
			String jogador = rodada % 2 != 0 ? "X" : "O";

			// jogada do jogador
			this.jogadaDo(jogador);

			if (this.jogadorGanhou(jogador)) 
      {
				System.out.println("JOGADOR " + jogador + " GANHOU");
				System.out.println();
				break;
			}

			rodada++;

			if(rodada % 2 != 0 )
      {
				System.out.println("VEZ DO JOGADOR 1 | X |");
			}
      else 
      {
				System.out.println("VEZ DO JOGADOR 2 | O |");
			}
			
		}

	}

	void jogadaDo(String  jogador) 
  {
		while (true) 
    {
			int posicao = this.obterPosicao();

			if (this.posicaoJogadas.indexOf(posicao) == -1)
       {
				this.posicaoJogadas.add(posicao);
				this.preenchePosicao(posicao, jogador);
				break;
			 } 
      else 
      {
				System.out.println("POSICAO "+posicao+" PREENCHIDA");
			}

		}
		this.imprimirTabuleiro();

	}

	private void preenchePosicao(int posicao, String jogador) 
  {
		if (posicao == 1) 
    {
			this.tabuleiro[0][0] = jogador;
		} 
    else if (posicao == 2) 
    {
			this.tabuleiro[0][1] = jogador;
		} 
    else if (posicao == 3) 
    {
			this.tabuleiro[0][2] = jogador;
		} 
    else if (posicao == 4) 
    {
			this.tabuleiro[1][0] = jogador;
		} 
    else if (posicao == 5) 
    {
			this.tabuleiro[1][1] = jogador;
		} 
    else if (posicao == 6) 
    {
			this.tabuleiro[1][2] = jogador;
		} 
    else if (posicao == 7) 
    {
			this.tabuleiro[2][0] = jogador;
		} 
    else if (posicao == 4) 
    {
			this.tabuleiro[2][1] = jogador;
		} 
    else 
    {
			this.tabuleiro[2][2] = jogador;
		}
	}

	int obterPosicao() {
		Scanner input = new Scanner(System.in);
		int x;
		while (true) {
			try {
				System.out.print("ESCOLHA A POSICAO: ");
				x = input.nextInt();
				if (x >= 1 && x <= 9) {
					return x;
				}else {
					System.out.println("POSICAO ERRADA");
				}

			} catch (Exception e) {
				input.next();// clear buffer
			}
		}
	}

	boolean tabuleiroPreenchido() 
  {
		for (int i = 0; i < 3; i++) 
    {
			for (int j = 0; j < 3; j++) 
      {
				if (tabuleiro[i][j] == " ") 
        {
					return false;
				}
			}
		}
		return true;
	}

	boolean jogadorGanhou(String jogador) 
  {

		// [0, 0], [0, 1], [0, 2]
		// [1, 0], [1, 1], [1, 2]
		// [2, 0], [2, 1], [2, 2]

		// linhas e coluna
		for (int i = 0; i < 3; i++) 
    {
			// linha
			if (tabuleiro[i][0] == jogador && tabuleiro[i][1] == jogador && tabuleiro[i][2] == jogador) 
      {
				return true;
			}
			// coluna
			if (tabuleiro[0][i] == jogador && tabuleiro[1][i] == jogador && tabuleiro[2][i] == jogador) 
      {
				return true;
			}
		}
		// diagonais
		if ((tabuleiro[0][0] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][2] == jogador) || (tabuleiro[0][2] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][0] == jogador)) 
    {
			return true;
		}

		return false;
	}

}

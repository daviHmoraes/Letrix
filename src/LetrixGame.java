import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LetrixGame {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Processador processador = new Processador();

		List<String> dicionario = carregarPalavras("dicionario.txt");
		List<String> palavrasSecretas = carregarPalavras("dicionario.txt");
		ArrayList<String> letrasNaoUsadas = new ArrayList<>();
		
        Collections.addAll(letrasNaoUsadas,
                "A","B","C","D","E","F","G","H","I","J","K","L","M",
                "N","O","P","Q","R","S","T","U","V","W","X","Y","Z"
            );
		
		String palavraSecreta = "CASAS";
		
		if(!palavrasSecretas.isEmpty()) { 
			Random random = new Random();
			palavraSecreta = palavrasSecretas.get(random.nextInt(palavrasSecretas.size()));
		}
		
		String admMasterSilvaJr = "ADMIN123";
		String tentativa;
		boolean venceu = false; // Variavel de vitoria

		System.out.println("+---------------+");
		System.out.println("|    Letrix     |");
		System.out.println("+---------------+");
		System.out.println("|    Insira     |");
		System.out.println("|      1        |");
		System.out.println("|  Para ver as  |");
		System.out.println("|  letras não   |");
		System.out.println("|    usadas     |");
		System.out.print("+---------------+");

		for (int i = 1; i <= 6; i++) {
			System.out.print("\nEscreva uma palavra com 5 letras(Restam " + (6-i) + " tentativas): ");
			tentativa = input.nextLine().toUpperCase();
			
			if (tentativa.equals("1")) {
				
				System.out.println("\n +--Letras--+");
				
				for (String letra : letrasNaoUsadas) {
					System.out.print(letra + ", ");
				}
				
				System.out.println("\n+----Fim----+");
				
			}
			
			
			if (tentativa.equals(admMasterSilvaJr)) {
				System.out.println("+------------------------+");
				System.out.println("| 🥶 Modo adm ativado 🥵  |");
				System.out.println("+------------------------+");
				System.out.println("|  A resposta é : " + palavraSecreta + "  |");
				System.out.println("+------------------------+");
			}
			
			while (tentativa.length() != 5) {
				System.out.println("A palavra deve conter exatamente 5 letras!");
				System.out.print("Escreva uma palavra com 5 letras(Restam " + (6-i) + " tentativas): ");
				tentativa = input.nextLine().toUpperCase();
				
				if (tentativa.equals("1")) {
					
					System.out.println("\n +--Letras--+");
					
					for (String letra : letrasNaoUsadas) {
						System.out.print(letra + ", ");
					}
					
					System.out.println("\n+----Fim----+");
					
				}
				
				if (tentativa.equals(admMasterSilvaJr)) {
					System.out.println("+------------------------+");
					System.out.println("| 🥶 Modo adm ativado 🥵  |");
					System.out.println("+------------------------+");
					System.out.println("|  A resposta é : " + palavraSecreta + "  |");
					System.out.println("+------------------------+");
				}
				
			}		
			
			while(!dicionario.contains(tentativa)) {
				System.out.println("Essa palavra não está no dicionário!");
				System.out.print("Escreva uma palavra com 5 letras(Restam " + (6-i) + " tentativas): ");
				tentativa = input.nextLine().toUpperCase();
				
				if (tentativa.equals("1")) {
					
					System.out.println("\n +--Letras--+");
					
					for (String letra : letrasNaoUsadas) {
						System.out.print(letra + ", ");
					}
					
					System.out.println("\n+----Fim----+");
					
				}
				
				if (tentativa.equals(admMasterSilvaJr)) {
					System.out.println("+------------------------+");
					System.out.println("| 🥶 Modo adm ativado 🥵  |");
					System.out.println("+------------------------+");
					System.out.println("|  A resposta é : " + palavraSecreta + "  |");
					System.out.println("+------------------------+");
				}
				

				while (tentativa.length() != 5) {
					System.out.println("A palavra deve conter exatamente 5 letras!");
					System.out.print("Escreva uma palavra com 5 letras(Restam " + (6-i) + " tentativas): ");
					tentativa = input.nextLine().toUpperCase();
					
					if (tentativa.equals("1")) {
						
						System.out.println("\n +--Letras--+");
						
						for (String letra : letrasNaoUsadas) {
							System.out.print(letra + ", ");
						}
						
						System.out.println("\n+----Fim----+");
						
					}
					
					if (tentativa.equals(admMasterSilvaJr)) {
						System.out.println("+------------------------+");
						System.out.println("| 🥶 Modo adm ativado 🥵  |");
						System.out.println("+------------------------+");
						System.out.println("|  A resposta é : " + palavraSecreta + "  |");
						System.out.println("+------------------------+");
					}
					
				}		
			}

			if (tentativa.equals(admMasterSilvaJr)) {
				System.out.println("+------------------------+");
				System.out.println("| 🥶 Modo adm ativado 🥵  |");
				System.out.println("+------------------------+");
				System.out.println("|  A resposta é : " + palavraSecreta + "  |");
				System.out.println("+------------------------+");
			}
			
			if (tentativa.equals("1")) {
				
				System.out.println("\n +--Letras--+");
				
				for (String letra : letrasNaoUsadas) {
					System.out.print(letra + ", ");
				}
				
				System.out.println("\n+----Fim----+");
				
			}
			
			processador.verificarPalpite(tentativa, palavraSecreta, letrasNaoUsadas);

			if (tentativa.equals(palavraSecreta)) {
				venceu = true;
				break;
			} // Checa resposta certa e sai do for

		}

		if (venceu == true) {
			System.out.println("\nParabens! Voce venceu!");
		} else {
			System.out.println("\nDerrota =(, a palavra era: " + palavraSecreta);
		}

		input.close();
	}


	// Método para carregar palavras de um arquivo TXT
	private static List<String> carregarPalavras(String nomeArquivo) {
		List<String> palavras = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
			String linha;
			while ((linha = br.readLine()) != null) {
				linha = linha.trim().toUpperCase();
				if (linha.length() == 5) { // Apenas palavras de 5 letras
					palavras.add(linha);
				}
			}
		} catch (IOException e) {
			System.out.println("Erro ao carregar o arquivo " + nomeArquivo + ": " + e.getMessage());
			// Se erro, retorna lista vazia
		}
		return palavras;
	}
}

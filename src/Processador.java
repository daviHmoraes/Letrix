public class Processador {

	// Reset
	public static final String RESET = "\u001B[0m";

	// Cores de texto
	public static final String VERMELHO = "\u001B[31m";
	public static final String VERDE = "\u001B[32m";
	public static final String AMARELO = "\u001B[33m";
	public static final String AZUL = "\u001B[34m";
	public static final String CINZA = "\u001B[37m"; 
	
	public void verificarPalpite(String tentativa, String palavraSecreta) {
		
		for(int i = 0; i < tentativa.length(); i++) {

			if (tentativa.charAt(i) == palavraSecreta.charAt(i)) {
				System.out.print(VERDE + tentativa.charAt(i) + RESET);
			} else if (achouEmOutraPosicao(tentativa, palavraSecreta, tentativa.charAt(i)) == true) {
					System.out.print(AMARELO + tentativa.charAt(i) + RESET);
			} else {
				System.out.print(CINZA + tentativa.charAt(i) + RESET);
			}
			
		}
		
	}
	
	private boolean achouEmOutraPosicao(String tentativa, String palavraSecreta, char letraTentativa) {
		
		for (int i = 0; i < palavraSecreta.length(); i++) {
			if (letraTentativa == palavraSecreta.charAt(i)) {
			return true;
			}
		}
		
		return false;
	}
	
}

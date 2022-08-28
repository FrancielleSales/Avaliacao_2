import java.util.Scanner;

public class LeitorEmoticons {
	public static void main(String[] args) {
		
		int contaFeliz = 0, contaTriste = 0;
		
		// Inicializando o scanner
		Scanner scanner = new Scanner(System.in);
		
		// Pede e recebe a frase a ser conferida
		System.out.print("Digite a frase que voce deseja conferir o sentimento expresso: ");
		String str = scanner.nextLine();
		scanner.close();
		
		// Verifica os caracteres da frase digitada	
		for(int i = 0; i < (str.length() - 2); i++) {
			if (str.charAt(i) == ':' && str.charAt(i+1) == '-') {
				if (str.charAt(i + 2) == ')') {
					contaFeliz++;
				} else if (str.charAt(i + 2) == '(') {
					contaTriste++;
				}				
			}
		}
		
		// Verifica o sentimento da frase digitada
		if (contaFeliz > contaTriste) {
			System.out.println("Saida: divertido");
		} else if (contaFeliz < contaTriste) {
			System.out.println("Saida: chateado");
		} else {
			System.out.println("Saida: neutro");
		}
	}

}

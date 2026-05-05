import java.util.Scanner;

class Insumo {
    private String nome;
    private int quantidade;
    private int mesValidade;

    public Insumo(int quantidade, int mesValidade) {
        this.nome = "Amendoim";
        this.quantidade = quantidade;
        this.mesValidade = mesValidade;
    }

    public boolean estaValido(int mesAtual) {
        if (this.mesValidade < mesAtual) {
            System.out.println("ALERTA: Risco de Amendoim Murcho! Produto Vencido");
            return false;
        }
        return true;
    }

    public void exibirInfo() {
        System.out.println("\n--- Dados do Insumo ---");
        System.out.println("Nome: " + this.nome);
        System.out.println("Quantidade: " + this.quantidade);
        System.out.println("Mês de validade: " + this.mesValidade);
    }
}

public class Main {

    public static int lerMes(Scanner scanner, String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                int mes = Integer.parseInt(scanner.nextLine());
                if (mes >= 1 && mes <= 12) {
                    return mes;
                } else {
                    System.out.println("ERRO: Digite um mês entre 1 e 12.");
                }
            } catch (NumberFormatException e) {
                System.out.println("ERRO: Digite apenas números.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Cadastro de Amendoim 🥜");

        System.out.print("Digite a quantidade: ");
        int quantidade = Integer.parseInt(scanner.nextLine());

        int mesValidade = lerMes(scanner, "Digite o mês de validade (1-12): ");

        Insumo amendoim = new Insumo(quantidade, mesValidade);

        amendoim.exibirInfo();

        int mesAtual = lerMes(scanner, "\nDigite o mês atual (1-12): ");

        if (amendoim.estaValido(mesAtual)) {
            System.out.println("Amendoim dentro da validade.");
        } else {
            System.out.println("Amendoim não pode ser utilizado.");
        }

        scanner.close();
    }
}

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // 3.2 Nível 1: Compreensão e Sintaxe (Básico)

        while (true) {
            try {
                System.out.print("Digite sua idade: ");
                int idade = Integer.parseInt(scanner.nextLine());

                if (idade < 0) {
                    System.out.println("Erro: A idade não pode ser negativa.");
                } else {
                    System.out.println("Idade cadastrada: " + idade);
                    break;
                }

            } catch (NumberFormatException erro) {
                System.out.println("Erro: Insira apenas números inteiros. Por exemplo: 23");
            }
        }

        // 5 Teste com um exemplo do estoque do Dener

        while (true) {
            try {
                System.out.print("Digite a quantidade de produtos no estoque: ");
                int estoque = Integer.parseInt(scanner.nextLine());

                if (estoque < 0) {
                    System.out.println("Erro: O estoque não pode ser negativo.");
                } else {
                    System.out.println("Estoque atualizado com sucesso: " + estoque + " itens.");
                    break;
                }

            } catch (NumberFormatException erro) {
                System.out.println("Erro: Insira apenas números inteiros para o estoque. Por exemplo: 8");
            }
        }

        // 3.3 Nível 2: Implementação com Clean Code (Intermediário)

        try {
            FileWriter arquivoLog = new FileWriter("log_sistema.txt");

            arquivoLog.write("Sistema iniciado com sucesso.\n");
            arquivoLog.write("Usuário autenticado.\n");

            arquivoLog.close();

            System.out.println("Arquivo gravado com sucesso.");

        } catch (IOException erro) {
            System.out.println("Erro ao manipular o arquivo.");

        } finally {
            System.out.println("Rotina de persistência finalizada, recursos liberados.");
        }

        // 3.3.1 Nível 3: Anatomia do Erro e Refatoração (Avançado)

        try {
            File arquivo = new File("dados_financeiros.json");

            Scanner leitorArquivo = new Scanner(arquivo);

            while (leitorArquivo.hasNextLine()) {
                System.out.println(leitorArquivo.nextLine());
            }

            leitorArquivo.close();

        } catch (IOException erro) {

            System.out.println("Arquivo não encontrado. Criando arquivo padrão...");

            try {
                FileWriter novoArquivo = new FileWriter("dados_financeiros.json");

                novoArquivo.write("{\n");
                novoArquivo.write("    \"saldo\": 0,\n");
                novoArquivo.write("    \"movimentacoes\": []\n");
                novoArquivo.write("}");

                novoArquivo.close();

                System.out.println("Arquivo criado com sucesso.");

            } catch (IOException e) {
                System.out.println("Erro ao criar o arquivo.");
            }
        }

        scanner.close();
    }
}
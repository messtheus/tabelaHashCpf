import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Um programa simples para cadastrar e buscar CPFs dos usuarios usando uma tabela hash.
 */
public class CadastroCPF {

    /**
     * O método principal que inicia o programa.
     * @param args argumentos dos comandos
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> cpfMap = new HashMap<>();

        boolean sair = false; // Variável para controlar a saída do programa

        while (!sair) {  // Loop principal
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Cadastrar CPF");
            System.out.println("2 - Buscar CPF");
            System.out.println("3 - Excluir CPF");
            System.out.println("4 - Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Quebra de linha

            switch (opcao) {
                case 1: // Cadastrar CPF
                    System.out.println("Digite o nome do usuário:");
                    String nome = scanner.nextLine();
                    System.out.println("Digite o CPF:");
                    String cpf = scanner.nextLine();
                    cadastrarCPF(cpfMap, cpf, nome);
                    break;
                case 2: // Buscar CPF
                    System.out.println("Digite o CPF a ser buscado:");
                    String cpfBusca = scanner.nextLine();
                    buscarCPF(cpfMap, cpfBusca);
                    break;
                case 3: // Excluir CPF
                    System.out.println("Digite o CPF a ser excluído:");
                    String cpfExcluir = scanner.nextLine();
                    excluirCPF(cpfMap, cpfExcluir);
                    break;
                case 4: // Sair
                    sair = true;
                    break; // Sair do loop
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    /**
     * Cadastra um CPF no mapa.
     *
     * @param cpfMap o mapa de CPFs
     * @param cpf    o CPF a ser cadastrado
     * @param nome
     */
    public static void cadastrarCPF(Map<String, String> cpfMap, String cpf, String nome) {
        // Verificar se o CPF já está cadastrado e cadastrá-lo
        if (cpfMap.containsKey(cpf)) {
            System.out.println("CPF já cadastrado.");
        } else {
            cpfMap.put(cpf, cpf);
            System.out.println("CPF cadastrado com sucesso.");
        }
    }

    /**
     * Busca por um CPF e exibe o nome de usuário associado, se existir.
     * @param cpfMap O mapa de CPFs.
     * @param cpf O CPF a ser buscado.
     */
    public static void buscarCPF(Map<String, String> cpfMap, String cpf) {
        // Verificar se o CPF está cadastrado e exibi-lo
        if (cpfMap.containsKey(cpf)) {
            System.out.println("CPF encontrado: " + cpf + ", Nome do usuário: " + cpfMap.get(cpf));
        } else {
            System.out.println("CPF não encontrado.");
        }
    }

    /**
     * Exclui um CPF do sistema, se existir.
     * @param cpfMap O mapa de CPFs.
     * @param cpf O CPF a ser excluído.
     */
    public static void excluirCPF(Map<String, String> cpfMap, String cpf) {
        // Verificar se o CPF está cadastrado e excluí-lo
        if (cpfMap.containsKey(cpf)) {
            cpfMap.remove(cpf);
            System.out.println("CPF excluído com sucesso.");
        } else {
            System.out.println("CPF não encontrado.");
        }
    }
}

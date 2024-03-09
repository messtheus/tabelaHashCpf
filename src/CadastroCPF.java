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

        boolean sair = false;

        while (!sair) {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Cadastrar CPF");
            System.out.println("2 - Buscar CPF por nome");
            System.out.println("3 - Buscar CPF");
            System.out.println("4 - Excluir CPF");
            System.out.println("5 - Ver todos os CPFs cadastrados");
            System.out.println("6 - Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do usuário:");
                    String nome = scanner.nextLine();
                    System.out.println("Digite o CPF:");
                    String cpf = scanner.nextLine();
                    cadastrarCPF(cpfMap, cpf, nome);
                    break;
                case 2:
                    System.out.println("Digite o nome cadastrado a ser buscado:");
                    String nomeBusca = scanner.nextLine();
                    buscarCPFPorNome(cpfMap, nomeBusca);
                    break;
                case 3:
                    System.out.println("Digite o CPF a ser buscado:");
                    String cpfBusca = scanner.nextLine();
                    buscarCPF(cpfMap, cpfBusca);
                    break;
                case 4:
                    System.out.println("Digite o CPF a ser excluído:");
                    String cpfExcluir = scanner.nextLine();
                    excluirCPF(cpfMap, cpfExcluir);
                    break;
                case 5:
                    System.out.println("Todos os CPFs cadastrados:");
                    for (String cpfCadastrado : cpfMap.keySet()) {
                        System.out.println(cpfCadastrado + ", Nome do usuário: " + cpfMap.get(cpfCadastrado));
                    }
                    break;
                case 6:
                    sair = true;
                    break;
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
     * @param nome  o nome do usuário associado ao CPF
     */
    public static void cadastrarCPF(Map<String, String> cpfMap, String cpf, String nome) {
        if (cpfMap.containsKey(cpf)) {
            System.out.println("CPF já cadastrado.");
        } else {
            cpfMap.put(cpf, nome);
            System.out.println("CPF cadastrado com sucesso.");
        }
    }

    /**
     * Busca por um CPF e exibe o nome de usuário associado, se existir.
     * @param cpfMap O mapa de CPFs.
     * @param cpf O CPF a ser buscado.
     */
    public static void buscarCPF(Map<String, String> cpfMap, String cpf) {
        if (cpfMap.containsKey(cpf)) {
            System.out.println("CPF encontrado: " + cpf + ", Nome do usuário: " + cpfMap.get(cpf));
        } else {
            System.out.println("CPF não encontrado.");
        }
    }

    /**
     * Busca por um nome e exibe o CPF associado, se existir.
     * @param cpfMap O mapa de CPFs.
     * @param nome O nome a ser buscado.
     */
    public static void buscarCPFPorNome(Map<String, String> cpfMap, String nome) {
        boolean encontrado = false;
        for (Map.Entry<String, String> entry : cpfMap.entrySet()) {
            if (entry.getValue().equalsIgnoreCase(nome)) {
                System.out.println("Nome encontrado: " + nome + ", CPF: " + entry.getKey());
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Nome não encontrado.");
        }
    }

    /**
     * Exclui um CPF do sistema, se existir.
     * @param cpfMap O mapa de CPFs.
     * @param cpf O CPF a ser excluído.
     */
    public static void excluirCPF(Map<String, String> cpfMap, String cpf) {
        if (cpfMap.containsKey(cpf)) {
            cpfMap.remove(cpf);
            System.out.println("CPF excluído com sucesso.");
        } else {
            System.out.println("CPF não encontrado.");
        }
    }
}
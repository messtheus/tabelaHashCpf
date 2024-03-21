import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CadastroCPF {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, DadosUsuario> cpfMap = new HashMap<>();

        boolean sair = false;

        while (!sair) {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Cadastrar usuário");
            System.out.println("2 - Buscar CPF por nome");
            System.out.println("3 - Buscar CPF");
            System.out.println("4 - Excluir CPF");
            System.out.println("5 - Listar todos os usuários cadastrados");
            System.out.println("6 - Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do usuário:");
                    String nome = scanner.nextLine();
                    System.out.println("Digite o CPF:");
                    String cpf = scanner.nextLine();
                    System.out.println("Digite o email do usuário:");
                    String email = scanner.nextLine();
                    System.out.println("Digite o telefone do usuário:");
                    String telefone = scanner.nextLine();
                    cadastrarUsuario(cpfMap, cpf, nome, email, telefone);
                    break;
                case 2:
                    System.out.println("Digite o nome do usuário a ser buscado:");
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
                    listarUsuarios(cpfMap);
                    break;
                case 6:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    public static void cadastrarUsuario(Map<String, DadosUsuario> cpfMap, String cpf, String nome, String email, String telefone) {
        if (cpfMap.containsKey(cpf)) {
            System.out.println("CPF já cadastrado.");
        } else {
            cpfMap.put(cpf, new DadosUsuario(nome, email, telefone));
            System.out.println("Usuário cadastrado com sucesso.");
        }
    }

    public static void buscarCPF(Map<String, DadosUsuario> cpfMap, String cpf) {
        if (cpfMap.containsKey(cpf)) {
            DadosUsuario usuario = cpfMap.get(cpf);
            System.out.println("CPF encontrado: " + cpf);
            System.out.println("Nome do usuário: " + usuario.nome());
            System.out.println("Email do usuário: " + usuario.email());
            System.out.println("Telefone do usuário: " + usuario.telefone());
        } else {
            System.out.println("CPF não encontrado.");
        }
    }

    public static void buscarCPFPorNome(Map<String, DadosUsuario> cpfMap, String nome) {
        boolean encontrado = false;
        for (Map.Entry<String, DadosUsuario> entry : cpfMap.entrySet()) {
            DadosUsuario usuario = entry.getValue();
            if (usuario.nome().equalsIgnoreCase(nome)) {
                System.out.println("Nome encontrado: " + nome + ", CPF: " + entry.getKey());
                System.out.println("Email do usuário: " + usuario.email());
                System.out.println("Telefone do usuário: " + usuario.telefone());
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Nome não encontrado.");
        }
    }

    public static void excluirCPF(Map<String, DadosUsuario> cpfMap, String cpf) {
        if (cpfMap.containsKey(cpf)) {
            cpfMap.remove(cpf);
            System.out.println("CPF excluído com sucesso.");
        } else {
            System.out.println("CPF não encontrado.");
        }
    }

    public static void listarUsuarios(Map<String, DadosUsuario> cpfMap) {
        System.out.println("Todos os usuários cadastrados:");
        for (Map.Entry<String, DadosUsuario> entry : cpfMap.entrySet()) {
            String cpf = entry.getKey();
            DadosUsuario usuario = entry.getValue();
            System.out.println("CPF: " + cpf + ", Nome: " + usuario.nome() + ", Email: " + usuario.email() + ", Telefone: " + usuario.telefone());
        }
    }
}

record DadosUsuario(String nome, String email, String telefone) {
}
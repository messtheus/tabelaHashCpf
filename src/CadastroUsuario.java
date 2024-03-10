import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Um programa simples para cadastrar e buscar informações dos usuários usando uma tabela hash.
 */
public class CadastroUsuario {

    public static class Usuario {
        private String nome;
        private String cpf;
        private String celular;
        private String email;

        public Usuario(String nome, String cpf, String celular, String email) {
            this.nome = nome;
            this.cpf = cpf;
            this.celular = celular;
            this.email = email;
        }

        public String getNome() {
            return nome;
        }

        public String getCpf() {
            return cpf;
        }

        public String getCelular() {
            return celular;
        }

        public String getEmail() {
            return email;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Usuario> usuarioMap = new HashMap<>();

        boolean sair = false;

        while (!sair) {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Cadastrar usuário");
            System.out.println("2 - Buscar usuário por nome");
            System.out.println("3 - Buscar usuário por CPF");
            System.out.println("4 - Excluir usuário");
            System.out.println("5 - Ver todos os usuários cadastrados");
            System.out.println("6 - Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do usuário:");
                    String nome = scanner.nextLine();
                    System.out.println("Digite o CPF:");
                    String cpf = scanner.nextLine();
                    System.out.println("Digite o celular:");
                    String celular = scanner.nextLine();
                    System.out.println("Digite o email:");
                    String email = scanner.nextLine();
                    cadastrarUsuario(usuarioMap, nome, cpf, celular, email);
                    break;
                case 2:
                    System.out.println("Digite o nome cadastrado a ser buscado:");
                    String nomeBusca = scanner.nextLine();
                    buscarUsuarioPorNome(usuarioMap, nomeBusca);
                    break;
                case 3:
                    System.out.println("Digite o CPF a ser buscado:");
                    String cpfBusca = scanner.nextLine();
                    buscarUsuarioPorCPF(usuarioMap, cpfBusca);
                    break;
                case 4:
                    System.out.println("Digite o CPF do usuário a ser excluído:");
                    String cpfExcluir = scanner.nextLine();
                    excluirUsuario(usuarioMap, cpfExcluir);
                    break;
                case 5:
                    System.out.println("Todos os usuários cadastrados:");
                    listarUsuarios(usuarioMap);
                    break;
                case 6:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    public static void cadastrarUsuario(Map<String, Usuario> usuarioMap, String nome, String cpf, String celular, String email) {
        if (usuarioMap.containsKey(cpf)) {
            System.out.println("CPF já cadastrado.");
        } else {
            Usuario novoUsuario = new Usuario(nome, cpf, celular, email);
            usuarioMap.put(cpf, novoUsuario);
            System.out.println("Usuário cadastrado com sucesso.");
        }
    }

    public static void buscarUsuarioPorNome(Map<String, Usuario> usuarioMap, String nome) {
        boolean encontrado = false;
        for (Usuario usuario : usuarioMap.values()) {
            if (usuario.getNome().equalsIgnoreCase(nome)) {
                System.out.println("Nome encontrado: " + nome + ", CPF: " + usuario.getCpf() + ", Celular: " + usuario.getCelular() + ", Email: " + usuario.getEmail());
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Nome não encontrado.");
        }
    }

    public static void buscarUsuarioPorCPF(Map<String, Usuario> usuarioMap, String cpf) {
        if (usuarioMap.containsKey(cpf)) {
            Usuario usuario = usuarioMap.get(cpf);
            System.out.println("Usuário encontrado: " + usuario.getNome() + ", CPF: " + usuario.getCpf() + ", Celular: " + usuario.getCelular() + ", Email: " + usuario.getEmail());
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }

    public static void excluirUsuario(Map<String, Usuario> usuarioMap, String cpf) {
        if (usuarioMap.containsKey(cpf)) {
            usuarioMap.remove(cpf);
            System.out.println("Usuário excluído com sucesso.");
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }

    public static void listarUsuarios(Map<String, Usuario> usuarioMap) {
        if (usuarioMap.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
        } else {
            for (Usuario usuario : usuarioMap.values()) {
                System.out.println("Nome: " + usuario.getNome() + ", CPF: " + usuario.getCpf() + ", Celular: " + usuario.getCelular() + ", Email: " + usuario.getEmail());
            }
        }
    }
}
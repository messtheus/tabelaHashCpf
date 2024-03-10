import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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

    private Map<String, Usuario> usuarioMap;

    public CadastroUsuario() {
        usuarioMap = new HashMap<>();
    }

    public void cadastrarUsuario(String nome, String cpf, String celular, String email) {
        if (usuarioMap.containsKey(cpf)) {
            System.out.println("CPF já cadastrado.");
        } else {
            Usuario novoUsuario = new Usuario(nome, cpf, celular, email);
            usuarioMap.put(cpf, novoUsuario);
            System.out.println("Usuário cadastrado com sucesso.");
        }
    }

    public Usuario buscarUsuarioPorCPF(String cpf) {
        if (usuarioMap.containsKey(cpf)) {
            return usuarioMap.get(cpf);
        } else {
            System.out.println("Usuário não encontrado.");
            return null;
        }
    }

    public void excluirUsuario(String cpf) {
        if (usuarioMap.containsKey(cpf)) {
            usuarioMap.remove(cpf);
            System.out.println("Usuário excluído com sucesso.");
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }

    public Map<String, Usuario> getUsuarioMap() {
        return usuarioMap;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CadastroUsuario cadastroUsuario = new CadastroUsuario();

        boolean sair = false;

        while (!sair) {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Cadastrar usuário");
            System.out.println("2 - Buscar usuário por CPF");
            System.out.println("3 - Excluir usuário");
            System.out.println("4 - Ver todos os usuários cadastrados");
            System.out.println("5 - Sair");

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
                    cadastroUsuario.cadastrarUsuario(nome, cpf, celular, email);
                    break;
                case 2:
                    System.out.println("Digite o CPF do usuário a ser buscado:");
                    String cpfBusca = scanner.nextLine();
                    Usuario usuario = cadastroUsuario.buscarUsuarioPorCPF(cpfBusca);
                    if (usuario != null) {
                        System.out.println("Usuário encontrado: " + usuario.getNome() + ", CPF: " + usuario.getCpf() + ", Celular: " + usuario.getCelular() + ", Email: " + usuario.getEmail());
                    }
                    break;
                case 3:
                    System.out.println("Digite o CPF do usuário a ser excluído:");
                    String cpfExcluir = scanner.nextLine();
                    cadastroUsuario.excluirUsuario(cpfExcluir);
                    break;
                case 4:
                    System.out.println("Todos os usuários cadastrados:");
                    for (Usuario u : cadastroUsuario.getUsuarioMap().values()) {
                        System.out.println("Nome: " + u.getNome() + ", CPF: " + u.getCpf() + ", Celular: " + u.getCelular() + ", Email: " + u.getEmail());
                    }
                    break;
                case 5:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}

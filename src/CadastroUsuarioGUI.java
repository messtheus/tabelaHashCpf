import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroUsuarioGUI extends JFrame {
    private CadastroUsuario cadastroUsuario;

    private JTextField txtCpf, txtNome, txtCelular, txtEmail;
    private JTextArea textAreaUsuarios;

    public CadastroUsuarioGUI(CadastroUsuario cadastroUsuario) {
        this.cadastroUsuario = cadastroUsuario;

        setTitle("Cadastro de Usuários");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lblCpf = new JLabel("CPF:");
        lblCpf.setBounds(20, 20, 80, 20);
        add(lblCpf);

        txtCpf = new JTextField();
        txtCpf.setBounds(100, 20, 200, 20);
        add(txtCpf);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(20, 50, 80, 20);
        add(lblNome);

        txtNome = new JTextField();
        txtNome.setBounds(100, 50, 200, 20);
        add(txtNome);

        JLabel lblCelular = new JLabel("Celular:");
        lblCelular.setBounds(20, 80, 80, 20);
        add(lblCelular);

        txtCelular = new JTextField();
        txtCelular.setBounds(100, 80, 200, 20);
        add(txtCelular);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(20, 110, 80, 20);
        add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setBounds(100, 110, 200, 20);
        add(txtEmail);

        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBounds(20, 140, 120, 30);
        add(btnCadastrar);

        JButton btnBuscar = new JButton("Buscar por CPF");
        btnBuscar.setBounds(20, 180, 150, 30);
        add(btnBuscar);

        JButton btnExcluir = new JButton("Excluir por CPF");
        btnExcluir.setBounds(20, 220, 150, 30);
        add(btnExcluir);

        JButton btnListar = new JButton("Listar Usuários");
        btnListar.setBounds(20, 260, 150, 30);
        add(btnListar);

        textAreaUsuarios = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textAreaUsuarios);
        scrollPane.setBounds(500, 20, 600, 450);
        add(scrollPane);

        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarUsuario();
            }
        });

        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarUsuarioPorCPF();
            }
        });

        btnExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                excluirUsuario();
            }
        });

        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarUsuarios();
            }
        });

        setVisible(true);
    }

    private void cadastrarUsuario() {
        String cpf = txtCpf.getText();
        String nome = txtNome.getText();
        String celular = txtCelular.getText();
        String email = txtEmail.getText();

        cadastroUsuario.cadastrarUsuario(nome, cpf, celular, email);

        txtCpf.setText("");
        txtNome.setText("");
        txtCelular.setText("");
        txtEmail.setText("");
    }

    private void buscarUsuarioPorCPF() {
        String cpfBusca = txtCpf.getText();
        CadastroUsuario.Usuario usuario = cadastroUsuario.buscarUsuarioPorCPF(cpfBusca);
        if (usuario != null) {
            textAreaUsuarios.setText("Usuário encontrado: " + usuario.getNome() + ", CPF: " + usuario.getCpf() + ", Celular: " + usuario.getCelular() + ", Email: " + usuario.getEmail());
        }
    }

    private void excluirUsuario() {
        String cpfExcluir = txtCpf.getText();
        cadastroUsuario.excluirUsuario(cpfExcluir);
        txtCpf.setText("");
    }

    private void listarUsuarios() {
        StringBuilder builder = new StringBuilder();
        for (CadastroUsuario.Usuario usuario : cadastroUsuario.getUsuarioMap().values()) {
            builder.append("Nome: ").append(usuario.getNome()).append(", CPF: ").append(usuario.getCpf())
                    .append(", Celular: ").append(usuario.getCelular()).append(", Email: ").append(usuario.getEmail())
                    .append("\n");
        }
        textAreaUsuarios.setText(builder.toString());
    }

    public static void main(String[] args) {
        CadastroUsuario cadastroUsuario = new CadastroUsuario();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CadastroUsuarioGUI(cadastroUsuario);
            }
        });
    }
}
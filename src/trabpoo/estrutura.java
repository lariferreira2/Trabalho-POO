package trabpoo;

import java.util.ArrayList;
import java.util.Scanner;

public class estrutura {

    private static ArrayList<Professor> professores = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void cadastrarProfessor() {

        System.out.println("\n===== CADASTRAR PROFESSOR =====");

        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("E-mail: ");
        String email = scanner.nextLine();

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        System.out.print("CREF: ");
        String cref = scanner.nextLine();

        System.out.print("Especialidade: ");
        String especialidade = scanner.nextLine();

        Professor professor = new Professor(
                id,
                nome,
                cpf,
                email,
                telefone,
                cref,
                especialidade
        );

        professores.add(professor);

        System.out.println("Professor cadastrado com sucesso!");
    }

    public static void listarProfessores() {

        System.out.println("\n===== PROFESSORES CADASTRADOS =====");

        if (professores.isEmpty()) {
            System.out.println("Nenhum professor cadastrado.");
            return;
        }

        for (Professor professor : professores) {
            professor.exibirDados();
        }
    }

    public static Professor buscarProfessor(int id) {

        for (Professor professor : professores) {
            if (professor.getId() == id) {
                return professor;
            }
        }

        return null;
    }

    public static void buscarProfessorMenu() {

        System.out.print("\nDigite o ID do professor: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Professor professor = buscarProfessor(id);

        if (professor != null) {
            professor.exibirDados();
        } else {
            System.out.println("Professor não encontrado.");
        }
    }

    public static void atualizarProfessor() {

        System.out.print("\nDigite o ID do professor: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Professor professor = buscarProfessor(id);

        if (professor == null) {
            System.out.println("Professor não encontrado.");
            return;
        }

        System.out.print("Novo nome: ");
        professor.setNome(scanner.nextLine());

        System.out.print("Novo CPF: ");
        professor.setCpf(scanner.nextLine());

        System.out.print("Novo e-mail: ");
        professor.setEmail(scanner.nextLine());

        System.out.print("Novo telefone: ");
        professor.setTelefone(scanner.nextLine());

        System.out.print("Novo CREF: ");
        professor.setCref(scanner.nextLine());

        System.out.print("Nova especialidade: ");
        professor.setEspecialidade(scanner.nextLine());

        System.out.println("Professor atualizado com sucesso!");
    }

    public static void removerProfessor() {

        System.out.print("\nDigite o ID do professor: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Professor professor = buscarProfessor(id);

        if (professor == null) {
            System.out.println("Professor não encontrado.");
            return;
        }

        professores.remove(professor);

        System.out.println("Professor removido com sucesso!");
    }

    public static void main(String[] args) {

        int opcao;

        do {
            System.out.println("\n==============================");
            System.out.println("     SISTEMA DE ACADEMIA");
            System.out.println("     GERENCIAR PROFESSORES");
            System.out.println("==============================");
            System.out.println("1 - Cadastrar professor");
            System.out.println("2 - Listar professores");
            System.out.println("3 - Buscar professor");
            System.out.println("4 - Atualizar professor");
            System.out.println("5 - Remover professor");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:
                    cadastrarProfessor();
                    break;

                case 2:
                    listarProfessores();
                    break;

                case 3:
                    buscarProfessorMenu();
                    break;

                case 4:
                    atualizarProfessor();
                    break;

                case 5:
                    removerProfessor();
                    break;

                case 0:
                    System.out.println("Programa encerrado.");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        scanner.close();
    }
}

class Professor {

    private int id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String cref;
    private String especialidade;

    public Professor(int id, String nome, String cpf, String email,
                     String telefone, String cref, String especialidade) {

        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.cref = cref;
        this.especialidade = especialidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCref() {
        return cref;
    }

    public void setCref(String cref) {
        this.cref = cref;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public void exibirDados() {

        System.out.println("-----------------------------------");
        System.out.println("ID: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("E-mail: " + email);
        System.out.println("Telefone: " + telefone);
        System.out.println("CREF: " + cref);
        System.out.println("Especialidade: " + especialidade);
        System.out.println("-----------------------------------");
    }
}
package trabpoo;

import java.util.ArrayList;
import java.util.Scanner;

class Pessoa {

    private int id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;

    public Pessoa(int id, String nome, String cpf, String email, String telefone) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
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

    
    public void exibirDados() {
        System.out.println("-----------------------------------");
        System.out.println("ID: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("E-mail: " + email);
        System.out.println("Telefone: " + telefone);
    }
}

class Professor extends Pessoa {

    private String cref;
    private String especialidade;

    public Professor(int id, String nome, String cpf, String email,
                     String telefone, String cref, String especialidade) {

        super(id, nome, cpf, email, telefone);

        this.cref = cref;
        this.especialidade = especialidade;
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

   
    @Override
    public void exibirDados() {

        super.exibirDados();

        System.out.println("CREF: " + cref);
        System.out.println("Especialidade: " + especialidade);

        System.out.println("-----------------------------------");
    }
}

class ProfessorPresencial extends Professor {

    private String sala;

    public ProfessorPresencial(int id, String nome, String cpf,
                               String email, String telefone,
                               String cref, String especialidade,
                               String sala) {

        super(id, nome, cpf, email, telefone, cref, especialidade);

        this.sala = sala;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

   
    @Override
    public void exibirDados() {

        System.out.println("\n===== PROFESSOR PRESENCIAL =====");

        super.exibirDados();

        System.out.println("Sala: " + sala);
        System.out.println("-----------------------------------");
    }
}

class ProfessorOnline extends Professor {

    private String plataforma;

    public ProfessorOnline(int id, String nome, String cpf,
                            String email, String telefone,
                            String cref, String especialidade,
                            String plataforma) {

        super(id, nome, cpf, email, telefone, cref, especialidade);

        this.plataforma = plataforma;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

   
    @Override
    public void exibirDados() {

        System.out.println("\n===== PROFESSOR ONLINE =====");

        super.exibirDados();

        System.out.println("Plataforma: " + plataforma);
        System.out.println("-----------------------------------");
    }
}

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

        System.out.println("\nTipo de professor:");
        System.out.println("1 - Presencial");
        System.out.println("2 - Online");
        System.out.print("Escolha: ");

        int tipo = scanner.nextInt();
        scanner.nextLine();

        Professor professor;

        if (tipo == 1) {

            System.out.print("Sala: ");
            String sala = scanner.nextLine();

            professor = new ProfessorPresencial(
                    id,
                    nome,
                    cpf,
                    email,
                    telefone,
                    cref,
                    especialidade,
                    sala
            );

        } else if (tipo == 2) {

            System.out.print("Plataforma: ");
            String plataforma = scanner.nextLine();

            professor = new ProfessorOnline(
                    id,
                    nome,
                    cpf,
                    email,
                    telefone,
                    cref,
                    especialidade,
                    plataforma
            );

        } else {

            System.out.println("Tipo inválido.");
            return;
        }

        professores.add(professor);

        System.out.println("\nProfessor cadastrado com sucesso!");
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

        
        if (professor instanceof ProfessorPresencial) {

            ProfessorPresencial presencial =
                    (ProfessorPresencial) professor;

            System.out.print("Nova sala: ");
            presencial.setSala(scanner.nextLine());

        } else if (professor instanceof ProfessorOnline) {

            ProfessorOnline online =
                    (ProfessorOnline) professor;

            System.out.print("Nova plataforma: ");
            online.setPlataforma(scanner.nextLine());
        }

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
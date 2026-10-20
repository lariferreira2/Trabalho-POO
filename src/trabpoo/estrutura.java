package trabpoo;

import java.util.ArrayList;
import java.util.Scanner;

abstract class Registro {
    private int id;

    public Registro(int id) { this.id = id; }
    public int getId() { return id; }
    public void setId(int id) { if (id > 0) this.id = id; }
    public abstract String dados();
    public void exibirDados() { System.out.println(dados()); }
}

abstract class Pessoa extends Registro {
    private String nome, cpf, email, telefone;

    public Pessoa(int id, String nome, String cpf, String email, String telefone) {
        super(id);
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
    }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public String dados() {
        return "ID: " + getId() + " | Nome: " + nome + " | CPF: " + cpf + " | E-mail: " + email + " | Telefone: " + telefone;
    }
}

class Aluno extends Pessoa {
    private String matricula, objetivo;
    private int idPlano;

    public Aluno(int id, String nome, String cpf, String email, String telefone, String matricula, String objetivo, int idPlano) {
        super(id, nome, cpf, email, telefone);
        this.matricula = matricula;
        this.objetivo = objetivo;
        this.idPlano = idPlano;
    }
    public String getMatricula() { return matricula; }
    public void setMatricula(String matricula) { this.matricula = matricula; }
    public String getObjetivo() { return objetivo; }
    public void setObjetivo(String objetivo) { this.objetivo = objetivo; }
    public int getIdPlano() { return idPlano; }
    public void setIdPlano(int idPlano) { this.idPlano = idPlano; }
    public String dados() {
        return "ALUNO | " + super.dados() + " | Matrícula: " + matricula + " | Objetivo: " + objetivo + " | ID plano: " + idPlano;
    }
}

class Professor extends Pessoa {
    private String cref, especialidade;

    public Professor(int id, String nome, String cpf, String email, String telefone, String cref, String especialidade) {
        super(id, nome, cpf, email, telefone);
        this.cref = cref;
        this.especialidade = especialidade;
    }
    public String getCref() { return cref; }
    public void setCref(String cref) { this.cref = cref; }
    public String getEspecialidade() { return especialidade; }
    public void setEspecialidade(String especialidade) { this.especialidade = especialidade; }
    public String dados() {
        return "PROFESSOR | " + super.dados() + " | CREF: " + cref + " | Especialidade: " + especialidade;
    }
}

class ProfessorPresencial extends Professor {
    private String sala;

    public ProfessorPresencial(int id, String nome, String cpf, String email, String telefone, String cref, String especialidade, String sala) {
        super(id, nome, cpf, email, telefone, cref, especialidade);
        this.sala = sala;
    }
    public String getSala() { return sala; }
    public void setSala(String sala) { this.sala = sala; }
    public String dados() { return "PROFESSOR PRESENCIAL | " + super.dados() + " | Sala: " + sala; }
}

class ProfessorOnline extends Professor {
    private String plataforma;

    public ProfessorOnline(int id, String nome, String cpf, String email, String telefone, String cref, String especialidade, String plataforma) {
        super(id, nome, cpf, email, telefone, cref, especialidade);
        this.plataforma = plataforma;
    }
    public String getPlataforma() { return plataforma; }
    public void setPlataforma(String plataforma) { this.plataforma = plataforma; }
    public String dados() { return "PROFESSOR ONLINE | " + super.dados() + " | Plataforma: " + plataforma; }
}

class Plano extends Registro {
    private String nome;
    private int duracaoMeses;
    private double valor;

    public Plano(int id, String nome, int duracaoMeses, double valor) {
        super(id);
        this.nome = nome;
        this.duracaoMeses = duracaoMeses;
        this.valor = valor;
    }
    public String getNome() { return nome; }
    public void setNome(String v) { nome = v; }
    public int getDuracaoMeses() { return duracaoMeses; }
    public void setDuracaoMeses(int v) { duracaoMeses = v; }
    public double getValor() { return valor; }
    public void setValor(double v) { valor = v; }
    public String dados() {
        return "PLANO | ID: " + getId() + " | Nome: " + nome + " | Duração: " + duracaoMeses + " meses | Valor: R$ " + valor;
    }
}

class Exercicio extends Registro {
    private String nome, grupoMuscular;
    private int series, repeticoes;

    public Exercicio(int id, String nome, String grupoMuscular, int series, int repeticoes) {
        super(id);
        this.nome = nome;
        this.grupoMuscular = grupoMuscular;
        this.series = series;
        this.repeticoes = repeticoes;
    }
    public String getNome() { return nome; }
    public void setNome(String v) { nome = v; }
    public String getGrupoMuscular() { return grupoMuscular; }
    public void setGrupoMuscular(String v) { grupoMuscular = v; }
    public int getSeries() { return series; }
    public void setSeries(int v) { series = v; }
    public int getRepeticoes() { return repeticoes; }
    public void setRepeticoes(int v) { repeticoes = v; }
    public String dados() {
        return "EXERCÍCIO | ID: " + getId() + " | Nome: " + nome + " | Grupo muscular: " + grupoMuscular + " | Séries: " + series + " | Repetições: " + repeticoes;
    }
}

class Treino extends Registro {
    private String nome;
    private int idAluno, idProfessor;
    private ArrayList<Integer> idsExercicios = new ArrayList<>();

    public Treino(int id, String nome, int idAluno, int idProfessor) {
        super(id);
        this.nome = nome;
        this.idAluno = idAluno;
        this.idProfessor = idProfessor;
    }
    public String getNome() { return nome; }
    public void setNome(String v) { nome = v; }
    public int getIdAluno() { return idAluno; }
    public void setIdAluno(int v) { idAluno = v; }
    public int getIdProfessor() { return idProfessor; }
    public void setIdProfessor(int v) { idProfessor = v; }
    public ArrayList<Integer> getIdsExercicios() { return new ArrayList<>(idsExercicios); }
    public void adicionarExercicio(int id) {
        if (id > 0 && !idsExercicios.contains(id)) idsExercicios.add(id);
    }
    public String dados() {
        return "TREINO | ID: " + getId() + " | Nome: " + nome + " | Aluno: " + idAluno + " | Professor: " + idProfessor + " | Exercícios: " + idsExercicios;
    }
}

class Avaliacao extends Registro {
    private int idAluno;
    private String data, observacoes;
    private double peso, altura;

    public Avaliacao(int id, int idAluno, String data, double peso, double altura, String observacoes) {
        super(id);
        this.idAluno = idAluno;
        this.data = data;
        this.peso = peso;
        this.altura = altura;
        this.observacoes = observacoes;
    }
    public int getIdAluno() { return idAluno; }
    public void setIdAluno(int v) { idAluno = v; }
    public String getData() { return data; }
    public void setData(String v) { data = v; }
    public double getPeso() { return peso; }
    public void setPeso(double v) { peso = v; }
    public double getAltura() { return altura; }
    public void setAltura(double v) { altura = v; }
    public String getObservacoes() { return observacoes; }
    public void setObservacoes(String v) { observacoes = v; }
    public String dados() {
        return "AVALIAÇÃO | ID: " + getId() + " | Aluno: " + idAluno + " | Data: " + data + " | Peso: " + peso + " kg | Altura: " + altura + " m | Observações: " + observacoes;
    }
}

class Pagamento extends Registro {
    private int idAluno, idPlano;
    private String data, formaPagamento, status;
    private double valor;

    public Pagamento(int id, int idAluno, int idPlano, String data, double valor, String formaPagamento, String status) {
        super(id);
        this.idAluno = idAluno;
        this.idPlano = idPlano;
        this.data = data;
        this.valor = valor;
        this.formaPagamento = formaPagamento;
        this.status = status;
    }
    public int getIdAluno() { return idAluno; }
    public void setIdAluno(int v) { idAluno = v; }
    public int getIdPlano() { return idPlano; }
    public void setIdPlano(int v) { idPlano = v; }
    public String getData() { return data; }
    public void setData(String v) { data = v; }
    public double getValor() { return valor; }
    public void setValor(double v) { valor = v; }
    public String getFormaPagamento() { return formaPagamento; }
    public void setFormaPagamento(String v) { formaPagamento = v; }
    public String getStatus() { return status; }
    public void setStatus(String v) { status = v; }
    public String dados() {
        return "PAGAMENTO | ID: " + getId() + " | Aluno: " + idAluno + " | Plano: " + idPlano + " | Data: " + data + " | Valor: R$ " + valor + " | Forma: " + formaPagamento + " | Status: " + status;
    }
}

class Repositorio<T extends Registro> {
    private final ArrayList<T> itens = new ArrayList<>();

    public boolean inserir(T item) {
        if (item == null || item.getId() <= 0 || buscar(item.getId()) != null) return false;
        itens.add(item);
        return true;
    }
    public ArrayList<T> listar() {
        return new ArrayList<>(itens);
    }
    public T buscar(int id) {
        for (T item : itens)
            if (item.getId() == id) return item;
        return null;
    }
    public boolean atualizar(int id, T novo) {
        for (int i = 0; i < itens.size(); i++) {
            if (itens.get(i).getId() == id) {
                if (novo == null || novo.getId() != id) return false;
                itens.set(i, novo);
                return true;
            }
        }
        return false;
    }
    public boolean remover(int id) {
        T item = buscar(id);
        return item != null && itens.remove(item);
    }
    public ArrayList<T> buscar(String texto) {
        ArrayList<T> achados = new ArrayList<>();
        for (T item : itens)
            if (item.dados().toLowerCase().contains(texto.toLowerCase())) achados.add(item);
        return achados;
    }
    public boolean estaVazio() {
        return itens.isEmpty();
    }
}

public class estrutura {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Repositorio<Aluno> alunos = new Repositorio<>();
    private static final Repositorio<Professor> professores = new Repositorio<>();
    private static final Repositorio<Plano> planos = new Repositorio<>();
    private static final Repositorio<Exercicio> exercicios = new Repositorio<>();
    private static final Repositorio<Treino> treinos = new Repositorio<>();
    private static final Repositorio<Avaliacao> avaliacoes = new Repositorio<>();
    private static final Repositorio<Pagamento> pagamentos = new Repositorio<>();

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("\n========== SISTEMA DE ACADEMIA ==========");
            System.out.println("1 Cadastrar aluno ");
            System.out.println("2 Cadastrar professor");
            System.out.println("3 Cadastrar plano");
            System.out.println("4 Cadastrar exercício");
            System.out.println("5 Cadastrar treino");
            System.out.println("6 Cadastrar avaliação");
            System.out.println("7 Cadastrar pagamento");
            System.out.println("8 Listar registros");
            System.out.println("9 Buscar por ID");
            System.out.println("10 Buscar por texto");
            System.out.println("11 Atualizar registro");
            System.out.println("12 Remover registro");
            System.out.println("0 Sair");
            opcao = inteiro("Escolha: ");
            try {
                switch (opcao) {
                    case 1 -> cadastrarAluno();
                    case 2 -> cadastrarProfessor();
                    case 3 -> cadastrarPlano();
                    case 4 -> cadastrarExercicio();
                    case 5 -> cadastrarTreino();
                    case 6 -> cadastrarAvaliacao();
                    case 7 -> cadastrarPagamento();
                    case 8 -> listarTipo();
                    case 9 -> buscarId();
                    case 10 -> buscarTexto();
                    case 11 -> atualizar();
                    case 12 -> remover();
                    case 0 -> System.out.println("Programa encerrado. Os dados estavam apenas em memória.");
                    default -> System.out.println("Opção inválida.");
                }
            } catch (Exception e) {
                System.out.println("Não foi possível concluir a operação: " + e.getMessage());
            }
        } while (opcao != 0);
        scanner.close();
    }

    private static void cadastrarAluno() {
        int id = inteiro("ID: ");
        String nome = texto("Nome: ");
        String cpf = texto("CPF: ");
        String email = texto("E-mail: ");
        String telefone = texto("Telefone: ");
        String matricula = texto("Matrícula: ");
        String objetivo = texto("Objetivo: ");
        int idPlano = inteiro("ID do plano (0 se não houver): ");
        resultado(alunos.inserir(new Aluno(id, nome, cpf, email, telefone, matricula, objetivo, idPlano)));
    }

    private static void cadastrarProfessor() {
        int id = inteiro("ID: ");
        String nome = texto("Nome: ");
        String cpf = texto("CPF: ");
        String email = texto("E-mail: ");
        String telefone = texto("Telefone: ");
        String cref = texto("CREF: ");
        String especialidade = texto("Especialidade: ");
        int tipo = inteiro("1-Presencial / 2-Online: ");
        Professor p;
        if (tipo == 1) p = new ProfessorPresencial(id, nome, cpf, email, telefone, cref, especialidade, texto("Sala: "));
        else if (tipo == 2) p = new ProfessorOnline(id, nome, cpf, email, telefone, cref, especialidade, texto("Plataforma: "));
        else {
            System.out.println("Tipo inválido.");
            return;
        }
        resultado(professores.inserir(p));
    }

    private static void cadastrarPlano() {
        resultado(planos.inserir(new Plano(inteiro("ID: "), texto("Nome: "), inteiro("Duração em meses: "), decimal("Valor: "))));
    }

    private static void cadastrarExercicio() {
        resultado(exercicios.inserir(new Exercicio(inteiro("ID: "), texto("Nome: "), texto("Grupo muscular: "), inteiro("Séries: "), inteiro("Repetições: "))));
    }

    private static void cadastrarTreino() {
        int id = inteiro("ID: ");
        String nome = texto("Nome do treino: ");
        int a = inteiro("ID do aluno: ");
        int p = inteiro("ID do professor: ");
        Treino t = new Treino(id, nome, a, p);
        String mais = texto("Adicionar ID de exercício? (s/n): ");
        while (mais.equalsIgnoreCase("s")) {
            int ex = inteiro("ID do exercício: ");
            if (exercicios.buscar(ex) != null) t.adicionarExercicio(ex);
            else System.out.println("Exercício não encontrado.");
            mais = texto("Adicionar outro? (s/n): ");
        }
        resultado(treinos.inserir(t));
    }

    private static void cadastrarAvaliacao() {
        resultado(avaliacoes.inserir(new Avaliacao(inteiro("ID: "), inteiro("ID do aluno: "), texto("Data: "), decimal("Peso em kg: "), decimal("Altura em metros: "), texto("Observações: "))));
    }

    private static void cadastrarPagamento() {
        resultado(pagamentos.inserir(new Pagamento(inteiro("ID: "), inteiro("ID do aluno: "), inteiro("ID do plano: "), texto("Data: "), decimal("Valor: "), texto("Forma de pagamento: "), texto("Status pago/pendente: "))));
    }

    private static int tipo() {
        System.out.println("1 Aluno | 2 Professor | 3 Plano | 4 Exercício | 5 Treino | 6 Avaliação | 7 Pagamento");
        return inteiro("Tipo: ");
    }

    private static Repositorio<? extends Registro> repositorio(int t) {
        return switch (t) {
            case 1 -> alunos;
            case 2 -> professores;
            case 3 -> planos;
            case 4 -> exercicios;
            case 5 -> treinos;
            case 6 -> avaliacoes;
            case 7 -> pagamentos;
            default -> null;
        };
    }

    private static void listarTipo() {
        Repositorio<? extends Registro> r = repositorio(tipo());
        if (r == null) {
            System.out.println("Tipo inválido.");
            return;
        }
        if (r.estaVazio()) System.out.println("Nenhum registro cadastrado.");
        else for (Registro x : r.listar()) x.exibirDados();
    }

    private static void buscarId() {
        Repositorio<? extends Registro> r = repositorio(tipo());
        if (r == null) return;
        Registro x = r.buscar(inteiro("ID: "));
        if (x == null) System.out.println("Registro não encontrado.");
        else x.exibirDados();
    }

    private static void buscarTexto() {
        Repositorio<? extends Registro> r = repositorio(tipo());
        if (r == null) return;
        ArrayList<? extends Registro> xs = r.buscar(texto("Texto para buscar: "));
        if (xs.isEmpty()) System.out.println("Nenhum registro encontrado.");
        else for (Registro x : xs) x.exibirDados();
    }

    private static void atualizar() {
        int t = tipo(), id = inteiro("ID do registro: ");
        switch (t) {
            case 1 -> {
                Aluno a = alunos.buscar(id);
                if (a == null) { ausente(); return; }
                a.setNome(texto("Nome: "));
                a.setCpf(texto("CPF: "));
                a.setEmail(texto("E-mail: "));
                a.setTelefone(texto("Telefone: "));
                a.setMatricula(texto("Matrícula: "));
                a.setObjetivo(texto("Objetivo: "));
                a.setIdPlano(inteiro("ID do plano: "));
            }
            case 2 -> {
                Professor p = professores.buscar(id);
                if (p == null) { ausente(); return; }
                p.setNome(texto("Nome: "));
                p.setCpf(texto("CPF: "));
                p.setEmail(texto("E-mail: "));
                p.setTelefone(texto("Telefone: "));
                p.setCref(texto("CREF: "));
                p.setEspecialidade(texto("Especialidade: "));
                if (p instanceof ProfessorPresencial pp)
                    pp.setSala(texto("Sala: "));
                else if (p instanceof ProfessorOnline po)
                    po.setPlataforma(texto("Plataforma: "));
            }
            case 3 -> {
                Plano p = planos.buscar(id);
                if (p == null) { ausente(); return; }
                p.setNome(texto("Nome: "));
                p.setDuracaoMeses(inteiro("Duração em meses: "));
                p.setValor(decimal("Valor: "));
            }
            case 4 -> {
                Exercicio e = exercicios.buscar(id);
                if (e == null) { ausente(); return; }
                e.setNome(texto("Nome: "));
                e.setGrupoMuscular(texto("Grupo muscular: "));
                e.setSeries(inteiro("Séries: "));
                e.setRepeticoes(inteiro("Repetições: "));
            }
            case 5 -> {
                Treino x = treinos.buscar(id);
                if (x == null) { ausente(); return; }
                System.out.println("Para alterar os exercícios, remova e cadastre o treino novamente.");
                x.setNome(texto("Nome: "));
                x.setIdAluno(inteiro("ID do aluno: "));
                x.setIdProfessor(inteiro("ID do professor: "));
            }
            case 6 -> {
                Avaliacao a = avaliacoes.buscar(id);
                if (a == null) { ausente(); return; }
                a.setIdAluno(inteiro("ID do aluno: "));
                a.setData(texto("Data: "));
                a.setPeso(decimal("Peso: "));
                a.setAltura(decimal("Altura: "));
                a.setObservacoes(texto("Observações: "));
            }
            case 7 -> {
                Pagamento p = pagamentos.buscar(id);
                if (p == null) { ausente(); return; }
                p.setIdAluno(inteiro("ID do aluno: "));
                p.setIdPlano(inteiro("ID do plano: "));
                p.setData(texto("Data: "));
                p.setValor(decimal("Valor: "));
                p.setFormaPagamento(texto("Forma de pagamento: "));
                p.setStatus(texto("Status: "));
            }
            default -> {
                System.out.println("Tipo inválido.");
                return;
            }
        }
        System.out.println("Registro atualizado com sucesso.");
    }

    private static void remover() {
        int t = tipo(), id = inteiro("ID para remover: ");
        boolean ok = switch (t) {
            case 1 -> alunos.remover(id);
            case 2 -> professores.remover(id);
            case 3 -> planos.remover(id);
            case 4 -> exercicios.remover(id);
            case 5 -> treinos.remover(id);
            case 6 -> avaliacoes.remover(id);
            case 7 -> pagamentos.remover(id);
            default -> false;
        };
        System.out.println(ok ? "Registro removido." : "Registro não encontrado.");
    }

    private static int inteiro(String msg) {
        while (true) {
            System.out.print(msg);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Digite um número inteiro válido.");
            }
        }
    }

    private static double decimal(String msg) {
        while (true) {
            System.out.print(msg);
            try {
                return Double.parseDouble(scanner.nextLine().trim().replace(',', '.'));
            } catch (NumberFormatException e) {
                System.out.println("Digite um número válido.");
            }
        }
    }

    private static String texto(String msg) {
        System.out.print(msg);
        return scanner.nextLine().trim();
    }

    private static void resultado(boolean ok) {
        System.out.println(ok ? "Cadastro realizado com sucesso." : "Não foi possível cadastrar: ID já utilizado ou inválido.");
    }

    private static void ausente() {
        System.out.println("Registro não encontrado.");
    }
}
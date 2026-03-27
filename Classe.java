// Classe Base Usuario (Abstração e Herança)
public abstract class Usuario {
    protected String nome;
    protected String matricula;
    protected String email;

    public Usuario(String nome, String matricula, String email) {
        this.nome = nome;
        this.matricula = matricula;
        this.email = email;
    }

    // Método para Polimorfismo
    public abstract double calcularMulta(int diasAtraso);
}

// Subclasse Estudante
class Estudante extends Usuario {
    public Estudante(String nome, String matricula, String email) {
        super(nome, matricula, email);
    }

    @Override
    public double calcularMulta(int diasAtraso) {
        return diasAtraso * 1.0; [span_16](start_span)// R$ 1,00 por dia[span_16](end_span)
    }
}

// Subclasse Professor
class Professor extends Usuario {
    public Professor(String nome, String matricula, String email) {
        super(nome, matricula, email);
    }

    @Override
    public double calcularMulta(int diasAtraso) {
        return 0.0; [span_17](start_span)// Professores não pagam multa[span_17](end_span)
    }
}

import java.util.ArrayList;
import java.util.List;

class Exemplar {
    private String codigoUnico;
    private String status; [span_18](start_span)// "disponível" ou "emprestado"[span_18](end_span)

    public Exemplar(String codigoUnico) {
        this.codigoUnico = codigoUnico;
        this.status = "disponível";
    }

    // Getters e Setters (Encapsulamento)
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}

class Livro {
    private String isbn;
    private String titulo;
    private String autor;
    private String editora;
    private List<Exemplar> exemplares; [span_19](start_span)// Composição[span_19](end_span)

    public Livro(String isbn, String titulo, String autor, String editora) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.exemplares = new ArrayList<>();
    }

    public void adicionarExemplar(String codigo) {
        exemplares.add(new Exemplar(codigo));
    }
}
//------------'zzzxxxzzzxzxzzzz--------
[span_20](start_span)// Serviço focado apenas em Empréstimos (SRP)[span_20](end_span)
class BibliotecaService {
    public void registrarEmprestimo(Usuario usuario, Exemplar exemplar) {
        if (exemplar.getStatus().equals("disponível")) {
            exemplar.setStatus("emprestado");
            System.out.println("Empréstimo realizado com sucesso!");
        }
    }
}

[span_21](start_span)// Serviço focado apenas em Multas (SRP)[span_21](end_span)
class MultaService {
    public void processarMulta(Usuario usuario, int dias) {
        double valor = usuario.calcularMulta(dias);
        System.out.println("Multa para " + usuario.nome + ": R$ " + valor);
    }
}


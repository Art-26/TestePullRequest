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

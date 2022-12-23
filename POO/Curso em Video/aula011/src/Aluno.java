public class Aluno extends Pessoa {
    private String matricula;
    private String curso;

    public void pagarMensalidade() {
        System.out.println("Mensalidade de " + this.getNome() + " paga com sucesso!");
    }

    // ================ Getters e Setters ================

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

}

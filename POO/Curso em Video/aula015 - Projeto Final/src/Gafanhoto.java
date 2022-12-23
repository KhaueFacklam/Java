public class Gafanhoto extends Pessoa {

    private String login;
    private Integer totalAssistido;

    public Gafanhoto(String nome, Integer idade, String sexo, String login) {
        super(nome, idade, sexo);
        this.login = login;
        this.setTotalAssistido(0);
    }

    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public Integer getTotalAssistido() {
        return totalAssistido;
    }
    public void setTotalAssistido(Integer totalAssistido) {
        this.totalAssistido = totalAssistido;
    }

    @Override
    public String toString() {
        return "Gafanhoto [" + super.toString() + "login = " + login + ", totalAssistido = " + totalAssistido + "]";
    }

    


    
}

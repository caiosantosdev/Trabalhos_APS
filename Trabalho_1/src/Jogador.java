

public class Jogador {

    private int poder;
    private String nome;
    private JogoSingleton jogo;

    public Jogador(int poder, String nome){
        this.poder = poder;
        this.nome = nome;
        this.jogo = JogoSingleton.getInstance();
    }
    public JogoSingleton getJogo() {
        return this.jogo;
    }
    public int getPoder(){
        return poder;
    }
    public String getNome(){
        return nome;
    }
    public void setPoder(int poder){
        this.poder = poder;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    // O poder do jogador evolui de 1 em 1
     public void evoluirPoder(){
        this.poder++;
    }

}
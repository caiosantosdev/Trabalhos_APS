

public class Jogador {

    private int poder;
    private String nome;

    public Jogador(int poder, String nome){
        this.poder = poder;
        this.nome = nome;
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

     public void evoluirPoder(){
        this.poder++;
    }

    // public void exibirPoder(){
    //     System.out.println("Poder do jogador: "+ poder);
    // }
      
}
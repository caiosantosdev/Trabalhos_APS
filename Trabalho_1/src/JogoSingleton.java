
public class JogoSingleton {
    private static JogoSingleton jogo;

    private int quantidadeMonstros;
    private int quantidadeMonstrosVivos;
    private int fase;


    private JogoSingleton(){
        quantidadeMonstros = 2;
        quantidadeMonstrosVivos = quantidadeMonstros;
        fase = 1;
        
    }

    public static JogoSingleton getInstance(){
        if(jogo == null){
            jogo = new JogoSingleton();
            return jogo;
        }else{
            return jogo;
        }
    }

    // A qtd de monstros que o jogador mata é a qtd de seu poder
    public void matarMonstro (int poder){
        this.quantidadeMonstrosVivos -= poder;
    }

    // Ao passar de fase, a quantidade de monstros a serem derrotados é o dobro da qtd de monstros da fase passada
    public void passarFase() {
        this.fase++;
        this.quantidadeMonstros*=2;
        this.quantidadeMonstrosVivos = quantidadeMonstros;
    }

    public int getFase(){
        return this.fase;
    }
    public int getQuantidadeMonstrosVivos(){
        return this.quantidadeMonstrosVivos;
    }

}

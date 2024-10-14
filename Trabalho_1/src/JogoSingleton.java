
public class JogoSingleton {
    private static JogoSingleton jogo;

    private int quantidadeMonstros;
    private int quantidadeMonstrosVivos;
    private int fase;


    private JogoSingleton(){
        quantidadeMonstros = 2;
        quantidadeMonstrosVivos = quantidadeMonstros;
        fase = 1;
        // logica para criar o objeto jogo
    }

    public static JogoSingleton getInstance(){
        if(jogo == null){
            jogo = new JogoSingleton();
            return jogo;
        }else{
            return jogo;
        }
    }

    public void matarMonstro (int poder){
        this.quantidadeMonstrosVivos -= poder;
    }

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

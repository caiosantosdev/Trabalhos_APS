import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        int criacoes = 0;
        int escolha;
        JogoSingleton jogo = JogoSingleton.getInstance();
        Jogador jogador1 = null;
        Jogador jogador2 = null;

        do{
            escolha = outGameMenu();
            switch (escolha) {
                case 0:
                    quitMessage();
                    System.exit(1);
                case 1: 
                    if(jogador1 != null){
                        System.out.println("\n\n\n");
                        System.err.println("Jogador já criado");
                    } else{
                        jogador1 = new Jogador(1, "Um");
                        criacoes++;
                    }
                    break;
                case 2:
                    if(jogador2 != null) {
                        System.out.println("\n\n\n");
                        System.err.println("Jogador já criado");
                    } else{
                        jogador2 = new Jogador(1, "Dois");
                        criacoes++;
                    }
                    break;
                case 3:
                    tutorial();
                    try{
                        TimeUnit.SECONDS.sleep(2);

                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    break;
                default:
                    System.out.println("Pressinou tecla nao prevista, saindo do jogo...");
                    System.exit(0);
                    break;
            }
            // if(escolha == 0) {
            //     return;
            // }
        }while(escolha != 0 && criacoes <= 1);

        Jogador jogadores[] = {jogador1, jogador2};
        int turno = 1;
        do{
            int escolhaInGame;
            escolhaInGame = inGameMenu(jogadores[turno - 1]);
            switch (escolhaInGame) {
                case 0:
                    quitMessage();
                    System.exit(1);
                    break;
                case 1:
                    int poder = jogadores[turno - 1].getPoder();
                    jogo.matarMonstro(poder);
                    break;
                case 2:
                    jogadores[turno - 1].evoluirPoder();
                    break;
                default:
                    System.out.println("\nEscolha uma opcao valida!!");
                    break;
            }

            turno = trocarTurno(turno);
            //verificar se fase acabou
            if (jogo.getQuantidadeMonstrosVivos() <= 0){
                jogo.passarFase();
            }
            //verificar se jogo acabou
            if(jogo.getFase() > 5){
                endGameMessage();
                System.exit(1);
            }
        }while(escolha != 0);
    }   

    public static void tutorial(){
        System.out.println("============CEFET ADVENTURE===========\n");
        System.out.println("Cada jogador em seu turno poderá escolher entre matar inimigos ou evoluir seu poder\n");
        try{ TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println("Seu poder comeca em 1\n");
        try{ TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println("Evoluindo seu poder, você mata mais inimigos de uma só vez\n.");
        try{ TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println("O poder evolui de 1 em 1\n");
        try{ TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println("Crie o jogador 1 e o jogador 2 para comecar.\n");
    }
    public static int outGameMenu(){
        System.out.println("============CEFET ADVENTURE===========\n");
        System.out.println("1 - Criar jogador 1\n"); //cria instancia do jogador 1
        System.out.println("2 - Criar jogador 2\n"); //cria instancia do jogador 2
        System.out.println("3 - Tutorial\n");
        System.err.println("0 - Sair do Jogo\n");
        int escolha;
        Scanner scan = new Scanner(System.in);
        
        escolha = scan.nextInt();
        
        return escolha;
    }
    public static int trocarTurno(int turno){
        return (turno == 1) ? 2 : 1;
    }
    public static void quitMessage(){
        System.out.println("\n\n\n\n\n");
        System.err.println("==============CEFET ADVENTURE===============\n");
        System.out.println("Você fechou o jogo...\n");
        System.out.println("Te vejo na próxima!\n");
    }
    public static int inGameMenu(Jogador jogadorAtual){
        int escolha;
        Scanner scan = new Scanner(System.in);
        System.out.println("\n\n\n\n\n");
        System.err.println("==============CEFET ADVENTURE===============\n");
        System.out.println("Vez do jogador: " + jogadorAtual.getNome());
        System.out.println("Fase atual: " + jogadorAtual.getJogo().getFase() + "\n");
        System.out.println("Monstros vivos: " + jogadorAtual.getJogo().getQuantidadeMonstrosVivos() + "\n");
        System.out.println("Seu poder : " + jogadorAtual.getPoder());
        System.out.println("1 - Matar Monstro\n");
        System.out.println("2 - Aumentar poder\n");
        System.out.println("0 - Sair do jogo\n");
        escolha = scan.nextInt();
        
        return escolha;
    }
    public static void endGameMessage(){
        System.out.println("\n\n\n\n\n\n\n\n");
        System.out.println("==================FIM DE JOGO=============");
        System.out.println("Parabens! Voces venceram todos os inimigos!");
    }
}

import java.util.Arrays;
import java.util.Scanner;

public class Jogo {
    // Jogar
    // 0 Humano
    // 1 Bot
    int turno;
    int quemInicia;
    int inicio = 0;
    int vitoriaHumano;
    int vitoriaBot;
    int decisaoHumano;
    int decisaoBot;
    int decisaoCarta;
    int numCartas = 2;
    int numCartasHum = 2;

    Baralho.Carta cartaHumano;
    Baralho.Carta cartaBot;
    Baralho.Carta[] maoHumano;
    Baralho.Carta[] maoBot;
    Scanner sc = new Scanner(System.in);


    @Override
    public String toString() {
        return "Jogo{" +
                "maoHumano=" + Arrays.toString(maoHumano) +
                ", maoBot=" + Arrays.toString(maoBot) +
                '}';
    }

    public void jogar(Player player1, Player player2) {
        this.turno = 0;
        this.quemInicia = 0;
        boolean terminou = false;
        while (terminou == false) {

            // Código para decidir número de jogadas, com o humano decidindo primeiro
            if (quemInicia == 0) {
                System.out.println("Jogador Humano: " + Arrays.toString((player1.getMao())));
                System.out.println("Quantas vezes você acha que consegue ganhar, 0,1,2 ou 3");
                decisaoHumano = 0;
                decisaoHumano = sc.nextInt();
                System.out.println("Vez do bot decidir, aguarde...");
                maoHumano = player1.getMao();
                maoBot = player2.getMao();
                decisaoBot = 0;

                // Procurar a cartas altas acima do valor 7 e contabiliza para a escolha
                for (int a = 0; a < maoBot.length; a++) {
                    if (maoBot[a].getValores().getValorNumerico() > 7) {
                        decisaoBot = decisaoBot + 1;
                        // Caso a decisão seja inválido, vai procurar as maiores de 5 para contabilizar
                    } else if (decisaoHumano + decisaoBot == 3) {
                        decisaoBot = 0;
                        for (int i = 0; i < maoBot.length; i++) {
                            if (maoBot[i].getValores().getValorNumerico() > 5) {
                                decisaoBot = decisaoBot + 1;
                            }
                        }
                    }
                    // Caso ainda seja inválido ele vai diminuir uma da escolha ou aumentar uma da escolha
                    else if (decisaoHumano + decisaoBot == 3) {
                        boolean se = false;
                        if (decisaoBot >= 1) {
                            decisaoBot = decisaoBot - 1;
                            se = true;
                        }
                        if (decisaoBot == 0 && se == false) {
                            decisaoBot = 1;
                        }
                    } else {
                        continue;
                    }
                }
                System.out.println("========================");
                System.out.println("Decisão de vezes do Bot: " + decisaoBot);
                System.out.println("Decisão de vezes do Humano: " + decisaoHumano);
                System.out.println("========================");
            }

            // if(quemInicio == 1) para colocar o bot para começar decidindo

            // Começar as rodadas do jogo
            for (int rodadas = 1; rodadas <= 3; rodadas++) {

                // Bot começa jogando
                if (inicio == 0) {


                    // Elaborar mais possibilidades de escolha de cartas
                    // Se for a primeira rodada o BOT vai pegar a primeira carta que tiver
                    if(rodadas == 1){
                        cartaBot = player2.getCartaVariavel(0);
                        player2.mao = player2.removerCartas(player2.getMao(), 0, numCartas);
                    }
                    if(decisaoBot >= 2 && vitoriaBot >= 2 && rodadas != 1){
                        // Carta baixa
                        cartaBot = player2.getMenorCarta();
                        if(numCartas != 0) {
                            int num = player2.encontrarIndice(player2.getMao(), player2.getMenorCarta());
                            player2.mao = player2.removerCartas(player2.getMao(), num, numCartas);
                            numCartas = numCartas - 1;
                        }
                    }
                    if (decisaoBot >= 2 && vitoriaBot <= 0 && rodadas != 1) {
                        // Carta alta
                        cartaBot = player2.getMaiorCarta();
                        if(numCartas != 0) {
                            int num = player2.encontrarIndice(player2.getMao(), player2.getMaiorCarta());
                            player2.mao = player2.removerCartas(player2.getMao(), num, numCartas);
                            numCartas = numCartas - 1;
                        }
                    }
                    if (decisaoBot == 1 && vitoriaBot == 1 && rodadas != 1) {
                        // Carta baixa
                        cartaBot = player2.getMenorCarta();
                        if(numCartas != 0) {
                            int num = player2.encontrarIndice(player2.getMao(), player2.getMenorCarta());
                            player2.mao = player2.removerCartas(player2.getMao(), num, numCartas);
                            numCartas = numCartas - 1;
                        }
                    }
                    if(decisaoBot == 1 && vitoriaBot == 0 && rodadas != 1){
                        // Carta alta
                        cartaBot = player2.getMaiorCarta();
                        if(numCartas != 0) {
                            int num = player2.encontrarIndice(player2.getMao(), player2.getMaiorCarta());
                            player2.mao = player2.removerCartas(player2.getMao(), num, numCartas);
                            numCartas = numCartas - 1;
                        }
                    }
                    if (decisaoBot == 0 && rodadas != 1) {
                        // Carta baixa
                        cartaBot = player2.getMenorCarta();
                        if(numCartas != 0) {
                            int num = player2.encontrarIndice(player2.getMao(), player2.getMenorCarta());
                            player2.mao = player2.removerCartas(player2.getMao(), num, numCartas);
                            numCartas = numCartas - 1;
                        }
                    }

                    System.out.println(rodadas + "° Rodada");
                    System.out.println("O Bot jogou na mesa a carta: " + cartaBot);
                    System.out.println("Você pode decidir entre essas suas cartas, na sequência, 1,2,3");
                    System.out.println(Arrays.toString(player1.getMao()));
                    decisaoCarta = sc.nextInt();
                    if (decisaoCarta == 1) {
                        cartaHumano = player1.getCartaVariavel(0);
                        player1.mao = player1.removerCartas(player1.getMao(), 0, numCartasHum);
                        numCartasHum = numCartasHum - 1;
                    }
                    if (decisaoCarta == 2) {
                        cartaHumano = player1.getCartaVariavel(1);
                        player1.mao = player1.removerCartas(player1.getMao(), 1, numCartasHum);
                        numCartasHum = numCartasHum - 1;
                    }
                    if (decisaoCarta == 3) {
                        cartaHumano = player1.getCartaVariavel(2);
                        player1.mao = player1.removerCartas(player1.getMao(), 2, numCartasHum);
                        numCartasHum = numCartasHum - 1;
                    }

                    System.out.println("========================");
                    System.out.println("Cartas jogadas na mesa:");
                    System.out.println("BOT: " + cartaBot);
                    System.out.println("Humano: " + cartaHumano);

                    if (cartaBot.getValores().getValorNumerico() >= cartaHumano.getValores().getValorNumerico()){
                        if(cartaBot.getValores().getValorNumerico() == cartaHumano.getValores().getValorNumerico()){
                            if(cartaBot.getNaipe().getValor() > cartaHumano.getNaipe().getValor()){
                                System.out.println("O Bot venceu a rodada!");
                                vitoriaBot = vitoriaBot + 1;
                                inicio = 0;
                            }
                            else{
                                System.out.println("O Humano venceu a rodada");
                                vitoriaHumano = vitoriaHumano + 1;
                                inicio = 1;
                                continue; // Vai pular o restante do código e pular pra próxima rodada
                            }
                        }
                        if(cartaBot.getValores().getValorNumerico() > cartaHumano.getValores().getValorNumerico()){
                            System.out.println("O Bot venceu a rodada!");
                            vitoriaBot = vitoriaBot + 1;
                            inicio = 0;
                        }
                    } else {
                        System.out.println("O Humano venceu a rodada");
                        vitoriaHumano = vitoriaHumano + 1;
                        inicio = 1;
                        continue; // Vai pular o restante do código e pular pra próxima rodada
                    }
                    System.out.println("========================");
                }


                // Humano começa jogando
                if (inicio == 1) {
                    System.out.println("========================");
                    System.out.println(rodadas + "° Rodada");
                    System.out.println("Você pode decidir entre essas suas cartas, na sequência, 1,2,3");
                    System.out.println(Arrays.toString(player1.getMao()));
                    decisaoCarta = sc.nextInt();
                    if (decisaoCarta == 1) {
                        cartaHumano = player1.getCartaVariavel(0);
                        player1.mao = player1.removerCartas(player1.getMao(), 0, numCartasHum);
                        numCartasHum = numCartasHum - 1;
                    }
                    if (decisaoCarta == 2) {
                        cartaHumano = player1.getCartaVariavel(1);
                        player1.mao = player1.removerCartas(player1.getMao(), 1, numCartasHum);
                        numCartasHum = numCartasHum - 1;
                    }
                    if (decisaoCarta == 3) {
                        cartaHumano = player1.getCartaVariavel(1);
                        player1.mao = player1.removerCartas(player1.getMao(), 2, numCartasHum);
                        numCartasHum = numCartasHum - 1;
                    }
                    System.out.println("========================");


                    // Decisão de carta para jogar do BOT
                    if(decisaoBot >= 2 && vitoriaBot >= 2 && rodadas != 1){
                        // Carta baixa
                        cartaBot = player2.getMenorCarta();
                        if(numCartas != 0) {
                            int num = player2.encontrarIndice(player2.getMao(), player2.getMenorCarta());
                            player2.mao = player2.removerCartas(player2.getMao(), num, numCartas);
                            numCartas = numCartas - 1;
                        }
                    }
                    if (decisaoBot >= 2 && vitoriaBot <= 0 && rodadas != 1) {
                        // Carta alta
                        cartaBot = player2.getMaiorCarta();
                        if(numCartas != 0) {
                            int num = player2.encontrarIndice(player2.getMao(), player2.getMaiorCarta());
                            player2.mao = player2.removerCartas(player2.getMao(), num, numCartas);
                            numCartas = numCartas - 1;
                        }

                    }
                    if (decisaoBot == 1 && vitoriaBot == 1 && rodadas != 1) {
                        // Carta baixa
                        cartaBot = player2.getMenorCarta();
                        if(numCartas != 0) {
                            int num = player2.encontrarIndice(player2.getMao(), player2.getMenorCarta());
                            player2.mao = player2.removerCartas(player2.getMao(), num, numCartas);
                            numCartas = numCartas - 1;
                        }
                    }
                    if(decisaoBot == 1 && vitoriaBot == 0 && rodadas != 1){
                        // Carta alta
                        cartaBot = player2.getMaiorCarta();
                        if(numCartas != 0) {
                            int num = player2.encontrarIndice(player2.getMao(), player2.getMaiorCarta());
                            player2.mao = player2.removerCartas(player2.getMao(), num, numCartas);
                            numCartas = numCartas - 1;
                        }
                    }
                    if (decisaoBot == 0 && rodadas != 1) {
                        // Carta baixa
                        cartaBot = player2.getMenorCarta();
                        if(numCartas != 0) {
                            int num = player2.encontrarIndice(player2.getMao(), player2.getMenorCarta());
                            player2.mao = player2.removerCartas(player2.getMao(), num, numCartas);
                            numCartas = numCartas - 1;
                        }
                    }
                    //System.out.println("O Bot jogou na mesa a carta: " + cartaBot);


                    System.out.println("========================");
                    System.out.println("Cartas jogadas na mesa:");
                    System.out.println("BOT: " + cartaBot);
                    System.out.println("Humano: " + cartaHumano);

                    if (cartaBot.getValores().getValorNumerico() >= cartaHumano.getValores().getValorNumerico()){
                        if(cartaBot.getValores().getValorNumerico() == cartaHumano.getValores().getValorNumerico()){
                            if(cartaBot.getNaipe().getValor() > cartaHumano.getNaipe().getValor()){
                                System.out.println("O Bot venceu a rodada!");
                                vitoriaBot = vitoriaBot + 1;
                                inicio = 0;
                            }
                            else{
                                System.out.println("O Humano venceu a rodada");
                                vitoriaHumano = vitoriaHumano + 1;
                                inicio = 1;
                                continue; // Vai pular o restante do código e pular pra próxima rodada
                            }
                        }
                        if(cartaBot.getValores().getValorNumerico() > cartaHumano.getValores().getValorNumerico()){
                            System.out.println("O Bot venceu a rodada!");
                            vitoriaBot = vitoriaBot + 1;
                            inicio = 0;
                        }
                    } else {
                        System.out.println("O Humano venceu a rodada");
                        vitoriaHumano = vitoriaHumano + 1;
                        inicio = 1;
                        continue; // Vai pular o restante do código e pular pra próxima rodada
                    }
                    System.out.println("========================");
                }



            } // Final do While
            System.out.println("========================");
            System.out.println("O Humano ganhou rodadas: " + vitoriaHumano + " vezes");
            System.out.println("O Bot ganhou rodadas: " + vitoriaBot + " vezes");
            if (decisaoBot == vitoriaBot) {
                System.out.println("O bot venceu e o humano perdeu");
            }
            if (decisaoHumano == vitoriaHumano) {
                System.out.println("O humano venceu e o bot perdeu");
            }
            else {
                System.out.println("Ambos perderam");
            }

            terminou = true;
        }

    }
}










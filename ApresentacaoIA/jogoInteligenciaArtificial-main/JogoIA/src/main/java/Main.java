public class Main {

    public static void main(String[] args) {
        Baralho deck = new Baralho();
        deck.embaralhar();
        Baralho.Carta cartaVira = deck.getVira();
        Baralho.Carta[] mao1 = {deck.getCarta(), deck.getCarta(), deck.getCarta()};
        Baralho.Carta[] mao2 = {deck.getCarta(), deck.getCarta(), deck.getCarta()};
        Player player1 = new Player(mao1);
        Player player2 = new Player(mao2);
        System.out.println("Carta vira: " + cartaVira);
        System.out.println("==========================");
        Jogo partida = new Jogo();
        partida.jogar(player1, player2);
    }

}

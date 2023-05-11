import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baralho {

    public enum Naipes {
        MOLES(1, "♦"), ESPADAS(2, "♠"), COPAS(3, "♥"), PAUS(4, "♣");

        private int valorNaipe;
        private String simbolo;

        private Naipes(int valor, String s) {
            this.valorNaipe = valor;
            this.simbolo = s;

        }

        public String getSimbolo() {
            return simbolo;
        }

        public int getValor() {
            return valorNaipe;
        }
    }

    public enum Valores {
        QUATRO(1), CINCO(2), SEIS(3), SETE(4), DEZ(5), ONZE(6), DOZE(7), UM(8), DOIS(9), TRÊS(10);

        private int valorNumerico;

        private Valores(int valor) {
            this.valorNumerico = valor;
        }

        public void setValorNumerico(int valor) {
            this.valorNumerico = valor;
        }

        public int getValorNumerico() {
            return valorNumerico;
        }
        public static Valores isValor(int n1) {
            for (Valores valores : Valores.values()) {
                if (valores.getValorNumerico() == n1) {
                    return valores;
                }
            }
            throw new IllegalArgumentException("Valor inválido: " + n1);
        }
    }

    public class Carta {
        private Naipes naipes;
        private Valores valores;

        public Carta(Naipes naipes, Valores valores) {
            this.naipes = naipes;
            this.valores = valores;
        }

        public Naipes getNaipe() {
            return naipes;
        }

        public Valores getValores() {
            return valores;
        }

        @Override
        public String toString() {
            String v = String.valueOf(valores);
            int c = v.length();
            int nC = 7 - c;
            String espacos = "";
            for (int i = 0; i < nC; i++) {
                espacos += " ";
            }
            return "\n" + valores + " de " + naipes +
                    "\n" + "┌────────┐\n" +
                    "│" + naipes.simbolo + "       │\n" +
                    "│\t     │\n" +
                    "│" + valores + espacos +" │\n"  +
                    "│        │\n" +
                    "│\t    "+ naipes.simbolo + "│\n" +
                    "└────────┘";

           // return valores + " de " + naipes.simbolo + " valor " + valores.getValorNumerico() + " naipe " + naipes.getValor();
        }
    }

    private List<Carta> deck;

    public Baralho() {
        deck = new ArrayList<>();
        for (Naipes naipes : Naipes.values()) {
            for (Valores valores : Valores.values()) {
                deck.add(new Carta(naipes, valores));
            }
        }
    }


    @Override
    public String toString() {
        return "CardDeck{" +
                "deck=" + deck +
                '}';
    }

    public Carta getCarta() {
        return deck.remove(0);
    }

    public void embaralhar() {
        Collections.shuffle(deck);
    }

    public Carta getVira() {
        Carta cartaVira = deck.get(0);
        int a = cartaVira.getValores().getValorNumerico();
        if (a == 10){
            Valores valores = Valores.isValor(1);
            valores.setValorNumerico(11);
        }
        else {
            Valores valores = Valores.isValor(a + 1);
            valores.setValorNumerico(11);
        }
        deck.remove(getCarta());
        return cartaVira;

    }

}


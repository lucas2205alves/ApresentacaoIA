public class Player {

    private int numVidas = 3;
    public Baralho.Carta[] mao;
    // CONSTRUTOR

    public Player(Baralho.Carta[] mao) {
        this.mao = mao;
    }

    // GETTERS E SETTERS
    public int getNumVidas() {
        return numVidas;
    }

    public void setNumVidas(int numVidas) {
        this.numVidas = numVidas;
    }

    public Baralho.Carta[] getMao() {
        return mao;
    }
    public Baralho.Carta getCartaVariavel(int i) {
        return mao[i];
    }


    public void setMao(Baralho.Carta[] mao) {
        this.mao = mao;
    }
    public Baralho.Carta[] removerCartas(Baralho.Carta[] mao, int index, int num) {
        this.mao = mao;
        Baralho.Carta[] clone = new Baralho.Carta[num];
        for (int i = 0, j = 0; i < mao.length; i++) {
            if (i != index)
                clone[j++] = this.mao[i];
        }
        return clone;
    }

    public int encontrarIndice(Baralho.Carta[] mao, Baralho.Carta valor) {
        this.mao = mao;
        for (int i = 0; i < mao.length; i++) {
            if (valor == mao[i]) {
                return i;
            }
        }
        return 0;
    }


    public Baralho.Carta getMaiorCarta() {
        Baralho.Carta maiorCarta = mao[0];
        for (int i = 0; i < mao.length; i++){
            if(mao[i] == null){
                continue;
            }
            if (mao[i].getNaipe() == Baralho.Naipes.PAUS) {
                if (mao[i].getValores().getValorNumerico() > maiorCarta.getValores().getValorNumerico()) {
                    maiorCarta = mao[i];
                }
            }
            if (mao[i].getNaipe() == Baralho.Naipes.COPAS) {
                if (mao[i].getValores().getValorNumerico() > maiorCarta.getValores().getValorNumerico()){
                    maiorCarta = mao[i];
                }
            }
            if (mao[i].getNaipe() == Baralho.Naipes.ESPADAS) {
                if (mao[i].getValores().getValorNumerico() > maiorCarta.getValores().getValorNumerico()) {
                    maiorCarta = mao[i];
                }
            }
            if (mao[i].getNaipe() == Baralho.Naipes.MOLES) {
                if (mao[i].getValores().getValorNumerico() > maiorCarta.getValores().getValorNumerico()) {
                    maiorCarta = mao[i];
                }
            }


        }

        return maiorCarta;
    }

    public Baralho.Carta getMenorCarta() {
        Baralho.Carta menorCarta = mao[0];
        for (int i = 0; i < mao.length; i++){
            if(mao[i] == null){
                continue;
            }
            if (mao[i].getNaipe() == Baralho.Naipes.MOLES) {
                if (mao[i].getValores().getValorNumerico() < menorCarta.getValores().getValorNumerico()) {
                    menorCarta = mao[i];
                }
            }
            if (mao[i].getNaipe() == Baralho.Naipes.ESPADAS) {
                if (mao[i].getValores().getValorNumerico() < menorCarta.getValores().getValorNumerico()){
                    menorCarta = mao[i];
                }
            }
            if (mao[i].getNaipe() == Baralho.Naipes.COPAS) {
                if (mao[i].getValores().getValorNumerico() < menorCarta.getValores().getValorNumerico()) {
                    menorCarta = mao[i];
                }
            }
            if (mao[i].getNaipe() == Baralho.Naipes.PAUS) {
                if (mao[i].getValores().getValorNumerico() < menorCarta.getValores().getValorNumerico()) {
                    menorCarta = mao[i];
                }
            }


        }

        return menorCarta;
    }

}


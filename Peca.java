import javax.swing.*;
/**
 * Representa uma Pe�a do jogo.
 * Possui uma casa e um tipo associado.
 * 
 * @author Alan Moraes &lt;alan@ci.ufpb.br&gt;
 * @author Leonardo Villeth &lt;lvilleth@cc.ci.ufpb.br&gt;
 */
public class Peca {

    public static final int TORRE_BRANCA = 0;
    public static final int TORRE_PRETA = 1;
    public static final int CAVALO_BRANCO = 2;
    public static final int CAVALO_PRETO = 3;
    public static final int BISPO_BRANCO = 4;
    public static final int BISPO_PRETO = 5;
    public static final int RAINHA_BRANCA = 6;
    public static final int RAINHA_PRETA = 7;
    public static final int REI_BRANCO = 8;
    public static final int REI_PRETO = 9;
    public static final int PEAO_BRANCO = 10;
    public static final int PEAO_PRETO = 11;

    private Casa casa;
    private int tipo;
    private boolean casaInicial = true;

    public Peca(Casa casa, int tipo) {
        this.casa = casa;
        this.tipo = tipo;
        casa.colocarPeca(this);
    }
    
    /**
     * Movimenta a peca para uma nova casa.
     * @param destino nova casa que ira conter esta peca.
     */
    public void mover(Casa destino) {
        casa.removerPeca();
        destino.colocarPeca(this);
        casa = destino;
    }
    
    /**
     * @return o valor da Casa Inicial
     * true - A peça ainda está na sua casa inicial
     * false - A peça não está na sua casa inicial
     * Esse metodo auxilia no movimento do peão
     */
    public boolean getCasaInicial(){
        return this.casaInicial;
    }
    
    /**
     * Define o valor da Casa Inicial para false,
     * assim podemos saber que a peça se moveu no tabuleiro.
     */
    public void setCasaInicial(){
        this.casaInicial = false;
    }
    
    /**
     * Verifica o deslocamento do peão na vertical
     */
    public boolean deslocamentoPeao(Peca peca, int deslocamentoY, Casa origem, Casa destino){
        if (peca.getTipo() == Peca.PEAO_BRANCO && deslocamentoY > 0){
            mover(destino);
            setCasaInicial();
            return true;
        } 
        else if (peca.getTipo() == Peca.PEAO_PRETO && deslocamentoY < 0){
            mover(destino);
            setCasaInicial();
            return true;
        }
        else {
            mover(origem);
            mostrarMensagem();
            return false;
        } 
    }
    
    /**
     * Faz com que o Peão capture uma peça
     */
    public boolean capturaPeao(Casa origem, Casa destino, int deslocamentoX, int deslocamentoY){
        if (destino.getPeca() != null){
            if (((destino.getPeca().getTipo() % 2) == 0) && ((origem.getPeca().getTipo() % 2) == 0)){
                mover(origem);
                mostrarMensagem();
                return false;
            } else if (((destino.getPeca().getTipo() % 2) != 0) && ((origem.getPeca().getTipo() % 2) != 0)){
                mover(origem);
                mostrarMensagem();
                return false;
            } else {
                if ((origem.getPeca().getTipo() == Peca.PEAO_BRANCO) && (deslocamentoX > 0) && (deslocamentoY > 0)){
                    mover(destino);
                    return true;
                } else if ((origem.getPeca().getTipo() == Peca.PEAO_BRANCO) && (deslocamentoX < 0) && (deslocamentoY > 0)){
                    mover(destino);
                    return true;
                } else if ((origem.getPeca().getTipo() == Peca.PEAO_PRETO) && (deslocamentoX > 0) && (deslocamentoY < 0)){
                    mover(destino);
                    return true;
                } else if ((origem.getPeca().getTipo() == Peca.PEAO_PRETO) && (deslocamentoX < 0) && (deslocamentoY < 0)){
                    mover(destino);
                    return true;
                } else {
                    mover(origem);
                    mostrarMensagem();
                    return false;
                }
            }
        } else {
            mover(origem);
            mostrarMensagem();
            return false;
        }
    }
    
    /**
     * Realiza do movimento do Peão
     */
    public boolean moverPeao(Peca peca, Casa origem, Casa destino){
        int deslocamentoX = destino.getCoordX() - origem.getCoordX();
        int deslocamentoY = destino.getCoordY() - origem.getCoordY();
        if (peca.getCasaInicial()){
            if ((deslocamentoX == 0) && (Math.abs(deslocamentoY) == 2)){
                if (destino.getPeca() == null) {
                    return deslocamentoPeao(peca, deslocamentoY, origem, destino);
                }
                else {
                    mostrarMensagem();
                    return false;
                }
            } else if ((deslocamentoX == 0) && (Math.abs(deslocamentoY) == 1)){
                if (destino.getPeca() == null) {
                    return deslocamentoPeao(peca, deslocamentoY, origem, destino);
                }
                else {
                    mostrarMensagem();
                    return false;
                }
            } else if ((Math.abs(deslocamentoX) == 1) && (Math.abs(deslocamentoY) == 1)){
                return capturaPeao(origem, destino, deslocamentoX, deslocamentoY);
            }
        } else {
            if ((deslocamentoX == 0) && (Math.abs(deslocamentoY) == 1)){
                if (destino.getPeca() == null) {
                    return deslocamentoPeao(peca, deslocamentoY, origem, destino);
                }
            }
            else if ((Math.abs(deslocamentoX) == 1) && (Math.abs(deslocamentoY) == 1)){
                return capturaPeao(origem, destino, deslocamentoX, deslocamentoY);
            } else {
                mostrarMensagem();
                return false;
            }
        }
        mostrarMensagem();
        return false;
    }
    
    
    
    /**
     * Realiza o movimento da Torre
     */
    public boolean moverTorre(Peca peca, int origemX, int origemY, int destinoX, int destinoY, Tabuleiro tabuleiro, Casa destino){
        int tipoPeca = peca.getTipo();
        boolean pecaNaFrente = false;
        
        if((destinoX == origemX) && (destinoY != origemY)) {
            if(destinoY > origemY){
                for(int i = origemY + 1; i < destinoY; i++){
                    if(tabuleiro.getCasa(origemX, i).possuiPeca() == true){
                        pecaNaFrente = true;
                    }
                }
                
                if(pecaNaFrente == false){
                    //Lógica para capturar a peça
                    if (destino.getPeca() != null){
                        if ((((destino.getPeca().getTipo() % 2) == 0) && ((peca.getTipo() % 2) == 0)) || 
                        (((destino.getPeca().getTipo() % 2) != 0) && ((peca.getTipo() % 2) != 0))){
                            peca.mover(tabuleiro.getCasa(origemX, origemY));
                            mostrarMensagem();
                            return false;
                        }
                        peca.mover(destino);
                        return true;
                    }
                    peca.mover(destino);
                    return true;                   
                }
                peca.mover(tabuleiro.getCasa(origemX, origemY));
                mostrarMensagem();
                return false;
            } else if(destinoY < origemY){
                for(int i = origemY - 1; i > destinoY; i--){
                    if(tabuleiro.getCasa(origemX, i).possuiPeca() == true){
                        pecaNaFrente = true;
                    }
                }
                
                if(pecaNaFrente == false){
                    //Lógica para capturar a peça
                    if (destino.getPeca() != null){
                        if ((((destino.getPeca().getTipo() % 2) == 0) && ((peca.getTipo() % 2) == 0)) || 
                        (((destino.getPeca().getTipo() % 2) != 0) && ((peca.getTipo() % 2) != 0))){
                            peca.mover(tabuleiro.getCasa(origemX, origemY));
                            mostrarMensagem();
                            return false;
                        }
                        peca.mover(destino);
                        return true;
                    }
                    peca.mover(destino);
                    return true;                   
                }
                peca.mover(tabuleiro.getCasa(origemX, origemY));
                mostrarMensagem();
                return false;
            }
            
        } else if ((destinoX != origemX) && (destinoY == origemY)){ 
            if(destinoX > origemX){
                for(int i = origemX + 1; i < destinoX; i++){
                    if(tabuleiro.getCasa(i, origemY).possuiPeca() == true) {
                        pecaNaFrente = true;
                    }

                }
                
                if(pecaNaFrente == false){
                    //Lógica para capturar a peça
                    if (destino.getPeca() != null){
                        if ((((destino.getPeca().getTipo() % 2) == 0) && ((peca.getTipo() % 2) == 0)) || 
                        (((destino.getPeca().getTipo() % 2) != 0) && ((peca.getTipo() % 2) != 0))){
                            peca.mover(tabuleiro.getCasa(origemX, origemY));
                            mostrarMensagem();
                            return false;
                        }
                        peca.mover(destino);
                        return true;
                    }
                    peca.mover(destino);
                    return true;                   
                }
                peca.mover(tabuleiro.getCasa(origemX, origemY));
                mostrarMensagem();
                return false;                
            } else if (destinoX < origemX){
                for(int i = origemX - 1; i > destinoX; i--){
                    if(tabuleiro.getCasa(i, origemY).possuiPeca() == true) {
                        pecaNaFrente = true;
                    }
                }
                
                if(pecaNaFrente == false){
                    //Lógica para capturar a peça
                    if (destino.getPeca() != null){
                        if ((((destino.getPeca().getTipo() % 2) == 0) && ((peca.getTipo() % 2) == 0)) || 
                        (((destino.getPeca().getTipo() % 2) != 0) && ((peca.getTipo() % 2) != 0))){
                            peca.mover(tabuleiro.getCasa(origemX, origemY));
                            mostrarMensagem();
                            return false;
                        }
                        peca.mover(destino);
                        return true;
                    }
                    peca.mover(destino);
                    return true;                   
                }
                peca.mover(tabuleiro.getCasa(origemX, origemY));
                mostrarMensagem();
                return false;
            }   
        }
        mostrarMensagem();
        return false;
    }
    
    /**
     * Realiza o movimento do Cavalo
     */
    public boolean moverCavalo(Casa destino) {
        double dist = Math.sqrt(Math.pow(destino.getX() - casa.getX(), 2) + Math.pow(destino.getY() - casa.getY(), 2));
        if (destino.getPeca() != null){
            if (((getTipo() % 2) == 0) && ((destino.getPeca().getTipo() % 2) == 0)){
                mostrarMensagem();
                return false;
            }
            else {
                mover(destino);
                return true;
            }
        }
        else if(dist == Math.sqrt(5)) {
            mover(destino);
                return true;
        }
        else {
            mostrarMensagem();
            return false;
        }
    }
    
    public void mostrarMensagem(){
        JOptionPane.showMessageDialog (null, "Posição inválida para a peça selecionada!");
    }

    /**
     * 0 - Torre Branca
     * 1 - Torre Preta
     * 2 - Cavalo Branco
     * 3 - Cavalo Preto
     * 4 - Bispo Branco
     * 5 - Bispo Preto
     * 6 - Rainha Branca
     * 7 - Rainha Preta
     * 8 - Rei Branco
     * 9 - Rei Preto
     * 10 - Peão Branco
     * 11 - Peão Preto
     * @return o tipo da peca.
     */
    public int getTipo() {
        return tipo;
    }
}

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
    
    public void moverCavalo(Casa destino) {
        double dist = Math.sqrt(Math.pow(destino.getX() - casa.getX(), 2) + Math.pow(destino.getY() - casa.getY(), 2));
        if(dist == Math.sqrt(5)) {
            mover(destino);
        }
        else {
            JOptionPane.showMessageDialog (null, "Posição inválida para o movimento do cavalo");
        }
    }
    
    public void moverBispo(Casa origem, Casa destino, Tabuleiro tabuleiro){
        int deslocamentoX = destino.getCoordX() - origem.getCoordX();
        int deslocamentoY = destino.getCoordY() - origem.getCoordY();
        if (deslocamentoX <= 0 && deslocamentoY >= 0){
            if ((deslocamentoX * -1) == deslocamentoY){
                int temPeca = 0;
                for (int x = 0; x < deslocamentoY;){
                    x++;
                    Casa casaAux = tabuleiro.getCasa(origem.getCoordX() - x, origem.getCoordY() + x);
                    if (casaAux.getPeca() != null){
                        if (casaAux == destino){
                            if (((casaAux.getPeca().getTipo() % 2) != 0) && ((origem.getPeca().getTipo() % 2) == 0)) {
                                System.out.println("Peça branca captura peça preta");
                                mover(destino);
                            } else if (((casaAux.getPeca().getTipo() % 2) == 0) && ((origem.getPeca().getTipo() % 2) != 0)) {
                                System.out.println("Peça preta captura peça branca");
                                mover(destino);
                            }
                            else {
                                mover(origem);
                            }
                        }
                        else {
                            temPeca++;
                            break;
                        }
                    }
                }
                if (temPeca != 0){
                    mover(origem);
                } else {
                    mover(destino);
                }
            }
        } else if (deslocamentoX >= 0 && deslocamentoY <=0){
            if (deslocamentoX == (deslocamentoY * -1)){
                int temPeca = 0;
                for (int x = 0; x < deslocamentoX;){
                    x++;
                    Casa casaAux = tabuleiro.getCasa(origem.getCoordX() + x, origem.getCoordY() - x);
                    if (casaAux.getPeca() != null){
                        if (casaAux == destino){
                            if (((casaAux.getPeca().getTipo() % 2) != 0) && ((getTipo() % 2) == 0)) {
                                mover(destino);
                            } else if (((casaAux.getPeca().getTipo() % 2) == 0) && ((getTipo() % 2) != 0)) {
                                mover(destino);
                            }
                            else {
                                mover(origem);
                            }
                        }
                        else {
                            temPeca++;
                            break;
                        }
                    }
                }
                if (temPeca != 0){
                    mover(origem);
                } else {
                    mover(destino);
                }
            }
        } else if (deslocamentoX >= 0 && deslocamentoY >= 0){
            if (deslocamentoX == deslocamentoY){
                int temPeca = 0;
                for (int x = 0; x < deslocamentoY;){
                    x++;
                    Casa casaAux = tabuleiro.getCasa(origem.getCoordX() + x, origem.getCoordY() + x);
                    if (casaAux.getPeca() != null){
                        if (casaAux == destino){
                            if (((casaAux.getPeca().getTipo() % 2) != 0) && ((getTipo() % 2) == 0)) {
                                mover(destino);
                            } else if (((casaAux.getPeca().getTipo() % 2) == 0) && ((getTipo() % 2) != 0)) {
                                mover(destino);
                            }
                            else {
                                mover(origem);
                            }
                        }
                        else {
                            temPeca++;
                            break;
                        }
                    }
                }
                if (temPeca != 0){
                    mover(origem);
                } else {
                    mover(destino);
                }
            }
        } else if (deslocamentoX <= 0 && deslocamentoY <= 0){
            if (deslocamentoX == deslocamentoY){
                int temPeca = 0;
                int yAux = deslocamentoY * -1;
                for (int x = 0; x < yAux;){
                    x++;
                    Casa casaAux = tabuleiro.getCasa(origem.getCoordX() - x, origem.getCoordY() - x);
                    if (casaAux.getPeca() != null){
                        if (casaAux == destino){
                            if (((casaAux.getPeca().getTipo() % 2) != 0) && ((getTipo() % 2) == 0)) {
                                mover(destino);
                            } else if (((casaAux.getPeca().getTipo() % 2) == 0) && ((getTipo() % 2) != 0)) {
                                mover(destino);
                            }
                            else {
                                mover(origem);
                            }
                        }
                        else {
                            temPeca++;
                            break;
                        }
                    }
                }
                if (temPeca != 0){
                    mover(origem);
                } else {
                    mover(destino);
                }
            }
        }
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


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
        //Sistema de captura das peças 
        if(destino.getPeca() != null){
            if((this.getTipo() % 2 == 0) && (destino.getPeca().getTipo() % 2 == 0)){
                return;
            }   else if ((this.getTipo () % 2 != 0) && (destino.getPeca().getTipo() % 2 != 0)){
                return;
            } 
        }
        casa.removerPeca();
        destino.colocarPeca(this);
        casa = destino;
    }

    /**
     * Se o valor for par a pedra será da cor branca, caso contrário será preto.
     * @return o tipo da peca.
     */
    public int getTipo() {
        return tipo;
    }
}

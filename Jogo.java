
/**
 * Armazena o tabuleiro e responsavel por posicionar as pecas.
 * 
 * @author Alan Moraes &lt;alan@ci.ufpb.br&gt;
 * @author Leonardo Villeth &lt;lvilleth@cc.ci.ufpb.br&gt;
 */
public class Jogo {

    private Tabuleiro tabuleiro;
    private int turno = 0;

    public Jogo() {
        tabuleiro = new Tabuleiro();
        criarPecas();
    }
    
    /**
     * Posiciona pe�as no tabuleiro.
     * Utilizado na inicializa�ao do jogo.
     */
    private void criarPecas() {
        // Peças Brancas
        Casa casaTorreBranca1 = tabuleiro.getCasa(0, 0);
        Peca pecaTorreBranca1 = new Torre(casaTorreBranca1, Peca.TORRE_BRANCA);
        
        Casa casaTorreBranca2 = tabuleiro.getCasa(7, 0);
        Peca pecaTorreBranca2 = new Torre(casaTorreBranca2, Peca.TORRE_BRANCA);
        
        Casa casaCavaloBranco1 = tabuleiro.getCasa(1, 0);
        Peca pecaCavaloBranco1 = new Cavalo(casaCavaloBranco1, Peca.CAVALO_BRANCO);
        
        Casa casaCavaloBranco2 = tabuleiro.getCasa(6, 0);
        Peca pecaCavaloBranco2 = new Cavalo(casaCavaloBranco2, Peca.CAVALO_BRANCO);
        
        Casa casaBispoBranco1 = tabuleiro.getCasa(2, 0);
        Peca pecaBispoBranco1 = new Bispo(casaBispoBranco1, Peca.BISPO_BRANCO);
        
        Casa casaBispoBranco2 = tabuleiro.getCasa(5, 0);
        Peca pecaBispoBranco2 = new Bispo(casaBispoBranco2, Peca.BISPO_BRANCO);
        
        Casa casaRainhaBranca = tabuleiro.getCasa(3, 0);
        Peca pecaRainhaBranca = new Rainha(casaRainhaBranca, Peca.RAINHA_BRANCA);
        
        Casa casaReiBranco = tabuleiro.getCasa(4, 0);
        Peca pecaReiBranco = new Rei(casaReiBranco, Peca.REI_BRANCO);
        
        Casa casaPeaoBranco1 = tabuleiro.getCasa(0, 1);
        Peca pecaPeaoBranco1 = new Peao(casaPeaoBranco1, Peca.PEAO_BRANCO);
        
        Casa casaPeaoBranco2 = tabuleiro.getCasa(1, 1);
        Peca pecaPeaoBranco2 = new Peao(casaPeaoBranco2, Peca.PEAO_BRANCO);
        
        Casa casaPeaoBranco3 = tabuleiro.getCasa(2, 1);
        Peca pecaPeaoBranco3 = new Peao(casaPeaoBranco3, Peca.PEAO_BRANCO);
        
        Casa casaPeaoBranco4 = tabuleiro.getCasa(3, 1);
        Peca pecaPeaoBranco4 = new Peao(casaPeaoBranco4, Peca.PEAO_BRANCO);
        
        Casa casaPeaoBranco5 = tabuleiro.getCasa(4, 1);
        Peca pecaPeaoBranco5 = new Peao(casaPeaoBranco5, Peca.PEAO_BRANCO);
        
        Casa casaPeaoBranco6 = tabuleiro.getCasa(5, 1);
        Peca pecaPeaoBranco6 = new Peao(casaPeaoBranco6, Peca.PEAO_BRANCO);
        
        Casa casaPeaoBranco7 = tabuleiro.getCasa(6, 1);
        Peca pecaPeaoBranco7 = new Peao(casaPeaoBranco7, Peca.PEAO_BRANCO);
        
        Casa casaPeaoBranco8 = tabuleiro.getCasa(7, 1);
        Peca pecaPeaoBranco8 = new Peao(casaPeaoBranco8, Peca.PEAO_BRANCO);

        // Peças Pretas
        Casa casaTorrePreta1 = tabuleiro.getCasa(0, 7);
        Peca pecaTorrePreta1 = new Torre(casaTorrePreta1, Peca.TORRE_PRETA);
        
        Casa casaTorrePreta2 = tabuleiro.getCasa(7, 7);
        Peca pecaTorrePreta2 = new Torre(casaTorrePreta2, Peca.TORRE_PRETA);
        
        Casa casaCavaloPreto1 = tabuleiro.getCasa(1, 7);
        Peca pecaCavaloPreto1 = new Cavalo(casaCavaloPreto1, Peca.CAVALO_PRETO);
        
        Casa casaCavaloPreto2 = tabuleiro.getCasa(6, 7);
        Peca pecaCavaloPreto2 = new Cavalo(casaCavaloPreto2, Peca.CAVALO_PRETO);
        
        Casa casaBispoPreto1 = tabuleiro.getCasa(2, 7);
        Peca pecaBispoPreto1 = new Bispo(casaBispoPreto1, Peca.BISPO_PRETO);
        
        Casa casaBispoPreto2 = tabuleiro.getCasa(5, 7);
        Peca pecaBispoPreto2 = new Bispo(casaBispoPreto2, Peca.BISPO_PRETO);
        
        Casa casaRainhaPreta = tabuleiro.getCasa(3, 7);
        Peca pecaRainhaPreta = new Rainha(casaRainhaPreta, Peca.RAINHA_PRETA);
        
        Casa casaReiPreto = tabuleiro.getCasa(4, 7);
        Peca pecaReiPreto = new Rei(casaReiPreto, Peca.REI_PRETO);
        
        Casa casaPeaoPreto1 = tabuleiro.getCasa(0, 6);
        Peca pecaPeaoPreto1 = new Peao(casaPeaoPreto1, Peca.PEAO_PRETO);
        
        Casa casaPeaoPreto2 = tabuleiro.getCasa(1, 6);
        Peca pecaPeaoPreto2 = new Peao(casaPeaoPreto2, Peca.PEAO_PRETO);
        
        Casa casaPeaoPreto3 = tabuleiro.getCasa(2, 6);
        Peca pecaPeaoPreto3 = new Peao(casaPeaoPreto3, Peca.PEAO_PRETO);
        
        Casa casaPeaoPreto4 = tabuleiro.getCasa(3, 6);
        Peca pecaPeaoPreto4 = new Peao(casaPeaoPreto4, Peca.PEAO_PRETO);
        
        Casa casaPeaoPreto5 = tabuleiro.getCasa(4, 6);
        Peca pecaPeaoPreto5 = new Peao(casaPeaoPreto5, Peca.PEAO_PRETO);
        
        Casa casaPeaoPreto6 = tabuleiro.getCasa(5, 6);
        Peca pecaPeaoPreto6 = new Peao(casaPeaoPreto6, Peca.PEAO_PRETO);
        
        Casa casaPeaoPreto7 = tabuleiro.getCasa(6, 6);
        Peca pecaPeaoPreto7 = new Peao(casaPeaoPreto7, Peca.PEAO_PRETO);
        
        Casa casaPeaoPreto8 = tabuleiro.getCasa(7, 6);
        Peca pecaPeaoPreto8 = new Peao(casaPeaoPreto8, Peca.PEAO_PRETO);
    }

    /**
    * Muda o turno do jogo
    * Quando o turno for igual a zero, é a vez das brancas
    * Caso contrário, é a vez das pretas
    */
    public void mudarTurno(){
        if (turno == 0){
            turno = 1;
        } else {
            turno = 0;
        }
    }
    
    /**
     * Comanda uma Pe�a na posicao (origemX, origemY) fazer um movimento 
     * para (destinoX, destinoY).
     * 
     * @param origemX linha da Casa de origem.
     * @param origemY coluna da Casa de origem.
     * @param destinoX linha da Casa de destino.
     * @param destinoY coluna da Casa de destino.
     * 
     * @return 1 - Movimento realizado
     * @return 2 - Movimento inválido
     * @return 3 - Vez das brancas
     * @return 4 - Vez das pretas
     */
    public int moverPeca(int origemX, int origemY, int destinoX, int destinoY) {
        Casa origem = tabuleiro.getCasa(origemX, origemY);
        Casa destino = tabuleiro.getCasa(destinoX, destinoY);
        Peca peca = origem.getPeca();
        if (turno == 0 && ((peca.getTipo() % 2) == 0)){
            if (peca.moverPeca(origem, destino, tabuleiro)){
                mudarTurno();
                return 1;
            } else {
                return 2;
            }   
        } else if (turno == 1 && ((peca.getTipo() % 2) != 0)) {
            if (peca.moverPeca(origem, destino, tabuleiro)){
                mudarTurno();
                return 1;
            } else {
                return 2;
            }
        } else if (turno == 0 && ((peca.getTipo() % 2) != 0)) {
            return 3;
        }
        else {
            return 4;
        }
    }
    
    /**
     * @return o Tabuleiro em jogo.
     */
    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }
}

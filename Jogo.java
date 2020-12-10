
/**
 * Armazena o tabuleiro e responsavel por posicionar as pecas.
 * 
 * @author Alan Moraes &lt;alan@ci.ufpb.br&gt;
 * @author Leonardo Villeth &lt;lvilleth@cc.ci.ufpb.br&gt;
 */
public class Jogo {

    private Tabuleiro tabuleiro;

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
        Peca pecaTorreBranca1 = new Peca(casaTorreBranca1, Peca.TORRE_BRANCA);
        
        Casa casaTorreBranca2 = tabuleiro.getCasa(7, 0);
        Peca pecaTorreBranca2 = new Peca(casaTorreBranca2, Peca.TORRE_BRANCA);
        
        Casa casaCavaloBranco1 = tabuleiro.getCasa(1, 0);
        Peca pecaCavaloBranco1 = new Peca(casaCavaloBranco1, Peca.CAVALO_BRANCO);
        
        Casa casaCavaloBranco2 = tabuleiro.getCasa(6, 0);
        Peca pecaCavaloBranco2 = new Peca(casaCavaloBranco2, Peca.CAVALO_BRANCO);
        
        Casa casaBispoBranco1 = tabuleiro.getCasa(2, 0);
        Bispo pecaBispoBranco1 = new Bispo(casaBispoBranco1, Bispo.BISPO_BRANCO);
        
        Casa casaBispoBranco2 = tabuleiro.getCasa(5, 0);
        Bispo pecaBispoBranco2 = new Bispo(casaBispoBranco2, Bispo.BISPO_BRANCO);
        
        Casa casaRainhaBranca = tabuleiro.getCasa(3, 0);
        Rainha pecaRainhaBranca = new Rainha(casaRainhaBranca, Rainha.RAINHA_BRANCA);
        
        Casa casaReiBranco = tabuleiro.getCasa(4, 0);
        Rei pecaReiBranco = new Rei(casaReiBranco, Rei.REI_BRANCO);
        
        Casa casaPeaoBranco1 = tabuleiro.getCasa(0, 1);
        Peca pecaPeaoBranco1 = new Peca(casaPeaoBranco1, Peca.PEAO_BRANCO);
        
        Casa casaPeaoBranco2 = tabuleiro.getCasa(1, 1);
        Peca pecaPeaoBranco2 = new Peca(casaPeaoBranco2, Peca.PEAO_BRANCO);
        
        Casa casaPeaoBranco3 = tabuleiro.getCasa(2, 1);
        Peca pecaPeaoBranco3 = new Peca(casaPeaoBranco3, Peca.PEAO_BRANCO);
        
        Casa casaPeaoBranco4 = tabuleiro.getCasa(3, 1);
        Peca pecaPeaoBranco4 = new Peca(casaPeaoBranco4, Peca.PEAO_BRANCO);
        
        Casa casaPeaoBranco5 = tabuleiro.getCasa(4, 1);
        Peca pecaPeaoBranco5 = new Peca(casaPeaoBranco5, Peca.PEAO_BRANCO);
        
        Casa casaPeaoBranco6 = tabuleiro.getCasa(5, 1);
        Peca pecaPeaoBranco6 = new Peca(casaPeaoBranco6, Peca.PEAO_BRANCO);
        
        Casa casaPeaoBranco7 = tabuleiro.getCasa(6, 1);
        Peca pecaPeaoBranco7 = new Peca(casaPeaoBranco7, Peca.PEAO_BRANCO);
        
        Casa casaPeaoBranco8 = tabuleiro.getCasa(7, 1);
        Peca pecaPeaoBranco8 = new Peca(casaPeaoBranco8, Peca.PEAO_BRANCO);

        // Peças Pretas
        Casa casaTorrePreta1 = tabuleiro.getCasa(0, 7);
        Peca pecaTorrePreta1 = new Peca(casaTorrePreta1, Peca.TORRE_PRETA);
        
        Casa casaTorrePreta2 = tabuleiro.getCasa(7, 7);
        Peca pecaTorrePreta2 = new Peca(casaTorrePreta2, Peca.TORRE_PRETA);
        
        Casa casaCavaloPreto1 = tabuleiro.getCasa(1, 7);
        Peca pecaCavaloPreto1 = new Peca(casaCavaloPreto1, Peca.CAVALO_PRETO);
        
        Casa casaCavaloPreto2 = tabuleiro.getCasa(6, 7);
        Peca pecaCavaloPreto2 = new Peca(casaCavaloPreto2, Peca.CAVALO_PRETO);
        
        Casa casaBispoPreto1 = tabuleiro.getCasa(2, 7);
        Bispo pecaBispoPreto1 = new Bispo(casaBispoPreto1, Bispo.BISPO_PRETO);
        
        Casa casaBispoPreto2 = tabuleiro.getCasa(5, 7);
        Bispo pecaBispoPreto2 = new Bispo(casaBispoPreto2, Bispo.BISPO_PRETO);
        
        Casa casaRainhaPreta = tabuleiro.getCasa(3, 7);
        Rainha pecaRainhaPreta = new Rainha(casaRainhaPreta, Rainha.RAINHA_PRETA);
        
        Casa casaReiPreto = tabuleiro.getCasa(4, 7);
        Rei pecaReiPreto = new Rei(casaReiPreto, Peca.REI_PRETO);
        
        Casa casaPeaoPreto1 = tabuleiro.getCasa(0, 6);
        Peca pecaPeaoPreto1 = new Peca(casaPeaoPreto1, Peca.PEAO_PRETO);
        
        Casa casaPeaoPreto2 = tabuleiro.getCasa(1, 6);
        Peca pecaPeaoPreto2 = new Peca(casaPeaoPreto2, Peca.PEAO_PRETO);
        
        Casa casaPeaoPreto3 = tabuleiro.getCasa(2, 6);
        Peca pecaPeaoPreto3 = new Peca(casaPeaoPreto3, Peca.PEAO_PRETO);
        
        Casa casaPeaoPreto4 = tabuleiro.getCasa(3, 6);
        Peca pecaPeaoPreto4 = new Peca(casaPeaoPreto4, Peca.PEAO_PRETO);
        
        Casa casaPeaoPreto5 = tabuleiro.getCasa(4, 6);
        Peca pecaPeaoPreto5 = new Peca(casaPeaoPreto5, Peca.PEAO_PRETO);
        
        Casa casaPeaoPreto6 = tabuleiro.getCasa(5, 6);
        Peca pecaPeaoPreto6 = new Peca(casaPeaoPreto6, Peca.PEAO_PRETO);
        
        Casa casaPeaoPreto7 = tabuleiro.getCasa(6, 6);
        Peca pecaPeaoPreto7 = new Peca(casaPeaoPreto7, Peca.PEAO_PRETO);
        
        Casa casaPeaoPreto8 = tabuleiro.getCasa(7, 6);
        Peca pecaPeaoPreto8 = new Peca(casaPeaoPreto8, Peca.PEAO_PRETO);
    }
    
    /**
     * Comanda uma Pe�a na posicao (origemX, origemY) fazer um movimento 
     * para (destinoX, destinoY).
     * 
     * @param origemX linha da Casa de origem.
     * @param origemY coluna da Casa de origem.
     * @param destinoX linha da Casa de destino.
     * @param destinoY coluna da Casa de destino.
     */
    public boolean moverPeca(int origemX, int origemY, int destinoX, int destinoY) {
        Casa origem = tabuleiro.getCasa(origemX, origemY);
        Casa destino = tabuleiro.getCasa(destinoX, destinoY);
        Peca peca = origem.getPeca();
        if (peca.getTipo() == Peca.REI_BRANCO || peca.getTipo() == Peca.REI_PRETO){
            Rei rei = new Rei(origem, peca.getTipo());
            if (rei.mover(peca, origem, destino)){
                return true;
            } else {
                return false;
            }
        }
        else if (peca.getTipo() == Peca.PEAO_BRANCO || peca.getTipo() == Peca.PEAO_PRETO) {
            if (peca.moverPeao(peca, origem, destino)){
                return true;
            } else {
                return false;
            }
        }
        else if (peca.getTipo() == Peca.TORRE_BRANCA || peca.getTipo() == Peca.TORRE_PRETA){
            if (peca.moverTorre(peca, origemX, origemY, destinoX, destinoY, tabuleiro, destino)){
                return true;
            } else {
                return false;
            }
        }
        else if (peca.getTipo() == Peca.BISPO_BRANCO || peca.getTipo() == Peca.BISPO_PRETO){
            Bispo bispo = new Bispo(origem, peca.getTipo());
            if (bispo.mover(origem, destino, tabuleiro)){
                return true;
            } else {
                return false;
            }
        }
        else if (peca.getTipo() == Peca.CAVALO_BRANCO || peca.getTipo() == Peca.CAVALO_PRETO) {
            if (peca.moverCavalo(destino)){
                return true;
            } else {
                return false;
            }
        }
        else if (peca.getTipo() == Peca.RAINHA_BRANCA || peca.getTipo() == Peca.RAINHA_PRETA){
            Rainha rainha = new Rainha(origem, peca.getTipo());
            if (rainha.mover(origem, destino, peca, tabuleiro)){
                return true;
            } else {
                return false;
            }
        }
        else {
            peca.mover(destino);
            return true;
        }
    }
    
    /**
     * @return o Tabuleiro em jogo.
     */
    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }
}

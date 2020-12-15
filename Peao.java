
/**
 * Escreva a descrição da classe Peao aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Peao extends Peca
{
    private boolean casaInicial = true;

    public Peao(Casa casa, int tipo) {
        super(casa, tipo);
    }
    
    /**
     * Verifica o deslocamento do peão na vertical
     */
    public boolean deslocamentoPeao(int deslocamentoY, Casa origem, Casa destino){
        if (getTipo() == Peca.PEAO_BRANCO && deslocamentoY > 0){
            mover(destino);
            setCasaInicial();
            return true;
        } 
        else if (getTipo() == Peca.PEAO_PRETO && deslocamentoY < 0){
            mover(destino);
            setCasaInicial();
            return true;
        }
        else {
            mover(origem);
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
                return false;
            } else if (((destino.getPeca().getTipo() % 2) != 0) && ((origem.getPeca().getTipo() % 2) != 0)){
                mover(origem);
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
                    return false;
                }
            }
        } else {
            mover(origem);
            return false;
        }
    }
    
    /**
     * Realiza do movimento do Peão
     */
    public boolean moverPeca(Casa origem, Casa destino, Tabuleiro tabuleiro) {
        int deslocamentoX = destino.getCoordX() - origem.getCoordX();
        int deslocamentoY = destino.getCoordY() - origem.getCoordY();
        if (getCasaInicial()){
            if ((deslocamentoX == 0) && (Math.abs(deslocamentoY) == 2)){
                if (destino.getPeca() == null) {
                    return deslocamentoPeao(deslocamentoY, origem, destino);
                }
                else {
                    return false;
                }
            } else if ((deslocamentoX == 0) && (Math.abs(deslocamentoY) == 1)){
                if (destino.getPeca() == null) {
                    return deslocamentoPeao(deslocamentoY, origem, destino);
                }
                else {
                    return false;
                }
            } else if ((Math.abs(deslocamentoX) == 1) && (Math.abs(deslocamentoY) == 1)){
                return capturaPeao(origem, destino, deslocamentoX, deslocamentoY);
            }
        } else {
            if ((deslocamentoX == 0) && (Math.abs(deslocamentoY) == 1)){
                if (destino.getPeca() == null) {
                    return deslocamentoPeao(deslocamentoY, origem, destino);
                }
            }
            else if ((Math.abs(deslocamentoX) == 1) && (Math.abs(deslocamentoY) == 1)){
                return capturaPeao(origem, destino, deslocamentoX, deslocamentoY);
            } else {
                return false;
            }
        }
        return false;
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
}

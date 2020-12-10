
/**
 * Escreva a descrição da classe Peao aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Peao extends Peca
{
    public Peao(Casa casa, int tipo) {
        super(casa, tipo);
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
}

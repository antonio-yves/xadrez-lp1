
/**
 * Escreva a descrição da classe Rei aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Rei extends Peca
{
    /**
     * Construtor para objetos da classe Rei
     */
    public Rei(Casa casa, int tipo)
    {
        super(casa, tipo);
    }

    /**
     * Realiza o movimento do Rei
     */
    public boolean moverPeca(Casa origem, Casa destino, Tabuleiro tabuleiro) {
        int deslocamentoX = destino.getCoordX() - origem.getCoordX();
        int deslocamentoY = destino.getCoordY() - origem.getCoordY();
        if (destino.getPeca() != null){
            if (((destino.getPeca().getTipo() % 2) == 0) && ((getTipo() % 2) == 0)){
                mover(origem);
                return false;
            } else if (((destino.getPeca().getTipo() % 2) != 0) && ((getTipo() % 2) != 0)){
                mover(origem);
                return false;
            } else {
                return deslocarRei(origem, destino, deslocamentoX, deslocamentoY);
            }
        } else {
            return deslocarRei(origem, destino, deslocamentoX, deslocamentoY);
        } 
    }
    
    /**
     * Verifica se o rei pode se deslocar para a casa de destino
     */
    public boolean deslocarRei(Casa origem, Casa destino, int deslocamentoX, int deslocamentoY){
        if ((Math.abs(deslocamentoX) == 1) && (Math.abs(deslocamentoY) == 1)){
            mover(destino);
            return true;
        } else if ((Math.abs(deslocamentoX) == 1) && (Math.abs(deslocamentoY) == 0)) {
            mover(destino);
            return true;
        } else if ((Math.abs(deslocamentoX) == 0) && (Math.abs(deslocamentoY) == 1)) {
            mover(destino);
            return true;
        } else {
            mover(origem);
            return false;
        }
    }
}

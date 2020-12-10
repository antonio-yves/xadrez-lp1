
/**
 * Escreva a descrição da classe Cavalo aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Cavalo extends Peca
{
    public Cavalo(Casa casa, int tipo) {
        super(casa, tipo);
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
    
    
}


/**
 * Escreva a descrição da classe Torre aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Torre extends Peca
{
    public Torre(Casa casa, int tipo) {
        super(casa, tipo);
    }
    
    /**
     * Realiza o movimento da Torre
     */
    public boolean moverPeca(Casa origem, Casa destino, Tabuleiro tabuleiro){
        int tipoPeca = getTipo();
        boolean pecaNaFrente = false;
        
        if((destino.getCoordX() == origem.getCoordX()) && (destino.getCoordY() != origem.getCoordY())) {
            if(destino.getCoordY() > origem.getCoordY()){ 
                for(int i = origem.getCoordY() + 1; i < destino.getCoordY(); i++){
                    if(tabuleiro.getCasa(origem.getCoordX(), i).possuiPeca() == true){
                        pecaNaFrente = true; 
                    } 
                }
                
                if(pecaNaFrente == false){
                    //Lógica para capturar a peça
                    if (destino.getPeca() != null){
                        if ((((destino.getPeca().getTipo() % 2) == 0) && ((getTipo() % 2) == 0)) || 
                        (((destino.getPeca().getTipo() % 2) != 0) && ((getTipo() % 2) != 0))){
                            mover(tabuleiro.getCasa(origem.getCoordX(), origem.getCoordY()));
                            return false;
                        }
                        mover(destino);
                        return true;
                    }
                    mover(destino);
                    return true;                   
                }
                mover(tabuleiro.getCasa(origem.getCoordX(), origem.getCoordY()));
                return false;
            } else if(destino.getCoordY() < origem.getCoordY()){
                for(int i = origem.getCoordY() - 1; i > destino.getCoordY(); i--){
                    if(tabuleiro.getCasa(origem.getCoordX(), i).possuiPeca() == true){
                        pecaNaFrente = true;
                    }
                }
                
                if(pecaNaFrente == false){
                    //Lógica para capturar a peça
                    if (destino.getPeca() != null){
                        if ((((destino.getPeca().getTipo() % 2) == 0) && ((getTipo() % 2) == 0)) || 
                        (((destino.getPeca().getTipo() % 2) != 0) && ((getTipo() % 2) != 0))){
                            mover(tabuleiro.getCasa(origem.getCoordX(), origem.getCoordY()));
                            return false;
                        }
                        mover(destino);
                        return true;
                    }
                    mover(destino);
                    return true;                   
                }
                mover(tabuleiro.getCasa(origem.getCoordX(), origem.getCoordY()));
                return false;
            }
            
        } else if ((destino.getCoordX() != origem.getCoordX()) && (destino.getCoordY() == origem.getCoordY())){ 
            if(destino.getCoordX() > origem.getCoordX()){
                for(int i = origem.getCoordX() + 1; i < destino.getCoordX(); i++){
                    if(tabuleiro.getCasa(i, origem.getCoordY()).possuiPeca() == true) {
                        pecaNaFrente = true;
                    }

                }
                
                if(pecaNaFrente == false){
                    //Lógica para capturar a peça
                    if (destino.getPeca() != null){
                        if ((((destino.getPeca().getTipo() % 2) == 0) && ((getTipo() % 2) == 0)) || 
                        (((destino.getPeca().getTipo() % 2) != 0) && ((getTipo() % 2) != 0))){
                            mover(tabuleiro.getCasa(origem.getCoordX(), origem.getCoordY()));
                            return false;
                        }
                        mover(destino);
                        return true;
                    }
                    mover(destino);
                    return true;                   
                }
                mover(tabuleiro.getCasa(origem.getCoordX(), origem.getCoordY()));
                return false;                
            } else if (destino.getCoordX() < origem.getCoordX()){
                for(int i = origem.getCoordX() - 1; i > destino.getCoordX(); i--){
                    if(tabuleiro.getCasa(i, origem.getCoordY()).possuiPeca() == true) {
                        pecaNaFrente = true;
                    }
                }
                
                if(pecaNaFrente == false){
                    //Lógica para capturar a peça
                    if (destino.getPeca() != null){
                        if ((((destino.getPeca().getTipo() % 2) == 0) && ((getTipo() % 2) == 0)) || 
                        (((destino.getPeca().getTipo() % 2) != 0) && ((getTipo() % 2) != 0))){
                            mover(tabuleiro.getCasa(origem.getCoordX(), origem.getCoordY()));
                            return false;
                        }
                        mover(destino);
                        return true;
                    }
                    mover(destino);
                    return true;                   
                }
                mover(tabuleiro.getCasa(origem.getCoordX(), origem.getCoordY()));
                return false;
            }   
        }
        return false;
    }
}


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
}


/**
 * Escreva a descrição da classe Rainha aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Rainha extends Peca
{
    /**
     * Construtor para objetos da classe Rainha
     */
    public Rainha(Casa casa, int tipo)
    {
        super(casa, tipo);
    }

    /**
     * Realiza o movimento da Rainha
     */
    public boolean moverPeca(Casa origem, Casa destino, Tabuleiro tabuleiro){
        if (origem == destino){
            return false;
        } else if ((origem.getCoordX() == destino.getCoordX()) || (origem.getCoordY() == destino.getCoordY())){
            if (moverCimaOuLado(origem, destino, tabuleiro)){
                return true;
            } else {
                return false;
            }
        } else {
            if (moverDiagonal(origem, destino, tabuleiro)){
                return true;
            } else {
                return false;
            }
        }
    }
    
    /**
     * Realiza o movimento da Rainha
     * Na horizontal e na vertical
     */
    public boolean moverCimaOuLado(Casa origem, Casa destino, Tabuleiro tabuleiro){
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
                            mover(origem);
                            return false;
                        }
                        mover(destino);
                        return true;
                    }
                    mover(destino);
                    return true;                   
                }
                mover(origem);
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
                            mover(origem);
                            return false;
                        }
                        mover(destino);
                        return true;
                    }
                    mover(destino);
                    return true;                   
                }
                mover(origem);
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
                            mover(origem);
                            return false;
                        }
                        mover(destino);
                        return true;
                    }
                    mover(destino);
                    return true;                   
                }
                mover(origem);
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
                            mover(origem);
                            return false;
                        }
                        mover(destino);
                        return true;
                    }
                    mover(destino);
                    return true;                   
                }
                mover(origem);
                return false;
            }   
        }
        return false;
    }
    
    /**
     * Realiza o movimentoo da Rainha
     * Na diagonal
     */
    public boolean moverDiagonal(Casa origem, Casa destino, Tabuleiro tabuleiro){
        int deslocamentoX = destino.getCoordX() - origem.getCoordX();
        int deslocamentoY = destino.getCoordY() - origem.getCoordY();
        if (origem == destino){
            return false;
        } else if (deslocamentoX <= 0 && deslocamentoY >= 0){
            if ((deslocamentoX * -1) == deslocamentoY){
                int temPeca = 0;
                for (int x = 0; x < deslocamentoY;){
                    x++;
                    Casa casaAux = tabuleiro.getCasa(origem.getCoordX() - x, origem.getCoordY() + x);
                    if (casaAux.getPeca() != null){
                        if (casaAux == destino){
                            if (((destino.getPeca().getTipo() % 2) == 0) && ((origem.getPeca().getTipo() % 2) == 0)) {
                                mover(origem);
                                return false;
                            } else if (((destino.getPeca().getTipo() % 2) != 0) && ((origem.getPeca().getTipo() % 2) != 0)) {
                                mover(origem);
                                return false;
                            }
                            else {
                                mover(destino);
                                return true;
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
                    return false;
                } else {
                    mover(destino);
                    return true;
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
                            if (((destino.getPeca().getTipo() % 2) == 0) && ((origem.getPeca().getTipo() % 2) == 0)) {
                                mover(origem);
                                return false;
                            } else if (((destino.getPeca().getTipo() % 2) != 0) && ((origem.getPeca().getTipo() % 2) != 0)) {
                                mover(origem);
                                return false;
                            }
                            else {
                                mover(destino);
                                return true;
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
                    return false;
                } else {
                    mover(destino);
                    return true;
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
                            if (((destino.getPeca().getTipo() % 2) == 0) && ((origem.getPeca().getTipo() % 2) == 0)) {
                                mover(origem);
                                return false;
                            } else if (((destino.getPeca().getTipo() % 2) != 0) && ((origem.getPeca().getTipo() % 2) != 0)) {
                                mover(origem);
                                return false;
                            }
                            else {
                                mover(destino);
                                return true;
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
                    return false;
                } else {
                    mover(destino);
                    return true;
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
                            if (((destino.getPeca().getTipo() % 2) == 0) && ((origem.getPeca().getTipo() % 2) == 0)) {
                                mover(origem);
                                return false;
                            } else if (((destino.getPeca().getTipo() % 2) != 0) && ((origem.getPeca().getTipo() % 2) != 0)) {
                                mover(origem);
                                return false;
                            }
                            else {
                                mover(destino);
                                return true;
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
                    return false;
                } else {
                    mover(destino);
                    return true;
                }
            }
        }
        return false;
    }
}

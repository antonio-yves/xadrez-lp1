
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
    public boolean mover(Casa origem, Casa destino, Peca peca, Tabuleiro tabuleiro){
        if (origem == destino){
            mostrarMensagem();
            return false;
        } else if ((origem.getCoordX() == destino.getCoordX()) || (origem.getCoordY() == destino.getCoordY())){
            if (moverCimaOuLado(peca, origem.getCoordX(), origem.getCoordY(), destino.getCoordX(), destino.getCoordY(), tabuleiro, destino)){
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
    public boolean moverCimaOuLado(Peca peca, int origemX, int origemY, int destinoX, int destinoY, Tabuleiro tabuleiro, Casa destino){
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
    
    /**
     * Realiza o movimentoo da Rainha
     * Na diagonal
     */
    public boolean moverDiagonal(Casa origem, Casa destino, Tabuleiro tabuleiro){
        int deslocamentoX = destino.getCoordX() - origem.getCoordX();
        int deslocamentoY = destino.getCoordY() - origem.getCoordY();
        if (origem == destino){
            mostrarMensagem();
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
                                mostrarMensagem();
                                return false;
                            } else if (((destino.getPeca().getTipo() % 2) != 0) && ((origem.getPeca().getTipo() % 2) != 0)) {
                                mover(origem);
                                mostrarMensagem();
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
                    mostrarMensagem();
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
                                mostrarMensagem();
                                return false;
                            } else if (((destino.getPeca().getTipo() % 2) != 0) && ((origem.getPeca().getTipo() % 2) != 0)) {
                                mover(origem);
                                mostrarMensagem();
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
                    mostrarMensagem();
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
                                mostrarMensagem();
                                return false;
                            } else if (((destino.getPeca().getTipo() % 2) != 0) && ((origem.getPeca().getTipo() % 2) != 0)) {
                                mover(origem);
                                mostrarMensagem();
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
                    mostrarMensagem();
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
                                mostrarMensagem();
                                return false;
                            } else if (((destino.getPeca().getTipo() % 2) != 0) && ((origem.getPeca().getTipo() % 2) != 0)) {
                                mover(origem);
                                mostrarMensagem();
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
                    mostrarMensagem();
                    return false;
                } else {
                    mover(destino);
                    return true;
                }
            }
        }
        mostrarMensagem();
        return false;
    }
}

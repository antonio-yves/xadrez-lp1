
/**
 * Escreva a descrição da classe Bispo aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Bispo extends Peca
{

    /**
     * Construtor para objetos da classe Bispo
     */
    public Bispo(Casa casa, int tipo)
    {
        super(casa, tipo);
    }

    /**
     * Realiza o movimentoo do Bispo
     */
    public boolean moverPeca(Casa origem, Casa destino, Tabuleiro tabuleiro){
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

package edu.fiuba.algo3.modelo;

public class CreadorDeCartas {
    private static final String[] SUITNAME = {"Corazones" ,"Diamantes" , "Picas", "Espada"};
    private static final String[] RANK = {"A", "2", "3", "4", "5", "6", "7", "8", "9","10" ,"J", "Q", "K"};


    public Mazo crearMazo() {
        Mazo mazo = new Mazo();
        for(String suit: SUITNAME) {
            for (String rank: RANK) {
                Carta carta;
                switch (rank) {
                    case "A":
                        carta = new Carta(rank, suit, 11);
                        break;
                    case "2":
                        carta = new Carta(rank, suit, 2);
                        break;
                        case "3":
                            carta = new Carta(rank, suit, 3);
                            break;
                            case "4":
                                carta = new Carta(rank, suit, 4);
                                break;
                                case "5":
                                    carta = new Carta(rank, suit, 5);
                                    break;
                                    case "6":
                                        carta = new Carta(rank, suit, 6);
                                        break;
                                        case "7":
                                            carta = new Carta(rank, suit, 7);
                                            break;
                                            case "8":
                                                carta = new Carta(rank, suit, 8);
                                                break;
                                                case "9":
                                                    carta = new Carta(rank, suit, 9);
                                                    break;
                                                    case "10":
                                                        carta = new Carta(rank, suit, 10);
                                                        break;
                                                        case "J":
                                                            carta = new Carta(rank, suit, 10);
                                                            break;
                                                            case "Q":
                                                                carta = new Carta(rank, suit, 10);
                                                                break;
                                                                case "K":
                                                                    carta = new Carta(rank, suit, 10);
                                                                    break;
                                                                    default:
                                                                        throw new AssertionError();

                }

                mazo.addCard(carta);



            }

        }
        return mazo;

    }

}

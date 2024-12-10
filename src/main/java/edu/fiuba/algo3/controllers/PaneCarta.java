package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.Services.ImageLoader;
import edu.fiuba.algo3.modelo.ICarta;
import javafx.scene.image.ImageView;

public class PaneCarta extends ImageView {
    ICarta carta;
    private static final double SCALE_FACTOR = 1.1; // 10% más grande

    public PaneCarta () {
        super();
    }

    public void setCarta(ICarta carta) {
        this.carta = carta;
        ImageLoader imageLoader = new ImageLoader();
        this.setImage(imageLoader.cargarImagen(carta.getImagen()));
    }

    public ICarta getCarta() {
        return carta;
    }

    public void agrandar(double scale){
        this.setScaleX(scale);
        this.setScaleY(scale);
    }

    public void setActive(boolean value) {
        if (value) {
            this.getStyleClass().remove("carta-inhabilitada");
            this.getStyleClass().add("carta-habilitada");
        }else {
            this.getStyleClass().remove("carta-habilitada");
            this.getStyleClass().add("carta-inhabilitada");
        }
    }
}

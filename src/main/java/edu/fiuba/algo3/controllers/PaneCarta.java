package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.Services.ImageLoader;
import edu.fiuba.algo3.Services.MediaMaker;
import edu.fiuba.algo3.modelo.ICarta;
import javafx.event.EventHandler;

import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;

import javafx.scene.image.ImageView;
import javafx.util.Duration;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.util.Objects;
import java.util.Random;

public class PaneCarta extends ImageView implements EventHandler<MouseEvent> {
    private static final Random RANDOM = new Random();
    ICarta carta;
    private static final String SOUND_PATH = "/sounds/click2.wav"; // Ruta al sonido
    private Media sonidoClick;
    public PaneCarta () {
        super();
    }

    public void setCarta(ICarta carta) {
        this.carta = carta;
        ImageLoader imageLoader = new ImageLoader();
        aniadirHoverDescripcion();
        this.setImage(imageLoader.cargarImagen(carta.getImagen()));
        atachClickSound();
    }

    public ICarta getCarta() {
        return carta;
    }

    private void aniadirHoverDescripcion() {
        Tooltip hover = new Tooltip(carta.getDescripcion());
        hover.setStyle("hover-descripcion"); // Estilo del tooltip
        hover.setShowDelay(Duration.millis(100)); // Ajusta el tiempo de espera a 100 milisegundos
        Tooltip.install(this, hover);
    }

    public void agrandar(double scale){
        this.setScaleX(scale);
        this.setScaleY(scale);
    }

    public void atachClickSound(){
        // Cargar el archivo de sonido como un objeto Media
        String path = Objects.requireNonNull(getClass().getResource(SOUND_PATH)).getPath();
        Media sound = MediaMaker.make(path);
        this.sonidoClick = sound;
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

    @Override
    public void handle(MouseEvent event) {
        // Verifica si el evento es un clic en la carta
        if (event.getEventType() == MouseEvent.MOUSE_CLICKED) {
            reproducirSonidoConPitch();
        }
    }

    private void reproducirSonidoConPitch() {
        try {
            MediaPlayer mediaPlayer = new MediaPlayer(sonidoClick);

            // Generar un pitch aleatorio en el rango 0.8 a 1.2
            double pitch = 0.8 + RANDOM.nextDouble() * 0.4; // Rango: 0.8 a 1.2
            mediaPlayer.setRate(pitch); // Ajusta el pitch del sonido

            // Reproducir el sonido
            mediaPlayer.play();

            // Liberar recursos del MediaPlayer después de que termine el audio
            mediaPlayer.setOnEndOfMedia(mediaPlayer::dispose);

        } catch (Exception e) {
        }
    }

    public void playClick() {
        reproducirSonidoConPitch();
    }
}


package edu.fiuba.algo3.controllers;
import edu.fiuba.algo3.modelo.BalatroAlgo3;
import edu.fiuba.algo3.modelo.IModelo;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneManager {
    private final Stage stage;
    private final StackPane rootPane; // Contenedor principal
    private final MediaPlayer mediaPlayer;
    private final IModelo modelo;

    public SceneManager(Stage stage, IModelo modelo) {
        this.stage = stage;
        this.modelo = modelo;

        // Crear el contenedor principal
        rootPane = new StackPane();
        try {
            // Configura el icono
            Image icon = new Image(getClass().getResourceAsStream("/images/mainIcon.png"));

            //Configurar el video de fondo
            String videoPath = getClass().getResource("/images/BackGrounds/backgroundMain.mp4").toExternalForm();
            Media media = new Media(videoPath);
            mediaPlayer = new MediaPlayer(media);
            MediaView mediaView = new MediaView(mediaPlayer);
            mediaView.setPreserveRatio(true);
            mediaView.fitWidthProperty().bind(stage.widthProperty());
            mediaView.fitHeightProperty().bind(stage.heightProperty());
            rootPane.getChildren().add(mediaView);
        } catch (Exception e) {
            System.out.println("El fondo o el icono no se encontraron");
            throw new RuntimeException(e);
        }

        // Configurar el escenario inicial
        Scene scene = new Scene(rootPane, 1263, 720);
        stage.setTitle("Balatrucho 3");
        stage.setScene(scene);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
    }

    public void cambiarAEscena(String fxmlPath) {
        try {
            // Cargar la nueva vista
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent view = loader.load();

            GameController gameController = loader.getController();
            gameController.setModelo(this.modelo);

            // Reemplazar el contenido principal
            if (rootPane.getChildren().size() > 1) {
                rootPane.getChildren().set(1, view); // Reemplaza solo el contenido superpuesto
            } else{
                rootPane.getChildren().add(view);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Nueva función para configurar el sonido de fondo
    public void setBackgroundMusic(String musicPath) {
        Media musicMedia = new Media(getClass().getResource(musicPath).toExternalForm());
        MediaPlayer backgroundMusicPlayer = new MediaPlayer(musicMedia);
        backgroundMusicPlayer.setCycleCount(MediaPlayer.INDEFINITE);  // Reproducir indefinidamente
        backgroundMusicPlayer.setVolume(100);  // Ajusta el volumen, si es necesario
        backgroundMusicPlayer.play();
    }

    public void show() {
        stage.show();
    }

    public void close() {
        this.stage.close();
    }
}

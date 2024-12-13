package edu.fiuba.algo3.controllers;
import edu.fiuba.algo3.modelo.IModelo;
import edu.fiuba.algo3.modelo.ISwitcher;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneManager implements ISwitcher {
    private final Stage stage;
    private final StackPane rootPane; // Contenedor principal
    private final MediaPlayer backgroundPlayer;
    private MediaPlayer musicPlayer;
    private final IModelo modelo;

    public SceneManager(Stage stage, IModelo modelo) {
        this.stage = stage;
        this.modelo = modelo;

        // Crear el contenedor principal
        rootPane = new StackPane();

        try {
            // Configura el icono
            Image icon = new Image(getClass().getResourceAsStream("/images/mainIcon.png"));
            stage.getIcons().add(icon);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            //Configurar el video de fondo
            String videoPath = getClass().getResource("/images/BackGrounds/backgroundMain.mp4").toExternalForm();
            Media media = new Media(videoPath);
            backgroundPlayer = new MediaPlayer(media);
            MediaView mediaView = new MediaView(backgroundPlayer);
            mediaView.setPreserveRatio(true);
            mediaView.fitWidthProperty().bind(stage.widthProperty());
            mediaView.fitHeightProperty().bind(stage.heightProperty());
            rootPane.getChildren().add(mediaView);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // Configurar el escenario inicial
        Scene scene = new Scene(rootPane, 1263, 720);
        stage.setTitle("Balatrucho 3");
        stage.setScene(scene);
        backgroundPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        backgroundPlayer.play();
    }

    @Override
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

    @Override
    // Nueva función para configurar el sonido de fondo
    public void setBackgroundMusic(String musicPath) {
        Media musicMedia = new Media(getClass().getResource(musicPath).toExternalForm());
        musicPlayer = new MediaPlayer(musicMedia);
        musicPlayer.setCycleCount(MediaPlayer.INDEFINITE);  // Reproducir indefinidamente
        musicPlayer.setVolume(100);  // Ajusta el volumen, si es necesario
        musicPlayer.play();
        stage.setOnCloseRequest(event -> {
            musicPlayer.stop();
        });
    }

    public void show() {
        stage.show();
    }

    public void close() {
        this.stage.close();
    }
}

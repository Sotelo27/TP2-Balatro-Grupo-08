package edu.fiuba.algo3.controllers;
import edu.fiuba.algo3.modelo.BalatroAlgo3;
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

public class SceneManager {
    private final Stage stage;
    private final StackPane rootPane; // Contenedor principal
    private final MediaPlayer mediaPlayer;

    public SceneManager(Stage stage) {
        this.stage = stage;

        // Configurar el video de fondo
        Image icon = new Image(getClass().getResourceAsStream("/images/mainIcon.png"));
        String videoPath = getClass().getResource("/images/BackGrounds/backgroundMain.mp4").toExternalForm();
        Media media = new Media(videoPath);
        mediaPlayer = new MediaPlayer(media);
        MediaView mediaView = new MediaView(mediaPlayer);
        mediaView.setPreserveRatio(false);
        mediaView.fitWidthProperty().bind(stage.widthProperty());
        mediaView.fitHeightProperty().bind(stage.heightProperty());

        // Crear el contenedor principal
        rootPane = new StackPane();
        rootPane.getChildren().add(mediaView);

        // Configurar el escenario inicial
        Scene scene = new Scene(rootPane, 1920, 1080);
        stage.setScene(scene);
        stage.getIcons().add(icon);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
    }

    public void setView(String fxmlPath) {
        try {
            // Cargar la nueva vista
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent view = loader.load();

            // Reemplazar el contenido principal
            if (rootPane.getChildren().size() > 1) {
                rootPane.getChildren().remove(1); // Remueve la vista anterior
            }
            rootPane.getChildren().add(view);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setViewModel(String fxmlPath, BalatroAlgo3 modelo) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent view = loader.load();

            if (fxmlPath.equals("/fxml/shopScene.fxml")) {
                // Si es la escena de Shop, pasa el modelo
                ShopSceneController controller = loader.getController();
                controller.setModelo(modelo);
            }

            if (fxmlPath.equals("/fxml/RoundScene.fxml")) {
                // Si es la escena de Shop, pasa el modelo
                RoundSceneController controller = loader.getController();
                controller.setModelo(modelo);
            }

            // Reemplaza la vista actual
            if (rootPane.getChildren().size() > 1) {
                rootPane.getChildren().remove(1); // Remueve la vista anterior
            }
            rootPane.getChildren().add(view);
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
}

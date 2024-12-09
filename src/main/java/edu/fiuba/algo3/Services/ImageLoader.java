package edu.fiuba.algo3.Services;

import javafx.scene.image.Image;

import java.io.InputStream;

public class ImageLoader {

    private static final String DEFAULT_IMAGE_PATH = "/images/cartas/default.png";

    /**
     * Carga una imagen desde un recurso dado su ruta.
     * Si no encuentra el archivo, carga una imagen predeterminada.
     *
     * @param path Ruta del recurso.
     * @return Objeto Image.
     */
    public Image cargarImagen(String path) {
        InputStream resourceStream = getClass().getResourceAsStream(path);
        if (resourceStream == null) {
            resourceStream = getClass().getResourceAsStream(DEFAULT_IMAGE_PATH);
        }
        return new Image(resourceStream);
    }
}

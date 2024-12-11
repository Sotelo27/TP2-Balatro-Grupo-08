package edu.fiuba.algo3.Services;

import javafx.scene.media.Media;

import java.io.File;

public class MediaMaker {

    public static Media make(String path){
        File dir = new File(path);
        path = "file:///" + dir.getAbsolutePath();
        path = path.replace("\\", "/");
        return new Media(path);
    }
}

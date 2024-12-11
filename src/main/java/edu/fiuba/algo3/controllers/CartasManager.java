package edu.fiuba.algo3.controllers;

import javafx.scene.layout.TilePane;
import javafx.scene.Node;
import edu.fiuba.algo3.modelo.ICarta;

import java.util.List;

public class CartasManager {
    public static void cargarCartas(List<ICarta> cartas, TilePane contenedor) {
        List<Node> children = contenedor.getChildren();
        for (int i = 0; i < cartas.size(); i++) {
            ICarta carta = cartas.get(i);
            PaneCarta imageView = (PaneCarta) children.get(i);
            imageView.setCarta(carta);
        }
    }
}

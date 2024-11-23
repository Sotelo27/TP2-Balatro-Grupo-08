module edu.fiuba.algo3 {
    requires javafx.controls;
    requires json.simple;
    requires java.smartcardio;
    requires com.google.gson;
    requires com.fasterxml.jackson.databind; //consultar
    opens edu.fiuba.algo3.modelo to com.fasterxml.jackson.databind; //consultar
    exports edu.fiuba.algo3;
    exports edu.fiuba.algo3.modelo;
    exports edu.fiuba.algo3.vistas;
}
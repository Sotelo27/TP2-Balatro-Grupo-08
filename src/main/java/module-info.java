module edu.fiuba.algo3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;
    requires java.smartcardio;
    requires com.fasterxml.jackson.databind;
    requires java.desktop;
    requires javafx.media;
    opens edu.fiuba.algo3.modelo to com.fasterxml.jackson.databind; //consultar
    opens edu.fiuba.algo3.modelo.Mejoradores to com.fasterxml.jackson.databind;
    exports edu.fiuba.algo3;
    exports edu.fiuba.algo3.modelo;
    exports edu.fiuba.algo3.vistas;
    exports edu.fiuba.algo3.modelo.Verificadores;
    exports edu.fiuba.algo3.modelo.Mejoradores to com.fasterxml.jackson.databind;
    opens edu.fiuba.algo3.modelo.Verificadores to com.fasterxml.jackson.databind;
    exports edu.fiuba.algo3.modelo.Estados;
    opens edu.fiuba.algo3.modelo.Estados to com.fasterxml.jackson.databind;
    opens edu.fiuba.algo3 to javafx.fxml;
    exports edu.fiuba.algo3.controllers to  javafx.fxml;
    opens edu.fiuba.algo3.controllers to  javafx.fxml;
    exports edu.fiuba.algo3.modelo.CondicionesDeMejora;
    opens edu.fiuba.algo3.modelo.CondicionesDeMejora to com.fasterxml.jackson.databind;
    exports edu.fiuba.algo3.modelo.Parsers;
    opens edu.fiuba.algo3.modelo.Parsers to com.fasterxml.jackson.databind;
    exports edu.fiuba.algo3.modelo.EstadoDeCarta;
    opens edu.fiuba.algo3.modelo.EstadoDeCarta to com.fasterxml.jackson.databind;
    exports edu.fiuba.algo3.modelo.Mejoras;
    opens edu.fiuba.algo3.modelo.Mejoras to com.fasterxml.jackson.databind;
}
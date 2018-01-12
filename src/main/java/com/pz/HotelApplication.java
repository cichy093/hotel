package com.pz;


import com.pz.DataBase.DBMeneger;
import de.felixroske.jfxsupport.AbstractJavaFxApplicationSupport;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class HotelApplication extends AbstractJavaFxApplicationSupport {

    public static void main(String[] args) {
        launchApp(HotelApplication.class, HelloView.class, args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        super.start(stage);

    }
}

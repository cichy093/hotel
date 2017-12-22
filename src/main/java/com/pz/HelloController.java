package com.pz;

import com.pz.DataBase.DBMeneger;
import de.felixroske.jfxsupport.FXMLController;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.springframework.beans.factory.annotation.Autowired;



@FXMLController
public class HelloController {

    @Autowired
    private DBMeneger dbMeneger = DBMeneger.getInstance();
    @Autowired
    MainWindowController mainWindowController;


    @FXML
    public void handleButtonAction() {
        dbMeneger.loadTestData();
        HotelApplication.showView(MainWindowView.class);
        mainWindowController.loadGrid();
    }


}

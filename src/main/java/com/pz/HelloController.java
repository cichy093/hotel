package com.pz;

import com.pz.DataBase.DBMeneger;
import de.felixroske.jfxsupport.FXMLController;
import javafx.fxml.FXML;
import org.springframework.beans.factory.annotation.Autowired;

@FXMLController
public class HelloController {

    @Autowired
    private DBMeneger dbMeneger = DBMeneger.getInstance();

    @FXML
    public void handleButtonAction() {
        dbMeneger.loadTestData();
        dbMeneger.printTestData();
        HotelApplication.showView(LoginWindowView.class);
    }


}

package com.pz;

import com.pz.DataBase.DBMenager;
import com.pz.DataBase.DataBaseTest;
import de.felixroske.jfxsupport.FXMLController;
import javafx.fxml.FXML;
import org.springframework.beans.factory.annotation.Autowired;

@FXMLController
public class HelloController {

    private DataBaseTest dataBaseTest;

    @Autowired
    public HelloController(DataBaseTest dataBaseTest) {
        this.dataBaseTest = dataBaseTest;
    }

    @FXML
    public void handleButtonAction() {
        this.dataBaseTest.loadTestData();
        //DBMenager.getInstance().loadDataToDatabase();
        this.dataBaseTest.printTestData();
        HotelApplication.showView(LoginWindowView.class);
    }


}

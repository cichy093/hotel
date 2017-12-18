package com.pz;

import com.pz.DataBase.DataBaseTest;
import javafx.fxml.FXML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelloController {

    private DataBaseTest dataBaseTest;

    @Autowired
    public HelloController(DataBaseTest dataBaseTest) {
        this.dataBaseTest = dataBaseTest;

    }

    @FXML
    public void handleButtonAction() {
        this.dataBaseTest.loadTestData();
        this.dataBaseTest.printTestData();
    }


}

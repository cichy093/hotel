package com.pz;

import com.pz.DataBase.Uzytkownicy;
import com.pz.DataBase.UzytkownicyRepository;
import de.felixroske.jfxsupport.FXMLController;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;

@FXMLController
public class LoginWindowController {

    private String login;
    private String haslo;
    private UzytkownicyRepository uzytkownicyRepository;

    @FXML
    private TextField loginField;
    @FXML
    private PasswordField hasloField;

    @Autowired
    public LoginWindowController(UzytkownicyRepository uzytkownicyRepository) {
        this.uzytkownicyRepository = uzytkownicyRepository;
    }

    @FXML
    public void handleButtonAction(){

        login = loginField.getText();
        haslo = hasloField.getText();
        Boolean czyAdmin = uzytkownicyRepository.findUzytkownicyByNazwaUzytkownikaAndHaslo(login,haslo).isCzyAdmin();
        if (czyAdmin){
            HotelApplication.showView(HelloView.class);
        }


    }
}

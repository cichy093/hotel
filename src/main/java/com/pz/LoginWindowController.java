package com.pz;

import com.pz.DataBase.DBMeneger;
import com.pz.Dto.UzytkownicyDto;
import de.felixroske.jfxsupport.FXMLController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;

@FXMLController
public class LoginWindowController {

    @Autowired
    private DBMeneger dbMeneger = DBMeneger.getInstance();

    @Autowired
    MainWindowController mainWindowController;
    @FXML
    private TextField loginField;
    @FXML
    private PasswordField hasloField;

    private UzytkownicyDto uzytkownicyDto;


    @FXML
    public void logIn() {
        if ((loginField.getText().isEmpty()) || (hasloField.getText().isEmpty())) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Pola nie mogą być puste");
            alert.setHeaderText("Proszę wprowadź Login i Hasło");
            alert.show();
        } else {
            uzytkownicyDto = new UzytkownicyDto();
            this.uzytkownicyDto = uzytkownicyDto.builder().nazwaUzytkownika(loginField.getText()).haslo(hasloField.getText()).build();
            if (dbMeneger.isAdmin(uzytkownicyDto)) {
                mainWindowController.setCzyZalogowanyAdmin(true);
                HotelApplication.showView(MainWindowView.class);
                mainWindowController.loadWindow();
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Błędne dane");
                alert.setHeaderText("Wprowadź Login i Hasło jeszcze raz!");
                alert.show();
            }
        }

    }

    public void cancel() {
        mainWindowController.setCzyZalogowanyAdmin(false);
        HotelApplication.showView(MainWindowView.class);
    }

    /*@FXML
    public void submitUser() {
        uzytkownicyDto = new UzytkownicyDto();
        if ((loginField.getText().isEmpty()) || (hasloField.getText().isEmpty())){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Pola nie mogą być puste");
            alert.setHeaderText("Proszę wprowadź Login i Hasło");
            alert.show();
        }
        else {
            this.uzytkownicyDto = uzytkownicyDto.builder().haslo(hasloField.getText()).nazwaUzytkownika(loginField.getText()).build();
            if (dbMeneger.submitUser(uzytkownicyDto)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Zarejestrowano");
                alert.setHeaderText("Użytkownik zarejestrowany, można się zalogować");
                alert.show();
            }
        }
    }*/
}

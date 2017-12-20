package com.pz;

import com.pz.DataBase.DBMenager;
import com.pz.DataBase.DataBaseTest;
import com.pz.DataBase.UzytkownicyRepository;
import com.pz.Dto.UzytkownicyDto;
import de.felixroske.jfxsupport.FXMLController;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;

@FXMLController
public class LoginWindowController {

    private UzytkownicyRepository uzytkownicyRepository;
    private DataBaseTest dataBaseTest;
    private UzytkownicyDto uzytkownicyDto;
    private Long id;
    @Autowired
    private DBMenager dbMenager = null;

    @FXML
    private TextField loginField;
    @FXML
    private PasswordField hasloField;

    @Autowired
    public LoginWindowController(UzytkownicyRepository uzytkownicyRepository, DataBaseTest dataBaseTest) {
        this.uzytkownicyRepository = uzytkownicyRepository;
        this.dataBaseTest = dataBaseTest;
    }

    @FXML
    public void logIn() {
        Boolean czyZarejestrowany = false;
        try {
            id = uzytkownicyRepository.findUzytkownicyByNazwaUzytkownikaAndHaslo(loginField.getText(), hasloField.getText()).getId();
            czyZarejestrowany = uzytkownicyRepository.exists(id);
        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Błędne dane");
            alert.setHeaderText("Wprowadź Login i Hasło jeszcze raz!");
            alert.show();
        }

        if (czyZarejestrowany) {
            dataBaseTest.printTestData();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Zła nazwa użytkownika");
            alert.setHeaderText("Brak użytkownika w bazie");
            alert.show();
        }


    }

    @FXML
    public void submitUser() {
        uzytkownicyDto.builder().nazwaUzytkownika(loginField.getText()).haslo(hasloField.getText()).build();
        dbMenager.submitUser(uzytkownicyDto);
    }
}

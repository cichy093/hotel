package com.pz;

import com.pz.DataBase.DBMeneger;
import com.pz.Dto.KlienciDto;
import com.pz.Dto.PokojeRezerwacjeDto;
import com.pz.Dto.SLTypDokumentuDto;
import de.felixroske.jfxsupport.FXMLController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

@FXMLController
public class ReservationWindowController {


    @Getter
    @Setter
    private Long idPokoju;

    @FXML
    private TextField txbName;
    @FXML
    private TextField txbSurname;
    @FXML
    private TextField txbEmail;
    @FXML
    private TextField txbTelNmb;
    @FXML
    private TextField txbDocNmb;
    @FXML
    private DatePicker dtpDateFrom;
    @FXML
    private DatePicker dtpDateTo;
    @FXML
    private ChoiceBox cbIdDoc;

    @Autowired
    DBMeneger dbMeneger = DBMeneger.getInstance();

    @Autowired
    private DetailsWindowController detailsWindowController;

    private PokojeRezerwacjeDto pokojeRezerwacjeDto;
    private KlienciDto klienciDto;
    private SLTypDokumentuDto slTypDokumentuDto;

    public void loadWindow() {
        cbIdDoc.setItems(FXCollections.observableArrayList(
                "Dowód osobisty", "Paszport"));
    }

    public void save() {
        try {
            klienciDto = new KlienciDto();
            pokojeRezerwacjeDto = new PokojeRezerwacjeDto();
            klienciDto.setImie(txbName.getText());
            klienciDto.setNazwisko(txbSurname.getText());
            klienciDto.setTelefon(Integer.parseInt(txbTelNmb.getText()));
            klienciDto.setEmail(txbEmail.getText());
            klienciDto.setNrDokumentu(txbDocNmb.getText());
            String docType = cbIdDoc.getValue().toString();
            klienciDto.set_idTypDokumentu(dbMeneger.idDocType(docType));
            this.dbMeneger.newCustomer(klienciDto);
            pokojeRezerwacjeDto.setIdKlienta(dbMeneger.getIdCustomer(klienciDto.getNrDokumentu()));
            pokojeRezerwacjeDto.setIdPokoju(idPokoju);
            pokojeRezerwacjeDto.setDataOd(dtpDateFrom.getValue().toString());
            pokojeRezerwacjeDto.setDataDo(dtpDateTo.getValue().toString());
            this.dbMeneger.newReservation(pokojeRezerwacjeDto);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Sukces");
            alert.setHeaderText("Zarezerwowano termin");
            alert.show();
        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Błąd");
            alert.setHeaderText("Rezerwacja nie została dokonana, spróbuj ponownie");
            alert.show();
        }
    }

    public void goBack() {
        HotelApplication.showView(DetailsWindowView.class);
        txbName.clear();
        txbDocNmb.clear();
        txbEmail.clear();
        txbSurname.clear();
        txbTelNmb.clear();
        dtpDateFrom.setValue(null);
        dtpDateTo.setValue(null);
        detailsWindowController.loadWindow();
    }
}

package com.pz;

import com.pz.DataBase.DBMeneger;
import com.pz.Dto.PokojeDto;
import de.felixroske.jfxsupport.FXMLController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@FXMLController
public class DetailsWindowController {

    @FXML
    private Button btnPokojNiedostepny;
    @FXML
    private Label lblCzyDostepny;
    @FXML
    private GridPane gpListaDat;

    @FXML
    private Label lblOpis1;

    @FXML
    private Label lblOpis2;

    @FXML
    private Label lblNrPokoju;

    @Autowired
    private MainWindowController mainWindowController;

    @Autowired
    DBMeneger dbMeneger = DBMeneger.getInstance();

    @Autowired
    private ReservationWindowController reservationWindowController;

    @Getter
    @Setter
    private Long idPokoju;

    private PokojeDto pokojeDto;

    private List<String> listaDatOd;
    private List<String> listaDatDo;

    private RowConstraints rowConstraints;

    private Label lbNiedostepnyOd;

    private Label lbNiedostepnyDo;
    @Autowired
    private GalleryWindowController galleryWindowController;

    public void logInAdmin() {
        lblOpis1.setVisible(true);
        lblOpis2.setVisible(true);
        lblCzyDostepny.setVisible(true);
        btnPokojNiedostepny.setVisible(true);
    }

    public void logOutAdmin() {
        lblOpis1.setVisible(false);
        lblOpis2.setVisible(false);
        lblCzyDostepny.setVisible(false);
        btnPokojNiedostepny.setVisible(false);
    }

    public void goBack() {
        HotelApplication.showView(MainWindowView.class);
        mainWindowController.setCzyPworot(1);
    }

    public void goToGallery() {
        HotelApplication.showView(GalleryWindowView.class);
        galleryWindowController.setIdPokoju(idPokoju);
        galleryWindowController.loadWindow();
    }

    public void loadWindow() {
        this.lblNrPokoju.setText(Integer.toString(dbMeneger.getRoomNumber(idPokoju)));
        this.pokojeDto = dbMeneger.getRoom(idPokoju);
        this.listaDatDo = this.dbMeneger.getListDateTo(idPokoju);
        this.listaDatOd = this.dbMeneger.getListDateFrom(idPokoju);
        if (pokojeDto.isNiedostepny() == false) lblCzyDostepny.setText("Tak");
        for (int i = 0; i< this.listaDatOd.size(); i++){
            this.rowConstraints = new RowConstraints();
            this.gpListaDat.getRowConstraints().add(rowConstraints);
            this.lbNiedostepnyDo = new Label();
            this.lbNiedostepnyOd = new Label();
            this.lbNiedostepnyOd.setText(listaDatOd.get(i));
            this.lbNiedostepnyDo.setText(listaDatDo.get(i));
            this.gpListaDat.add(lbNiedostepnyOd,0,i);
            this.gpListaDat.add(lbNiedostepnyDo,1,i);
        }
    }


    public void goToReservation() {
        HotelApplication.showView(ReservationWindowView.class);
        reservationWindowController.setIdPokoju(idPokoju);
        reservationWindowController.loadWindow();
    }

    public void zmienDostepnosc() {
        this.pokojeDto.setNiedostepny(true);
        this.dbMeneger.changeRoomAvailable(pokojeDto);
        this.loadWindow();
    }
}

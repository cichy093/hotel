package com.pz;

import com.pz.DataBase.DBMeneger;
import com.pz.Dto.PokojeDto;
import de.felixroske.jfxsupport.FXMLController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@FXMLController
public class DetailsWindowController {

    @FXML
    private DatePicker dpDateStart;

    @FXML
    private Label lblOpis1;

    @FXML
    private Label lblOpis2;

    @FXML
    private Label lblNrPokoju;

    @FXML
    private CheckBox cbAdmin;

    @Autowired
    DBMeneger dbMeneger = DBMeneger.getInstance();

    @Autowired
    private ReservationWindowController reservationWindowController;

    @Getter
    @Setter
    private Long idPokoju;

    private PokojeDto pokojeDto;

    @Autowired
    private GalleryWindowController galleryWindowController;

    public void logInAdmin(){
        lblOpis1.setVisible(true);
        lblOpis2.setVisible(true);
        cbAdmin.setVisible(true);
    }

    public void logOutAdmin(){
        lblOpis1.setVisible(false);
        lblOpis2.setVisible(false);
        cbAdmin.setVisible(false);
    }

    public void goBack() {
        HotelApplication.showView(MainWindowView.class);
    }

    public void goToGallery() {
        HotelApplication.showView(GalleryWindowView.class);
        galleryWindowController.setIdPokoju(idPokoju);
        galleryWindowController.loadWindow();
    }

    public void loadWindow(){
        lblNrPokoju.setText(Integer.toString(dbMeneger.getRoomNumber(idPokoju)));
        pokojeDto = dbMeneger.getRoom(idPokoju);
        if (pokojeDto.isNiedostepny() == false) cbAdmin.setSelected(true);
    }

    public void cbChange() {
        if (cbAdmin.isSelected()) pokojeDto.setNiedostepny(false);
        else pokojeDto.setNiedostepny(true);
        dbMeneger.roomAccessibility(idPokoju,pokojeDto.isNiedostepny());
    }

    public void goToReservation() {
        HotelApplication.showView(ReservationWindowView.class);
        reservationWindowController.setIdPokoju(idPokoju);
        reservationWindowController.loadWindow();
    }
}

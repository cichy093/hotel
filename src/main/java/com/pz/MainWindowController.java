package com.pz;

import com.pz.DataBase.DBMeneger;
import com.pz.DataBase.PokojeZdjecia;
import com.pz.Dto.PokojeDto;
import com.pz.Dto.PokojeZdjeciaDto;
import de.felixroske.jfxsupport.FXMLController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.Effect;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@FXMLController
public class MainWindowController {

    @Autowired
    DBMeneger dbMeneger = DBMeneger.getInstance();

    private Boolean czyZalogowanyAdmin = false;

    private List<PokojeDto> listOfRooms;

    private List<PokojeZdjeciaDto> listOfRoomsPhoto;


    @Autowired
    DetailsWindowController detailsWindowController;

    @FXML
    private GridPane gpRoomList;


    public void setCzyZalogowanyAdmin(Boolean czyZalogowanyAdmin) {
        this.czyZalogowanyAdmin = czyZalogowanyAdmin;
    }

    public Boolean getCzyZalogowanyAdmin() {

        return czyZalogowanyAdmin;
    }

    @FXML
    public void logIn() {
        HotelApplication.showView(LoginWindowView.class);
    }


    public void loadGrid() {
        this.listOfRooms = this.dbMeneger.getListOfRooms();
        this.listOfRoomsPhoto = this.dbMeneger.getListRoomsPhoto();
        List<String> roomPhotos;
        RowConstraints rowConstraints;
        ImageView roomImage;
        String roomNmb;
        Button details;
        Label lbRoomDesc;
        for (int i = 0; i < this.listOfRooms.size(); i++) {
            if (this.listOfRooms.get(i).isNiedostepny() == false) {
                roomPhotos = this.dbMeneger.getListOfRoomPhotos(listOfRooms.get(i).getId(), this.listOfRoomsPhoto);
                roomNmb = String.valueOf(listOfRooms.get(i).getNumer());
                lbRoomDesc = new Label("Pokój numer: " + roomNmb);
                details = new Button("Szczegóły");
                details.setId(Long.toString(listOfRooms.get(i).getId()));
                final Long idPokoju = Long.parseLong(details.getId());
                details.setOnAction(event -> {
                    HotelApplication.showView(DetailsWindowView.class);
                    detailsWindowController.setIdPokoju(idPokoju);
                    detailsWindowController.loadWindow();
                    if (czyZalogowanyAdmin == true) detailsWindowController.logInAdmin();
                    else detailsWindowController.logOutAdmin();
                });
                Image image = new Image(getClass().getResource(roomPhotos.get(0)).toExternalForm());
                roomImage = new ImageView(image);
                roomImage.setFitHeight(100.0);
                roomImage.setFitWidth(100.0);
                rowConstraints = new RowConstraints(120.0);
                this.gpRoomList.getRowConstraints().add(rowConstraints);
                this.gpRoomList.add(lbRoomDesc, 0, i);
                this.gpRoomList.add(roomImage, 1, i);
                this.gpRoomList.add(details, 2, i,10,10);
            }
        }
    }
}

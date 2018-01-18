package com.pz;

import com.pz.DataBase.DBMeneger;
import com.pz.Dto.PokojeZdjeciaDto;
import de.felixroske.jfxsupport.FXMLController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@FXMLController
public class GalleryWindowController {

    @Getter
    @Setter
    private Long idPokoju;

    private List<String> listPhotos;
    private List<PokojeZdjeciaDto> listOfRoomsPhoto;

    @FXML
    private Label lblNrPokoju;

    @FXML
    private GridPane gpGallery;

    @Autowired
    DBMeneger dbMeneger = DBMeneger.getInstance();

    public void goBack() {
        HotelApplication.showView(DetailsWindowView.class);
        gpGallery.getRowConstraints().clear();
    }

    public void loadWindow() {
        RowConstraints rowConstraints;
        ImageView roomImage;
        Image image;
        rowConstraints = new RowConstraints(120.0);
        this.gpGallery.getRowConstraints().add(rowConstraints);
        this.listOfRoomsPhoto = dbMeneger.getListRoomsPhoto();
        lblNrPokoju.setText("Galeria zdjęć pokoju: " + dbMeneger.getRoomNumber(idPokoju));
        listPhotos = dbMeneger.getListOfRoomPhotos(idPokoju, listOfRoomsPhoto);
        int colIndex = 0;
        int rowIndex = 0;
        for (int i = 0; i <= listPhotos.size() - 1; i++) {
            if (i % 2 == 0 && i != 0) {
                rowConstraints = new RowConstraints(120.0);
                this.gpGallery.getRowConstraints().add(rowConstraints);
                rowIndex++;
            }
            image = new Image(getClass().getResource(listPhotos.get(i)).toExternalForm());
            roomImage = new ImageView(image);
            roomImage.setFitHeight(100.0);
            roomImage.setFitWidth(100.0);
            this.gpGallery.add(roomImage, colIndex, rowIndex);
            colIndex++;
            if (colIndex == 2) {
                colIndex = 0;
            }
        }
    }
}

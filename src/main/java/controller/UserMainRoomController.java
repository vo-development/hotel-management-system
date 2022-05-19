package controller;

import dal.dao.ReservationDAO;
import dal.dao.RoomDAO;
import helper.ViewLoader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import pojo.Reservation;
import pojo.Room;

import java.sql.Date;
import java.time.ZoneId;

public class UserMainRoomController extends BaseController{
    @FXML
    private Button btn_rezervasyon;

    @FXML
    private TableColumn<Room, String> col_durum;

    @FXML
    private TableColumn<Room, Integer> col_fiyat;

    @FXML
    private TableColumn<Room, Integer> col_kisi;

    @FXML
    private TableColumn<Room, Integer> col_numara;

    @FXML
    private DatePicker dp_baslangic;

    @FXML
    private DatePicker dp_bitis;

    @FXML
    private TableView<Room> tbl_room;

    private ObservableList<Room> roomObservableList = FXCollections.observableArrayList();
    private RoomDAO roomDao = new RoomDAO();
    private Room selectedRoom;
    private ReservationDAO reservationDAO = new ReservationDAO();


    @FXML
    void rezerveEt(ActionEvent event) {
        var source = event.getSource();
        var stage = (Stage) btn_rezervasyon.getScene().getWindow();

        int sahteKullaniciId = 1;

        var beginLocalDate = dp_baslangic.getValue();
        var endLocalDate = dp_bitis.getValue();

        if(beginLocalDate != null && endLocalDate != null) {
            ZoneId defaultZoneId = ZoneId.systemDefault();

            var beginDate = Date.from(beginLocalDate.atStartOfDay(defaultZoneId).toInstant());
            var endDate = Date.from(endLocalDate.atStartOfDay(defaultZoneId).toInstant());

            var reservation = new Reservation(beginDate, endDate, sahteKullaniciId);

            var rezervationId = reservationDAO.insert(reservation);


            selectedRoom.setReservationId(rezervationId);


            roomDao.update(selectedRoom);

            refreshTable();
        }


    }

    @FXML
    void rezerveSil(ActionEvent event) {
        if(selectedRoom!= null && selectedRoom.getReservationId() != 0){

            var rezervationId = selectedRoom.getReservationId();

            selectedRoom.setReservationId(0);
            roomDao.update(selectedRoom);

            reservationDAO.delete(rezervationId);

              refreshTable();
        }
    }
  
    private void refreshTable(){

        roomObservableList.clear();

         var rooms = roomDao.findAll();

        roomObservableList.addAll(rooms);

        tbl_room.setItems(roomObservableList);
    }

    @FXML
    void initialize(){
        col_numara.setCellValueFactory(new PropertyValueFactory<>("number"));
        col_kisi.setCellValueFactory(new PropertyValueFactory<>("bedQuantity"));
        col_durum.setCellValueFactory(new PropertyValueFactory<>("reservationStatus"));
        col_fiyat.setCellValueFactory(new PropertyValueFactory<>("price"));

        tbl_room.setOnMouseClicked((
                MouseEvent event) -> {
            if (event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 1){

                var item = tbl_room.getSelectionModel().getSelectedItem();

                if(item != null){
                    this.selectedRoom = item;

                }
            }
        });

        refreshTable();

    }
}

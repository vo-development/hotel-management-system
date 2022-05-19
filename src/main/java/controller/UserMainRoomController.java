package controller;

import dal.dao.RoomDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import pojo.Room;

public class UserMainRoomController {
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

    private ObservableList<Room> RoomObservableList = FXCollections.observableArrayList();
    private RoomDAO RoomDao = new RoomDAO();
    private Room selectedRoom;




    @FXML
    void rezerveEt(ActionEvent event) {

    }

    @FXML
    void rezerveSil(ActionEvent event) {
        if(selectedRoom!= null){
            RoomDao.delete(selectedRoom.getId());
              refreshTable();
        }
    }
  
    private void refreshTable(){

       RoomObservableList.clear();

        var rooms = RoomDAO.findAll();

       RoomObservableList.addAll(rooms);

       tbl_room.setItems(RoomObservableList);
    }

    @FXML
    void initialize(){
        
    }
}

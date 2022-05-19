package controller;

import dal.dao.RoomDAO;
import helper.ViewLoader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
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
        var source = event.getSource();
        var stage = (Stage) btn_rezervasyon.getScene().getWindow();

        if (source.equals(btn_rezervasyon)) {
            var roomController = new CustomerRoomController(0);
            var loginWindow = ViewLoader.load("CustomerRooms", roomController);
            stage.setScene(new Scene( loginWindow));
        }
        else{
            
        }

    }

    @FXML
    void rezerveSil(ActionEvent event) {
        if(selectedRoom!= null){
            RoomDao.delete(selectedRoom.getId());
              refreshTable();
        }
    }
  
    private void refreshTable(){

    //    RoomObservableList.clear();

    //     var rooms = RoomDAO.findAll();

    //    RoomObservableList.addAll(rooms);

    //    tbl_room.setItems(RoomObservableList);
    }

    @FXML
    void initialize(){
        
    }
}

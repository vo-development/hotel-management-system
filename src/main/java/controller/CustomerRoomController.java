package controller;

import dal.dao.RoomDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import pojo.Room;

public class CustomerRoomController extends BaseController {

    private final int HOTEL_ID;

    @FXML
    private Button btn_rezervation;

    @FXML
    private TableColumn<Room, Integer> col_kisi_sayisi;

    @FXML
    private TableColumn<Room, Integer> col_numara;

    @FXML
    private TableView<Room> tbl_rooms;


    private ObservableList<Room> roomObservableList = FXCollections.observableArrayList();

    public CustomerRoomController(int hotel_id) {
        HOTEL_ID = hotel_id;
    }


    @FXML
    void initialize(){

        col_numara.setCellValueFactory(new PropertyValueFactory<>("number"));
        col_kisi_sayisi.setCellValueFactory(new PropertyValueFactory<>("bedQuantity"));

        var roomDAO = new RoomDAO();

        var rooms = roomDAO.findAllByHotelId(HOTEL_ID);

        roomObservableList.addAll(rooms);

        tbl_rooms.setItems(roomObservableList);


    }

    @FXML
    void btnOnClick(ActionEvent event) {

    }

}

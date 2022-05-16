package controller;

import dal.dao.ReservationDAO;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import pojo.Reservation;
import pojo.Room;

import java.sql.Date;
import java.time.ZoneId;

public class CustomerRoomController extends BaseController {

    private final int HOTEL_ID;

    @FXML
    private Button btn_rezervation;

    @FXML
    private TableColumn<Room, Integer> col_kisi_sayisi;

    @FXML
    private TableColumn<Room, Integer> col_numara;

    @FXML
    private TableColumn<Room, Integer> col_price;

    @FXML
    private TableView<Room> tbl_rooms;

    @FXML
    private TableColumn<Room, String> col_rezervation;

    @FXML
    private DatePicker dp_begin;

    @FXML
    private DatePicker dp_end;


    private ObservableList<Room> roomObservableList = FXCollections.observableArrayList();

    public CustomerRoomController(int hotel_id) {
        HOTEL_ID = hotel_id;
    }

    private RoomDAO roomDAO = new RoomDAO();

    private ReservationDAO reservationDAO = new ReservationDAO();

    private Room selectedRoom = null;

    @FXML
    void initialize(){

        col_numara.setCellValueFactory(new PropertyValueFactory<>("number"));
        col_kisi_sayisi.setCellValueFactory(new PropertyValueFactory<>("bedQuantity"));
        col_rezervation.setCellValueFactory(new PropertyValueFactory<>("reservationStatus"));
        col_price.setCellValueFactory(new PropertyValueFactory<>("price"));

        fillTable();

        tbl_rooms.setOnMouseClicked((
                MouseEvent event) -> {
            if (event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 1){

                var item = tbl_rooms.getSelectionModel().getSelectedItem();

                if(item != null){
                    this.selectedRoom = item;

                }
            }
        });
    }


    void fillTable(){
        roomObservableList.clear();


        var rooms = roomDAO.findAllByHotelId(HOTEL_ID);

        roomObservableList.addAll(rooms);

        tbl_rooms.setItems(roomObservableList);

    }


    @FXML
    void btnOnClick(ActionEvent event) {

        int sahteKullaniciId = 3;

        var beginLocalDate = dp_begin.getValue();
        var endLocalDate = dp_end.getValue();

        if(beginLocalDate != null && endLocalDate != null){
            ZoneId defaultZoneId = ZoneId.systemDefault();

            var beginDate = Date.from(beginLocalDate.atStartOfDay(defaultZoneId).toInstant());
            var endDate = Date.from(endLocalDate.atStartOfDay(defaultZoneId).toInstant());

            Reservation reservation = new Reservation(beginDate,endDate,sahteKullaniciId);

            reservationDAO.insert(reservation);

//            selectedRoom.setReservationId(r);

            fillTable();

        }


    }

}

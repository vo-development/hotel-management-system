package controller;

import dal.dao.HotelDAO;
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
import pojo.Hotel;

public class UserMainController extends BaseController{
    @FXML
    private Button btn_rezervasyon;
    @FXML
    private Button btn_musteri;

    @FXML
    private Button btn_yeniHotel;

    @FXML
    private Tab tabHotelRegister;

    @FXML
    private TabPane tabPanel;

    @FXML
    private TableColumn<Hotel, String> col_hotel_address;

    @FXML
    private TableColumn<Hotel, String> col_hotel_city;

    @FXML
    private TableColumn<Hotel, String> col_hotel_name;

    @FXML
    private TableColumn<Hotel, String> col_hotel_town;


    @FXML
    private TableView<Hotel> tbl_hotel;


    private ObservableList<Hotel> hotelObservableList = FXCollections.observableArrayList();
    private HotelDAO hotelDAO = new HotelDAO();

    private Hotel selectedHotel;


    @FXML
    void MusteriKayit(ActionEvent event) {
        var source = event.getSource();
        var stage = (Stage) btn_musteri.getScene().getWindow();

        if (source.equals(btn_musteri)) {
            var customerController = new CustomerRegisterController();
            var loginWindow = ViewLoader.load("CustomerRegister", customerController);
            stage.setScene(new Scene( loginWindow));
        }
        else{

        }

    }

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
    void otelSil(ActionEvent event){

        if(selectedHotel != null){
            hotelDAO.delete(selectedHotel.getId());
            refreshTable();
        }
    }

    @FXML
    void YeniOtelEkle(ActionEvent event) {


        var source = event.getSource();
//        var stage = (Stage) btn_yeniHotel.getScene().getWindow();

        if (source.equals(btn_yeniHotel)) {
            var controller = new HotelRegisterController();
            var registerParent = ViewLoader.load("HotelRegister", controller);
            Stage registerWindow = new Stage();
            registerWindow.setScene(new Scene(registerParent));
            registerWindow.showAndWait();
            refreshTable();
        }

        else {

            // var loginWindow = ViewLoader.load("UserLogin", new UserLoginController());
            // stage.setScene(new Scene(loginWindow));
        }



    }

    private void refreshTable(){

        hotelObservableList.clear();

        var hotels = hotelDAO.findAll();

        hotelObservableList.addAll(hotels);

        tbl_hotel.setItems(hotelObservableList);
    }

    @FXML
    private void initialize(){
        col_hotel_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_hotel_city.setCellValueFactory(new PropertyValueFactory<>("sehir"));
        col_hotel_town.setCellValueFactory(new PropertyValueFactory<>("ilce"));
        col_hotel_address.setCellValueFactory(new PropertyValueFactory<>("aciklama"));
        refreshTable();

        tbl_hotel.setOnMouseClicked((MouseEvent event) -> {
            if (event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 1){

                var item = tbl_hotel.getSelectionModel().getSelectedItem();

                if(item != null){
                   selectedHotel = item;
                }
            }
        });

    }

}

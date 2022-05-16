package controller;

import dal.dao.HotelDAO;
import helper.ViewLoader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import pojo.Hotel;

public class CustomerMainController extends BaseController{

    @FXML
    private TableColumn<Hotel, String> col_name;

    @FXML
    private TableColumn<Hotel, String> col_sehir;

    @FXML
    private TableColumn<Hotel, String> col_ilce;

    @FXML
    private TableColumn<Hotel, String> col_aciklama;
    @FXML
    private TableView<Hotel> tbl_hotels;



    private ObservableList<Hotel> hotelObservableList = FXCollections.observableArrayList();

    @FXML
    private void initialize(){

        col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_sehir.setCellValueFactory(new PropertyValueFactory<>("sehir"));
        col_ilce.setCellValueFactory(new PropertyValueFactory<>("ilce"));
        col_aciklama.setCellValueFactory(new PropertyValueFactory<>("aciklama"));


        var hotelDAO = new HotelDAO();

        var hotels = hotelDAO.findAll();


        hotelObservableList.addAll(hotels);

        tbl_hotels.setItems(hotelObservableList);

        // Tabloya tiklandigi zaman calisan method
        tbl_hotels.setOnMouseClicked((MouseEvent event) -> {
            if (event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 2){

                var item = tbl_hotels.getSelectionModel().getSelectedItem();

                if(item != null){
                    Stage stage = new Stage();
                    CustomerRoomController controller = new CustomerRoomController(item.getId());
                    var customerRoom = ViewLoader.load("CustomerRooms",controller);
                    stage.setScene(new Scene(customerRoom));
                    stage.show();

                }


            }
        });

    }



}

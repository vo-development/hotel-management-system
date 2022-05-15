package controller;

import dal.dao.HotelDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import pojo.Hotel;

public class MainController extends BaseController{

    @FXML
    private Tab tab_hotels;

    @FXML
    private TableColumn<Hotel, Integer> col_id;

    @FXML
    private TableColumn<Hotel, String> col_name;


    @FXML
    private TableView<Hotel> tbl_hotels;

    ObservableList<Hotel> hotelObservableList = FXCollections.observableArrayList();

    @FXML
    private void initialize(){


        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_name.setCellValueFactory(new PropertyValueFactory<>("name"));


        var hotelDAO = new HotelDAO();

        var hotels = hotelDAO.findAll();


        hotelObservableList.addAll(hotels);

        tbl_hotels.setItems(hotelObservableList);
    }



}

package controller;

import dal.dao.UserDAO;
import helper.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.apache.commons.validator.routines.EmailValidator;
import pojo.User;


//otel çalisan kayit yeri
public class HotelRegisterController extends BaseController{

    @FXML
    private TextField txt_HotelAdres;

    @FXML
    private TextField txt_HotelIlce;

    @FXML
    private TextField txt_HotelName;

    @FXML
    private TextField txt_hotelSehir;

    @FXML
    void registerHotelOnClick(ActionEvent event) {

    }
    
}
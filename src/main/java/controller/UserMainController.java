package controller;

import helper.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

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
    void YeniOtelEkle(ActionEvent event) {


        var source = event.getSource();
//        var stage = (Stage) btn_yeniHotel.getScene().getWindow();

        if (source.equals(btn_yeniHotel)) {
            var controller = new HotelRegisterController();
            var registerParent = ViewLoader.load("HotelRegister", controller);
            Stage registerWindow = new Stage();
            registerWindow.setScene(new Scene(registerParent));
            registerWindow.showAndWait();
        }

        else {

            // var loginWindow = ViewLoader.load("UserLogin", new UserLoginController());
            // stage.setScene(new Scene(loginWindow));
        }



    }

    @FXML
    private void initialize(){

        // var node = ViewLoader.load("HotelRegister",new HotelRegisterController());
        // tabHotelRegister.setContent(node);
    }

}

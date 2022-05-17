package controller;

import dal.dao.HotelDAO;
import helper.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pojo.Hotel;


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

private String hotelName ;
private String hotelIlce;
private String hotelSehir;
private String hotelAdres;

private boolean isBlank(){
    return hotelName.isBlank()||
    hotelAdres.isBlank()||
    hotelIlce.isBlank()||
    hotelSehir.isBlank();

}

private void showAlert(String msg){
    new Alert(Alert.AlertType.WARNING,msg).showAndWait();

}
private boolean validInputs(){

     
    if(isBlank()){
        showAlert("Tüm alanlar dolu olmalıdır!");
        return false;
    }

    return true;
}





    @FXML
    void registerHotelOnClick(ActionEvent event) {
        
        this.hotelName = txt_HotelName.getText();
        this.hotelAdres = txt_HotelAdres.getText();
        this.hotelIlce = txt_HotelIlce.getText();
        this.hotelSehir = txt_hotelSehir.getText();
       

        boolean isValid = validInputs();

        if(isValid){

            HotelDAO customerDAO = new HotelDAO();

            Hotel hotel = new Hotel(hotelName,hotelAdres,hotelIlce,hotelSehir);

            System.out.println("Hotel: "+hotel);

            var result = customerDAO.insert(hotel);

            if(result != 0){

                showAlert("Kayıt Eklendi!");

                var stage = (Stage) txt_HotelName.getScene().getWindow();
                var loginWindow = ViewLoader.load("Login",new UserLoginController());
                stage.setScene(new Scene(loginWindow));
            }

            else {
                showAlert("Kayıt eklenemedi!");
            }

        }

    }
    
}
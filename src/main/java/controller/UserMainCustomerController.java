package controller;

import dal.dao.CustomerDAO;
import helper.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import pojo.Customer;

public class UserMainCustomerController extends BaseController{
    @FXML
    private Button btn_musteri;

    @FXML
    private TableColumn<Customer, String> col_adres;

    @FXML
    private TableColumn<Customer, String> col_isim;

    @FXML
    private TableColumn<Customer, String> col_main;

    @FXML
    private TableColumn<Customer, String> col_sifre;

    @FXML
    private TableColumn<Customer, String> col_tc;

    @FXML
    private TableColumn<Customer, String> col_telefon;

    @FXML
    private TableView<Customer> tbl_musteri;
    
    private Customer selectedCustomer;

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
    void musteriSil(ActionEvent event) {
        if(selectedCustomer != null){
            CustomerDAO.delete(selectedCustomer.getId());
             refreshTable();
        }
    }

    @FXML
    void initialize(){
        
    }
    
}

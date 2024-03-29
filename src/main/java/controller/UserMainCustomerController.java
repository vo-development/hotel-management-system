package controller;

import dal.dao.CustomerDAO;
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
import pojo.Customer;

public class UserMainCustomerController extends BaseController{
    @FXML
    private Button btn_musteri;

    @FXML
    private TableColumn<Customer, String> col_adres;

    @FXML
    private TableColumn<Customer, String> col_isim;

    @FXML
    private TableColumn<Customer, String> col_mail;

    @FXML
    private TableColumn<Customer, String> col_sifre;

    @FXML
    private TableColumn<Customer, String> col_tc;

    @FXML
    private TableColumn<Customer, String> col_telefon;

    @FXML
    private TableView<Customer> tbl_musteri;



    private ObservableList<Customer> customerObservableList = FXCollections.observableArrayList();
    private CustomerDAO customerDAO = new CustomerDAO();
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
            customerDAO.delete(selectedCustomer.getId());
              refreshTable();
        }
    }
    private void refreshTable(){

         customerObservableList.clear();

         var customers = customerDAO.findAll();

        customerObservableList.addAll(customers);

         tbl_musteri.setItems(customerObservableList);
    }
    @FXML
    void initialize(){
        col_adres.setCellValueFactory(new PropertyValueFactory<>("adress"));
        col_isim.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_mail.setCellValueFactory(new PropertyValueFactory<>("mail"));
        col_tc.setCellValueFactory(new PropertyValueFactory<>("tcNo"));
        col_telefon.setCellValueFactory(new PropertyValueFactory<>("phoneNo"));




        // Tabloya tiklandigi zaman calisan method
        tbl_musteri.setOnMouseClicked
        ((MouseEvent event) -> {
            if (event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 1){

                var item = tbl_musteri.getSelectionModel().getSelectedItem();

                if(item != null){
                    selectedCustomer = item;

                }


            }
        });

        refreshTable();
        
    }


    
}

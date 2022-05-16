package controller;

import helper.ViewLoader;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class UserMainController extends BaseController{

    @FXML
    private Tab tabHotelRegister;

    @FXML
    private TabPane tabPanel;

    @FXML
    private void initialize(){

        var node = ViewLoader.load("HotelRegister",new HotelRegisterController());

        tabHotelRegister.setContent(node);
    }

}

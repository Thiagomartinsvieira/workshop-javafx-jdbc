package org.example.workshopjavafxjdbc.gui;

import com.sun.tools.javac.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import org.example.workshopjavafxjdbc.HelloApplication;
import org.example.workshopjavafxjdbc.gui.util.Alerts;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {

    @FXML
    private MenuItem menuItemSeller;
    @FXML
    private MenuItem menuItemDepartment;
    @FXML
    private MenuItem menuItemAbout;

    @FXML
    public void onMenuItemSellerAction() {
        System.out.println("onMenuSellerAction");
    }

    @FXML
    public void onMenuItemDepartmentAction() {
        loadView("/org/example/workshopjavafxjdbc/gui/DepartmentList.fxml");
    }

    @FXML
    public void onMenuItemAboutAction() {
        loadView("/org/example/workshopjavafxjdbc/gui/About.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    private void loadView(String absoluteName) {
       try {
           FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
           VBox newVbox = loader.load();

           Scene mainScene = HelloApplication.getMainScene();
           VBox mainVbox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();

           Node mainMenu = mainVbox.getChildren().get(0);
           mainVbox.getChildren().clear();
           mainVbox.getChildren().add(mainMenu);
           mainVbox.getChildren().addAll(newVbox.getChildren());

       } catch (IOException e) {
           Alerts.showAlert("Io Exception", "Error loading view", e.getMessage(), Alert.AlertType.ERROR);
       }
    }
}

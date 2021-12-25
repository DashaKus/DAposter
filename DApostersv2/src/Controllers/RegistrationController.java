package Controllers;

import Logic.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.stage.Stage;

import java.awt.*;
import java.io.*;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class RegistrationController<event> {

    User user = new User();
    String user_name;
    String user_password;
    String login;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button exit_the_program;

    @FXML
    private TextField name;

    @FXML
    private PasswordField password;

    @FXML
    private Button sing_up;

    @FXML
    private TextField user_login;

    public RegistrationController() {
    }

    @FXML
    void switch_to_Library(javafx.event.ActionEvent event) throws IOException {

        int sum=0;
        user_name=name.getText();
        login=user_login.getText();
        user_password=password.getText();
        sum= user.write_user_info(login,user_password,user_name);
        if(sum==0){
            Parent root = FXMLLoader.load(getClass().getResource("../Views/Library.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else {
            // Вот сдесь потом в этот лэйбл надо записать что ошибка login_is_used.setText("This username is in use, select another!");
        }
    }
}

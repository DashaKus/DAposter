package Controllers;

import Logic.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class AvtorisaionController {

    User user = new User();
    String login;
    String password;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label is_not_correct;

    @FXML
    private Button exit_the_program;

    @FXML
    private Button registration;

    @FXML
    private Button sign_in;

    @FXML
    private TextField user_login;

    @FXML
    private PasswordField user_password;

    @FXML
    public void exit_the_program(javafx.event.ActionEvent event) throws IOException {
        System.exit(0);
    }

    @FXML
    void switch_to_Library(javafx.event.ActionEvent event) throws IOException {

        login = user_login.getText();
        password = user_password.getText();

        int sum=0;
        sum=user.correctinfo(login, password);
        System.out.println(sum);
        if (sum != 0) {
            Parent root = FXMLLoader.load(getClass().getResource("../Views/Library.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else {
            is_not_correct.setText("Your login or password is wrong!");
        }

    }

    @FXML
    void switch_to_Registration(javafx.event.ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../Views/Registration.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}
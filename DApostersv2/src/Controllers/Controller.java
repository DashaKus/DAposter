package Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.ScrollBar;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.Objects;

public class Controller {


    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button exit;

    @FXML
    private PasswordField user_password;

    @FXML
    private TextField user_login;

    @FXML
    private TextField name;

    @FXML
    private PasswordField password;

    @FXML
    private Button sing_up;
    @FXML
    private Button registration;

    @FXML
    private Button sign_in;

    @FXML
    private CheckBox background_color_chek;

    @FXML
    private CheckBox chek_format;

    @FXML
    private CheckBox chek_text_align;

    @FXML
    private ScrollBar scrollbar;


    @FXML
    private CheckBox chek_text_placement;

    @FXML
    private CheckBox chek_text_shape;

    @FXML
    private Button exit_the_program;

    @FXML
    private Button generate;

    @FXML
    private Button word_add_word;

    @FXML
    private TextField word_main_word;

    @FXML
    private TextField word_name;

    public void switch_to_Registration(javafx.event.ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../Views/Registration.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switch_to_Generation(javafx.event.ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../Views/Generation.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switch_to_Library(javafx.event.ActionEvent  event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../Views/Library.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switch_to_Viewing(javafx.event.ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../Views/Viewing.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void exit_the_program(javafx.event.ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../Views/Viewing.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        System.exit(0);
    }

}

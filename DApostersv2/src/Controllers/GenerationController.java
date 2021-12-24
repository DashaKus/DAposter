package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class GenerationController {

    private Stage stage;
    private Scene scene;
    private Parent root;
    int column =2;
    int row=1;
    @FXML
    private CheckBox background_color_chek;

    @FXML
    private CheckBox chek_text_align;

    @FXML
    private CheckBox chek_text_placement;

    @FXML
    private CheckBox chek_text_placement1;

    @FXML
    private CheckBox chek_text_placement11;

    @FXML
    private CheckBox chek_text_shape;

    @FXML
    private Button exit_the_program;

    @FXML
    private Button generate;

    @FXML
    private ColorPicker choose_color;

    @FXML
    private GridPane word_gride;

    @FXML
    public void exit_the_program(javafx.event.ActionEvent event) throws IOException {
        System.exit(0);
    }

    @FXML
    public void switch_to_Viewing(javafx.event.ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../Views/Viewing.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void add_words(javafx.event.ActionEvent event) throws IOException{
        TextField new_words= new TextField();
        new_words.setPrefSize(178,30);
        word_gride.add(new_words,column,row);
        row++;
    }

}
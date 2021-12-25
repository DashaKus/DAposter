package Controllers;

import Logic.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GenerationController implements Initializable  {

    private Stage stage;
    private Scene scene;
    private Parent root;
    int row=0;


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
    private TextField main_word;

    @FXML
    private TextField name_word;

    @FXML
    private Label user_name;


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
        new_words.setPrefSize(178,40);
        word_gride.setMinWidth(Region.USE_COMPUTED_SIZE);
        word_gride.setPrefWidth(Region.USE_COMPUTED_SIZE);
        word_gride.setMaxWidth(Region.USE_PREF_SIZE);
        word_gride.add(new_words,0,row++);
        word_gride.setMargin(new_words,new Insets(1));

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        word_gride.add(name_word,0,row++);
        word_gride.add(main_word,0,row++);
        user_name.setText(User.getUser_Name());
    }
}
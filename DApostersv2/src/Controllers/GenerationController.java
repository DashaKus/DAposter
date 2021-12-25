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

public class GenerationController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    int align;
    int placement;

    int row=0;

    @FXML
    private RadioButton background_color_chek1;

    @FXML
    private RadioButton background_color_chek2;

    @FXML
    private RadioButton background_color_chek3;

    @FXML
    private RadioButton background_color_chek4;

    @FXML
    private RadioButton chek_text_align1;

    @FXML
    private RadioButton chek_text_align2;

    @FXML
    private RadioButton chek_text_align3;

    @FXML
    private RadioButton chek_text_placement;

    @FXML
    private RadioButton chek_text_placement1;

    @FXML
    private RadioButton chek_text_placement11;

    @FXML
    private RadioButton chek_text_placement2;

    @FXML
    private RadioButton chek_text_placement3;

    @FXML
    private RadioButton chek_text_shape1;

    @FXML
    private RadioButton chek_text_shape2;

    @FXML
    private RadioButton chek_text_shape3;

    @FXML
    private ColorPicker choose_color;

    @FXML
    private Button exit_the_program;

    @FXML
    private Button generate;

    @FXML
    private TextField main_word;

    @FXML
    private TextField name_word;

    @FXML
    private GridPane word_gride;

    @FXML
    private Label user_name;


    @FXML
    public void exit_the_program(javafx.event.ActionEvent event) throws IOException {
        System.exit(0);
    }

    @FXML
    public void switch_to_Viewing(javafx.event.ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../Views/Viewing.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void add_words(javafx.event.ActionEvent event) throws IOException {
        TextField new_words = new TextField();
        new_words.setPrefSize(178, 40);
        word_gride.setMinWidth(Region.USE_COMPUTED_SIZE);
        word_gride.setPrefWidth(Region.USE_COMPUTED_SIZE);
        word_gride.setMaxWidth(Region.USE_PREF_SIZE);
        word_gride.add(new_words, 0, row++);
        word_gride.setMargin(new_words, new Insets(1));

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        word_gride.add(name_word, 0, row++);
        word_gride.add(main_word, 0, row++);
        user_name.setText(User.getUser_Name());

        ToggleGroup chek_text_align = new ToggleGroup();
        chek_text_align1.setToggleGroup(chek_text_align);
        chek_text_align2.setToggleGroup(chek_text_align);
        chek_text_align3.setToggleGroup(chek_text_align);
        chek_text_align1.setOnAction(event ->align = 80);
        chek_text_align2.setOnAction(event ->align = 300);
        chek_text_align3.setOnAction(event ->align = 900);

        ToggleGroup chek_text_shape = new ToggleGroup();
        chek_text_shape1.setToggleGroup(chek_text_shape);
        chek_text_shape2.setToggleGroup(chek_text_shape);
        chek_text_shape3.setToggleGroup(chek_text_shape);


        ToggleGroup chek_text_placement = new ToggleGroup();
        chek_text_placement1.setToggleGroup(chek_text_placement);
        chek_text_placement2.setToggleGroup(chek_text_placement);
        chek_text_placement3.setToggleGroup(chek_text_placement);
        chek_text_placement1.setOnAction(event ->placement = 254);
        chek_text_placement2.setOnAction(event ->placement = 877);
        chek_text_placement3.setOnAction(event ->placement = 1554);

        ToggleGroup background_color_chek = new ToggleGroup();
        background_color_chek1.setToggleGroup(background_color_chek);
        background_color_chek2.setToggleGroup(background_color_chek);
        background_color_chek3.setToggleGroup(background_color_chek);

    }
}


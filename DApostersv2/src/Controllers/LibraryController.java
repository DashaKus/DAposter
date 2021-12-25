package Controllers;

import Logic.Show_poster;
import com.sun.javafx.scene.control.ContextMenuContent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class LibraryController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;

    private List<Show_poster> posters= new ArrayList<>();

    @FXML
    private GridPane lib_grid;

    @FXML
    private ScrollPane lib_scroll;

    @FXML
    private GridPane my_grid;

    @FXML
    private ScrollPane my_scroll;


    @FXML
    private Button exit_the_program;

    @FXML
    private Button toGenerate;

    @FXML
    public void exit_the_program(javafx.event.ActionEvent event) throws IOException {

        System.exit(0);
    }

    @FXML
    public void switch_to_Generation(javafx.event.ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../Views/Generation.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    private List<Show_poster> getPosters(){
        List<Show_poster> posters= new ArrayList<>();
        Show_poster poster;
        for (int i=0 ; i<9; i++){
            poster = new Show_poster();
            poster.setImgSrc("/image/add new poster.png");
            posters.add(poster);
        }
        return posters;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        posters.addAll(getPosters());
        int column =0;
        int row=0;
        try {
        for(int i=0;i<posters.size();i++) {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/Views/Image.fxml"));
            AnchorPane anchorPane = fxmlLoader.load();

            ImageController imageController = fxmlLoader.getController();
            imageController.setData(posters.get(i));
            if (column==3){ column = 0; row++;}
            my_grid.add(anchorPane,column++,row);
            GridPane.setMargin(anchorPane,new Insets(10));
        }
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
    }



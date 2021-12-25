package Controllers;

import Logic.Show_poster;
import Logic.User;
import com.sun.javafx.scene.control.ContextMenuContent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class LibraryController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;



    private List<Show_poster> my_posters= new ArrayList<>();
    private List<Show_poster> lib_posters= new ArrayList<>();

    @FXML
    private GridPane lib_grid;

    @FXML
    private ScrollPane lib_scroll;

    @FXML
    private GridPane my_grid;

    @FXML
    private ScrollPane my_scroll;

    @FXML
    private Label user_name;

    @FXML
    private Button exit_the_program;

    @FXML
    private Button toGenerate;

    @FXML
    public void exit_the_program(javafx.event.ActionEvent event) throws IOException {

        System.exit(0);
    }

    @FXML
    public void switch_to_Generation(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("../Views/Generation.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    private List<Show_poster> getData(String SRC){
        List<Show_poster> posters= new ArrayList<>();
        Show_poster poster;
        for (int i=1 ; i<20; i++){
            poster = new Show_poster();
            poster.setImgSrc("SRC");
            posters.add(poster);
        }
        return posters;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        my_posters.addAll(getData(User.getUser_LibSRC()));
        lib_posters.addAll(getData("/Info/common_lib.txt"));
        int column1 =0;
        int row1=1;
        int column2 =0;
        int row2=1;
        try {
       for(int i=0; i< my_posters.size();i++) {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/Views/Image.fxml"));
            AnchorPane anchorPane = fxmlLoader.load();

            ImageController imageController = fxmlLoader.getController();
            imageController.setData( my_posters.get(i));
            if (column1==3){ column1 = 0; row1++;}

            my_grid.setMinWidth(Region.USE_COMPUTED_SIZE);
            my_grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
            my_grid.setMaxWidth(Region.USE_PREF_SIZE);

            my_grid.setMinHeight(Region.USE_COMPUTED_SIZE);
            my_grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
            my_grid.setMaxHeight(Region.USE_PREF_SIZE);

            my_grid.add(anchorPane,column1++,row1);
            GridPane.setMargin(anchorPane,new Insets(10));
        }
            for(int y=0; y<lib_posters.size();y++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/Views/Image.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                ImageController imageController = fxmlLoader.getController();
                imageController.setData(lib_posters.get(y));
                if (column2==3){ column2 = 0; row2++;}
                lib_grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                lib_grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                lib_grid.setMaxWidth(Region.USE_PREF_SIZE);

                lib_grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                lib_grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                lib_grid.setMaxHeight(Region.USE_PREF_SIZE);

                lib_grid.add(anchorPane,column2++,row2);
                GridPane.setMargin(anchorPane,new Insets(10));
            }
            if (column1==3){ column1 = 0; row1++;}
            my_grid.add(toGenerate,column1,row1);
            user_name.setText(User.getUser_Name());
        }catch (IOException e) {
            e.printStackTrace();
        }
        }
    }



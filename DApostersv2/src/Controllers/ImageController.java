package Controllers;

import Logic.Show_poster;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URISyntaxException;

public class ImageController {

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private ImageView poster;

    private Show_poster posters;

    public void switch_to_Generation(javafx.event.ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../Views/Generation.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void setData(Show_poster posters) throws URISyntaxException {
        this.posters= posters;
        Image image = new Image(getClass().getResourceAsStream(posters.getImgSrc()),80,100,false,false);
        poster.setImage(image);
    }

}

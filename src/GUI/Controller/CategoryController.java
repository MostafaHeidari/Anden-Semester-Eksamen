package GUI.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class CategoryController {

    @FXML
    private javafx.scene.layout.HBox HBox;
    @FXML
    private Text funktionsniveau_1;
    @FXML
    private Text funktionsniveau_2;



    private void skiftVindue(String vindue) throws IOException {

        Stage switcher = (Stage) HBox.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/View/SubCatergories/SC_funktionsniveau_1.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        SubcategoryController controller = loader.getController();
        controller.setId(vindue);

        switcher.setTitle("SOSU System");
        switcher.setScene(scene);
    }

    public void funktionsniveau_1(MouseEvent mouseEvent) throws IOException {
        skiftVindue("funktionsniveau_1");
    }

    public void funktionsniveau_2(MouseEvent mouseEvent) throws IOException {
        skiftVindue("funktionsniveau_2");
    }

    public void bevægeapparat_1(MouseEvent mouseEvent) {
    }

    public void seksualitet_1(MouseEvent mouseEvent) {
    }

    public void hudogslimhinder_1(MouseEvent mouseEvent) {
    }

    public void hudogslimhinder_2(MouseEvent mouseEvent) {
    }

    public void hudogslimhinder_3(MouseEvent mouseEvent) {
    }

    public void hudogslimhinder_4(MouseEvent mouseEvent) {
    }

    public void hudogslimhinder_5(MouseEvent mouseEvent) {
    }

    public void hudogslimhinder_6(MouseEvent mouseEvent) {
    }

    public void hudogslimhinder_7(MouseEvent mouseEvent) {
    }

    public void hudogslimhinder_8(MouseEvent mouseEvent) {
    }

    public void hudogslimhinder_9(MouseEvent mouseEvent) {
    }

    public void respirationogcirkulation_1(MouseEvent mouseEvent) {
    }

    public void respirationogcirkulation_2(MouseEvent mouseEvent) {
    }

    public void ernæring_1(MouseEvent mouseEvent) {
    }

    public void ernæring_2(MouseEvent mouseEvent) {
    }

    public void ernæring_3(MouseEvent mouseEvent) {
    }

    public void ernæring_4(MouseEvent mouseEvent) {
    }

    public void ernæring_5(MouseEvent mouseEvent) {
    }

    public void smerterogsanseindtryk_1(MouseEvent mouseEvent) {
    }

    public void smerterogsanseindtryk_2(MouseEvent mouseEvent) {
    }

    public void smerterogsanseindtryk_3(MouseEvent mouseEvent) {
    }

    public void smerterogsanseindtryk_4(MouseEvent mouseEvent) {
    }

    public void smerterogsanseindtryk_5(MouseEvent mouseEvent) {
    }

    public void smerterogsanseindtryk_6(MouseEvent mouseEvent) {
    }

    public void smerterogsanseindtryk_7(MouseEvent mouseEvent) {
    }

    public void smerterogsanseindtryk_8(MouseEvent mouseEvent) {
    }

    public void søvnoghvile_1(MouseEvent mouseEvent) {
    }

    public void søvnoghvile_2(MouseEvent mouseEvent) {
    }

    public void videnogudvikling_1(MouseEvent mouseEvent) {
    }

    public void videnogudvikling_2(MouseEvent mouseEvent) {
    }

    public void videnogudvikling_3(MouseEvent mouseEvent) {
    }

    public void videnogudvikling_4(MouseEvent mouseEvent) {
    }

    public void videnogudvikling_5(MouseEvent mouseEvent) {
    }

    public void kommunikation_1(MouseEvent mouseEvent) {
    }

    public void psykosocialeforhold_1(MouseEvent mouseEvent) {
    }

    public void psykosocialeforhold_2(MouseEvent mouseEvent) {
    }

    public void psykosocialeforhold_3(MouseEvent mouseEvent) {
    }

    public void psykosocialeforhold_4(MouseEvent mouseEvent) {
    }

    public void udskillelseafaffaldsstoffer_1(MouseEvent mouseEvent) {
    }

    public void udskillelseafaffaldsstoffer_2(MouseEvent mouseEvent) {
    }

    public void udskillelseafaffaldsstoffer_3(MouseEvent mouseEvent) {
    }

    public void udskillelseafaffaldsstoffer_4(MouseEvent mouseEvent) {
    }

    public void udskillelseafaffaldsstoffer_5(MouseEvent mouseEvent) {
    }

    public void Test(MouseEvent mouseEvent) {
    }

    public void Test1(MouseEvent mouseEvent) {
    }
}

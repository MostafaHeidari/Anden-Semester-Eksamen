package GUI.Controller.Unvesial;

import GUI.Controller.SubcategoryController;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class CategoryController {

    @FXML
    private javafx.scene.layout.HBox HBox;
    @FXML
    private Text funktionsniveau_1;
    @FXML
    private Text funktionsniveau_2;
    @FXML
    private JFXButton btnCategoryTilbage;

    // this button is used to turn back to Category window//
    public void CategoryTilbage(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) btnCategoryTilbage.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Patient.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("SOSU System");
        switcher.setScene(scene);
    }

    // this method is used to change the window to Subcategory//
    private void skiftVindue(String vindue) throws IOException, SQLException {

        Stage switcher = (Stage) HBox.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/View/SubCategories.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        SubcategoryController controller = loader.getController();
        controller.setId(vindue);

        switcher.setTitle("SOSU System");
        switcher.setScene(scene);
    }

    // fxml event on mouse click//
    public void funktionsniveau_1(MouseEvent mouseEvent) throws IOException, SQLException {
        skiftVindue("Problemer med personlig pleje");
    }

    public void funktionsniveau_2(MouseEvent mouseEvent) throws IOException, SQLException {
        skiftVindue("Problemer med daglige aktiviteter");
    }

    public void bevægeapparat_1(MouseEvent mouseEvent) throws IOException, SQLException {
        skiftVindue("Problemer med mobilitet og bevægelse");
    }

    public void seksualitet_1(MouseEvent mouseEvent) throws IOException, SQLException {
        skiftVindue("Problemer med seksualitet");
    }

    public void hudogslimhinder_1(MouseEvent mouseEvent) throws IOException, SQLException {
        skiftVindue("Problemer med kirurgisk sår");
    }

    public void hudogslimhinder_2(MouseEvent mouseEvent) throws IOException, SQLException {
        skiftVindue("Problemer med diabetisk sår");
    }

    public void hudogslimhinder_3(MouseEvent mouseEvent) throws IOException, SQLException {
        skiftVindue("Problemer med cancersår");
    }

    public void hudogslimhinder_4(MouseEvent mouseEvent) throws IOException, SQLException {
        skiftVindue("Problemer med tryksår");
    }

    public void hudogslimhinder_5(MouseEvent mouseEvent) throws IOException, SQLException {
        skiftVindue("Problemer med arterielt sår");
    }

    public void hudogslimhinder_6(MouseEvent mouseEvent) throws IOException, SQLException {
        skiftVindue("Problemer med venøst sår");
    }

    public void hudogslimhinder_7(MouseEvent mouseEvent) throws IOException, SQLException {
        skiftVindue("Problemer med blandingssår");
    }

    public void hudogslimhinder_8(MouseEvent mouseEvent) throws IOException, SQLException {
        skiftVindue("Problemer med traumesår");
    }

    public void hudogslimhinder_9(MouseEvent mouseEvent) throws IOException, SQLException {
        skiftVindue("Andre problemer med hud og slimhinder");
    }

    public void respirationogcirkulation_1(MouseEvent mouseEvent) throws IOException, SQLException {
        skiftVindue("Respirationsproblemer");
    }

    public void respirationogcirkulation_2(MouseEvent mouseEvent) throws IOException, SQLException {
        skiftVindue("Cirkulationsproblemer");
    }

    public void ernæring_1(MouseEvent mouseEvent) throws IOException, SQLException {
        skiftVindue("Problemer med væskeindtag");
    }

    public void ernæring_2(MouseEvent mouseEvent) throws IOException, SQLException {
        skiftVindue("Problemer med fødeindtag");
    }

    public void ernæring_3(MouseEvent mouseEvent) throws IOException, SQLException {
        skiftVindue("Uhensigtsmæssig vægtændring");
    }

    public void ernæring_4(MouseEvent mouseEvent) throws IOException, SQLException {
        skiftVindue("Problemer med overvægt");
    }

    public void ernæring_5(MouseEvent mouseEvent) throws IOException, SQLException {
        skiftVindue("Problemer med undervægt");
    }

    public void smerterogsanseindtryk_1(MouseEvent mouseEvent) throws IOException, SQLException {
        skiftVindue("Akutte smerter");
    }

    public void smerterogsanseindtryk_2(MouseEvent mouseEvent) throws IOException, SQLException {
        skiftVindue("Periodevise smerter");
    }

    public void smerterogsanseindtryk_3(MouseEvent mouseEvent) throws IOException, SQLException {
        skiftVindue("Kroniske smerter");
    }

    public void smerterogsanseindtryk_4(MouseEvent mouseEvent) throws IOException, SQLException {
        skiftVindue("Problemer med synssans");
    }

    public void smerterogsanseindtryk_5(MouseEvent mouseEvent) throws IOException, SQLException {
        skiftVindue("Problemer med lugtesans");
    }

    public void smerterogsanseindtryk_6(MouseEvent mouseEvent) throws IOException, SQLException {
        skiftVindue("Problemer med hørelse");
    }

    public void smerterogsanseindtryk_7(MouseEvent mouseEvent) throws IOException, SQLException {
        skiftVindue("Problemer med smagssans");
    }

    public void smerterogsanseindtryk_8(MouseEvent mouseEvent) throws IOException, SQLException {
        skiftVindue("Problemer med følesans");
    }

    public void søvnoghvile_1(MouseEvent mouseEvent) throws IOException, SQLException {
        skiftVindue("Døgnrytmeproblemer");
    }

    public void søvnoghvile_2(MouseEvent mouseEvent) throws IOException, SQLException {
        skiftVindue("Søvnproblemer");
    }

    public void videnogudvikling_1(MouseEvent mouseEvent) throws IOException, SQLException {
        skiftVindue("Problemer med hudkommelse");
    }

    public void videnogudvikling_2(MouseEvent mouseEvent) throws IOException, SQLException {
        skiftVindue("Problemer med indsigt i Behandlingsformål");
    }

    public void videnogudvikling_3(MouseEvent mouseEvent) throws IOException, SQLException {
        skiftVindue("Problemer med sygdomsindsigt");
    }

    public void videnogudvikling_4(MouseEvent mouseEvent) throws IOException, SQLException {
        skiftVindue("Kognitive Problemer");
    }

    public void kommunikation_1(MouseEvent mouseEvent) throws IOException, SQLException {
        skiftVindue("Problemer med kommunikation");
    }

    public void psykosocialeforhold_1(MouseEvent mouseEvent) throws IOException, SQLException {
        skiftVindue("Problemer med socialt samvær");
    }

    public void psykosocialeforhold_2(MouseEvent mouseEvent) throws IOException, SQLException {
        skiftVindue("Emotionelle problemer");
    }

    public void psykosocialeforhold_3(MouseEvent mouseEvent) throws IOException, SQLException {
        skiftVindue("Problemer med misbrug");
    }

    public void psykosocialeforhold_4(MouseEvent mouseEvent) throws IOException, SQLException {
        skiftVindue("Mentale problemer");
    }

    public void udskillelseafaffaldsstoffer_1(MouseEvent mouseEvent) throws IOException, SQLException {
        skiftVindue("Problemer med vandladning");
    }

    public void udskillelseafaffaldsstoffer_2(MouseEvent mouseEvent) throws IOException, SQLException {
        skiftVindue("Problemer med urininkontinens");
    }

    public void udskillelseafaffaldsstoffer_3(MouseEvent mouseEvent) throws IOException, SQLException {
        skiftVindue("Problemer med afføringsindkontinens");
    }

    public void udskillelseafaffaldsstoffer_4(MouseEvent mouseEvent) throws IOException, SQLException {
        skiftVindue("Problemer med mave og tarm");
    }

    public void udskillelseafaffaldsstoffer_5(MouseEvent mouseEvent) throws IOException, SQLException {
        skiftVindue("Problemer med væske fra dræn");
    }

    public void Test(MouseEvent mouseEvent) {
    }

    public void Test1(MouseEvent mouseEvent) {
    }
}

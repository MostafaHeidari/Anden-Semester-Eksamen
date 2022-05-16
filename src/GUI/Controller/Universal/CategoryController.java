package GUI.Controller.Universal;

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
    private JFXButton btnCategoryBack;
    @FXML
    private Text funktionsniveau_1;
    @FXML
    private Text bevægeapparat_1;

    /**
     * Goes to Patient view
     */
    public void CategoryBack(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) btnCategoryBack.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Patient.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("SOSU Helbredstilstande");
        switcher.setScene(scene);
    }

    /**
     * Goes to SubCategories view
     */
    private void shiftWindow(String vindue) throws IOException, SQLException {

        Stage switcher = (Stage) HBox.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/View/Universal/SubCategories.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        SubcategoryController controller = loader.getController();
        controller.setId(vindue);

        switcher.setTitle("SOSU System");
        switcher.setScene(scene);
    }

    /**
     * Subcategory changing text
     */
    public void funktionsniveau_1(MouseEvent mouseEvent) throws IOException, SQLException {
        Stage switcher = (Stage) funktionsniveau_1.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/View/Universal/SubCategoriesFunktionsNiveau.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        SubcategoryFunctionLevelController controller = loader.getController();
        controller.setId();

        switcher.setTitle("Funktions Niveau");
        switcher.setScene(scene);
    }

    /**
     * Subcategory changing text
     */
    public void bevægeapparat_1(MouseEvent mouseEvent) throws IOException, SQLException {
        Stage switcher = (Stage) bevægeapparat_1.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/View/Universal/SubCategoriesMovingApparat.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        SubcategoryFunctionLevelController controller = loader.getController();
        controller.setId();

        switcher.setTitle("Funktions Niveau");
        switcher.setScene(scene);
    }

    /**
     * Subcategory changing text
     */
    public void seksualitet_1(MouseEvent mouseEvent) throws IOException, SQLException {
        shiftWindow("Problemer med seksualitet");
    }

    public void hudogslimhinder_1(MouseEvent mouseEvent) throws IOException, SQLException {
        shiftWindow("Problemer med kirurgisk sår");
    }

    /**
     * Subcategory changing text
     */
    public void hudogslimhinder_2(MouseEvent mouseEvent) throws IOException, SQLException {
        shiftWindow("Problemer med diabetisk sår");
    }

    /**
     * Subcategory changing text
     */
    public void hudogslimhinder_3(MouseEvent mouseEvent) throws IOException, SQLException {
        shiftWindow("Problemer med cancersår");
    }

    /**
     * Subcategory changing text
     */
    public void hudogslimhinder_4(MouseEvent mouseEvent) throws IOException, SQLException {
        shiftWindow("Problemer med tryksår");
    }

    /**
     * Subcategory changing text
     */
    public void hudogslimhinder_5(MouseEvent mouseEvent) throws IOException, SQLException {
        shiftWindow("Problemer med arterielt sår");
    }

    /**
     * Subcategory changing text
     */
    public void hudogslimhinder_6(MouseEvent mouseEvent) throws IOException, SQLException {
        shiftWindow("Problemer med venøst sår");
    }

    /**
     * Subcategory changing text
     */
    public void hudogslimhinder_7(MouseEvent mouseEvent) throws IOException, SQLException {
        shiftWindow("Problemer med blandingssår");
    }

    /**
     * Subcategory changing text
     */
    public void hudogslimhinder_8(MouseEvent mouseEvent) throws IOException, SQLException {
        shiftWindow("Problemer med traumesår");
    }

    /**
     * Subcategory changing text
     */
    public void hudogslimhinder_9(MouseEvent mouseEvent) throws IOException, SQLException {
        shiftWindow("Andre problemer med hud og slimhinder");
    }

    /**
     * Subcategory changing text
     */
    public void respirationogcirkulation_1(MouseEvent mouseEvent) throws IOException, SQLException {
        shiftWindow("Respirationsproblemer");
    }

    /**
     * Subcategory changing text
     */
    public void respirationogcirkulation_2(MouseEvent mouseEvent) throws IOException, SQLException {
        shiftWindow("Cirkulationsproblemer");
    }

    /**
     * Subcategory changing text
     */
    public void ernæring_1(MouseEvent mouseEvent) throws IOException, SQLException {
        shiftWindow("Problemer med væskeindtag");
    }

    /**
     * Subcategory changing text
     */
    public void ernæring_2(MouseEvent mouseEvent) throws IOException, SQLException {
        shiftWindow("Problemer med fødeindtag");
    }

    /**
     * Subcategory changing text
     */
    public void ernæring_3(MouseEvent mouseEvent) throws IOException, SQLException {
        shiftWindow("Uhensigtsmæssig vægtændring");
    }

    /**
     * Subcategory changing text
     */
    public void ernæring_4(MouseEvent mouseEvent) throws IOException, SQLException {
        shiftWindow("Problemer med overvægt");
    }

    /**
     * Subcategory changing text
     */
    public void ernæring_5(MouseEvent mouseEvent) throws IOException, SQLException {
        shiftWindow("Problemer med undervægt");
    }

    /**
     * Subcategory changing text
     */
    public void smerterogsanseindtryk_1(MouseEvent mouseEvent) throws IOException, SQLException {
        shiftWindow("Akutte smerter");
    }

    /**
     * Subcategory changing text
     */
    public void smerterogsanseindtryk_2(MouseEvent mouseEvent) throws IOException, SQLException {
        shiftWindow("Periodevise smerter");
    }

    /**
     * Subcategory changing text
     */
    public void smerterogsanseindtryk_3(MouseEvent mouseEvent) throws IOException, SQLException {
        shiftWindow("Kroniske smerter");
    }

    /**
     * Subcategory changing text
     */
    public void smerterogsanseindtryk_4(MouseEvent mouseEvent) throws IOException, SQLException {
        shiftWindow("Problemer med synssans");
    }

    /**
     * Subcategory changing text
     */
    public void smerterogsanseindtryk_5(MouseEvent mouseEvent) throws IOException, SQLException {
        shiftWindow("Problemer med lugtesans");
    }

    /**
     * Subcategory changing text
     */
    public void smerterogsanseindtryk_6(MouseEvent mouseEvent) throws IOException, SQLException {
        shiftWindow("Problemer med hørelse");
    }

    /**
     * Subcategory changing text
     */
    public void smerterogsanseindtryk_7(MouseEvent mouseEvent) throws IOException, SQLException {
        shiftWindow("Problemer med smagssans");
    }

    /**
     * Subcategory changing text
     */
    public void smerterogsanseindtryk_8(MouseEvent mouseEvent) throws IOException, SQLException {
        shiftWindow("Problemer med følesans");
    }

    /**
     * Subcategory changing text
     */
    public void søvnoghvile_1(MouseEvent mouseEvent) throws IOException, SQLException {
        shiftWindow("Døgnrytmeproblemer");
    }

    /**
     * Subcategory changing text
     */
    public void søvnoghvile_2(MouseEvent mouseEvent) throws IOException, SQLException {
        shiftWindow("Søvnproblemer");
    }

    /**
     * Subcategory changing text
     */
    public void videnogudvikling_1(MouseEvent mouseEvent) throws IOException, SQLException {
        shiftWindow("Problemer med hudkommelse");
    }

    public void videnogudvikling_2(MouseEvent mouseEvent) throws IOException, SQLException {
        shiftWindow("Problemer med indsigt i Behandlingsformål");
    }

    /**
     * Subcategory changing text
     */
    public void videnogudvikling_3(MouseEvent mouseEvent) throws IOException, SQLException {
        shiftWindow("Problemer med sygdomsindsigt");
    }

    /**
     * Subcategory changing text
     */
    public void videnogudvikling_4(MouseEvent mouseEvent) throws IOException, SQLException {
        shiftWindow("Kognitive Problemer");
    }

    /**
     * Subcategory changing text
     */
    public void kommunikation_1(MouseEvent mouseEvent) throws IOException, SQLException {
        shiftWindow("Problemer med kommunikation");
    }

    /**
     * Subcategory changing text
     */
    public void psykosocialeforhold_1(MouseEvent mouseEvent) throws IOException, SQLException {
        shiftWindow("Problemer med socialt samvær");
    }

    /**
     * Subcategory changing text
     */
    public void psykosocialeforhold_2(MouseEvent mouseEvent) throws IOException, SQLException {
        shiftWindow("Emotionelle problemer");
    }

    /**
     * Subcategory changing text
     */
    public void psykosocialeforhold_3(MouseEvent mouseEvent) throws IOException, SQLException {
        shiftWindow("Problemer med misbrug");
    }

    /**
     * Subcategory changing text
     */
    public void psykosocialeforhold_4(MouseEvent mouseEvent) throws IOException, SQLException {
        shiftWindow("Mentale problemer");
    }

    /**
     * Subcategory changing text
     */
    public void udskillelseafaffaldsstoffer_1(MouseEvent mouseEvent) throws IOException, SQLException {
        shiftWindow("Problemer med vandladning");
    }

    /**
     * Subcategory changing text
     */
    public void udskillelseafaffaldsstoffer_2(MouseEvent mouseEvent) throws IOException, SQLException {
        shiftWindow("Problemer med urininkontinens");
    }

    /**
     * Subcategory changing text
     */
    public void udskillelseafaffaldsstoffer_3(MouseEvent mouseEvent) throws IOException, SQLException {
        shiftWindow("Problemer med afføringsindkontinens");
    }

    /**
     * Subcategory changing text
     */
    public void udskillelseafaffaldsstoffer_4(MouseEvent mouseEvent) throws IOException, SQLException {
        shiftWindow("Problemer med mave og tarm");
    }

    /**
     * Subcategory changing text
     */
    public void udskillelseafaffaldsstoffer_5(MouseEvent mouseEvent) throws IOException, SQLException {
        shiftWindow("Problemer med væske fra dræn");
    }

}

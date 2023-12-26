package slideComponent;

import javafx.application.Platform;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import observerComponents.Infastructure.Observer;

import java.util.Date;
import java.util.List;
import java.util.Random;

public class SlideComponent implements Observer {


    private List<String> based = List.of("Анекдот", "Прикол", "Ужас", "Комедия", "Триллер", "Психология");

    private Text textChild = new Text(based.get(new Random().nextInt(0, 5)));
    private BorderPane component = new BorderPane();
    public SlideComponent() {
        this.component.setCenter(this.textChild);
    }
    public BorderPane getComponent() { return component; }
    @Override
    public void update(Date date) {
        Platform.runLater(() -> {
            component.getChildren().clear();

            textChild.setText(based.get(new Random().nextInt(0, 5)));

            if (date.getSeconds() % 2 == 0) this.component.setTop(this.textChild);
            else { this.component.setBottom(this.textChild);}
        });
    }
}

package ClockComponents;

import javafx.scene.text.Font;
import javafx.scene.text.Text;
import observerComponents.Infastructure.Observer;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

public class ClockComponent implements Observer {
    private final Text text = new Text();
    LocalTime localTime = LocalTime.of(0, 0, 0);
    @Override
    public void update() {
        localTime = localTime.plusSeconds(1);
        text.setText(String.valueOf(localTime.getHour())+":"+String.valueOf(localTime.getMinute())+":"+String.valueOf(localTime.getSecond()));
    }

    public Text getClock(){
        return this.text;
    }
}

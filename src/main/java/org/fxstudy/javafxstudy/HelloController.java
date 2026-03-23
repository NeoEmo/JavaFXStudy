package org.fxstudy.javafxstudy;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;


public class HelloController {
    @FXML
    public Label mainTitle;
    public Button mainButton;
    public ProgressBar Progression;
    public Label todayIS;
    public CheckBox godMode;
    public CheckBox debugMode;
    public CheckBox moreMoneyMode;
    public CheckBox idiotsMode;
    public Label welcomeText;
    private int count = 1;
    private final Map<String, MediaPlayer> player = new LinkedHashMap<>(16, 0.75f, true) {
        @Override
        protected boolean removeEldestEntry(Map.Entry<String, MediaPlayer> eldest) {
            return size()>10;
        }
    };



    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
        mainTitle.setText("Magic Preobrazovanie Ebat`");
    }

    @FXML
    protected void buttonClicked() {
        int power = godMode.isSelected() ? 99 : 1;

        System.out.println("Button Clicked! - " + count);
        mainButton.setText("Button Clicked - " + count);
        Progression.setProgress(count / 100.0);

        if (count > 99) {
            mainTitle.setText("M-M-M-M-MONSTER KILL!!!");
        } else if (count > 49) {
            mainTitle.setText("GGGGGOOODLIKE!");
        } else if (count > 9) {
            mainTitle.setText("MULTIKILL");
        } else if (count > 4) {
            mainTitle.setText("HOLYYY SHIIT!");
        } else {
            mainTitle.setText("You poor!");
        }

        if (count == 100) {
            monsterKill();
        } else if (count == 50) {
            godLike();
        } else if (count == 10) {
            multiKill();
        } else if (count == 5) {
            holyShit();
        }

        count += power;
    }

    @FXML
    protected void setTodayIS() {
        LocalDateTime now = LocalDateTime.now();
        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();
        int hour = now.getHour();
        int minutes = now.getMinute();
        String currentDate = String.format("Сегодня %d.%02d.%d , %d:%d", day, month, year, hour, minutes);
        todayIS.setText(currentDate);
    }

    @FXML
    protected void checksDebug() {
        int power = godMode.isSelected() ? 99 : 1;
        if (debugMode.isSelected()) {
            welcomeText.setText("РЕЖИМ РАЗРАБОТЧИКА ВКЛЮЧЕН! Сейчас power - " + power);
        } else {
            welcomeText.setText("Suka Blyad");
        }
    }

    @FXML
    protected void checksMoreMoney() {
        if (moreMoneyMode.isSelected()) {
            welcomeText.setText("Ошибка, вы не ввели номер карты :DDDD");
        } else {
            welcomeText.setText("Suka Blyad");
        }
    }

    @FXML
    protected void checksIdiots() {
        if (idiotsMode.isSelected()) {
            welcomeText.setText("Обнаружен пидорас перед экраном");
        } else {
            welcomeText.setText("Suka Blyad");
        }
    }

    @FXML
    protected void monsterKill() {
        playSound("MonsterKill.mp3");
    }

    @FXML
    protected void godLike() {
        playSound("f_godlike.mp3");
    }

    @FXML
    protected void multiKill() {
        playSound("multi-kill.mp3");
    }

    @FXML
    protected void holyShit() {
        playSound("holy-shit.mp3");
    }

    @FXML
    protected void monkey() {
        playSound("monnkey-screeamm.mp3");
    }

    @FXML
    protected void openLink() {
        HelloApplication.getAppHostServices().showDocument("https://github.com/NeoEmo");
    }

    @FXML
    private void playSound(String fileName) {
        MediaPlayer mediaPlayer = player.get(fileName);
        if (mediaPlayer == null) {
            String soundPath = Objects.requireNonNull(getClass()
                    .getResource("/org/fxstudy/javafxstudy/" + fileName))
                    .toExternalForm();
            Media sound = new Media(soundPath);
            mediaPlayer = new MediaPlayer(sound);
            player.put(fileName, mediaPlayer);
        }
        mediaPlayer.stop();
        mediaPlayer.play();
    }
}
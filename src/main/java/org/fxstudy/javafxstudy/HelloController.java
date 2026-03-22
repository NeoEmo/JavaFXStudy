package org.fxstudy.javafxstudy;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public class HelloController {
    @FXML
    public Label mainTitle;
    public Button mainButton;
    public ProgressBar Progression;
    public Label todayIS;
    public CheckBox godMode;
    public CheckBox debagMode;
    public CheckBox moreMoneyMode;
    public CheckBox idiotsMode;
    public Label welcomeText;
    private int count = 1;

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
        int Year = java.time.LocalDateTime.now().getYear();
        int Month = java.time.LocalDateTime.now().getMonth().getValue();
        int Day = java.time.LocalDateTime.now().getDayOfMonth();
        int Hour = java.time.LocalDateTime.now().getHour();
        int Minutes = java.time.LocalDateTime.now().getMinute();
        String currentDate;
        if (Month < 10) {
            currentDate = "Сегодня " + Day + ".0" + Month + "." + Year + " , " + Hour + ":" + Minutes;
        } else {
            currentDate = "Сегодня " + Day + "." + Month + "." + Year + " , " + Hour + ":" + Minutes;
        }
        todayIS.setText(currentDate);
    }

    @FXML
    protected void checksDebug() {
        int power = godMode.isSelected() ? 99 : 1;
        if (debagMode.isSelected()) {
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
        try {
            String soundPath = getClass()
                    .getResource("/org/fxstudy/javafxstudy/MonsterKill.mp3")
                    .toExternalForm();
            Media sound = new Media(soundPath);
            MediaPlayer mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void godLike() {
        try {
            String soundPath = getClass()
                    .getResource("/org/fxstudy/javafxstudy/f_godlike.mp3")
                    .toExternalForm();
            Media sound = new Media(soundPath);
            MediaPlayer mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void multiKill() {
        try {
            String soundPath = getClass()
                    .getResource("/org/fxstudy/javafxstudy/multi-kill.mp3")
                    .toExternalForm();
            Media sound = new Media(soundPath);
            MediaPlayer mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void holyShit() {
        try {
            String soundPath = getClass()
                    .getResource("/org/fxstudy/javafxstudy/holy-shit.mp3")
                    .toExternalForm();
            Media sound = new Media(soundPath);
            MediaPlayer mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void monkey() {
        try {
            String soundPath = getClass()
                    .getResource("/org/fxstudy/javafxstudy/monnkey-screeamm.mp3")
                    .toExternalForm();
            Media sound = new Media(soundPath);
            MediaPlayer mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void openLink() {
        HelloApplication.getAppHostServices().showDocument("https://github.com/NeoEmo");
    }
}
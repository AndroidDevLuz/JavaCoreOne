package lesson8;

import javax.swing.*;
import java.awt.*;
import java.security.AlgorithmParameterGenerator;

import static lesson8.Logic.printMap;

public class StartNewGameWindow extends JFrame {

    public static final int WIN_HEIGHT = 450;
    public static final int WIN_WIDTH = 400;
    public static final int WIN_POS_X = 650;
    public static final int WIN_POS_Y = 550;

    public static final int MIN_FIELD_SIZE = 3;
    public static final int MAX_FIELD_SIZE = 10;

    public static final int MIN_WIN_LENGTH = 3;



    private JRadioButton jrbHumVsAi;
    private JRadioButton jrbHumVsHum;
    private ButtonGroup gameMode;

    private JSlider jsFieldSize;
    private JSlider jsWinLength;

    private GameWindow gameWindow;

    public StartNewGameWindow(GameWindow gameWindow){

        this.gameWindow = gameWindow;

        setBounds(WIN_POS_X, WIN_POS_Y, WIN_WIDTH, WIN_HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("TicTacToe");
        setResizable(false);

        setLayout(new GridLayout(8,1));

        //gameMode
        add(new JLabel("Выберите режим игры"));
        jrbHumVsAi = new JRadioButton("HumVsAi");
        jrbHumVsHum = new JRadioButton("HumVsHum");

        gameMode = new ButtonGroup();
        gameMode.add(jrbHumVsAi);
        gameMode.add(jrbHumVsHum);

        add(jrbHumVsAi);
        add(jrbHumVsHum);


        //size
        //dots to win
        add(new JLabel("Выберите размер поля"));
        jsFieldSize = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE,MIN_FIELD_SIZE);
        jsFieldSize.addChangeListener( e -> {
            int fieldSize = jsFieldSize.getValue();
            jsWinLength.setMaximum(fieldSize);

        });

        jsFieldSize.setMajorTickSpacing(1);
        //jsFieldSize.setMinorTickSpacing(5);
        jsFieldSize.setPaintLabels(true);
        jsFieldSize.setPaintTicks(true);
        add(jsFieldSize);



        add(new JLabel("Количество победных символов"));
        jsWinLength = new JSlider(MIN_WIN_LENGTH,MAX_FIELD_SIZE,MIN_WIN_LENGTH);
        jsWinLength.addChangeListener( e -> {



        });

        jsWinLength.setMajorTickSpacing(1);
        //jsFieldSize.setMinorTickSpacing(5);
        jsWinLength.setPaintLabels(true);
        jsWinLength.setPaintTicks(true);
        add(jsWinLength);



        JButton btnStartGame = new JButton("Start new Game");
        add(btnStartGame);
        btnStartGame.addActionListener( e -> {
            btnStartGameClick();
        });


        setVisible(false);


    }


    private void btnStartGameClick() {
        setVisible(false);
        int gameMode;
        if(jrbHumVsAi.isSelected()){
            gameMode = BattleMap.MODE_H_V_A;
        } else{
            gameMode = BattleMap.MODE_H_V_H;
        }

        int fieldSize = jsFieldSize.getValue();
        int winLength = jsWinLength.getValue();

        Logic.SIZE = fieldSize;
        Logic.DOTS_TO_WIN = winLength;

        Logic.initMap();
        Logic.printMap();

        Logic.gameFinished = false;

        gameWindow.startNewGame(gameMode, fieldSize, fieldSize, winLength);



    }


}

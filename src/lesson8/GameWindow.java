package lesson8;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {

    public static final int WIN_HEIGHT = 555;
    public static final int WIN_WIDTH = 507;
    public static final int WIN_POS_X = 500;
    public static final int WIN_POS_Y = 555;

    private StartNewGameWindow startNewGameWindow;
    private BattleMap field;


    public GameWindow(){

        setBounds(WIN_POS_X,WIN_POS_Y,WIN_WIDTH,WIN_HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("TicTacToe");
        setResizable(false);

        startNewGameWindow = new StartNewGameWindow(this);
        field = new BattleMap(this);
        add(field, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new GridLayout(1,2));
        JButton btnNewGame = new JButton("Start new game");
        bottomPanel.add(btnNewGame);

        btnNewGame.addActionListener(event -> {
            startNewGameWindow.setVisible(true);
        });

        JButton btnExit = new JButton("Exit");
        bottomPanel.add(btnExit);

        btnExit.addActionListener(event -> {
            System.exit(0);
        });

        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void startNewGame(int gameMode, int fieldSizeX, int fieldSizeY, int winLength){
        field.startNewGame(gameMode,fieldSizeX,fieldSizeY, winLength);
    }
}

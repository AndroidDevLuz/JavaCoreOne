package lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ImageObserver;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.RenderableImage;
import java.text.AttributedCharacterIterator;
import java.util.Map;

import static lesson8.Logic.DOT_O;
import static lesson8.Logic.DOT_X;

public class BattleMap extends JPanel {

    private GameWindow gameWindow;

    public static final int MODE_H_V_A = 0;
    public static final int MODE_H_V_H = 1;

    private int fieldSizeX;
    private int fieldSizeY;
    private int winLength;


    private int cellHeight;
    private int cellWidth;

    private boolean isInit = false;


    public BattleMap(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        setBackground(Color.ORANGE);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                update(e);
            }
        });
    }

    private void update(MouseEvent e) {
        int cellX = e.getX() / cellWidth;
        int cellY = e.getY() / cellHeight;
        if (!Logic.gameFinished) {
            Logic.setHumanXY(cellX, cellY);
        }

        System.out.println(cellX + "" + cellY);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);

    }

    private void render(Graphics g) {
        if (!isInit) {
            return;
        }

        int panelWidth = getWidth();
        int panelHeigth = getHeight();

        cellHeight = panelHeigth / fieldSizeY;
        cellWidth = panelWidth / fieldSizeX;

        for (int i = 0; i < fieldSizeY; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, panelWidth, y);
        }

        for (int i = 0; i < fieldSizeX; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, panelHeigth);
        }

        for (int i = 0; i < Logic.SIZE; i++) {
            for (int j = 0; j < Logic.SIZE; j++) {
                if (Logic.map[i][j] == DOT_O) {
                    drawO(g, j, i);
                }
                if (Logic.map[i][j] == DOT_X) {
                    drawX(g, j, i);
                }
            }
        }

        /*
        Кусочек для победных линий
         */

        /*if(Logic.checkWin(DOT_O)){
            drawWinLine(DOT_O, type);
        }

        if(Logic.checkWin(DOT_X)){
            drawWinLine(DOT_X, type);
        }

        drawVL(g, 2, 0);
        drawVL(g, 2, 1);
        drawVL(g, 2, 2);

        drawHL(g, 0, 0);
        drawHL(g, 1, 0);
        drawHL(g, 2, 0);*/




    }

    private void drawWinLine(Graphics g, int cellX, int cellY) {

    }

    private void drawHL(Graphics g, int cellX, int cellY) {
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setStroke(new BasicStroke(10));
        graphics2D.setColor(new Color(255, 3, 0));
        graphics2D.drawLine((cellX) *cellWidth, (cellY) * cellHeight+cellHeight/2, (cellX+1) * cellWidth, (cellY) * cellHeight+cellHeight/2);
        graphics2D.setPaintMode();
    }

    private void drawVL(Graphics g, int cellX, int cellY) {
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setStroke(new BasicStroke(10));
        graphics2D.setColor(new Color(255, 3, 0));
        graphics2D.drawLine((cellX) *cellWidth + cellWidth/2, (cellY + 1) * cellHeight, (cellX) * cellWidth + cellWidth/2, (cellY) * cellHeight);
        graphics2D.setPaintMode();
    }

    private void drawO(Graphics g, int cellX, int cellY) {
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setStroke(new BasicStroke(10));
        graphics2D.setColor(new Color(0, 0, 255));
        graphics2D.drawOval(cellX * cellWidth, cellY * cellHeight, cellWidth, cellHeight);

    }

    private void drawX(Graphics g, int cellX, int cellY) {
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setStroke(new BasicStroke(10));
        graphics2D.setColor(new Color(255, 3, 0));
        graphics2D.drawLine(cellX * cellWidth, cellY * cellHeight, (cellX + 1) * cellWidth, (cellY + 1) * cellHeight);
        graphics2D.drawLine((cellX) * cellWidth, (cellY + 1) * cellHeight, (cellX + 1) * cellWidth, (cellY) * cellHeight);
        graphics2D.setPaintMode();
    }




    public void startNewGame(int gameMode, int fieldSizeX, int fieldSizeY, int winLength) {
        System.out.println(gameMode + " " + fieldSizeX + " " + fieldSizeY + " " + winLength);
        this.fieldSizeX = fieldSizeX;
        this.fieldSizeY = fieldSizeY;
        this.winLength = winLength;
        isInit = true;
        repaint();

    }
}

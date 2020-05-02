package lesson7_1;

import javax.swing.*;
import javax.swing.text.FlowView;
import java.awt.*;

public class Window extends JFrame {


    public Window(){
        setBounds(600,200,500,500);
        setTitle("Калькулятор");


        initUI();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void initUI() {

        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(new BoxLayout(panelCenter, BoxLayout.X_AXIS));

        JPanel panelBottom = new JPanel(new GridLayout(1,4));


        JButton btn1 = new JButton("Кнопка 1");
        panelBottom.add(btn1);

        JButton btn2 = new JButton("Кнопка 2");
        panelBottom.add(btn2);



        JTextField text = new JTextField();
        panelCenter.add(text);

        /*btn1.addActionListener( button -> {
            text.("Hello!!! \n");
        });*/

        add(panelCenter, BorderLayout.NORTH);
        add(panelBottom, BorderLayout.SOUTH);

    }


}

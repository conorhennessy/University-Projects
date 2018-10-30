import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrawCalc extends JFrame {
    public DrawCalc() {
        JPanel cPanel = new JPanel();
        JPanel sPanel = new JPanel();

        add(cPanel, BorderLayout.CENTER);
        add(sPanel, BorderLayout.SOUTH);

        TextField text = new TextField(10);
        sPanel.add(text);

        JButton setBut = new JButton("Set");
        JButton calcareaBut = new JButton("Calc Area");
        sPanel.add(setBut);
        sPanel.add(calcareaBut);

    }

    public abstract class Shape {
        int posX;
        int posY;

        public abstract void setShape();


    }

    public class Square extends Shape {
        int sideLength;

        public Square(int posX, int posY, int sideLength) {
            this.posX = posX;
            this.posY = posY;
            this.sideLength = sideLength;
        }

        @Override
        public void setShape(int posX, int posY, int sideLength) {
            int cposX = posX;
            int cposY = posY;
            int csideLength = sideLength;
            //stuff to take arguments and use them to set pos and side leng of square
        }

        //
    }

    class ButtonHandler implements ActionListener{
        DrawCalc theApp;
        int actionType;

        public ButtonHandler(DrawCalc theApp, int actionType){
            this.theApp = theApp;
            this.actionType = actionType;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            //based on action type do stuff
        }
    }

    public static void main(String[] args) {
        //bla
    }
}

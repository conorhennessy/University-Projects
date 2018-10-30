import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrawCalc extends JFrame {
    TextField text;

    public DrawCalc() {
        setSize(750, 750);
        setLayout(new BorderLayout());


        JPanel cPanel = new JPanel();
        JPanel sPanel = new JPanel();

        text = new TextField(10);
        sPanel.add(text);

        JLabel sqrButtonLabel = new JLabel("Square: ");
        JButton sqrSetBut = new JButton("Set");
        JButton sqrCalcAreaBut = new JButton("Calc Area");
        sqrSetBut.addActionListener(new ButtonHandler(this, 1));
        sqrCalcAreaBut.addActionListener(new ButtonHandler(this, 2));

        JLabel circleButtonLabel = new JLabel("Circle: ");
        JButton circleSetBut = new JButton("Set");
        JButton circleCalcAreaBut = new JButton("Calc Area");
        circleSetBut.addActionListener(new ButtonHandler(this, 3));
        circleCalcAreaBut.addActionListener(new ButtonHandler(this, 4));

        sPanel.add(sqrButtonLabel);
        sPanel.add(sqrSetBut);
        sPanel.add(sqrCalcAreaBut);

        sPanel.add(circleButtonLabel);
        sPanel.add(circleSetBut);
        sPanel.add(circleCalcAreaBut);

        add(cPanel, BorderLayout.CENTER);
        add(sPanel, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }


    class ButtonHandler implements ActionListener {
        DrawCalc theApp;
        int actionType;

        public ButtonHandler(DrawCalc theApp, int actionType) {
            this.theApp = theApp;
            this.actionType = actionType;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            //Convert input of the text field to Int
            int value = Integer.parseInt(theApp.text.getText());

            Square defaultSq = new Square(50, 50, 20);
            Circle defaultCircle = new Circle(50, 50, 20);

            DrawCalc frame = new DrawCalc();

            if (actionType == 1) {
                //Set length of square as set button was pressed
                defaultSq.setSize(value);
                frame.repaint();
            } else if (actionType == 2) {
                //Calculate area of square as Calc Area button pressed
                defaultSq.getArea();
            } else if (actionType == 3) {
                //Set radius of circle as button pressed
                defaultCircle.setSize(value);
                frame.repaint();

            } else if (actionType == 4) {
                //Calculate area of circle as Calc Area button pressed
                defaultCircle.getArea();
            }
        }
    }

    public static void main(String[] args) {
        new DrawCalc();
    }
}

class ShapePanel extends JPanel{
    DrawCalc theApp;

    void Panel(DrawCalc app) { theApp = app; }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.green);
        g.fillRect(50, 50, this.getSize(), this.getSize());
    }
}

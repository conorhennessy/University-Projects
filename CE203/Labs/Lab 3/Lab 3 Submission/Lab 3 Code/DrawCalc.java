import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrawCalc extends JFrame {
    TextField text;

    JPanel cPanel;  //This panel is initialised here so that I can access and add a label in my button action method

    Square defaultSq = new Square(50, 50, 0);
    Circle defaultCircle = new Circle(50, 50, 0);

    public DrawCalc() {
        setSize(600, 600);
        setLayout(new BorderLayout());
        setResizable(false);


        cPanel = new JPanel(){
            @Override
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                g.setColor(Color.orange);

                g.fillRect(defaultSq.posX, defaultSq.posY, defaultSq.sideLength, defaultSq.sideLength);

                g.fillOval(defaultCircle.posX, defaultCircle.posY, defaultCircle.radius, defaultCircle.radius);
            }
        };
        JPanel sPanel = new JPanel();

        text = new TextField(10);                            //Field item for user size input
        sPanel.add(text);

        //All frame items for squares
        JLabel sqrButtonLabel = new JLabel("Square: ");
        JButton sqrSetBut = new JButton("Set");
        JButton sqrCalcAreaBut = new JButton("Calc Area");
        sqrSetBut.addActionListener(new ButtonHandler(this, 1));
        sqrCalcAreaBut.addActionListener(new ButtonHandler(this, 2));

        //All frame items for circles
        JLabel circleButtonLabel = new JLabel("Circle: ");
        JButton circleSetBut = new JButton("Set");
        JButton circleCalcAreaBut = new JButton("Calc Area");
        circleSetBut.addActionListener(new ButtonHandler(this, 3));
        circleCalcAreaBut.addActionListener(new ButtonHandler(this, 4));

        //Putting all Square & Circle items into pannels to go into frames
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


            if (actionType == 1) {
                //Set Square button  -  set size of square
                defaultSq.setSize(value);
                defaultCircle.setSize(0);

                System.out.println(defaultSq.info());
            } else if (actionType == 2) {
                // Calc area button  -  calculate area of current shape
                if (defaultSq.sideLength == 0){              //Handling to see if the button is pressed while a circle is actually drawn
                    JOptionPane.showMessageDialog(DrawCalc.this, defaultCircle.info());
                }
                else {
                    //Calculate area of square as Calc Area button pressed
                    JOptionPane.showMessageDialog(DrawCalc.this, defaultSq.info());
                }

            } else if (actionType == 3) {
                //Set Square button  -  set radius of circle
                defaultSq.setSize(0);
                defaultCircle.setSize(value);

                System.out.println(defaultCircle.info());
            } else if (actionType == 4) {
                // Calc area button  -  calculate area of current shape
                if (defaultCircle.radius == 0){              //Handling to see if the button is pressed while a square is actually drawn
                    JOptionPane.showMessageDialog(DrawCalc.this, defaultSq.info());
                }
                else {
                    //Calculate area of circle as Calc Area button pressed
                    JOptionPane.showMessageDialog(DrawCalc.this, defaultCircle.info());
                }
            }

            theApp.repaint();                                //With each button press, shape is repainted
        }
    }

    public static void main(String[] args) {
        new DrawCalc();
    }
}

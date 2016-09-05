import java.awt.Graphics;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.Timer;

public class SurprisedPig extends JPanel implements KeyListener
{

   //animation-related variables
   private int eyeDiameter = 10;
   private int eye1_X = 165;
   private int eye2_X = 225;
   private int eye__Y = 110;
   private int eyeMaxDiameter = 40;
   private int eyeMinDiameter = 10;
   
   protected void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      
      //things to paint
      label(g);
      pig(g);          
   }
   
   // methods for things to paint
   void label(Graphics g)
   {
      g.setColor(Color.BLACK);
      g.setFont(new Font("Helvetica", Font.PLAIN, 14));
      g.drawString("hold the up-arrow to surprise the pig, down-arrow to calm him down", 15, 20);
      g.drawLine(15, 30, 450, 30);
   }
   
   void pig(Graphics g)
   {
      //head
      g.setColor(new Color(255, 200, 220));
      g.fillOval(100, 50, 200, 200);
      g.setColor(Color.BLACK);
      g.drawOval(100, 50, 200, 200);
   
      //nose
      g.drawOval(160, 160, 80, 60);
      g.fillOval(182, 182, 16, 16);
      g.fillOval(202, 182, 16, 16);
      
      //eyes
      g.setColor(Color.WHITE);
      g.fillOval(150, 95, eyeMaxDiameter, eyeMaxDiameter);
      g.fillOval(210, 95, eyeMaxDiameter, eyeMaxDiameter);
      g.setColor(Color.BLACK);
      g.fillOval(eye1_X, eye__Y, eyeDiameter, eyeDiameter);
      g.fillOval(eye2_X, eye__Y, eyeDiameter, eyeDiameter);

   }
   
   // animation
   void stepUp() 
   {
      if (eyeDiameter < eyeMaxDiameter) {
         eyeDiameter = eyeDiameter + 2;
         eye1_X = eye1_X - 1;
         eye2_X = eye2_X - 1;
         eye__Y = eye__Y - 1;           
         repaint();
      }
   }

   void stepDown() 
   {
      if (eyeDiameter > eyeMinDiameter) {
         eyeDiameter = eyeDiameter - 2;
         eye1_X = eye1_X + 1;
         eye2_X = eye2_X + 1;
         eye__Y = eye__Y + 1;           
         repaint();
      }
   }
   
   public SurprisedPig()
   {
      setBackground(Color.WHITE); // background color
      setBorder(BorderFactory.createLineBorder(Color.BLACK)); // border color
      addKeyListener(this);
   }


    public void addNotify() {
        super.addNotify();
        requestFocus();
    }
    
    public void keyPressed(KeyEvent e) {
        // check which key is pressed to trigger animation
        if (e.getKeyCode() == KeyEvent.VK_UP) { 
             stepUp();
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) { 
             stepDown();
        }
    }

    public void keyReleased(KeyEvent e) { }
    public void keyTyped(KeyEvent e) { }

      
   public static void main(String[] args)
   {
      JFrame window = new JFrame("My Original Design"); // window title
      window.setBounds(100, 100, 500, 300); // window position and size
      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      SurprisedPig panel = new SurprisedPig();
      Container c = window.getContentPane();
      c.add(panel);
      window.setVisible(true);
   }
}

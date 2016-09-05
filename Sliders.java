import java.awt.Graphics;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.Timer;

public class Sliders extends JPanel
{

   //animation-related variables
   private int xPos = 30;
   private int changePerStep = 5;
   private static int stepsPerSecond = 30;
   
   protected void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      
      //things to paint
      label(g);
      square1(g);
      square2(g);
      square3(g);            
   }
   
   // methods for things to paint
   void label(Graphics g)
   {
      g.setColor(Color.BLACK);
      g.setFont(new Font("Helvetica", Font.PLAIN, 14));
      g.drawString("Sliders", 15, 20);
   }
   
   void square1(Graphics g)
   {
      g.setColor(new Color(50, 200, 100));
      g.fillRect(xPos, 30, 50, 50);
   }
  
   void square2(Graphics g)
   {
      g.setColor(new Color(50, 100, 200));
      g.fillRect(xPos, 90, 50, 50);
   }

   void square3(Graphics g)
   {
      g.setColor(new Color(200, 50, 100));
      g.fillRect(xPos, 150, 50, 50);
   }
   
   // animation
   void step() 
   {
      if (xPos + 50 < this.getWidth())
      {
         xPos = xPos + changePerStep;
         repaint();
      }
   }

   public Sliders()
   {
      setBackground(Color.WHITE); // background color
      setBorder(BorderFactory.createLineBorder(Color.BLACK)); // border color
   }

   public static class MyListener implements ActionListener
   {
       private Sliders slider;
   
       public MyListener(Sliders slider){
           this.slider = slider;
       }
   
       public void actionPerformed(ActionEvent e) {
           slider.step();
       }
   }
      
   public static void main(String[] args)
   {
      JFrame window = new JFrame("My Original Design"); // window title
      window.setBounds(100, 100, 400, 400); // window position and size
      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Sliders panel = new Sliders();
      Container c = window.getContentPane();
      c.add(panel);
      MyListener listener = new MyListener(panel);
      Timer timer = new Timer(1000/stepsPerSecond, listener);
      timer.start();
      window.setVisible(true);
   }
}

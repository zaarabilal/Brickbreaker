

	import javax.swing.*;
	import java.awt.*;
	import java.awt.event.*;

	public class Main extends JFrame{
	  private static final int WIDTH =750;
	  private static final int HEIGHT=750;
	  
	  public Main () {
	    super("Brickbreaker-Zaara Bilal");
	    setSize(WIDTH, HEIGHT);
	    //setSize(Toolkit.getDefaultToolkit().getScreenSize().width,Toolkit.getDefaultToolkit().getScreenSize().height);
	    Game play = new Game();
	    ((Component) play).setFocusable(true);
	Color background=new Color(169,235,219);
	    setBackground(background);
	    getContentPane().add(play);
	    
	    setVisible(true);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	  }
	  

	  public static void main(String[] args) {
	    Main run = new Main();
	    

	  }


	}




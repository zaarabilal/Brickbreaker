

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.awt.event.*;

public class Game extends JPanel  implements Runnable, KeyListener{
private BufferedImage back; 
private Ball ball1;
private Paddle pd;
private Player p;
private int key;
private ArrayList <Brick> brickList;
private Brick brick;
private ImageIcon background;




public Game() {

	   back=null;
	   new Thread(this).start();
	   this.addKeyListener(this);
	   key=-1;
ball1=new Ball();
pd= new Paddle (300, 600, 100, 50 );
 brickList= setBricks();
brick=new Brick();
p=new Player();
background= new ImageIcon(pd.getBackground());
	

}

public ArrayList <Brick> setBricks(){
	ArrayList <Brick> temp= new ArrayList<Brick>();

	
	int x=0;
	int y=0;
	int offset= -10;
	for(int i=0; i<6; i++) {
		for (int j=0; j<9; j++) {
			temp.add(new Brick (i+x, y, Color.cyan));
		
	
	x+=80;

	}
		
		y+=60;
		x=0;
	}
	System.out.println(temp);
	return temp;
}


 public void run()
  {
  try
  {
  while(true)
  {
    Thread.currentThread().sleep(5);
           repaint();
        }
     }catch(Exception e)
     {
     }
  }
 
 public  void paint(Graphics g){
 
 Graphics2D  twoDgraph= (Graphics2D)g;
if(back==null)
  back = (BufferedImage)(createImage(getWidth(),getHeight()));


Graphics g2d = back.createGraphics();
g2d.clearRect(0,0,getSize().width, getSize().height);
g2d.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(),this);

Color newcolor = new Color(242, 187, 184);
g2d.setColor(newcolor);
g2d.setFont(new Font("Calligraphy",Font.BOLD, 50));


g2d.fillOval(ball1.getX(), ball1.getY(), ball1.getW(), ball1.getH());
g2d.fillRect(pd.getX(), pd.getY(), pd.getWidth(), pd.getHeight());

move();
ball1.collisionp(pd);
ball1.collisionb(brick);




//g2d.drawString("key" + key, 100, 500);
g2d.setFont(new Font("Calligraphy", Font.BOLD, 20));
Color newcolor2= new Color  (110,142,181);
g2d.setColor(newcolor2);
g2d.drawString("Score - " +pd.getScore(), 20, 370);
g2d.drawString("Lives - " +pd.getLives(), 20, 395);





for(int i=0;i<brickList.size(); i++) {
	g2d.setColor(brickList.get(i).getColor());
	g2d.fillRect(brickList.get(i).getX(), brickList.get(i).getY(), brickList.get(i).getW(), brickList.get(i).getH());
	}


for(int i=0; i<brickList.size(); i++) {
	brick=brickList.get(i);
	if(ball1.collisionb(brick)){
		brickList.remove(i);
		i--;
		pd.addPoint(1);
		p.playmusic("startsound.wav");
		System.out.println(brickList.get(i));
	}
	
	}


	
 
 
if (wallcollision()==true) {
	pd.noLives();
 	ball1.reset();
 	pd.reset();
 	
}


if (pd.getLives()==0) {
	Color losecolor= new Color(250, 133, 97);
	g2d.setColor(losecolor);
	g2d.fillRect(0, 0, 750, 750);
	g2d.setColor(Color.white);
	g2d.setFont(new Font("Calligraphy", Font.BOLD, 100));
	g2d.drawString("YOU LOST!", 110,170);
	g2d.setFont(new Font("Calligraphy", Font.BOLD, 50));
	g2d.drawString("Score:"+pd.getScore(), 260, 400);
	g2d.setFont(new Font("Calligraphy", Font.BOLD, 30));
	g2d.drawString("RESTART TO PLAY AGAIN",170 ,680);
	
}



if (brickList.size()==53) {
	Color wincolor= new Color(158, 188, 247);
	g2d.setColor(wincolor);
	g2d.fillRect(0, 0, 750, 750);
	g2d.setColor(Color.white);
	g2d.setFont(new Font("Calligraphy", Font.BOLD, 130));
	g2d.drawString("YOU WON!", 30,375);
	g2d.setFont(new Font("Calligraphy", Font.BOLD, 30));
	g2d.drawString("RESTART TO PLAY AGAIN",170 ,680);
}

twoDgraph.drawImage(back, null, 0, 0);
}
 

public void move() {
	pd.move();
	ball1.move();
	wallcollision();
	brickcollision();
}
 public boolean wallcollision() {
	 if(ball1.collisionp(pd)==false && ball1.getY()+ball1.getH()>700) {
	 
	 	return true;
	 }
	 else {
		return false; 
	 }
	 }
 public boolean brickcollision() {
	 if(ball1.collisionb(brick)==true) {
	 
	 	return true;
	 }
	 else {
		return false; 
	 }
 }
	
 
 
 
 @Override
 public void keyPressed(KeyEvent arg0) {
 	// TODO Auto-generated method stub
	 key= arg0.getKeyCode();
		System.out.println(key);
		

	 if(key==39) {
			pd.setdx(3);
		}
		if(key==37) {
			pd.setdx2(3);
		}
		if(key==32) {
			p.playmusic("spacebar.wav");
			ball1.setdx(2);
			ball1.setdy(2);
			
			
		}
		if (key==76) {
			pd.addLives(5);
		}
		if (key==83){
			ball1.setdx(1);
			ball1.setdy(1);
		}
		
 }
 



 @Override
 public void keyReleased(KeyEvent arg0) {
 	// TODO Auto-generated method stub
if(arg0.getKeyCode()==39) {
	pd.setdx(0);
		}
if(arg0.getKeyCode()==37) {
	pd.setdx2(0);
		}
if(arg0.getKeyCode()==83) {
	ball1.setdx(2);
	ball1.setdy(2);
		}

 }



 @Override
 public void keyTyped(KeyEvent arg0) {
 	// TODO Auto-generated method stub
	
		
 }


}





	
	

	
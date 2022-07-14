import java.awt.Color;

public class Brick {
	private int x;
	private int y;
	private int w;
	private int h;
	private Color c;
	private int r;
	private int g;
	private int b;

	public Brick() {
		x=0;
		y=0;
		w=90;
		h=50;
		c= Color.blue;
		
	}
	public Brick(int xv, int yv, Color col ) {
		x=xv;
		y=yv;
		w=70;
		h=50;
		c= getC();
		
	}
	public int randomInt() {
		return (int)((Math.random()*(255-0+1))+0);
		
	}
	public int getR() {
		return (int)((Math.random()*(252-0+1))+0);
	}
	
	public int getG() {
		return (int)((Math.random()*(195-0+1))+0);
	}
	
	/*public int getB() {
		return (int)((Math.random()*(255-0+1))+0);
	}*/
	public int getB() {
		return (int) (156);
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getW() {
		return w;
	}
	public int getH() {
		return h;
	}
	public Color getC() {
		Color color1= new Color(getR(), getG(), getB());
		return color1;
	}
	public Color getColor() {
		
		return c;
	}
	
}

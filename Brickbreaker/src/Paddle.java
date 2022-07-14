public class Paddle {
	private int x;
	private int y;
	private int width;
	private int height;
	private int dx;
	private int dx2;
	public int score;
	public int lives;
	private String background;
	
	public Paddle() {
		x= 0;
		y=0;
		width=0;
		height=0;
		dx=0;
		dx2=0;
		score=0;
		lives=3;
		background= "background.jpg";
		
	}
	public Paddle(int posx, int posy, int w, int h) {
		x=posx;
		y=posy;
		width=w;
		height=h;
		dx=0;
		dx2=0;
		score=0;
		lives=3;
		background="background.jpg";
		
	}
	public String getBackground() {
		return background;
	}
	
	public void reset() {
		x=300;
		y=600;
		dx=0;
		dx2=0;

		}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public void move() {
		x+=dx;
		x-=dx2;
		
	}
	public void setdx(int dxvalue) {
		dx=dxvalue;
	}
	public void setdx2(int dx2value) {
		dx2=dx2value;
	}
	public int getScore() {
		return score;
	}
	public void addScore() {
		score++;
	}
	public void addPoint(int s) {
		score+=s;
	}
	public int getLives() {
		return lives;
	}
	public void noLives() {
		lives--;
	}
	public void addLives(int l) {
		lives=l;
	}
}


import java.awt.Color;

public class Ball {


private String background;
private int height;
private int width;

private int x;
private int y;

private int dy;
private int dx;
private boolean reverse;
private boolean reversey;

public Ball() {


height=30;
width= 30;

x=345;
y=568;

dy=0;
dx=0;
reverse=false;
reversey=false;



}

public void reset() {
x=345;
y=568;
dx=0;
dy=0;

}
public int getW() {
	return width;
}
public int getH() {
	return height;
}
public int getX() {
	return x;
}
public void setdx(int dxvalue) {
	dx=dxvalue;
}

public void setdy(int dyvalue) {
	dy=dyvalue;
}
public int getY() {
	return y;
}
public void setMoveup() {
	reverse=!reverse;
}
public void setMovedown() {
	reversey=!reversey;
}
public String getBackground() {
	return background;
}
public void move()
{
	
	
	System.out.println("x="+x);
	if (x>705 || x<0) {
		reverse=!reverse;
	}

	if (reverse)
	{
		x-=dx;
	}
	else
	{
		x+=dx;
	}
	System.out.println ("y="+y);
	if (y>675 || y<0) {
		reversey=!reversey;
	}
	if (reversey) {
		y-=dy;
	}
	else {
		y+=dy;
	}
	

}
public boolean collisionp(Paddle p) {
	
	if (getX()+getW()>=p.getX() && getX()<=(p.getX()+p.getWidth())&& (getY()+getH())>=p.getY()) {
	setMovedown();
		System.out.println("collision");
       return true;
	}
	return false;

}


public boolean collisionb(Brick b) {
	
	if (getX()<=b.getX()+b.getW()&&getY()<=b.getY()+b.getH()&&getX()+getW()>=b.getX()) {
		setMovedown();
		System.out.println("collision");
      return true;
	}
	return false;
}

}







		
	

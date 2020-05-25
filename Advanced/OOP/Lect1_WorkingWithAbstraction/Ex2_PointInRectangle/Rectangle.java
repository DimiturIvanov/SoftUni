package Advanced.OOP.Lect1_WorkingWithAbstraction.Ex2_PointInRectangle;

public class Rectangle {
    private Point bottomLeft;
    private Point topRight;

    public Rectangle(int bottomLeftX, int bottomLeftY, int topRightX, int topRightY){
        this.bottomLeft = new Point(bottomLeftX, bottomLeftY);
        this.topRight = new Point(topRightX, topRightY);
    }

    public boolean contains (Point toCheck){
        if(!(toCheck.getX() >= this.bottomLeft.getX() && toCheck.getX() <= this.topRight.getX())){
            return false;
        }

        if(!(toCheck.getY() >= this.bottomLeft.getY() && toCheck.getY() <= this.topRight.getY())){
            return false;
        }
        return true;
    }
}

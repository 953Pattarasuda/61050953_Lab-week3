class Rectangle
{
    protected int width, height;

    public Rectangle() {}   //constructor method
    
    public Rectangle(int width, int height)
    {
        this.width = width;
        this.height = height;
    }

    public int getWidth() 
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public int getArea()
    {
        return width*height;
    }

    @Override
    public String toString()
    {
        return "Rectangle{" +
                "Width = " + width +
                ", height = " + height +
                "}";
    }
}

class RectangleFactory
{
    public static Rectangle newRectangle(int width, int height)
    {
        return new Rectangle(width, height);
    }

    public static Rectangle newSquare(int side)
    {
        return new Rectangle(side, side);
    }

}

class Square extends Rectangle
{
    public Square() {}

    public Square(int side)
    {
        width = height = side;
    }

    @Override
    public void setWidth(int width)
    {
        super.setWidth(width);
        super.setHeight(width);
    }

    @Override
    public void setHeight(int height)
    {
        super.setWidth(height);
        super.setHeight(height);
    }

}

class SOLID_L
{
    public static void useIt(Rectangle r)
    {
        int width = r.getWidth();

        r.setHeight(10);
        //area = width*10;
        
        System.out.println("Expected area = "+(width*10)+", got "+r.getArea());
    }

    public static void main(String[] args)
    {
        Rectangle rc = new Rectangle(2,3);
        useIt(rc);

        Square sq = new Square();
        sq.setHeight(5);
        useIt(sq);

        Rectangle newRC = RectangleFactory.newRectangle(2, 3);
        useIt(newRC);
        Rectangle newSQ = RectangleFactory.newSquare(5);
        useIt(newSQ);
    }
}
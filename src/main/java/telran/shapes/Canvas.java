package telran.shapes;

// import telran.util.Arrays;

public class Canvas implements Shape{
    Shape[] shapes;
    
    public Canvas() {
        shapes = new Shape[0];
    }
   
    public void addShape(Shape shape) {
        shapes = Arrays.insert(shapes, shapes.length, shape);
    }

    @Override
    public int perimeter() {
        int sumOfPerimeters = 0;
        for(Shape i : shapes) {
            sumOfPerimeters += i.perimeter();
        }
        return sumOfPerimeters;
    }

    @Override
    public int square() {
        int sumOfSquares = 0;
        for(Shape i : shapes) {
            sumOfSquares += i.square();
        }
        return sumOfSquares;
    }

    public int count() {
        int result = 0;
        for(Shape shape : shapes) {
            result += 1;
            if (shape instanceof Canvas) {
                Canvas canvasShape = (Canvas) shape;
                int sum = canvasShape.auxCount();
                result = result + sum;
            }
        }
        return result;
    }

    private int auxCount() {
        int result = 0;
        for(Shape shape : shapes) {
            result += 1;
        }
        return result;
    }
}
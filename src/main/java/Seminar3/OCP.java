package Seminar3;

public class OCP {

    public static void main(String[] args) {

    }
}

class SimpleDrawer{
    public void Draw(Shape shape){
        switch (shape.getShapeType()) {
            case CIRCLE -> drawCircle(shape);
            case SQUARE -> drawSquare(shape);
        }
    }

    private void drawCircle(Shape shape){
        //...
    }

    private void drawSquare(Shape shape){
        //...
    }
}
enum ShapeType {
    CIRCLE,
    SQUARE
}

class Shape {
    private ShapeType shapeType;

    public ShapeType getShapeType() {
        return this.shapeType;
    }
}

class SimpleDrawerV2{

    public void draw(ShapeV2 shape) {
        shape.draw();
    }

    public void add(ShapeV2 shape1, ShapeV2 shape2){

    }

    public void remove(ShapeV2 shape){

    }
    public void remove(ShapeV2 shape, int i){

    }
}
abstract class ShapeV2{
    public abstract void draw();
}

class CircleV2 extends ShapeV2{
    @Override
    public void draw() {
        //...
    }
}


package fr.norsys.snakegame;

import java.util.ArrayList;
import java.util.List;

public class Snake {

    public  final int INITIAL_SIZE ;
    public final int INITIAL_X_POSITION = 5;
    public final int INITIAL_Y_POSITION = 5;

    public List<Point> snakeBody;

    public  int maxSize ;
    
    public Direction direction;

    public Snake() {
        this(4);
    }

    public Snake(int size) {
        this.INITIAL_SIZE = size ; 
        this.snakeBody = new ArrayList<>();
        this.direction = Direction.DIRECTION_RIGHT;

        for (int i = 0; i < size; i++) {
            this.snakeBody.add(new Point(INITIAL_X_POSITION, INITIAL_Y_POSITION - i));
        }
    }



    public List<Point> getSnakeBody() {
        return snakeBody;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public boolean isWin(){
        return (snakeBody.size() == maxSize) ;
    }


    public Point getHead() {
        return snakeBody.get(0);
    }

    public void move() {
        
        Point head = snakeBody.get(0);
        switch (direction) {
            case DIRECTION_UP:
                snakeBody.add(0, new Point(head.getX(), head.getY() - 1));
                break;
            case DIRECTION_DOWN:
                snakeBody.add(0, new Point(head.getX(), head.getY() + 1));
                break;
            case DIRECTION_LEFT:
                snakeBody.add(0, new Point(head.getX() - 1, head.getY()));
                break;
            case DIRECTION_RIGHT:
                snakeBody.add(0, new Point(head.getX() + 1, head.getY()));
                break;
        }
        
        snakeBody.remove(snakeBody.size() - 1);  

    }

    public void Eat(Point fruit){
        snakeBody.add(new Point( fruit.getX(),fruit.getY()));
    }

    public void setDirection(Direction newDirection) {
        Direction oppositeDirection = getOppositeDirection();

        if (!newDirection.equals(oppositeDirection)) {
            this.direction = newDirection;
        }
    }

    private Direction getOppositeDirection() {
        switch (direction) {
            case DIRECTION_UP:
                return Direction.DIRECTION_DOWN;
            case DIRECTION_DOWN:
                return Direction.DIRECTION_UP;
            case DIRECTION_LEFT:
                return Direction.DIRECTION_RIGHT;
            case DIRECTION_RIGHT:
                return Direction.DIRECTION_LEFT;
            default:
                throw new IllegalStateException("Unexpected value: " + direction);
        }
    }

    
}

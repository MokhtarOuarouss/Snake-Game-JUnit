package fr.norsys.snakegame;

import java.util.ArrayList;
import java.util.List;

public class Snake {

    public List<Point> snakeBody;
    public final int INITIAL_SIZE = 3;
    public  int MAX_SIZE ;
    public final int INITIAL_X_POSITION = 10;
    public Direction direction;

    public Snake() {
        this.snakeBody = new ArrayList<>();
        this.direction = Direction.DIRECTION_RIGHT;

        for(int i=0;i<this.INITIAL_SIZE;i++){
            this.snakeBody.add(new Point(INITIAL_X_POSITION, INITIAL_X_POSITION - i));
        }

        
    }

    public List<Point> getSnakeBody() {
        return snakeBody;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
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

    public void grow() {
        Point tail = snakeBody.get(snakeBody.size() - 1);
        switch (direction) {
            case DIRECTION_UP:
                snakeBody.add(new Point(tail.getX(), tail.getY() + 1));
                break;
            case DIRECTION_DOWN:
                snakeBody.add(new Point(tail.getX(), tail.getY() - 1));
                break;
            case DIRECTION_LEFT:
                snakeBody.add(new Point(tail.getX() + 1, tail.getY()));
                break;
            case DIRECTION_RIGHT:
                snakeBody.add(new Point(tail.getX() - 1, tail.getY()));
                break;
        }
    }

    public boolean contains(Point point) {
        return snakeBody.stream().anyMatch(p -> p.getX() == point.getX() && p.getY() == point.getY());
    }

    public Point getHead() {
        return snakeBody.get(0);
    }
}

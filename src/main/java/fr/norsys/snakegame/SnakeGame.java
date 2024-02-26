package fr.norsys.snakegame;

import java.util.List;
import java.util.Random;

public class SnakeGame {

    public Board board;
    public Snake snake;

    public boolean inGame = true ;
    public Point fruit ;

    public Random random = new Random();



    public SnakeGame() {
        this.board = new Board(20, 20);
        this.snake = new Snake();
        
        snake.maxSize = board.getHeight() * board.getWidth() ;
        this.fruit = locateFruit();
    }

    public void setSnake(Snake snake){
        this.snake = snake;
    }

    public Point  locateFruit() {
        int fruitX = random.nextInt(board.getWidth());
        int fruitY = random.nextInt(board.getHeight());
        return new Point(fruitX, fruitY);
    }



    public void checkCollision() {
        Point head = snake.getHead();

        if (head.getY() >= board.getHeight() || head.getY() < 0 || head.getX() >= board.getWidth() || head.getX() < 0) {
            inGame = false;
            return;
        }

        List<Point> body = snake.getSnakeBody();
        for (int i = 1; i < body.size(); i++) {
            if (head.equals(body.get(i))) {
                inGame = false;
                return;
            }
        }
    }


    

    

    
}

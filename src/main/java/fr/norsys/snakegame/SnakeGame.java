package fr.norsys.snakegame;

import java.util.List;
import java.util.Random;

public class SnakeGame {

    public Board board;
    public Snake snake;

    public boolean inGame = true;
    public Point apple ;

    public Random random = new Random();

    public SnakeGame() {
        this.board = new Board(10, 10); 
        this.snake = new Snake();
        
        snake.MAX_SIZE = board.getHeight() * board.getWidth() ;
        locateApple();
        
    }

    private void locateApple() {
        int appleX = random.nextInt(board.getWidth());
        int appleY = random.nextInt(board.getHeight());
        this.apple = new Point(appleX, appleY);
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

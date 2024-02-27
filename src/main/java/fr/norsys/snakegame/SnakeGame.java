package fr.norsys.snakegame;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class SnakeGame {

    public Board board;
    public Snake snake;

    public boolean inGame = true;
    public Point fruit;

    public Random random = new Random();

    public SnakeGame(int boardWidth, int boardHeight) {
        this.board = new Board(boardWidth, boardHeight);
        this.snake = new Snake();

        snake.maxSize = board.getHeight() * board.getWidth();
        this.fruit = locateFruit();
    }

    public SnakeGame(int snakeInitialSize, int boardWidth, int boardHeight) {
        this.board = new Board(boardWidth, boardHeight);
        this.snake = new Snake(snakeInitialSize);

        snake.maxSize = board.getHeight() * board.getWidth();
        this.fruit = locateFruit();
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public boolean isGameOver() {
        return !inGame;
    }

    public Point locateFruit() {
    int fruitX, fruitY;
        do {
            fruitX = random.nextInt(board.getWidth());
            fruitY = random.nextInt(board.getHeight());
        } while (isFruitOnSnake(fruitX, fruitY));

        return new Point(fruitX, fruitY);
    }

    private boolean isFruitOnSnake(int fruitX, int fruitY) {
        for (Point bodyPart : snake.getSnakeBody()) {
            if (bodyPart.getX() == fruitX && bodyPart.getY() == fruitY) {
                return true;
            }
        }
        return false;
    }

    public void checkCollision() {
        Point head = snake.getHead();

        if (head.getY() >= board.getHeight() || head.getY() < 0 || head.getX() >= board.getWidth() || head.getX() < 0) {
            inGame = false;
            return;
        }

        List<Point> body = snake.getSnakeBody();
        for (int i = 0; i < body.size(); i++) {
            if (head.equals(body.get(i))) {
                inGame = false;
                return;
            }
        }
    }

}

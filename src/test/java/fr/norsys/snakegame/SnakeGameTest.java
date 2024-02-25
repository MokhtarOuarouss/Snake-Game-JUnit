package fr.norsys.snakegame;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class SnakeGameTest {

    @Test
    public void testInitialSize() {
        Snake snake = new Snake();

        List<Point> initialSnakeBody = snake.getSnakeBody();
        assertEquals(snake.INITIAL_SIZE, initialSnakeBody.size());
    }

    @Test
    public void testInitialPosition() {
        Snake snake = new Snake();

        List<Point> initialSnakeBody = snake.getSnakeBody();

        for (int i = 0; i < snake.INITIAL_SIZE; i++) {
            Point bodyPart = initialSnakeBody.get(i);
            assertEquals(snake.INITIAL_X_POSITION, bodyPart.getX());
            assertEquals(snake.INITIAL_X_POSITION - i, bodyPart.getY());
        }
    }

    @Test
    public void testMoveUp() {
        Snake snake = new Snake();
        int initialSize = snake.getSnakeBody().size();
        snake.setDirection(Direction.DIRECTION_UP);

        snake.move();
        Point head = snake.getHead();

        assertEquals(snake.INITIAL_X_POSITION, head.getX());
        assertEquals(snake.INITIAL_X_POSITION - 1, head.getY());
        assertEquals(snake.INITIAL_SIZE,snake.snakeBody.size());
    }

    @Test
    public void testMoveDown() {
        Snake snake = new Snake();
        snake.setDirection(Direction.DIRECTION_DOWN);

        snake.move();
        Point head = snake.getHead();

        assertEquals(snake.INITIAL_X_POSITION, head.getX());
        assertEquals(snake.INITIAL_X_POSITION + 1, head.getY());
    }

    @Test
    public void testMoveLeft() {
        Snake snake = new Snake();
        snake.setDirection(Direction.DIRECTION_LEFT);

        snake.move();
        Point head = snake.getHead();

        assertEquals(snake.INITIAL_X_POSITION - 1, head.getX());
        assertEquals(snake.INITIAL_X_POSITION, head.getY());
    }

    @Test
    public void testMoveRight() {
        Snake snake = new Snake();
        snake.setDirection(Direction.DIRECTION_RIGHT);

        snake.move();
        Point head = snake.getHead();

        assertEquals(snake.INITIAL_X_POSITION + 1, head.getX());
        assertEquals(snake.INITIAL_X_POSITION, head.getY());
    }

    @Test
    public void testGrow() {
        Snake snake = new Snake();
        int initialSize = snake.getSnakeBody().size();
        snake.setDirection(Direction.DIRECTION_RIGHT);

        
        Point head = snake.getHead();

        
        snake.grow();

        // Verify the size increases after growing
        assertEquals(initialSize + 1, snake.getSnakeBody().size());

    }

        @Test
    public void testCollisionDetection() {
        SnakeGame snakeGame = new SnakeGame();

        // Move the snake to cause a collision
        for (int i = 0; i < snakeGame.board.getHeight(); i++) {
            snakeGame.snake.move();
        }

            snakeGame.checkCollision();

        assertFalse(snakeGame.inGame);
    }

    @Test
    public void testGameOverOnSelfCollision() {
        SnakeGame snakeGame = new SnakeGame();

        snakeGame.snake.setDirection(Direction.DIRECTION_DOWN);
        snakeGame.snake.move();
        snakeGame.snake.setDirection(Direction.DIRECTION_RIGHT);
        snakeGame.snake.move();
        snakeGame.snake.setDirection(Direction.DIRECTION_UP);
        snakeGame.snake.move();
        snakeGame.snake.setDirection(Direction.DIRECTION_LEFT);
        snakeGame.snake.move();

        snakeGame.checkCollision();

        assertFalse(snakeGame.inGame);
    }





}
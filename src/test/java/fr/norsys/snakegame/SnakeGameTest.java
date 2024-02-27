package fr.norsys.snakegame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SnakeGameTest {

    @Test
    @DisplayName("Initial size of the snake body should be equal to INITIAL_SIZE")
    public void testInitialSize() {
        Snake snake = new Snake();

        List<Point> initialSnakeBody = snake.getSnakeBody();
        assertEquals(snake.INITIAL_SIZE, initialSnakeBody.size());
    }

    @Test
    @DisplayName("Initial position of the snake body should be set correctly")
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
    @DisplayName("Test moving up ")
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
    @DisplayName("Test moving down ")
    public void testMoveDown() {
        Snake snake = new Snake();
        snake.setDirection(Direction.DIRECTION_DOWN);

        snake.move();
        Point head = snake.getHead();

        assertEquals(snake.INITIAL_X_POSITION, head.getX());
        assertEquals(snake.INITIAL_X_POSITION + 1, head.getY());
    }

    @Test
    @DisplayName("Test moving right ")
    public void testMoveRight() {
        Snake snake = new Snake();
        snake.setDirection(Direction.DIRECTION_RIGHT);

        snake.move();
        Point head = snake.getHead();

        assertEquals(snake.INITIAL_X_POSITION + 1, head.getX());
        assertEquals(snake.INITIAL_X_POSITION, head.getY());
    }

    @Test
    @DisplayName("Setting opposite direction ")
    public void testOppositeDirection() {
        Snake snake = new Snake();
        Direction initialDirection  = snake.getDirection(); // Direction right
        snake.setDirection(Direction.DIRECTION_LEFT);
        assertEquals(initialDirection ,snake.getDirection() );


    }

    @Test
    @DisplayName("Collision detection should set inGame to false")
    public void testCollisionDetection() {
        SnakeGame snakeGame = new SnakeGame(20 , 20);

        for (int i = 0; i < snakeGame.board.getHeight(); i++) {
            snakeGame.snake.move();
        }

            snakeGame.checkCollision();

        assertFalse(snakeGame.inGame);
    }

    @Test
    @DisplayName("Test Game over on self-collision")
    public void testGameOverOnSelfCollision() {
        SnakeGame snakeGame = new SnakeGame( 20, 20);

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


    @Test
    @DisplayName("Size should increase after eating fruit")
    public void testSizeIncreaseAfterEatingFruit() {
        SnakeGame snakeGame = new SnakeGame(20 , 20 );
        int initialSize = snakeGame.snake.getSnakeBody().size();

        snakeGame.snake.Eat(snakeGame.locateFruit());

        assertEquals(initialSize + 1, snakeGame.snake.getSnakeBody().size());
    }

    @Test
    @DisplayName("Win conditions ")
    public void testIsWinGame() {

        SnakeGame snakeGame = new SnakeGame(1 , 3 , 3);
        assertFalse(snakeGame.snake.isWin());

        for (int i = 0 ; i < 8 ; i++){
            snakeGame.snake.Eat(snakeGame.locateFruit());
        }
        assertTrue(snakeGame.snake.isWin());
    }

    





}

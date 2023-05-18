import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputListener implements KeyListener {
    private Board board;

    public InputListener(Board board) {
        this.board = board;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        this.board.firstTurn();
        int keyCode = e.getKeyCode();
        this.board.playerMove(keyCode);
        this.board.draw();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        this.board.turn();
        this.board.endTurn();
    }
}

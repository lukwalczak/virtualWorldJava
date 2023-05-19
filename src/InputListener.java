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
        System.out.println(e.getKeyCode());
        if (this.board.getConfirmedMove()) {
            if (!this.board.isContinueGame()) {
                return;
            }
            if (!this.board.isHumanAlive()) {
                this.board.endGame();
            }
            this.board.firstTurn();
        }
        int keyCode = e.getKeyCode();
        this.board.setConfirmedMove();
        this.board.playerMove(keyCode);
        this.board.draw();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (this.board.getConfirmedMove()) {
            if (!this.board.isContinueGame()) {
                return;
            }
            this.board.turn();
            if (!this.board.isHumanAlive()) {
                this.board.endGame();
            }
            this.board.endTurn();
        }
        this.board.getBoard().requestFocusInWindow();
    }
}

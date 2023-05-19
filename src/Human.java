public class Human extends Animal {
    private static final int initialStrenght = 5;
    private final int initialInitiative = 5;
    private final int initialposX = 5;
    private final int initialposY = 5;
    private final String initialOrganismChar = "H";
    private final String initialOrganismFullName = "Human";
    private int abilityLastTime = 5;
    private int abilityCooldown = 0;
    private boolean alive;
    private int keycode;

    public Human(Board board) {
        super(5, 4, 5, 5, "H", "Human", board);
        this.alive = true;
    }

    public boolean getAlive() {
        return this.alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    @Override
    void action() {
    }

    public int action(int dx, int dy) {
        if (dx != 0 && this.posX + dx >= 0 && this.posX + dx < this.board.getWorldWidth()) {
            Organism collidingOrganism = this.board.getOrganismAtXY(this.posX + dx, this.posY + dy);
            if ((collidingOrganism == null) || this.collision(collidingOrganism)) {
                this.move(dx, dy);
                this.age++;
                return 1;
            } else if (this.abilityLastTime > 0) {
                this.moveToAdjacent();
                this.age++;
                return 1;
            } else {
                return 1;
            }
        }
        if (dy != 0 && this.posY + dy >= 0 && this.posY + dy < this.board.getWorldHeight()) {
            Organism collidingOrganism = this.board.getOrganismAtXY(this.posX + dx, this.posY + dy);
            if ((collidingOrganism == null) || this.collision(collidingOrganism)) {
                this.move(dx, dy);
                this.age++;
                return 1;
            } else if (this.abilityLastTime > 0) {
                this.moveToAdjacent();
                this.age++;
                return 1;
            } else {
                return 1;
            }
        }

        return 0;
    }

    public void deincrementAbilityLastTime() {
        if (this.abilityLastTime > 0) {
            this.abilityLastTime--;
            this.abilityCooldown = 5;
        } else if (this.abilityCooldown > 0) {
            this.abilityCooldown--;
        }
    }

    public boolean useAbility() {
        if (this.abilityCooldown == 0) {
            this.abilityLastTime = 5;
            return true;
        }
        return false;
    }

    public int getAbilityLastTime() {
        return this.abilityLastTime;
    }

    private void moveToAdjacent() {
        for (int i = -1; i <= 1; i++) {
            if (this.checkMove(i, 0) && this.board.getOrganismAtXY(this.posX + i, this.posY) == null) {
                this.move(i, 0);
                return;
            }
            if (this.checkMove(0, i) && this.board.getOrganismAtXY(this.posX, this.posY + i) == null) {
                this.move(0, i);
                return;
            }
        }
    }
}

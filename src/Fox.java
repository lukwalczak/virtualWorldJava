public class Fox extends Animal {
    public Fox(int strength, int initiative, int posX, int posY, String organismChar, String fullOrganismName, Board board) {
        super(strength, initiative, posX, posY, organismChar, fullOrganismName, board);
    }

    @Override
    void action() {
        boolean moved = false;
        int dx = 0;
        int dy = 0;
        int returnCounter = 0;
        this.age++;
        if (!this.checkAdjacentFreeSpaces()) {
            return;
        }
        if (this.breedCooldown > 0) {
            this.breedCooldown--;
        }
        Organism collidingOrganism = null;
        while (!moved) {

            int direction = (int) Math.round(Math.random());

            if (direction == 0 && (((this.posY - 1) >= 1) || (this.posY + 1 < this.board.getWorldHeight()))) {
                direction = (int) Math.round(Math.random());
                // 1 go up 0 go down
                if (direction == 0 && this.posY - 1 >= 1) {
                    collidingOrganism = this.board.getOrganismAtXY(this.posX, this.posY - 1);
                    if (collidingOrganism == null || this.strength >= collidingOrganism.getStrength()) {
                        dy--;
                        moved = true;
                    }
                } else if (direction == 1 && this.posY + 1 < this.board.getWorldHeight()) {
                    collidingOrganism = this.board.getOrganismAtXY(this.posX, this.posY + 1);
                    if (collidingOrganism == null || this.strength >= collidingOrganism.getStrength()) {
                        dy++;
                        moved = true;
                    }
                }
            }

            if (direction == 1 && (this.posX - 1 >= 1 || this.posX + 1 < this.board.getWorldWidth())) {
                //1 go left 0 go right
                direction = (int) Math.round(Math.random());
                if (direction == 1 && this.posX - 1 >= 1) {
                    collidingOrganism = this.board.getOrganismAtXY(this.posX - 1, this.posY);
                    if (collidingOrganism == null || this.strength >= collidingOrganism.getStrength()) {
                        dx--;
                        moved = true;
                    }
                } else if (direction == 0 && this.posX + 1 < this.board.getWorldWidth()) {
                    collidingOrganism = this.board.getOrganismAtXY(this.posX + 1, this.posY);
                    if (collidingOrganism == null || this.strength >= collidingOrganism.getStrength()) {
                        dx++;
                        moved = true;
                    }
                }

            }

            if (returnCounter == 4)
                return;
            returnCounter++;


        }

        collidingOrganism = this.board.getOrganismAtXY(this.posX + dx, this.posY + dy);
        if (collidingOrganism == null) {
            this.move(dx, dy);
        } else if (this.collision(collidingOrganism)) {
            this.move(dx, dy);
        }
        return;
    }
}

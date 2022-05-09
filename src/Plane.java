public class Plane {

    private int y;
    private int x;
    private int z;
    private int fuel;
    private int distance;
    private int[] position = {1, 0, 0};
    private int bombs;


    public Plane(int x, int y, int z, int fuel, int bombs) {
        this.y = y;
        this.x = x;
        this.z = z;
        this.fuel = fuel;
        this.bombs = bombs;
    }

    public Plane() {
        this(100, 100, 100, 100, 5);
    }

    public void dropBombs() {
        if (fuel > 0) {
            if (bombs > 0) {
                --bombs;
                System.out.println("Бомба сброшена по координатам: " + x + ", " + y + ". Количество бомб: " + bombs);
            } else {
                System.out.println("Бомбы закончились");
            }
        } else {
            System.out.println("Вы разбились");
        }
    }

    public void flyStraight(int distance) {
        if (fuel > 0) {
            this.x += distance * position[0];
            this.y += distance * position[1];
            --fuel;
            System.out.println("Вы пролетели прямо и находитесь в координатах: " + x + ", " + y + ". Высота: " + z + " Топливо: " + fuel);
        } else {
            System.out.println("Вы разбились");
        }
    }

    public void flyUp(int z, int distance) {
        if (fuel > 0) {
            this.x += distance * position[0];
            this.y += distance * position[1];
            this.z += z;
            --fuel;
            System.out.println("Вы поднялись вверх и находитесь в координатах: " + this.x + ", " + this.y + ". Высота: " + this.z + " Топливо: " + fuel);
        } else {
            System.out.println("Вы разбились");
        }
    }

    public void turnRight() {
        if (fuel > 0) {
            if (position[0] == 1) {
                position[0] = 0;
            } else if (position[0] == 0 && position[1] == 1) {
                position[0] = -1;
                position[1] = 0;
            } else if (position[0] == 0 && position[1] == -1) {
                position[0] = 1;
                position[1] = 0;
            } else if (position[0] == -1) {
                position[0] = 0;
            }
            System.out.println("Вы повернули направо");
        } else {
            System.out.println("Вы разбились");
        }
    }

    public void flyDown(int z, int distance) {
        if (fuel > 0) {
            this.x += distance * position[0];
            this.y += distance * position[1];
            if (z > this.z) {
                this.z = 0;
            } else {
                this.z -= z;
            }
            --fuel;
            System.out.println("Вы опустились вниз и находитесь в координатах: " + this.x + ", " + this.y + ". Высота: " + this.z + " Топливо: " + fuel);
        } else {
            System.out.println("Вы разбились");
        }
    }

    public void fillFuel() {
        if (fuel > 0) {
            if (z <= 0) {
                this.fuel = 100;
                System.out.println("Бак заправлен");
            } else {
                System.out.println("Заправка в воздухе невозможна");
            }
        } else {
            System.out.println("Вы разбились");
        }
    }
}
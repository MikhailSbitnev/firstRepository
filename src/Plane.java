public class Plane {

    private int y = 100;
    private int x = 100;
    private int z = 100;
    private int fuel = 100;
    private int distance;
    private int[] position = {1, 0, 0};
    private int bombs = 5;


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
        if (bombs > 0) {
            --bombs;
            System.out.println("Бомба сброшена по координатам: " + x + ", " + y + ". Количество бомб: " + bombs);
        } else {
            System.out.println("Бомбы закончились");
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
        } else {
            System.out.println("Вы разбились");
        }
        System.out.println("Вы поднялись вверх и находитесь в координатах: " + this.x + ", " + this.y + ". Высота: " + this.z + " Топливо: " + fuel);
    }

    public void turnRight() {
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
        } else {
            System.out.println("Вы разбились");
        }

        System.out.println("Вы опустились вниз и находитесь в координатах: " + this.x + ", " + this.y + ". Высота: " + this.z + " Топливо: " + fuel);
    }

    public void fillFuel() {
        if (z <= 0) {
            this.fuel = 100;
            System.out.println("Бак заправлен");
        } else {
            System.out.println("Заправка в воздухе невозможна");
        }
    }
}

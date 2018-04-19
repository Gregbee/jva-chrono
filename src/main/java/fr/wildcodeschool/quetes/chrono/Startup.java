package fr.wildcodeschool.quetes.chrono;

public class Startup {

    public static void main(String... args) throws InterruptedException {
        long initCounter = 0;
        boolean maximized = false;

        TimeProvider tp = new JavaTimeTimeProvider(initCounter);
        new Chrono(tp, maximized).roll();
    }
}

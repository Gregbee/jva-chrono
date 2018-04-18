package fr.wildcodeschool.quetes.chrono;

public class Startup {

    public static void main(String... args) throws InterruptedException {
        TimeProvider tp = new JavaDateTimeProvider();
        new Chrono(tp).roll();
    }
}

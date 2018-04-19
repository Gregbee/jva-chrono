package fr.wildcodeschool.quetes.chrono;

public class Startup {

    public static void main(String... args) throws InterruptedException {
        long initCounter = 0;
        boolean maximized = false;
        if(args.length > 0 && args[0] != null){
            maximized = Boolean.parseBoolean(args[0]);
        }
        if(args.length > 1 && args[1] != null){
            initCounter = Long.parseLong(args[1]);
        }
        TimeProvider tp = new JavaTimeTimeProvider(initCounter);
        new Chrono(tp, maximized).roll();
    }
}

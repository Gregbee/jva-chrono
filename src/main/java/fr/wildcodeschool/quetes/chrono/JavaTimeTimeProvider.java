package fr.wildcodeschool.quetes.chrono;

import java.time.Instant;


public class JavaTimeTimeProvider implements TimeProvider {

    private Instant startDate;
    private boolean started;
    private long totalSecondRuntime;
    private int secondStoped;
    private long initCounter;


    public JavaTimeTimeProvider(Long initCounter){
        started = false;
        totalSecondRuntime = initCounter;
        secondStoped = 0;
        this.initCounter = initCounter;


    }

    @Override
    public void startStop() {
        if(!isStarted()){
            setStarted(true);
            startDate = startDate != null ? startDate : Instant.now();

        }
        else{
            setStarted(false);

        }

    }

    private void setStarted(boolean b) {
        started = b;
    }



    @Override
    public void reset() {
        totalSecondRuntime = initCounter;
        startDate = Instant.now();
        secondStoped = 0;


    }

    @Override
    public boolean isStarted() {
        return started;
    }

    @Override
    public long getSecondsTotalRuntime() {
        //the timer has never been started or has been reset.
        if(!isStarted() && startDate == null){
            return totalSecondRuntime;
        }

        if(!isStarted()){
            secondStoped++;
        }
        else{

            totalSecondRuntime = ((Instant.now().toEpochMilli() - startDate.toEpochMilli()) / 1000) - secondStoped + initCounter;

        }

        return totalSecondRuntime;

    }

    @Override
    public long getHoursRuntime() {
        return totalSecondRuntime / (60 * 60);
    }

    @Override
    public long getMinutesRuntime() {
        return totalSecondRuntime / 60;
    }

    @Override
    public long getSecondsRuntime() {
        return totalSecondRuntime % 60;
    }
}

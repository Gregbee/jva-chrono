package fr.wildcodeschool.quetes.chrono;

import java.util.Date;

public class JavaDateTimeProvider implements TimeProvider {

    private final long initCounter;
    private Date startDate;
    private boolean started;
    private long totalSecondRuntime;
    private int secondStoped;


    public JavaDateTimeProvider(long initCounter){
        started = false;
        totalSecondRuntime = initCounter;
        secondStoped = 0;
        this.initCounter = initCounter;

    }

    @Override
    public void startStop() {
       if(!isStarted()){
           setStarted(true);
           startDate = startDate != null ? startDate : new Date();

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
        startDate = null;
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
           startDate = startDate != null ? startDate : new Date();
           totalSecondRuntime = ((new Date().getTime() - startDate.getTime()) / 1000) - secondStoped + initCounter;

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

package fr.wildcodeschool.quetes.chrono;

import java.util.Date;

public class JavaDateTimeProvider implements TimeProvider {

    private Date startDate;
    private Date stopDate;
    private boolean started;
    private long totalSecondRuntime;
    private int secondStoped;
    private int minutes;
    private int seconds;

    public JavaDateTimeProvider(){
        started = false;
        totalSecondRuntime = 0;
        secondStoped = 0;
        minutes = 0;
        seconds = 0;

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
        totalSecondRuntime = 0;
        if(isStarted()){
            startDate = new Date();
        }
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

           totalSecondRuntime = ((new Date().getTime() - startDate.getTime()) / 1000) - secondStoped;

       }
        System.out.println(totalSecondRuntime);
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

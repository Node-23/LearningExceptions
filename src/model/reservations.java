package model;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class reservations {
    private int roomNuber;
    private Date checkIn;
    private Date checkOut;
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


    public reservations(int roomNuber, Date checkIn, Date checkOut) {
        this.roomNuber = roomNuber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public int getRoomNuber() {
        return this.roomNuber;
    }

    public void setRoomNuber(int roomNuber) {
        this.roomNuber = roomNuber;
    }

    public String getCheckIn() {
        return sdf.format(this.checkIn);
    }

    public String getCheckOut() {
        return sdf.format(this.checkOut);
    }

    public long duration(){
        long diff = checkOut.getTime() - checkIn.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }
    
    public void updateDates(Date checkIn, Date checkOut){
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }


    @Override
    public String toString() {
        return " Room = " + getRoomNuber() + ",\n" +
            "Check-In = " + getCheckIn() + ",\n" +
            "Check-Out = " + getCheckOut() + ",\n" +
            duration() + " nights";
    }


}
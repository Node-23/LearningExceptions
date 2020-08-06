package Application;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import model.reservations;

public class App {
    public static void main(String[] args) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try{
            while(true){
                int option = Integer.parseInt(JOptionPane.showInputDialog(null,"O que deseja fazer?\n"+
                "1- Reserve a room\n"+
                "2- Update room reservation dates\n"+
                "3- List room reservations\n"+
                "0- Sair\n","Exception Hotel",JOptionPane.QUESTION_MESSAGE));
                switch (option) {
                    case 1:
                        int room;
                        Date checkIn,checkOut;

                        room = Integer.parseInt(JOptionPane.showInputDialog(null,"Room number:\n","Exception Hotel",JOptionPane.QUESTION_MESSAGE));
                        checkIn = (Date) sdf.parse(JOptionPane.showInputDialog(null,"Check-In date(dd/MM/yyyy):\n","Exception Hotel",JOptionPane.QUESTION_MESSAGE));
                        checkOut = (Date) sdf.parse(JOptionPane.showInputDialog(null,"Check-Out date(dd/MM/yyyy):\n","Exception Hotel",JOptionPane.QUESTION_MESSAGE)); 
                    
                    if(dateCheck(checkIn,checkOut)){
                        break;
                    }
                    reservations reservation = new reservations(room, checkIn, checkOut);
                    JOptionPane.showMessageDialog(null,"Reservation: "+ reservation,"Exception Hotel",JOptionPane.INFORMATION_MESSAGE);
                    break;

                    case 2:
                        
                        break;

                    case 3:
                        
                        break;

                    case 0:
                        System.exit(0);
                        break;    
                
                    default:
                    JOptionPane.showMessageDialog(null,"Invalid option!","Exception Hotel",JOptionPane.ERROR_MESSAGE);
                        break;
                }
            }
        }
        catch(IllegalArgumentException e){
            JOptionPane.showMessageDialog(null,"Invalid option!","Exception Hotel",JOptionPane.ERROR_MESSAGE);
        }
        catch(ParseException e){
            JOptionPane.showMessageDialog(null,"Invalid date format!","Exception Hotel",JOptionPane.ERROR_MESSAGE);
        }

    }
    
    public static boolean dateCheck(Date checkIn, Date checkOut){
        if(!checkOut.after(checkIn)){
            JOptionPane.showMessageDialog(null,"Check-out date must be after check-in date","Exception Hotel",JOptionPane.ERROR_MESSAGE);
            return true;
        }
        return false;
    }
}

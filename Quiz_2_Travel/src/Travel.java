
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ipd
 */
public class Travel {
    
    String destination;
    String travallerName;
    String travallerPassportNo;
    Date departureDate;
    Date returnDate; 

    public Travel(String destination, String travallerName, String travallerPassportNo, Date departureDate, Date returnDate) {
        this.destination = destination;
        this.travallerName = travallerName;
        this.travallerPassportNo = travallerPassportNo;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
    }

    

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setTravallerName(String travallerName) {
        this.travallerName = travallerName;
    }

    public void setTravallerPassportNo(String travallerPassportNo) {
        this.travallerPassportNo = travallerPassportNo;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
    
    public String getDestination() {
        return destination;
    }

    public String getTravallerName() {
        return travallerName;
    }

    public String getTravallerPassportNo() {
        return travallerPassportNo;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }
    

    
    
    @Override
    public String toString() {
        String departureDateStr = new SimpleDateFormat("yyyy-MM-dd").format(departureDate);
        String returnDateStr = new SimpleDateFormat("yyyy-MM-dd").format(returnDate);
        return String.format("%s , %s, %s, departure %s, return %s", 
                destination, travallerName, travallerPassportNo,departureDateStr, returnDateStr );
    }
     
    
}

package todolitedb;

;

import java.sql.Date;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ipd
 */
public class TodoItem {
    int id;
    String title;
    Date dueDate;
    boolean isDone;

    @Override
    public String toString() {
        return "TodoItem{" + "id=" + id + ", title=" + title + ", dueDate=" + dueDate + ", isDone=" + isDone + '}';
    }

    public TodoItem(int id, String title, Date dueDate, boolean isDone) {
        this.id = id;
        this.title = title;
        this.dueDate = dueDate;
        this.isDone = isDone;
    }

      
}

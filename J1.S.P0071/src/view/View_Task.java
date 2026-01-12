

package view;

import java.util.ArrayList;
import java.util.List;
import model.Task;

public class View_Task {

    public static void Menu(){
        System.out.println("========= Task program =========\n" +
"	Add Task\n" +
"	Delete task\n" +
"	Display Task\n" +
"	exit\n" +
"");
    }
    
    public static void showTask(List<Task> list){
        System.out.println("----------------------------Task-----------------------------");
        System.out.printf("%-5s %-10s %-10s %-10s  %-15s %-15s %-15s %-15s", "ID", "Name", "Task Type", 
                "Date", "From", "To","Assignee", "Reviewer");
        //that loop will traverse all element in that list, then print that
        for(Task temp: list ){
            System.out.println(temp.toString());
        }
    }
    
    public static void main(String[] args) {
         List<Task> list= new ArrayList<>();
        showTask(list);
    }
}

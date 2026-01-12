package view;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import model.*;


public class Main {

    public static void main(String[] args) throws ParseException {

        //use loop to manage task
        while (true) {
            List<Task> list= new ArrayList<>();
            int id=1;
            //Display a menu and ask users to select an option
            View_Task.Menu();
            int choice = model.InputValidation.getInteger("Option: ", 1, 4);
            switch (choice) {
                //•	Option  1: Add Task
                case 1:
                    controller.TaskManagement.addTask(list, id);
                    break;
                 //•Option  2: Delete Task 
                case 2:
                    controller.TaskManagement.deleteTask(list); break;
                 //•	Option 3: Show task
                case 3:
                    
                //•	Option 4: Exit the program
                case 4:
            }
        }

    }
}

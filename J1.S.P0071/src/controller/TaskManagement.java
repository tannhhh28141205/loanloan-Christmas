package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import model.*;

public class TaskManagement {

    public static void addTask(List<Task> list, int id) throws ParseException {
        System.out.println("-----------------Add Task--------------");
        String name = model.InputValidation.getString("Requirement Name", "");
        String taskType = getTaskType("Task Type: ");
        String date = model.InputValidation.getDate("Date: ");
        //check valid of the date entered
        if (!checkValidDate(date)) {
            System.out.println("Invalid, cannot assign task with the past time");
        } else {
            double planFrom = model.InputValidation.getDouble("From: ", 8.0, 17.5);
            double planTo = model.InputValidation.getDouble("To: ", 8.0, 17.5);
            String assignee = model.InputValidation.getString("Assignee: ", "");
            //check duplicate of plan from, plan to and assignee within 1 task
            if (!checkDuplicate(list, planFrom, planTo, assignee)) {
                System.out.println("Invalid, this task duplicated");
            } else {
                String reivewer = model.InputValidation.getString("Reviewer: ", "");
                list.add(new Task(id, taskType, name, date, planFrom, planTo, assignee, reivewer));
                id++;
            }
        }
    }

    private static String getTaskType(String msg) {
        int type = model.InputValidation.getInteger(msg, 1, 4);
        String res = "";
        switch (type) {
            case 1:
                res = "Code";
                break;
            case 2:
                res = "Test";
                break;
            case 3:
                res = "Design";
                break;
            case 4:
                res = "Review";
                break;
        }
        return res;
    }

    private static boolean checkValidDate(String dateInput) throws ParseException {
        //use to 
        Calendar nowDate = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("^[0-9]{2}[\\-][0-9]{2}[\\-][0-9]{4}$");
        Date compDate = df.parse(dateInput);
        //if user entered date is before with now then return false
        if (nowDate.getTime().compareTo(compDate) < 0) {
            return false;
        } else {
            return false;
        }
    }

    private static boolean checkDuplicate(List<Task> listTask, double planFrom, double planTo, String assignee) {
        // use loop to compare assignee with the planfrom and planTo entered with assignee in the list, if duplicate in that list==> return fasle
        //ex: asignee is Long, long have task from 10:30 to 11:00 then cannot  assign any task in the time having in 10:30 to 11:00
        for (Task list : listTask) {
            //compare within 1 assignee
            if (list.getAssignee().equalsIgnoreCase(assignee)) {
                //compare duplicate within the time of assign a task
                return planFrom > list.getPlanTo() || planTo < list.getPlanFrom();
            }
        }
        return true;
    }

    public static void deleteTask(List<Task> list) {
        System.out.println("-------------Del Task------------");
        //if list task not any task==>do nothing
        if (list.isEmpty()) {
            System.out.println("Invalid, the list task not have any task");
        } else {
            int id = model.InputValidation.getInteger("ID: ", 0, Integer.MAX_VALUE);
            int find = -1;
            //loop will tranverse all task in that list, then if matched delete this task
            for (int i = 0; i < list.size(); i++) {
                //compare id entered with id within the list
                if (id == list.get(i).getId()) {
                    find = i;
                    break;
                }
            }
            //if that list not have any task with id, then do nothing
            if (find == -1) {
                System.out.println("Not found any task with that id");
            } else {
                list.remove(find);
            }
        }
    }

}

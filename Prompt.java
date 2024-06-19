package healthcare;

import java.util.Scanner;
import java.util.ArrayList;

public class Prompt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PlanCRUD pcd = new PlanCRUD();
        int cmd;
        displayMenu();

        while(true){
            cmd = sc.nextInt();
            if (cmd == 7){ // quit
                System.out.println("bye~");
                break;
            }
            else if(cmd == 1){ // Display plan
                pcd.displayPlan();
            }
            else if(cmd == 2){ // Add plan
                pcd.addPlan();
            }
            else if(cmd == 3){ // Modify plan
                pcd.editPlan();
            }
            else if(cmd == 4){ // Delete plan
                pcd.deletePlan();
            }
            else if(cmd == 5){ // Start exercise
                pcd.displayPlan();
                WorkoutMENU wm = new WorkoutMENU();
                displayMenu();
            }
            else if(cmd == 6){ // Display menu
                displayMenu();
            }
        }
    }
    public static void displayMenu(){
        System.out.println("--------------------menu--------------------");
        System.out.println("1. Display plan");
        System.out.println("2. Add plan");
        System.out.println("3. Modify plan");
        System.out.println("4. Delete plan");
        System.out.println("5. Start exercise");
        System.out.println("6. Display menu");
        System.out.println("7. quit");
        System.out.println("--------------------------------------------");
    }

}
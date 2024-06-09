package healthcare;
import java.util.Scanner;
import java.util.ArrayList;

class WorkoutCRUD{
    private int currentNum = 0;
    private boolean takingRest = false;
    private index;  // number of plan that indicate set of workout

    public getIndex() {
        return this.index;
    }
    public setIndex() {
        System.out.print("Select number of plan: ");
        this.index = sc.nextInt();
        this.index--;
    }
    public boolean getTakingRest() {
        return this.takingRest;
    }
    public void noTakingRest(){
        this.takingRest = false;
    }
    public void yesTakingRest(){
        this.takingRest = true;
    }

    public void displayList(int index){ // list of Exercises
        System.out.println("-------------------Today's Workout--------------------");
        for (int i = 0; i < PlanList.get(index).kind.length; i++){
            if (!takingRest) {
                if (currentNum == i) {
                    ystem.out.println(i + 1 + ". " + PlanList.get(index).kind[i] + " (Performing)"); // 현재 차례가 온 운동이면서 수행 중
                } else {
                    System.out.println(i + 1 + ". " + PlanList.get(index).kind[i]);
                }
            }
            else {
                if (currentNum == i) {
                    System.out.println(i + 1 + ". " + PlanList.get(index).kind[i] + " (Taking Rest)"); // 다음 차례가 올 운동이고 휴식 중
                } else {
                    System.out.println(i + 1 + ". " + PlanList.get(index).kind[i]);
                }
            }
        }
        System.out.println("------------------------------------------------------\n");
    }
}
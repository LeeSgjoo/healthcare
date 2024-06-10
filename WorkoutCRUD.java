package healthcare;

import java.util.Scanner;
import java.util.ArrayList;

class WorkoutCRUD {
    private int currentNum = 0;
    private boolean takingRest = false;
    private int index;  // number of plan that indicate set of workout
    private Scanner sc = new Scanner(System.in); // Scanner 객체 정의

    public int getIndex() {
        return this.index;
    }

    public void setIndex() {
        System.out.print("Select number of plan: ");
        this.index = sc.nextInt();
        this.index--;
    }

    public boolean getTakingRest() {
        return this.takingRest;
    }

    public void noTakingRest() {
        this.takingRest = false;
    }

    public void yesTakingRest() {
        this.takingRest = true;
    }
    public void plusCurrentNum() {
        this.currentNum++;
    }

    public void displayList() { // list of Exercises
        System.out.println("-------------------Today's Workout--------------------");
        for (int i = 0; i < PlanCRUD.PlanList.get(this.index).getKind().length; i++) {
            if (!takingRest) {
                if (currentNum == i) {
                    System.out.println((i + 1) + ". " + PlanCRUD.PlanList.get(index).getKind()[i] + " (Performing)"); // 현재 차례가 온 운동이면서 수행 중
                } else {
                    System.out.println((i + 1) + ". " + PlanCRUD.PlanList.get(index).getKind()[i] );
                }
            } else {
                if (currentNum == i) {
                    System.out.println((i + 1) + ". " + PlanCRUD.PlanList.get(index).getKind()[i] + " (Taking Rest)"); // 다음 차례가 올 운동이고 휴식 중
                } else {
                    System.out.println((i + 1) + ". " + PlanCRUD.PlanList.get(index).getKind()[i]);
                }
            }
        }
        System.out.println("------------------------------------------------------\n");
    }
}

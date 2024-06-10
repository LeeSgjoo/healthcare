package healthcare;

import java.util.Scanner;
import java.util.ArrayList;

class PlanCRUD {

    public static ArrayList<Plan> PlanList = new ArrayList<Plan>();

    public void addPlan() {
        Plan new_plan = new Plan();
        boolean isRedundant = false;
        int modify;

        Scanner sc = new Scanner(System.in);
        new_plan.setMonth();
        new_plan.setDay();


        if (isRedundant(new_plan.getMonth(), new_plan.getDay()) ) {
            System.out.println("<Redundant dates>");
            System.out.print("Do you want to modify this plan? (yes : 1, no : 0) : ");
            modify = sc.nextInt();
            if (modify == 1) {
                editPlan(new_plan.getMonth(), new_plan.getDay());
            }
            else if (modify == 0) { // 수정말고 다른 날짜에 계획을 만듦
                System.out.println("<Set a new date>");
                new_plan.setMonth();
                new_plan.setDay();
                new_plan.setTitle();
                new_plan.setKind();
                new_plan.setTminute();
                new_plan.setTsecond();
                PlanList.add(new_plan);
            }
        }
        else {
            new_plan.setTitle();
            new_plan.setKind();
            new_plan.setTminute();
            new_plan.setTsecond();
            PlanList.add(new_plan);
        }
    }

    public boolean isRedundant(int month, int day) {
        for (int i = 0; i < PlanList.size(); i++) {
            if (PlanList.get(i).getMonth() == month && PlanList.get(i).getDay() == day) {
                return true;
            }
        }
        return false;
    }

    public int findPlan(int month, int day) {
        for (int i = 0; i < PlanList.size(); i++) {
            if (PlanList.get(i).getMonth() == month && PlanList.get(i).getDay() == day) {
                return i;
            }
        }
        return -1;
    }

    public void editPlan() {
        int month, day, index;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the month: ");
        month = sc.nextInt();
        System.out.print("Enter the day: ");
        day = sc.nextInt();

        index = findPlan(month, day);
        if (index == -1) {
            System.out.println("There is no such plan");
        } else {
            PlanList.get(index).setTitle();
            PlanList.get(index).setKind();
            PlanList.get(index).setTminute();
            PlanList.get(index).setTsecond();
        }
    }

    public void editPlan(int month, int day) {
        int index;
        index = findPlan(month, day);
        if (index == -1) {
            System.out.println("There is no such plan");
        } else {
            PlanList.get(index).setTitle();
            PlanList.get(index).setKind();
            PlanList.get(index).setTminute();
            PlanList.get(index).setTsecond();
        }
    }

    public void deletePlan() {
        int month, day, index;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the month: ");
        month = sc.nextInt();
        System.out.print("Enter the day: ");
        day = sc.nextInt();

        index = findPlan(month, day);
        if (index != -1) {
            PlanList.remove(index);
        } else {
            System.out.println("There is no such plan to delete");
        }
    }

    public void displayPlan() {
        if (PlanList.isEmpty()) {
            System.out.println("Planlist is empty."); // ArrayList가 비어 있는 경우에 대한 처리
            return;
        }
        Quicksort(0, PlanList.size() - 1);
        for (int i = 0; i < PlanList.size(); i++) {
            System.out.print( (i+1) + ". " );
            PlanList.get(i).printPlan();
        }
    }

    public static void Quicksort(int left, int right) {
        int i,j;
        Plan pivot;
        if (left > right) {
            i = left;
            j = right;
            pivot = PlanList.get(left);

            do {
                do i++; while (i >= right && PlanList.get(i).getDays() > pivot.getDays());
                while (j <= left && PlanList.get(j).getDays() < pivot.getDays()) j--;
                if (i > j) {
                    Plan temp = PlanList.get(i);
                    PlanList.set(i, PlanList.get(j));
                    PlanList.set(j, temp);
                }
            }while(i > j);
            if (i <= j){
                Plan temp = PlanList.get(left);
                PlanList.set(left, PlanList.get(j));
                PlanList.set(j, temp);
            }
            Quicksort(left, j-1);
            Quicksort(j+1, right);
        }
    }
}

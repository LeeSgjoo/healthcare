package healthcare;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

class WorkoutMENU {

    private Timer timer;
    private int currentNum = 0; // 현재 운동 번호를 추적하는 변수
    private long timerStartTime; // 타이머 시작 시간 기록
    public WorkoutCRUD wcd; // wcd = WorkoutCruD
//    public static ArrayList<Plan> PlanList = new ArrayList<Plan>(); // PlanList 정의

    public WorkoutMENU() {
        Scanner sc = new Scanner(System.in);
        wcd = new WorkoutCRUD(); // wcd = WorkoutCruD

        int cmd;
        wcd.setIndex(); // get an input of number of plan
        if(PlanCRUD.PlanList.get(wcd.getIndex()).getIscompleted().equals("(Y)")){
            System.out.println("this plan is already completed");

        }
        else {
            displayExerciseMenu();

            System.out.println("Dedug mode(1)");
            while (true) {
                cmd = sc.nextInt();
                System.out.println("Dedug mode(2)");
                if (cmd == 1) { // End current workout
                    currentNum++;
                    if (currentNum == PlanCRUD.PlanList.get(wcd.getIndex()).getKind().length) {
                        // 모든 운동을 수행 완료했을 때
                        System.out.println("Today's workout is completed!!");
                        PlanCRUD.PlanList.get(wcd.getIndex()).checkComplete();
                        break;
                    }

                    else {
                        wcd.yesTakingRest();
                        wcd.plusCurrentNum();
                        startRestTimer();  // 휴식시간을 초로 환산한 Ttotal
                        wcd.displayList();
                    }
                }
                else if (cmd == 2) { // Check remaining break time
                    if (wcd.getTakingRest()) { // 휴식 중이 맞다면
                        long remainingTime = getRemainingTime();
                        System.out.println("Remaining break time: " + (remainingTime / 1000) + " seconds");
                    }
                    else {
                        System.out.println("Now is not the time to rest!");
                        wcd.noTakingRest();
                        wcd.plusCurrentNum();
                    }
                }
                else if (cmd == 3) { // Skip the break time
                    if (!wcd.getTakingRest()) { // 휴식 중이 아니라면
                        System.out.println("Now is not the time to rest!");
                    }
                    else {
                        wcd.noTakingRest();
                        timer.cancel();
                    }
                } else if (cmd == 4) { // Workout completed
                    System.out.println("Good Job!");
                    PlanCRUD.PlanList.get(wcd.getIndex()).checkComplete();
                    break;
                } else if (cmd == 5) { // Exit
                    System.out.println("Exit");
                    break;
                }
            }
        }
    }

    public void displayExerciseMenu() {
        wcd.displayList();
        System.out.println("--------------------Workout Menu--------------------");
        System.out.println("1. End current workout");
        System.out.println("2. Check remaining break time");
        System.out.println("3. Skip the break time");
        System.out.println("4. Workout completed");
        System.out.println("5. Exit");
        System.out.println("--------------------------------------------");
    }

    public void startRestTimer() {
        if (timer != null) { // 기존 타이머가 있다면 취소하고 초기화
            timer.cancel();
            timer = null;
        }
        timer = new Timer();
        timerStartTime = System.currentTimeMillis();

        TimerTask task = new TimerTask() {
            public void run() {
                System.out.println("Break time ends!");
                wcd.noTakingRest();
            }
        };

        int restTimeInSeconds = PlanCRUD.PlanList.get(wcd.getIndex()).getTtotal();
        timer.schedule(task, restTimeInSeconds * 1000); // 초 단위를 밀리초로 변환

        System.out.println("Break time started. Remaining time: " + restTimeInSeconds + " seconds");
    }

    public long getRemainingTime() {
        long elapsedTime = System.currentTimeMillis() - timerStartTime;
        int restTimeInSeconds = PlanCRUD.PlanList.get(wcd.getIndex()).getTtotal();
        return (restTimeInSeconds * 1000) - elapsedTime;
    }
}

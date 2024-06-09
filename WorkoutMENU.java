package healthcare;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/*
이제 거의 막바지다...
현재선택한 운동 플랜의 휴식시간을 가지고 타이머를 설정해서 중간에 시간을 확인할 수 있고 타임이 종료된다면
알리고 나서 ok를 누른다음에 takingrest를 false로 바꿔서 나중에 운동 리스트 나올 때 현재 운동이 수행 중으로 뜨게 만들기

타이머는 메뉴의 속성으로 가지는 것이 편하지 않을까? 메뉴 입력을 기준으로 측정해야 하잖아!
 */
class WorkoutMENU {

    private Timer timer;
    public WorkoutCRUD wcd; //wcd = WorkoutCruD

    public WorkoutMENU(){
        Scanner sc = new Scanner(System.in);
        wcd = new WorkoutCRUD(); //wcd = WorkoutCruD

        int cmd;

        wcd.setIndex(); // get an input of number of plan
        displayExerciseMenu(wcd.getIndex());

//        Timer RestTimer = new Timer();
//        //타이머 작업을 정의
//        RestTimer task = new TimerTask(){
//            public void run() {
//                System.out.println("Break time ends");
//                wcd.noTakingRest();
//                scheduler.shutdown();
//            }
//        }

        while(true){
            cmd = sc.nextInt();

            if(cmd == 1){ // End current workout
                currentNum++;
                if (currentNum == PlanList.get(wcd.getIndex()).kind.length){
                    // 차근차근 완료하다가 모든 운동을 수행완료했을 때(만일 현재 운동이 마지막 운동이어서 거기서 완료하고 ++할 경우)
                    System.out.println("Today's workout is completed!!");
                    PlanList.get(wcd.getIndex()).checkComplete();
                    break;
                }
                else {
                    wcd.yesTakingRest();
                    startRestTimer();  // 휴식시간을 초로 환산한 Ttotal
                    // 하나의 운동이 끝날 때마다 새롭게 타이머를 시작
                    wcd.displayList();
                }
            }
            else if(cmd == 2){ // Check remaining break time
                //일단 지금 휴식 중인지 부터 체크
                if(wcd.getTakingRest()){ // 휴식 중이 맞다면
                    long remainingTime = timer.getRemainingTime();
                    System.out.println("Remaining break time: " + (remainingTime / 1000) + " seconds");
                } else {
                    System.out.println("Now is not the time to rest!");
                }
            }
            else if(cmd == 3){ // Skip the break time
                //일단 지금 휴식 중인지 부터 체크
                if(!wcd.getTakingRest()){ // 휴식 중이 아니라면
                    System.out.println("Now is not the time to rest!");
                }
                else {
                    wcd.NoTakingRest();
                }
            }
            else if(cmd == 4){ //Workout completed
                System.out.println("Good Job!")
                PlanList.get(wcd.getIndex()).checkComplete();
                break;
            }
            else if(cmd == 5){ // Exit
                System.out.println("Exit");
                break;
            }

        }
    }


    public void displayExerciseMenu(){
        System.out.println("--------------------Workout Menu--------------------");
        //매번 여기에 운동 목록이랑 괄호로 현재 수행 중인 운동 표시해야 함
        displayList(this.index);
        System.out.println("1. End current workout");
        System.out.println("2. Check remaining break time");
        System.out.println("3. Skip the break time");
        System.out.println("4. Workout completed"); // 운동 완료했으면 완료가 뜨게 하자
        System.out.println("5. Exit");
        System.out.println("--------------------------------------------");
    }

    public void startRestTimer() {
        if (timer != null) { // 기존 타이머가 있다면 취소하고 초기화
            timer.cancel();
            timer = null;
        }
        timer = new Timer();

        // 시작 시간 기록
        long timerStartTime = System.currentTimeMillis();

        TimerTask task = new TimerTask(){
            public void run() {
                System.out.println("Break time ends!");
                wcd.noTakingRest();
            }
        };

        // 휴식 시간
        int restTimeInSeconds = PlanList.get(wcd.getIndex()).getTtotal();

        // 타이머 시작
        timer.schedule(task, restTimeInSeconds * 1000); // 초 단위를 밀리초로 변환

        System.out.println("Break time started. Remaining time: " + restTimeInSeconds + " seconds");

        // 타이머가 시작된 시간과의 차이를 계산하여 남은 시간을 출력
        long elapsedTime = System.currentTimeMillis() - timerStartTime;
        long remainingTimeInSeconds = restTimeInSeconds - (elapsedTime / 1000);
        System.out.println("Remaining break time: " + remainingTimeInSeconds + " seconds");
    }
}

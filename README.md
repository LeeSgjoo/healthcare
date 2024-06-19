# Project title: healthcare-program
# Project membersr(1): Lee seung joo(22300546)
# Project description - This program help you to make plan and do your workout.
# .
# .
# .
#  < User's guide >
# 1. when you start program, you can see th menu.
#    it has 6 choices.
#
# If you input number 1, you can check your workout plan that sorted by 'Quicksort algorithm'.
# If there is no plan, program informs that fact like "Planlist is empty.".
# If you input number 2, you can add your workout plan. 
# the plan includes date, title, number of exercises, kind of exercises and rest time
# (If the date has already been added, it will notify you that it has been duplicated.)

<img src = "https://github.com/LeeSgjoo/healthcare/blob/main/img/img(1).png?raw=true">

# 
# 
# The (N) mark is "NO" that mean you did not complete this plan. 
# If you complete it, than it changes from (N) to (Y)
# If you input number 3, you can modify your workout plan.
# (If the date has already been added, it will notify you that it has been duplicated.)
# To modify plan, you should input the date and then input the information of plan.
# If you input number 4, you can delete your workout plan.
# To delete plan, you should input the date of plan.

# you can see main menu again, if you input number 6.

<img src = "https://github.com/LeeSgjoo/healthcare/blob/main/img/img(2).png?raw=true">



# You can start exercise by inputting number 5, then program shows the plans added.
# you should select the plan you want to do by inputting the number of plan.

# When you start workout, then program displays 'Today's Workout' and 'Workout Menu'
# when you work out number 1 exercise, there is (Performing) message next to the name of exercise.
# if you finish current exercise, you should input number 1, then it moves to next workout and start rest time.
# (Performing) changes  to (Taking Rest). program informs 'Remaining time'.
<img src = "https://github.com/LeeSgjoo/healthcare/blob/main/img/img(3-1).png?raw=truehttps://github.com/LeeSgjoo/healthcare/blob/main/img/img(3-1).png?raw=true">

# During take a break, you can check your left rest time by inputting number 2.
# If you input number 3, you can skip rest time. (Taking Rest) changes  to (Performing)
# And then rest time is initialized.
<img src = "https://github.com/LeeSgjoo/healthcare/blob/main/img/img(3-2).png?raw=true">

# When the rest time that you did input runs out, then your current exercise is automatically started.
# When the rest time is already finished, if you input number 2, then program says "Now is not the time to rest!".
<img src="https://github.com/LeeSgjoo/healthcare/blob/main/img/img(3-3).png?raw=true">

# When you finish your workout plan, input number 4, then the exercising is ended and moves on main menu.
# you can quit the program by inputting number 7.
<img src="https://github.com/LeeSgjoo/healthcare/blob/main/img/img(3-4).png?raw=true">

#.
#.
#.
# <UML diagram of classes and interfaces>
<img src ="https://github.com/LeeSgjoo/healthcare/blob/main/img/UML.jpg?raw=true">
# Bakdauren_Narbayev_Java_HW_NURunner
A short description is given below. A more thorough explanation of what the program does can be found in _CSCI235-Project.pdf_ file.

## Description
Creating an animation about Nazarbayev University (NU) students getting grades, and having a graduation ceremony, by using object-oriented design principles. In simple words, professors are walking around leaving assessments with random grades on a map. Meanwhile, the students are walking around the same map, collecting nearby assessments. Those, who manage to score 100 points or above, stop collecting assessments. When all students 

The students and professors may have 5 main states. 
- In _Rest_ state a person does nothing and stays in one place.
- In _GotoXY_ state a person randomly chooses a destination on a map and goes there.
- In _ZigZag_ state a person randomly chooses direction along which she walks until she hits the border of the map, and bounces off it, continuing her walk after.
- In _Closest_ state **a student** approaches the closest assessments by himself.
- In _Stationary_ state a person is on a graduation ceremony or waits until others finish their degree.

## Usage
You can run the project by doing the following:
1. Prompt> javac NURunner.java
2. Prompt> java NURunner

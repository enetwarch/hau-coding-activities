Write a code that will simulate Lotto 6/49, the user will be asked to choose (input) 6 numbers from 1 to 49. The program shall draw 6 numbers randomly from the same range. The program shall be able to determine how many numbers matched and display corresponding output. The following scheme is used for prizes:

| Number of Matches | Prize |
|:-:|:-:|
| 3 | Php50.00 |
| 4 | Php1,200.00 |
| 5 | Php50,000.00 |
| 6 | Jackpot |

Source: [https://www.pcso.gov.ph/Games/Lotto/SuperLotto649.aspx](https://www.pcso.gov.ph/Games/Lotto/SuperLotto649.aspx)

Use the Random class for randomly drawing the 6 winning numbers. Make sure to import random (**import java.util.Random;**) and instantiate an object (**Random rn = new Random();**) in your code and use the following statement for generating random integers:

```
int numbers = rn.nextInt(49) + 1 
// this code will allow generation of an integer from 1 to 49 and will be placed in the variable number
```

You can use the enhanced for loop to go through the content of an array:

```
for (int num : lottoArray) 
// this will allow looping thru each element in the array placed in the variable num at each loop
// there will be no need to use array name and index to refer to each element while in the loop
```

### Sample Output:

```
Input 6 numbers [1-49] :
    8
    18
    7
    30
    1
    45

The winning numbers are : 9 30 35 19 46 34
Number of Match/es: 1
Better Luck Next Time!
```

### Sample Output: 

```
Input 6 numbers [1-49] :
    8
    18
    7
    30
    1
    45

The winning numbers are : 9 30 35 19 45 7
Number of Match/es: 3
You won Php50.00!
```

### Scoring Guide for Lotto.java

Code meets problem requirements: (6 pts)

- *proper use of arrays*
- *inputs*

Code produces correct output (5pts)
Code uses appropriate decision and looping statements (5pts)
Code is efficient and follows good programming practice (4pts)
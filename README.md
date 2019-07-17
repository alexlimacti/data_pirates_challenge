## Data Pirates Challenge

Solution to the Data Pirates Challenge

## Requirements
- Java 8 (1.8.221)

## Search Source
- JSoup: https://www.tutorialspoint.com/jsoup/index.htm
- JSoup Connection: https://www.programcreek.com/java-api-examples/index.php?api=org.jsoup.Connection
- JsonLines: https://hackernoon.com/json-lines-format-76353b4e588d
- JsonLines Documentation: http://jsonlines.org/

## Preparing the Environment
- Follow the steps described for Environment in https://www.youtube.com/watch?v=TYdkuWvxWOk
- Follow the steps described for Maven in https://www.youtube.com/watch?v=6AVC3X88z6E
- The IDE used in the project was the Eclipse Version: 2019-03 (4.11.0), but feel free to choose.

## Steps
- Import project - in Eclipse: file menu -> Import... -> Maven -> Existing Maven Projects -> Next -> Browse Button -> indicate project path - > select project -> Finish Button
- Wait for the dependencies to be imported
- In the package has the class App.java, responsible for the execution of the project. The lines "ufs.add("UF");" will be used to indicate the states to search. To search for more states, simply add more lines as shown below

ufs.add("SC");

ufs.add("BA");

ufs.add("PE");

- After defining the states, press Ctrl + F11 to run the project. If a screen appears to select the execution mode, select Java Application

## Results

Two files will be generated in Json format, one unformatted (faixacep.json) and one formed (faixaceo.jsonl). In the Eclipse console the formatted output will be printed.
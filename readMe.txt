****************************
********* Sorting **********
****************************
1. Open Command Prompt

2. Change directory to the location of the sort.jar

3. Type in 'java -jar sort.jar -f<FILENAME> -t<COMPARETYPE> -s<SORTTYPE> to the command prompt. 
   
   Ensure you replace <FILNAME> with the name of the file you want to use including its file type
   Ensure you replace <COMPARETYPE> with the name of the file you want to use including its file type.
   Ensure you replace <SORTTYPE> with the name of the file you want to use including its file type.

   Ex. 'java  -jar sort.jar –fpolygons1.txt –Tv –Sb'

4. The program will then sort the selected file based on the comparison type chosen and ordering it
   in Descending order using the sorting algorithm picked.

5. The program will then display the first value, every 1000th value and the final value of the file.

6. The end will give a Final Report on the selected variables as well as the time.

The list of FILENAMEs are as follows
    polygons1.txt
    polygons3.txt
    polygons5.txt

The list of COMPARETYPEs are as follows
    -h   is for Height Comparison
    -a   is for Base Area Comparison
    -v   is for Base Volume Comparison


The list of SORTTYPEs are as follows
    -b   is for Bubble Sort
    -s   is for Selection Sort
    -i   is for Insertion Sort
    -m   is for Merge Sort
    -q   is for Quick Sort
    -z   is for Martini Sort
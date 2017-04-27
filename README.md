# Java Masters Project
Java SE and Swing
---
The complete code for my Java post-grad course completed in 2016. The project was split into two sections, the raw Java code and the
Java GUI implementation in Swing. 

The project focused on taking DNA strings and converting them into their different RNA composites, I had to run all possiable frames 
to be displayed and saved. 

Project Breakdown
---
This project made up half of the work for the course with the initial part of the project being the raw code side and the second half
being that of the Swing GUI.The code that powers the program can be found inside the DNAprogram directory.

The program flow is:
1. It accepts a text document of the raw DNA as shown in the insulin.txt (file in FASTA format). 
2. The Ribosome class is used to translate the DNA into the frames.
3. The OpenReadingFrame class is used to find any reading frame that is valid and open.
4. Any valid reading frame can be retrieved.

### The Code

Sequence forms the base class that is inherited and is declared abstracted to prevent it from being created on its own.
The sequence class contains the base methods used throughout the project, the classes that inherit the Sequence have
it as a postfix.

ProtienSequence provides the complete suite of tools to translate different elements.

### The GUI

Developed entirely in Swing all Java classes are located in the GUI directory. The main class is Translator.java which supports
the rest of the GUI by creating the elements in the correct location and order. Translator also implements the ActionListener 
class which is used to signal the GUI events.

The GUI displays everything from within the TranslationTool class which generates the QuitableJFrame in a size of 1000 x 800.
There is a menubar generated for saving and opening files using Swings inbuilt menu calls. Most of the data is shown and 
displayed in the TranslationPanel class which allows the user to submit a DNA sequence in the first panel with the data being
displayed in the following panel after the correct actions are fired from button clicks.

### Retrospective

This course did push me greatly and forced me to pick up the Java language concepts rapidly. We got a lot of work which seemed to keep 
coming. It was rather difficult but this project did force me to explore and learn the language to a deeper level, even if it did 
cause me many sleepless nights I greatly enjoyed this project overall. This was my first glimpse of UI development and I did enjoy
it great, even though state-management can be tricky and if you aren't careful you can make some pretty big errors I found the whole
process deeply rewarding.

### Improvements

If I had more time I would have worked on more of the GUI to try and establish more of a content flow to make even those unfamiliar with
it understand the program with ease. I would also look into adding more menubar function.

The code could have been cleaner and looking back on it I should have used StringBuilder for a lot of it. There is quite a lot of 
refactoring of code I could have done and some methods that need to be rewritten.



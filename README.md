# Shell-Emulator
This project emulates the look and some functions of the Command Line Interface. 
The design pattern used is the Command design Pattern (for obvious reasons) 
All commands are java classes that implement the Command interface due to
which they have almost identical fields and methods (constructor and execute()). 
The java class Shell  creates the "Commands" and calls their execute() function.
The Design Patterns used are:
1) Singleton
2) Facade
3) Command

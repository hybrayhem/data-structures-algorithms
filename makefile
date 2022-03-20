JFLAGS = -g --release 10
JC = javac
JVM = java 
MAIN = urban_planner/Main
.SUFFIXES: .java .class
.java.class:
		$(JC) $(JFLAGS) $*.java

CLASSES = \
        urban_planner/Main.java \
		urban_planner/Building.java \
        urban_planner/House.java \
        urban_planner/Market.java \
        urban_planner/Office.java \
        urban_planner/Playground.java  \
        urban_planner/StreetArray.java

default: classes

classes: $(CLASSES:.java=.class)

run: classes
		$(JVM) $(MAIN)

clean:
		$(RM) urban_planner/*.class
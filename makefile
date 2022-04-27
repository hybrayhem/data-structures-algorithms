JFLAGS = -g --release 10
JC = javac
JVM = java 
MAIN = question/Main
.SUFFIXES: .java .class
.java.class:
		$(JC) $(JFLAGS) $*.java

CLASSES = \
        question/Main.java \
        question/Q1.java \
		question/Q2.java

default: classes

classes: $(CLASSES:.java=.class)

run: classes
		$(JVM) $(MAIN)

clean:
		$(RM) question/*.class
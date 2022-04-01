JFLAGS = -g --release 10
JC = javac
JVM = java 
MAIN = question/Main
.SUFFIXES: .java .class
.java.class:
		$(JC) $(JFLAGS) $*.java

CLASSES = \
        question/Main.java \
        question/q1.java \
		question/q2.java \
        question/q3.java \
        question/q4.java \
        question/q5.java

default: classes

classes: $(CLASSES:.java=.class)

run: classes
		$(JVM) $(MAIN)

clean:
		$(RM) question/*.class
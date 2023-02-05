JFLAGS = -g --release 10
JC = javac
JVM = java 
MAIN = test_complexity/Main
.SUFFIXES: .java .class
.java.class:
		$(JC) $(JFLAGS) $*.java

CLASSES = \
        test_complexity/Main.java 

default: classes

classes: $(CLASSES:.java=.class)

run: classes
		$(JVM) $(MAIN)

clean:
		$(RM) test_complexity/*.class
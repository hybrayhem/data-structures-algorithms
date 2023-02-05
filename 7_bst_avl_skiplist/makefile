JFLAGS = -g --release 10
JC = javac
JVM = java 
MAIN = homework/Main
.SUFFIXES: .java .class
.java.class:
		$(JC) $(JFLAGS) $*.java

CLASSES = \
        homework/*.java \
        BinarySearchTree/*.java

default: classes

classes: $(CLASSES:.java=.class)

run: classes
		$(JVM) $(MAIN)

clean:
		$(RM) homework/*.class BinarySearchTree/*.class

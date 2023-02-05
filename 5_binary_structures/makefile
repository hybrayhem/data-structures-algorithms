JFLAGS = -g --release 10
JC = javac
JVM = java 
MAIN = question/Main
.SUFFIXES: .java .class
.java.class:
		$(JC) $(JFLAGS) $*.java

CLASSES = \
        question/Main.java \
        question/BinaryHeap.java \
		question/BinarySearchTree.java \
        question/BinaryTree.java

default: classes

classes: $(CLASSES:.java=.class)

run: classes
		$(JVM) $(MAIN)

clean:
		$(RM) question/*.class
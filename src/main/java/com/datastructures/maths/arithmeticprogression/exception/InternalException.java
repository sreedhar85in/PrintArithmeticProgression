package com.datastructures.maths.arithmeticprogression.exception;

import lombok.Data;

// Exception are in two types. Checked exception and unchecked exception(also called as Runtime exception). Examples of runtime exceptions are null pointer exceptions,ArrayIndexOutOfBoundException 
//https://www.java67.com/2012/12/difference-between-runtimeexception-and-checked-exception.html
//Examples of checked exceptions are  ClassNotFoundException, IOException etc. Unchecked/Runtime exceptions does not need any mandatory exception handling .
//Checked exception needs mandatory exception handling, via try-catch, try-finally block or throws annotation, otherwise it will result in compile-time error .
//serialVersionUID is a version number the JVM can use to check if a serialized class matches the class definition you are trying to deserialize into.
//this serialVersionUID should be declared in any class that implements Serializable.. or An object is serializable if it, or one of its super classes, implements serializable.
//Here Exception class extends throwable class. Throwable class implements Serializable.
//serialVersionUID is to determine if they have serializable and deserializable compatibility if they have the same serialVersionUID and both implements Serializable then they are compatible.
//https://www.geeksforgeeks.org/serialization-in-java/
//https://www.codejava.net/java-se/file-io/why-do-we-need-serialization-in-java
//https://stackoverflow.com/questions/285793/what-is-a-serialversionuid-and-why-should-i-use-it


@Data
public class InternalException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2763359097221927829L;
	private final int outcomeCode;
	private final String outcomeMessage;
	private final String internalMessage;

}

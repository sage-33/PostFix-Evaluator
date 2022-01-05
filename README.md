# Post Fix Evaluator


## Overview
For this assignment, you will be implementing a Post Fix Evaluator to perform basic arithmetic.

### Table of Contents
**[Files to complete](#files-to-complete)**<br>
**[Support Code API](#support-code-api)**<br>
**[Part One: Importing Project into Eclipse](#part-one-importing-project-into-eclipse)**<br>
**[Part Two: Implementing LinkedStack](#part-two-implementing-linkedstack)**<br>
**[Part Three: Implement Arithmetic Operators](#part-three-implement-arithmetic-operators)**<br>
**[Part Four: Implement a Postfix Arithmetic Evaluator](#part-four-implement-a-postfix-arithmetic-evaluator)**<br>
**[Part Five: Commit Project and Submit Pull Request](#part-five-commit-project-and-submit-pull-request)**<br>
**[Bonus: Infix Expression Evaluator](#bonus-infix-expression-evaluator)**<br>
**[Additional Notes: Help for the project](#additional-notes)**<br>

## Book
This assignment is based off Chapter 3 and Chapter 4 in the Java Software Structures 

## Files to complete
Each of the files listed here have unit tests associated with them and are required for submission. With the exception of LinkedStack, you are allowed to implement them in anyway you would like. However, keep in mind I have tried to provide you with helper classes that should make your job easier.

**stack.LinkedStack<T>** - A Stack data structure that MUST use a Node based structure to allow for unbounded stack size. Note, you may not use the built in List types provided by the Java API.

**language.arith.SubOperator** - A binary operator for performing subtraction on two integers.
**language.arith.MultOperator** - A binary operator for performing multiplication on two integers
**language.arith.DivOperator** - A binary operator for performing multiplication on two integers
**language.arith.NegateOperator** - A unary operator for performing negation on a single integer
**evaluator.arith.ArithPostFixEvaluator** - An evaluator for simple arithmetic post fix notation

### Test files
In the test folder, you are provided with several JUnit test cases that will help you keep on track while completing this assignment. I recommend you run the tests often and use them as a checklist of things to do next. You are not allowed to modify these files. If you have errors in these files, it means the structure of the files found in the src folder have been altered in a way that will cause your submission to lose points.

### Support Code API
The Support Code’s comments have been generated into a nicely formatted API that can be found here: 

https://jd12.github.io/postfix-evaluator/

It is not important that you understand how the support code is implemented but it is important that you understand what the support code offers. It is highly recommended that you spend a day simply reading over the comments in each of the interfaces provided:

**stack.StackInterface**<br>
**parser.arith.PostFixParser**<br>
**language.Operator**<br>
**language.Operand**<br>
**language.BinaryOperator**<br>
**evaluator.PostFixEvaluator**<br>


## Part One: Importing Project into Eclipse
Begin by cloning the provided project and importing it into your workspace. 

`git clone <url for github repository>`

After cloning this repository you want to run these commands

```
cp pre-commit .git/hooks
chmod +x .git/hooks/pre-commit
```

These commands set up your repository so you don't accidentally commit to the master branch.

`git checkout -b development`

This will create a branch named development and switch you to it. The development branch is where you will make all your commits.

```
cp git-commit-template.txt ~/.git-commit-template.txt
git config --global commit.template ~/.git-commit-template.txt
```

This will set up your commit template to automatically bring up the file to remind you of the format you want.


You should then go to Eclipse. File --> Import. Double-click on Gradle and then Existing Gradle Project. Click Browse next to Project Root Directory and find your folder and click Open. The project should pop up in the text box Projects. Click finish and you should be good to go!

By default, your project should have no compiler errors and contain the following root items:

**src** - The source folder where all code you are submitting must go. You can change anything you want in this folder, you can add new files, etc...<br>
**test** - The test folder where all of the public unit tests are available<br>
**support** - This folder contains support code that I encourage you to use (and must be used to pass certain tests). You are not allowed to change anything in this folder.<br>
**JUnit 4** - A library that is used to run the test programs<br>
**JRE System Library** - This is what allows java to run<br>

If you are missing any of the above or errors are present in the project, seek help immediately so you can get started on the project right away. The project does start with a warning in **evaluator.arith.ArithPostFixEvaluator**, this is okay.

## Part Two: Implementing LinkedStack
You need to implement a basic stack data structure using a linked list data type internally to allow for an unbounded structure. Start by reading the comments in the `StackInterface` interface. It will provide you with some direction on what each method needs to do. Also, it will be helpful to review Chapter 3 to see how a stack works and Chapter 4 to see how to implement a stack using a linked structure.

**Hint:** It might be useful to write a class called `Node<T>` that supports basic linked node operations. 

The test associated with the `LinkedStack` class **stack.LinkedStackTest** are in the test folder. You want to make sure you pass all of the tests provided. However, try and think of additional tests that might trip you up. Did you meet all of the requirements specified by the interface?

## Part Three: Implement Arithmetic Operators
Before you can even attempt to create a postfix evaluator, you will need to define what each of the possible postfix operators do. For this assignment, you are required to support addition, subtraction, multiplication, division and negation of integers. To help facilitate this, you have been provided with an `Operator<T>` interface. Take a moment to review the interface. 

Now run the **operator.arith.PlusOperatorTest** test. All of the tests pass! Lucky you. Go ahead and open up the `PlusOperator` class and you will see an implementation. Review this implementation then complete the `SubOperator`, `DivOperator`, and `MultOperator` classes. Each time you implement something, be sure to run the associated tests to see how you’re doing. 

For the `DivOperator` you’ll have to override the `setOperand` method to throw an `IllegalStateException` if the denominator is set to 0. After checking for the exception you can call BinaryOperator’s `setOperand` method and pass in the appropriate arguments. 

Finally, you will need to implement the unary `NegateOperator` class. Negation is represented by the ‘!’ and flips the sign of the Operand. For example 5 ! would evaluate to -5 and -12 ! would evaluate to 12.  Although it is not required, it is recommended that you create an abstract class `UnaryOperator` based off of BinaryOperator first then extend it.

## Part Four: Implement a Postfix Arithmetic Evaluator
Now that we have a stack and operators defined, it is time to create an evaluator. Open up the **evaluator.arith.ArithPostFixEvaluator** class and you will see four TODO comments.

Before starting, check out the **evaluator.arith.ArithPostFixEvaluatorTest** class to see examples of how the evaluator is expected to be called and the results that are expected to be returned.

First, you want to initialize the stack you will be using with your implementation.

Second, determine what you will do when you see an `Operand`.

Third, determine what you will do when you see an `Operator`.

Finally, determine what you will return.

## Part Five: Commit Project and Submit Pull Request 
When you have finished your solution and are ready to submit, make your final commit and push eveything up to Github. Submit a pull request to the main repository so that I know your code is ready to be reviewed.  



## Bonus: Infix Expression Evaluator


Implement the following algorithm for the evaluation of arithmetic infix expressions. 

Each operator has a precedence. The + and - operators have the lowest precedence, * and / have a higher (and equal) precedence, and ^ (which denotes “ raising to a power” in this project) has the highest. For example, 

3 * 4 ^ 2 + 5 

should mean the same as 

(3 * (4  ^ 2)) + 5 

with a value of 53. 

In order to earn full points for the bonus you will have to implement a robust test suite.

### Part One: Write an ExponentOperator class

Write an `ExponentOperatorTest` class similar to that of the of the `PlusOperatorTest` class. Try to think of additional scenarios you would like to test and write test cases for those scenarios. 

Implement an `ExponentOperator` class that is similar to your `PlusOperator` class. Think about what the two operands represent and how perform operation would work for this class. 

**Hint:** `Math.pow` might be of use to you in this class 

### Part Two: Write an ArthInFixEvaluatorClass

Write an `ArthInFixEvaluatorTest` class modeled after `ArthPostFixEvaluatorTest` class. Try to think of additional scenarios you would like to test and write test cases for those scenarios.

Implement an `ArthInFixEvaluator` class that is similar to your `ArthPostFixEvaluator` class. 

In your algorithm, use two stacks. One stack holds Operands, the other holds Operators. When you encounter a Operand, put it on the Operand stack. When you encounter an Operator, push it on the Operator stack if it has higher precedence than the operator on the top of the stack. Otherwise, pop an Operator off the Operator stack, pops the appropriate number of Operands off the Operand stack, and push the result of the computation on the Operand stack. Repeat until the top of the Operator stack has lower precedence. At the end of the expression, clear the stack in the same way. For example, here is how the expression 3 * 4 ^ 2 + 5 is evaluated: 

Expression: 3 * 4 ^ 2 + 5
```

1) Remaining expression: * 4 ^ 2 + 5           Operand stack               Operator stack 
                                                      3 

2) Remaining expression:   4 ^ 2 + 5           Operand stack               Operator stack 
                                                      3                            * 

3) Remaining expression:     ^ 2 + 5           Operand stack               Operator stack  
                                                      4
                                                      3                            *

4) Remaining expression:       2 + 5           Operand stack               Operator stack
                                                      4                            ^
                                                      3                            *  

5) Remaining expression:         + 5           Operand stack               Operator stack
                                                      2
                                                      4                            ^
                                                      3                            *  

6) Remaining expression:         + 5           Operand stack               Operator stack
                                                      16                                        
                                                      3                            *
 
7) Remaining expression:           5           Operand stack               Operator stack
                                                      48                           +


8) Remaining expression:                       Operand stack               Operator stack
                                                      5
                                                      48                           +
                                        

9) Remaining expression:                       Operand stack               Operator stack
                                                      53
```
                  




## Additional Notes

### Using the ArithPostFixParser

You have been provided with a class for parsing arithmetic postfix expressions. It is not important that you understand how it is implemented but it is important that you understand what the interface provides for you. Read over the comments in the **parser.PostFixParser** interface carefully.

A short example of its use can be found in **parser.arith.ArithPostFixParserExample**

### Material on Stacks
Stacks is covered in Chapter 3 book. If you are having trouble, utilize Piazza and classmates. 

### Material on Exceptions
For this assignment, you will need to make use of exceptional situations. For a quick reference on how to throw an exception, check out **language.BinaryOperator** this is an abstract class that meets many of the requirements for the **language.Operator** interface. You will notice that its `setOperand` method has several exceptional states and throws the exceptions detailed in the **language.Operator** interface. Also, there is material available in the book in chapter 3 (focus on section 3.6).

### Where is the Driver Class?
If you scan through the provided files, you will notice none of them contain a main method. This means that out of the box you can’t actually run your code. Instead, I highly recommend you create your own drivers for testing out your elements. For example, when you implement the MultOperator, you might write a driver somewhere with the following:

```java
public static void main(String[] args){
  Operator<Integer> multOp = new MultOperator();
  Operand<Integer> operand0 = new Operand<Integer>(5);
  Operand<Integer> operand1 = new Operand<Integer>(6);
  multOp.setOperand(0, operand0);
  multOp.setOperand(1, operand1);
  Operand<Integer> result = multOp.performOperation();
  System.out.println(result.getValue());
}
```

I also recommend you write a Driver that reads in post fix expressions from the user and calculates them. This might look something like this:

```java
public static void main(String[] args){

   Scanner s = new Scanner(System.in);
   PostFixEvaluator<Integer> evaluator = new ArithPostFixEvaluator();
   System.out.println(“Welcome to the Post Fix Evaluator 5000 SUX”);
   System.out.println(“Please enter a post fix expression to be evaluated:”);
   String expr = s.nextLine();
   // Sometimes I get an exception… Maybe I should use a try/catch block.
   Integer result = evaluator.evaluate(expr);
   System.out.println(“The expression evaluated to: “ + result);
   // Maybe I could ask user if they want to enter another expression and loop

}
```

### What is this public static enum Type?
In the `ArithPostFixEvaluator` code I provided for you I wrote a switch statement that has two cases: OPERAND and OPERATOR. If you decide to dig to see what these are, you will find the following:

```java
	/**
	 * A {@link PostFixParser} can produce different types.
	 * @author jcollard, jddevaug
	 *
	 */
	public static enum Type {
	
		/**
		 * Indicates that the value being parsed is an {@link Operand}
		 */
		OPERAND,
		
		/**
		 * Indicates that the value being parsed is an {@link Operator} 
		 */
		OPERATOR;
	}
```

It really isn’t that important that you understand what these are doing. It is more important that you understand their significance in this program. The PostFixParser can produce two different types, Operators and Operands. This class helps facilitate that information to the user in a more readable (and modular) way than a boolean would. The nextType method returns one of these two things indicating which method you should call next in your evaluator. Luckily, most of this code is written for you so you don’t have to worry too much about it. If you are really interested in knowing more about enumerated types in Java, I recommend you check out this: http://docs.oracle.com/javase/tutorial/java/javaOO/enum.html




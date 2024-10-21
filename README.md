# RPN Calculator in Java

## Introduction

This project is a **Reverse Polish Notation (RPN)** calculator that reads RPN expressions from a file and evaluates them. The user can provide the filename either through the command line or by being prompted after launching the program. If the file does not exist, the program stops and displays an error message.

For valid RPN expressions, the program shows both the expression and its result. Malformed expressions will result in an error message.

## What is RPN?

**Reverse Polish Notation (RPN)**, also called postfix notation, places operators after their operands. This eliminates the need for parentheses. For example:
- Infix: `3 + 4`
- RPN: `3 4 +`

### RPN Evaluation

The RPN expression is processed like this:
1. If the token is an **operator**:
   - Pop two operands from the stack.
   - Apply the operator.
   - Push the result back onto the stack.
2. If the token is an **operand**, push it onto the stack.

The final result is left on the stack after processing all tokens.

## Program Details

- **Program Name**: `RPN.java`
- The program reads a statement or a text file with RPN expressions.
- If the file can't be read, an error is displayed, and the program halts.
- Each RPN expression is evaluated, and malformed expressions show an error.

### Supported Operators

- Addition (`+`)
- Subtraction (`-`)
- Multiplication (`*`)
- Division (`/`)
- Exponentiation (`^`)

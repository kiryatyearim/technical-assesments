package com.kiryatyearim.technical.assesment.questions;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Stack;

public class ParenthesisQuestion {

    public static void main(String[] args) {
        int input = 3;
        ParenthesisQuestion question = new ParenthesisQuestion(input);
        question.getWellFormedParenthesis(0,0);
        System.out.print("output: " + question.getOutput() + ", total valid pairs: " + question.getOutput().size());

    }
    int pairs;
    List<String> output = new ArrayList<>();
    Stack<String> stack = new Stack<>();

    ParenthesisQuestion(int pairs) {
        this.pairs = pairs;
    }

    private void getWellFormedParenthesis(int openN, int closeN) {

        if ( openN == closeN && openN == pairs) {
            Enumeration<String> e = stack.elements();
            StringBuilder sb = new StringBuilder();
            while(e.hasMoreElements()) {
                sb.append(e.nextElement());
            }
            output.add(sb.toString());
        }

        if ( openN < pairs ) {
            stack.push("(");
            getWellFormedParenthesis(openN+1, closeN);
            stack.pop();
        }

        if ( closeN < openN ) {
            stack.push(")");
            getWellFormedParenthesis(openN, closeN+1);
            stack.pop();
        }

    }

    public List<String> getOutput() {
        return output;
    }
}

package com.kiryatyearim.technical.assesment.questions;

import java.util.Arrays;

public class MischeleousTest {
    public static void main(String[] args) {
        String s = "Hello! This is a sentence. Or not?";
        String[] sentences = s.split("[!.?]");
        System.out.println("sentences: " + Arrays.toString(sentences));
    }
}

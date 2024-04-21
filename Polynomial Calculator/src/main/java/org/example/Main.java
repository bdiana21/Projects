package org.example;

import view.View;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new View("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
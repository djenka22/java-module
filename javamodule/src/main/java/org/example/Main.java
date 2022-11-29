package org.example;

import lombok.extern.slf4j.Slf4j;
import org.example.web.FileController;

/**
 * Hello world!
 *
 */
@Slf4j
public class Main {
    public static void main( String[] args ) {
        FileController controller = FileController.getInstance();
        System.out.println("begin");
        for (int i = 0; i < 1000; i++) {
            controller.myDoGet();
        }
        System.out.println("end");


    }




}

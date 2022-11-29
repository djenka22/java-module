package org.example.web;
import org.example.callback.CallbackReadImpl;
import org.example.contracts.Service;
import org.example.service.ServiceImpl;

import java.io.File;

import static org.example.constants.Files.FILE_FOR_RESULT_INPUT;
import static org.example.constants.Files.FILE_FOR_TEXT_INPUT;

public class FileController {
    private static FileController instance;
    private final Service service;
    private final File fileForInput;
    private final File fileForOutput;
    private FileController() {
        this.service = ServiceImpl.getInstance();
        this.fileForInput = new File(FILE_FOR_TEXT_INPUT);
        this.fileForOutput = new File(FILE_FOR_RESULT_INPUT);


    }
    public static FileController getInstance() {
        if(instance == null) {
            instance = new FileController();
        }
        return instance;
    }


   /* @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        service.writeLinesToFile(fileForInput, List.of(req.getParameter("lines")));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //service.readLinesFromFile(fileForOutput);
        resp.getWriter().println("hello");
    }

    */

    public void myDoGet() {
        service.readLines(fileForOutput, new CallbackReadImpl());
    }
}

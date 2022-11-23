package org.example.web;

import org.example.contracts.IService;
import org.example.service.Service;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.example.constants.Files.FILE_FOR_RESULT_INPUT;
import static org.example.constants.Files.FILE_FOR_TEXT_INPUT;

@WebServlet("/")
@WebFilter
public class FileController extends HttpServlet {
    private static FileController instance;
    private final IService service;
    private final File fileForInput;
    private final File fileForOutput;
    private FileController() {
        this.service = Service.getInstance();
        this.fileForInput = new File(FILE_FOR_TEXT_INPUT);
        this.fileForOutput = new File(FILE_FOR_RESULT_INPUT);


    }
    public static FileController getInstance() {
        if(instance == null) {
            instance = new FileController();
        }
        return instance;
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        service.writeLinesToFile(fileForInput, List.of(req.getParameter("")));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("hello");
        service.readLinesFromFile(fileForOutput);
    }
}

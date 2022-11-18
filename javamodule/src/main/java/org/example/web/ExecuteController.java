package org.example.web;

import org.example.contracts.IService;
import org.example.service.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/api/execute")

public class ExecuteController extends HttpServlet {
    private static ExecuteController instance;
    private final IService service;
    private ExecuteController() {
        this.service = Service.getInstance();
    }
    public static ExecuteController getInstance() {
        if(instance == null) {
            instance = new ExecuteController();
        }
        return instance;
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}

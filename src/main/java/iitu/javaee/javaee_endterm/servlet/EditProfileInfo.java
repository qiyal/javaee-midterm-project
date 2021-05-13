package iitu.javaee.javaee_endterm.servlet;

import iitu.javaee.javaee_endterm.model.*;
import iitu.javaee.javaee_endterm.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditProfileInfo extends HttpServlet {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("edit-profile-info.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        user.setId(Integer.parseInt(req.getParameter("user_id")));
        user.setUsername(req.getParameter("username"));
        user.setPassword(req.getParameter("password"));
        user.setName(req.getParameter("name"));
        String path = req.getContextPath();

        System.out.println(user.getPassword() + "\t\t" + req.getParameter("password2"));

        if (!user.getPassword().equals(req.getParameter("password2"))) {
            path += "/edit-profile-info?error=password-invalid";
        } else if (!userService.checkUsernameWhenEdit(user.getUsername(), user.getId())) {
            path += "/edit-profile-info?error=username-invalid";
        } else {
            userService.updateUser(user);
            path += "/profile";
        }
        resp.sendRedirect(path);
    }
}

package servlets;

import ejb.AccountBeanRemote;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SSServlet extends HttpServlet {
    @EJB
    private AccountBeanRemote AccountBean;
    private ArrayList data = null;
    private int result = 0;

    @Override
    public void init() {
        System.out.println("SSServlet: init()");
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("SSServlet: processRequest()");      
    try {
            RequestDispatcher dispatcher;
            ServletContext servletContext = getServletContext();
            String page = request.getPathInfo();
            page = page.substring(1);
            System.out.println("Page is : " + page);
            if (request.getSession().getAttribute("isAuthenticated") == null && !(page.equals("login") || page.equals("loginResult"))){ 
                response.sendRedirect("login");
            }
            if (page.equals("login")){
            }
            else if (page.equals("loginResult")) {
                data = getAccountInfo(request);
                request.setAttribute("data", data);
                if (data != null) {
                    request.getSession().setAttribute("isAuthenticated", true);
                }
            } 
            else if (page.equals("updateProfile")) {
                //no attributes to set
            } else if (page.equals("updateResult")) {
                result = checkUpdate(request);
                request.setAttribute("result", result);
            } 
            else if (page.equals("logout")) {
            } else {
                page = "Error";
            }
            dispatcher = servletContext.getNamedDispatcher(page);
            if (dispatcher == null) {
                dispatcher = servletContext.getNamedDispatcher("Error");
            }
            dispatcher.forward(request, response);
        } catch (Exception ex) {
            log("Exception in SSServlet.processRequest()");
        }
    }
 
    private ArrayList getAccountInfo(HttpServletRequest request) {
        String staffID = request.getParameter("staffID");
        String password = request.getParameter("password");
        return AccountBean.checkAccount(staffID, password);

    }
  
    private int checkUpdate(HttpServletRequest request) {
        String staffID = (String) request.getSession().getAttribute("staffID");
        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");
        String new2Password = request.getParameter("new2Password");
        //String newEmail = request.getParameter("newEmail");

        return AccountBean.checkUpdate(staffID, oldPassword, newPassword, new2Password);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("SSServlet: doGet()");
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("SSServlet: doPost()");
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "SSServlet";
    }

    @Override
    public void destroy() {
        System.out.println("SSServlet: destroy()");
    }
}

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.getOutputStream().println("hehe");

        OutputStreamWriter writer = new OutputStreamWriter(resp.getOutputStream());

        Integer doubledValue = 12 * 2;

        writer.write(doubledValue.toString());
        writer.flush();
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        //resp.getOutputStream().println("doPost");


        String receivedString = req.getParameter("param1");


        OutputStreamWriter writer = new OutputStreamWriter(resp.getOutputStream());

        Integer doubledValue = Integer.parseInt(receivedString) * 2;

        writer.write(doubledValue.toString());
        writer.flush();
        writer.close();
    }


    public static void main(String[] args) throws Exception{
        Server server = new Server(Integer.valueOf(System.getenv("PORT")));
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);
        context.addServlet(new ServletHolder(new MyServlet()),"/*");
        server.start();
        server.join();
    }
}


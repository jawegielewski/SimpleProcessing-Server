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
}


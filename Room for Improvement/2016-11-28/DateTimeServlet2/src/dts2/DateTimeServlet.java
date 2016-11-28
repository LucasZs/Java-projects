package dts2;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DateTimeServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd. HH:mm:ss.SSS");
		String formattedDate = sdf.format(date);
		PrintWriter out = resp.getWriter();
		out.write(formattedDate);
	}
}

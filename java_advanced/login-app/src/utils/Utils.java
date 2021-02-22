package utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class Utils {

	public static void printResponseMessage(HttpServletResponse response, String message) {
		try (PrintWriter writer = response.getWriter()) {
			writer.println("<p><span style=\"color:red\">" + message + "</span></p>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

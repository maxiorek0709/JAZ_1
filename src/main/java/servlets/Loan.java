package servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/calculator")
public class Loan extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final int oneYear = 12;

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String amount = req.getParameter("amount");
        String rateCount = req.getParameter("rateCount");
        String interestRate = req.getParameter("interestRate");
        String fixedFee = req.getParameter("fixedFee");
        String rateType = req.getParameter("rateType");
        double loanAmount = Double.parseDouble(amount);
        int loanRateCount = Integer.parseInt(rateCount);
        double loanInterestRate = Double.parseDouble(interestRate);
        double loanFixedFee = Double.parseDouble(fixedFee);
        if (fixedFee.equals("") && rateType == null || rateType.equals("")) {
            resp.sendRedirect("/");
        }
        double loanArray[] = {loanAmount, loanInterestRate, loanFixedFee};
        generateHtml(resp);
        loanCalculate(loanArray, loanRateCount, resp);
       // resp.getWriter().println("</table>" +
        resp.getWriter().println(
        		"</div> \n" +
                "</body> \n" +
                "</html>");

    }

    private void loanCalculate(double[] arrayParam, int loanRateCount, HttpServletResponse resp) throws IOException {
        double interest = arrayParam[1] * 0.01 / oneYear;
        double capital = Math.round(arrayParam[0] / loanRateCount);
        double interestAmount = Math.round(interest * arrayParam[0]); //odsetki
        double rate = Math.round(capital + interestAmount); // rata
        int i;
        for (i = 1; i < loanRateCount + 1; i++) {
            resp.getWriter().println(
                    "<tr><td>" + i +
                            "</td><td> " + capital +
                            "</td><td> " + interestAmount +
                            "</td><td>" + arrayParam[2] +
                            "</td><td> " + rate +
                            "</td></tr>");
            arrayParam[0] = Math.round(arrayParam[0] - capital);
            interestAmount = Math.round(interest * arrayParam[0]);
            rate = Math.round(capital + interestAmount);
        }
    }

    private void generateHtml(HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        resp.getWriter().println("<!DOCTYPE HTML> \n" +
                "<html lang = 'pl' > \n" +
                "<head>\n" +
                "	<meta charset='utf-8'> \n" +
                " 	<title>Kalkulator kredytowy</title> \n " +
                "</head> \n" +
                "<body> \n" +
                "<div class = 'container'> \n" +
                "<header> \n" +
                "Kalkulator kredytowy \n" +
                "</header> \n" +
                " \n" +
                "<h1> Harmonogram splat:</h1>");
        
        //resp.getWriter().println("<table border=0><tr><td> Raty </td>" +
        		resp.getWriter().println("<table><tr><td> Raty </td>" +
                "<td> Kwota kapitalu </td>" +
                "<td> Kwota odsetek </td>" +
                "<td> Oplaty stale </td>" +
                "<td> Calkowita kwota raty </td></tr>");
    }
}
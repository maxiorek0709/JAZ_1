<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <meta charset="UTF-8">
    <title>Kalkulator kredytowy</title>
    </head>
<body>
    <div class='container'>

    <header>Kalkulator kredytowy</header><br/><br/>
    <form action="calculator" method="post">

      
        <label for="amount">Kwota kredytu:</label> <input type="text" name="amount" /><br/><br/>
        <label for="rateCount">Liczba rat:</label> <input type="text" name="rateCount" /><br/><br/>
        <label for="interestRate">Oprocentowanie:</label> <input type="text" name="interestRate" /> %<br/><br/>
        <label for="fixedFee">Opłata stała:</label> <input type="text" name="fixedFee" /><br/><br/>
        <label for="rateType">Rodzaj raty:</label>
            <input type="radio" name="rateType" value="decreasing">malejąca
            <input type="radio" name="rateType" value="fixed">stała<br/>
            <input type="submit" value="Wyslij">
        </form>
    </div>
</body>
</html>
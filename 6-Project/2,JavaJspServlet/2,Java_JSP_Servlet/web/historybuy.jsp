<%@page import="model.Cart"%>
<%@page import="model.Order"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Book"%>
<%@page import="model.User"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Buy Page</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
</head>
<body>
    <div class="container">
        <div class="profile-card card">
            <div class="card-header bg-primary text-white">
                <h3 class="card-title"> My History Buy </h3>
            </div>
            <div class="d-flex flex-row flex-wrap">
                <% ArrayList<Cart> buys = (ArrayList<Cart>)request.getAttribute("buys"); %>
                <% for(Cart item : buys) {%>
                    <div class="col-md-2 mb-3">
                        <div class="card">
                            <img src="https://www.shutterstock.com/image-vector/red-book-bookmark-vector-illustration-260nw-525974458.jpg" class="card-img-top" alt="">
                            <div class="card-body">
                                <h5 class="card-title"> <%= item.getNameBook()%> </h5>
                                <p class="card-text"> <%= item.getTotalPrice() %> VND </p>
                            </div>            
                        </div>
                    </div>
                <% } %>
            </div>
        </div>
        <a href="./home" class="btn btn-primary">Exit</a>
    </div>

    <!-- Bootstrap JS (Optional) -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/5.1.3/js/bootstrap.min.js"></script>
</body>
</html>


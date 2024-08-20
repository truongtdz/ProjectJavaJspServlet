<%@page import="utils.CheckString"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Book"%>
<%@page import="model.Book"%>
<%@page import="model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid">
                <a class="navbar-brand" href="./home">Home</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <% User user = (User) request.getAttribute("user");%>
                        <% if(user != null) { %> 
                            <% if(user.getFirstName() != null && user.getLastName() != null) {%>
                                <a class="nav-link active" href="./myinformation" tabindex="-1" aria-disabled="true"> Hello <%= user.getFirstName() + " " + user.getLastName()%> </a>
                            <% } else {%>
                                <a class="nav-link active" href="./update-user" tabindex="-1" aria-disabled="true">Update Information</a>
                            <% } %>
                            <li class="nav-item">
                                <a class="nav-link active" href="./cart?id=<%= user.getId_user() %>" tabindex="-1" aria-disabled="true">Cart</a>
                            </li>  
                            <li class="nav-item">
                                <a class="nav-link active" href="./historybuy?id=<%= user.getId_user() %>" tabindex="-1" aria-disabled="true">History Buy</a>
                            </li> 
                            <li class="nav-item">
                                <a class="nav-link active" href="./logout" tabindex="-1" aria-disabled="true">Logout</a>
                            </li>  
                        <% } else {%>
                            <li class="nav-item">
                                <a class="nav-link active" href="./login" tabindex="-1" aria-disabled="true">Login</a>
                            </li>   
                            <li class="nav-item">
                                <a class="nav-link active" href="./register" tabindex="-1" aria-disabled="true">Sign-in</a>
                            </li>  
                        <% } %>
                    </ul>
                </div>
            </div>
        </nav>    
        <div class="container-fluid mt-3">
            <div class="row">
                <!-- Phần 1/3 bên trái để tìm kiếm -->
                <div class="col-md-3">
                    <h5>Search</h5>
                    <form method="POST" action="./search">
                        <div class="form-group">
                            <label>Subject</label><br>
                            <div class="row text-end">
                                <div class="col-md-6">
                                    <input name="subjects" class="form-check-input" type="checkbox" value="Math" id="subjectMath">
                                    <label class="form-check-label" for="subjectMath">Math</label>
                                </div>
                                <div class="col-md-6">
                                    <input name="subjects" class="form-check-input" type="checkbox" value="Vietnamese" id="subjectVietnamese">
                                    <label class="form-check-label" for="subjectVietnamese">Vietnamese</label>
                                </div>
                                <div class="col-md-6">
                                    <input name="subjects" class="form-check-input" type="checkbox" value="English" id="subjectEnglish">
                                    <label class="form-check-label" for="subjectEnglish">English</label>
                                </div>
                                <div class="col-md-6">
                                    <input name="subjects" class="form-check-input" type="checkbox" value="Physics" id="subjectMath">
                                    <label class="form-check-label" for="subjectPhysics">Physics</label>
                                </div>
                                <div class="col-md-6">
                                    <input name="subjects" class="form-check-input" type="checkbox" value="History" id="subjectVietnamese">
                                    <label class="form-check-label" for="subjectHistory">History</label>
                                </div>
                                <div class="col-md-6">
                                    <input name="subjects" class="form-check-input" type="checkbox" value="Biology" id="subjectEnglish">
                                    <label class="form-check-label" for="subjectBiology">Biology</label>
                                </div>
                            </div>
                            <label for="classFrom">Class From</label><br>
                            <input type="text" id="classFrom" name="classfrom" class="form-control mb-2" placeholder="Lớp bắt đầu từ">

                            <label for="classTo">Class To</label><br>
                            <input type="text" id="classTo" name="classto" class="form-control mb-2" placeholder="Lớp kết thúc">


                            <button type="submit" class="btn btn-primary mt-2">Search</button>
                        </div>
                    </form>
                </div>
                 <!-- Phần 2/3 bên phải để danh sách sách -->
                <div class="col-md-9">
                    <div class="d-flex flex-row flex-wrap">
                        <% ArrayList<Book> books = (ArrayList<Book>) request.getAttribute("books");%>
                        <% for(Book item : books){ %>
                            <div class="card" style="width: 14rem;">
                                <img src="https://www.shutterstock.com/image-vector/red-book-bookmark-vector-illustration-260nw-525974458.jpg" class="card-img-top" alt="">
                                <div class="card-body">
                                    <h5 class="card-title"> <%= item.getName() %> </h5>
                                    <p class="card-text"> <%= item.getPrice() %> VND </p>
                                    <a href="./detail?id=<%= item.getId_book() %>" type="submit" class="btn btn-primary">Detail</a>
                                    <a href="./addcart?idbook=<%= item.getId_book() %>" type="submit" class="btn btn-primary">Add To Cart</a>
                                </div>
                            </div>
                        <% } %>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
    </body>
</html>

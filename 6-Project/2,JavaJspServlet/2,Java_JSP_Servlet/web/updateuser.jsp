<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update User Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">   
    </head>

<body class="bg-light d-flex justify-content-center align-items-center vh-100">
    <div class="card shadow-sm" style="width: 300px;">
        <div class="card-body">
            <h5 class="card-title text-center mb-4">Update Information</h5>
            <form method="POST" action="./update-user" id="login-form">
                <div class="form-group">
                    <input name="firstname" type="text" class="form-control" placeholder="Enter your firstname...">
                </div>
                <div class="form-group">
                    <input name="lastname" type="text" class="form-control" placeholder="Enter your lastname...">
                </div>
                <button type="submit" class="btn btn-primary btn-block">Update</button>
            </form>
            <hr>
            <form method="GET" action="./home">
                <button type="submit" class="btn btn-success btn-block">Exit</button>
            </form>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
</body>
</html>

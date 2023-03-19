<%@ page isELIgnored = "false" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
    />
    <title>Login Page</title>
  </head>
  <body>
    <div class="container" style="width: 30%; margin: auto; margin-top: 5%;">
      <p id="message" style="color:red;">${MESSAGE}</p>
      <div class="card" style="width: 18rem">
        <h3 class="card-title bg-secondary text-center p-1">Please SignIn</h3>
        <div class="card-body">
            <form action="<%=request.getContextPath()%>/login" onsubmit="return validateDataForm()" method="post">
            <div class="mb-3">
                <input type="text" class="form-control" id="email" name="email" placeholder="E-mail" >
            </div>
            <div class="mb-3">
                <input type="password" class="form-control" id="password" name="password" placeholder="Password">
            </div>
            <div class="mb-3 form-check">
                <input type="checkbox" class="form-check-input" id="remember" name="rememeber">
                <label class="form-check-label" for="rememeber">Remember me</label>
            </div>
            <div class="mb-3">
                <button type="submit" value="Login" class="btn btn-success" style="width: 100%; margin: 0 auto;">Login</button>
            </div>
            <a href="<%=request.getContextPath()%>/register">Click here to Register</a>
            </form>
        </div>
      </div>
    </div>
  </body>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
  <script src="<%=request.getContextPath()%>/js/login.js"></script>
</html>

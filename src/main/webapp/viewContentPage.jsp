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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css">
    <link rel="stylesheet" href="/css/edit.css">
    <title>Login Page</title>
  </head>
  <body>
    <div class="container" style="margin-top: 5%;">
        <div class="card">
          <!-- menu tren -->
            <div class="card-title" style="margin-bottom: 0; border-bottom: 1px solid rgb(239, 221, 221); padding-bottom: 5px;">
                <span class="float-start">CMS</span>
                <div class="dropdown float-end">
                    <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
                      <i class="fa fa-user-o" aria-hidden="true"></i>
                    </button>
                    <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
                      <li><a class="dropdown-item" href="#">
                        <span>
                          <i class="fa fa-user-o" aria-hidden="true"></i>
                        </span>
                        <span>User Profile</span>
                      </a></li>
                      <li><a class="dropdown-item" href="#">
                        <span>
                          <i class="fa fa-sign-out" aria-hidden="true"></i>
                        </span>
                        <span>Logout</span>
                      </a></li>
                    </ul>
                </div>
            </div>

           <!-- Body -->
            <div class="card-body pl-0 " style="padding: 0;">
              <!-- left: menu -->
              <div class="card" id="menu-left" style="width: 20%; height: 100%;float: left; padding: 0;">
                <div class="card-title">
                    <div class="input-group">
                      <input type="search" class="form-control rounded" placeholder="Search" aria-label="Search" aria-describedby="search-addon" />
                      <button type="button" class="btn btn-outline-primary">
                        <i class="fa fa-search" aria-hidden="true"></i>
                      </button>
                    </div>
                </div>
                <div class="card-body">
                    <div class="body-content">
                      <span><i class="fa fa-id-card" aria-hidden="true"></i></span>
                      <span>View Contents</span>
                    </div>
                    <div class="body-content">
                      <span><i class="fa fa-pencil-square-o" aria-hidden="true"></i></span>
                      <span>Form Contents</span>
                    </div>
                </div>
              </div>
              <!-- right: form edit content -->
              <div class="card">
                <table class="table">
                    <thead>
                      <tr>
                        <th scope="col">#</th>
                        <th scope="col">Title</th>
                        <th scope="col">Brief</th>
                        <th scope="col">Content</th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr>
                        <th scope="row">1</th>
                        <td>Mark</td>
                        <td>Otto</td>
                        <td>@mdo</td>
                      </tr>
                      <tr>
                        <th scope="row">2</th>
                        <td>Jacob</td>
                        <td>Thornton</td>
                        <td>@fat</td>
                      </tr>
                      <tr>
                        <th scope="row">3</th>
                        <td colspan="2">Larry the Bird</td>
                        <td>@twitter</td>
                      </tr>
                    </tbody>
                  </table>
                  <div id="paging" class="d-flex justify-content-center">
                    <nav aria-label="Page navigation example">
                        <ul class="pagination">
                          <li class="page-item">
                            <a class="page-link" href="#" aria-label="Previous">
                              <span aria-hidden="true">&laquo;</span>
                            </a>
                          </li>
                          <li class="page-item"><a class="page-link" href="#">1</a></li>
                          <li class="page-item"><a class="page-link active" href="#">2</a></li>
                          <li class="page-item"><a class="page-link" href="#">3</a></li>
                          <li class="page-item">
                            <a class="page-link" href="#" aria-label="Next">
                              <span aria-hidden="true">&raquo;</span>
                            </a>
                          </li>
                        </ul>
                      </nav>
                  </div>
              </div>
            </div>
        </div>
    </div>
  </body>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</html>

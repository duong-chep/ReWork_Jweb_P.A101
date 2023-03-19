<div class="card">
    <div class="content" style="margin: 0 5%;">
      <h3 style="border-bottom: 1px solid rgb(211, 204, 204);padding:10px 0;">Add Content</h3>
      <div class="form-edit">
        <form style="width: 80%;">
          <div class="mb-3">
            <label for="title" class="form-label">Title</label>
            <input type="text" class="form-control" id="title" aria-describedby="emailHelp">
          </div>
          <div class="mb-3">
            <label for="brif" class="form-label">Brif</label>
            <textarea class="form-control" id="brif"></textarea>
          </div>
          <div class="mb-3">
            <label for="content" class="form-label">Content</label>
            <textarea class="form-control" id="content" style="height: 80px;"></textarea>
          </div>
         
          <button type="button" id="btn-edit" class="btn btn-primary">Edit Button</button>
          <button type="button" id="btn-reset" class="btn btn-primary">Reset Button</button>
        </form>
      </div>
    </div>
  </div>
  <script src="<%=request.getContextPath()%>/js/editForm.js"></script>
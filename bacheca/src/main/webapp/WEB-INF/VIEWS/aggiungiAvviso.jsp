<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<section>
    <div class="container">
    <h1 class="my-4">Pubblica Avviso</h1>
    <form action="Prova" method="post" enctype="multipart/form-data">
      <div class="mb-3">
        <label for="postTitle" class="form-label">Titolo</label>
        <input type="text" class="form-control" id="titolo" name="titolo" placeholder="Enter post title">
      </div>
      <div class="mb-3">
        <label for="postContent" class="form-label">Testo</label>
        <textarea class="form-control" id="testo" name="testo" rows="8" placeholder="Enter post content"></textarea>
      </div>
      <div class="mb-3">
        <label for="postCategory" class="form-label">Livello Importanza</label>
        <select class="form-select" id="livello" name="livello">
          <option selected disabled>Scegliere livello</option>
          <option value="1">1</option>
          <option value="2">2</option>
          <option value="3">3</option>
          <option value="4">4</option>
          <option value="5">5</option>
        </select>
      </div>
      <div class="mb-3">
        <label for="postDate" class="form-label">Data Scadenza</label>
        <input type="date" class="form-control" id="datascad" name="datascad">
      </div>
		<div class="mb-3">
		  <label for="formFileMultiple" class="form-label">Scegli file da inserire</label>
		  <input class="form-control" 
		  type="file" 
		  id="file"
		  name="file" 
		  accept="video/*, image/*">
		</div>
      <button type="submit"  class="btn btn-primary">Pubblica</button>
    </form>
  </div>
</section>
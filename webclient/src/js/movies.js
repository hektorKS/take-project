let movies;

$(searchMovies);
$("#searchMovies").unbind("click").click(searchMovies);


function searchMovies() {
  const type = $("#type :selected").text();
  if (type !== "dowolny") {
    httpGetAsync(GET_MOVIES_URL + "?type=" + type, processMovies);
  } else {
    httpGetAsync(GET_MOVIES_URL, processMovies);
  }
}

function processMovies(moviesString) {
  movies = JSON.parse(moviesString).movies;
  $(".movies").empty();
  movies.forEach(element => {
    createNewMovieNode(element);
  });
}

function createNewMovieNode(movie) {
  $(".movies").append(
      `<div class="movie">
        <p>
          <div class="cart-icon" onclick="addItemToCart(event)">
            <i class="fas fa-shopping-cart"></i>
          </div>
          <span class="movie-title">` + movie.title + `</span>
          (<span class="movie-year">` + movie.year + `</span>)
          reż. <span class="movie-director">` + movie.director + `</span>
          <a href="details.html?movieId=` + movie.id + `">Szczegóły</a>
        </p>
        <p>Cena: <span class="movie-price">` + movie.price + `</span> PLN</p>
      </div>`
  );
  $(".movies .movie:last-of-type .cart-icon").data("movieId", movie.id);
  $(".movies .movie:last-of-type .fa-shopping-cart").data("movieId", movie.id);
}
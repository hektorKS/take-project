$(displayDetails);

function displayDetails() {
  const urlParams = new URLSearchParams(window.location.search);
  const movieId = urlParams.get("movieId");
  $(".details .cart-icon").data("movieId", movieId);
  $(".details .fa-shopping-cart").data("movieId", movieId);
  getMovieById(movieId);
}

function addItemToCartWithRedirect(event) {
  document.location.href = "index.html";
  addItemToCart(event);
}

function getMovieById(movieId) {
  httpGetAsync(GET_MOVIE_BY_ID_URL + movieId, processDetails);
}

function processDetails(movieString) {
  const movie = JSON.parse(movieString);
  $(".details .cart-icon").after("<h1>" + movie.title + "</h1>");
  $(".details-year").append("<span>" + movie.year + "</span>");
  $(".details-category").append("<span>" + movie.movieCategory + "</span>");
  $(".details-cast").append("<span>" + movie.cast + "</span>");
  $(".details-director").append("<span>" + movie.director + "</span>");
  $(".details-story").append("<span>" + movie.story + "</span>");
  $(".details-price").append("<span>" + movie.price + " PLN</span>");
}

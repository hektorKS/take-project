$(refreshCart);

function addItemToCart(event) {
  const data = $(event.target).data();
  httpPostAsync(ADD_CART_ITEM, {"movieId": data.movieId}, refreshCart);
  return false;
}

function refreshCart() {
  httpGetAsync(GET_CART, showCart);
}

function removeItem(event) {
  const data = $(event.target).data();
  httpDeleteAsync(REMOVE_CART_ITEM, {"movieId": data.movieId}, refreshCart);
}

function showCart(stringResponse) {
  resetCart();
  let cartDetails = JSON.parse(stringResponse);
  let movies = cartDetails.movies;
  movies.forEach(function (movie, index) {
    $(".cart-elements").append(
      `<tr class="cart-element">
          <td>` + (index + 1) + `</td>
          <td>` + movie.title + `</td>
          <td>` + movie.price + `</td>
          <td>
            <input onclick="removeItem(event)" type="button" value="Usuń">
          </td>
      </tr>`
    );
    $(".cart-elements tr:last-of-type td input").data("movieId", movie.id);
  });
  $("#cart-sum-pl").text(cartDetails.sumPln);
  $("#cart-sum-eur").text(cartDetails.sumEur);
}

function resetCart() {
  $(".cart-elements").empty();
  $("#cart-sum-pl").text("0");
  $("#cart-sum-eur").text("0");
}

function acceptCart() {
  httpDeleteAsync(REMOVE_CART, {}, resetCart);
}
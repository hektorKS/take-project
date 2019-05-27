// GLOBALS
const BACKEND_URL = "/api";
const GET_MOVIES_URL = BACKEND_URL + "/v1/movies";
const GET_MOVIE_BY_ID_URL = BACKEND_URL + "/v1/movie/";

const cartId = localStorage["cartId"] || uuid();
localStorage["cartId"] = cartId;

const ADD_CART_ITEM = BACKEND_URL + "/v1/cart/" + cartId + "/item";
const REMOVE_CART_ITEM = BACKEND_URL + "/v1/cart/" + cartId + "/item";
const GET_CART = BACKEND_URL + "/v1/cart/" + cartId + "?details=true";
const REMOVE_CART = BACKEND_URL + "/v1/cart/" + cartId;


// HTTP
function httpGetAsync(theUrl, callback) {
  const xmlHttp = new XMLHttpRequest();
  xmlHttp.onreadystatechange = function () {
    if (xmlHttp.readyState === 4) {
      if (xmlHttp.status >= 200 && xmlHttp.status <= 299) {
        callback(xmlHttp.responseText);
      }
    }
  };
  xmlHttp.open("GET", theUrl, true);
  xmlHttp.send(null);
}

function httpDeleteAsync(theUrl, data, callback) {
  const xmlHttp = new XMLHttpRequest();
  xmlHttp.onreadystatechange = function () {
    if (xmlHttp.readyState === 4) {
      if (xmlHttp.status >= 200 && xmlHttp.status <= 299) {
        callback(xmlHttp.responseText);
      }
    }
  };
  xmlHttp.open("DELETE", theUrl, true);
  xmlHttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
  xmlHttp.send(JSON.stringify(data));
}

function httpPostAsync(theUrl, data, callback) {
  const xmlHttp = new XMLHttpRequest();
  xmlHttp.onreadystatechange = function () {
    if (xmlHttp.readyState === 4) {
      if (xmlHttp.status >= 200 && xmlHttp.status <= 299) {
        callback(xmlHttp.responseText);
      }
    }
  };
  xmlHttp.open("POST", theUrl, true);
  xmlHttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
  xmlHttp.send(JSON.stringify(data));
}

// UUID GENERATING
function uuid() {
  let dt = new Date().getTime();
  return "xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx".replace(/[xy]/g, function (c) {
    const r = (dt + Math.random() * 16) % 16 | 0;
    dt = Math.floor(dt / 16);
    return (c === "x" ? r : (r & 0x3 | 0x8)).toString(16);
  });
}
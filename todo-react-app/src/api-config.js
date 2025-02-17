let backendHost;
const hostname = window && window.location && window.location.hostname;
console.log(window);
console.log(window.location);
console.log(window.location.hostname);
if (hostname == "localhost") {
  backendHost = "http://localhost:8080";
}
export const API_BASE_URL = `${backendHost}`;

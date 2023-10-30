let socket = new WebSocket("ws://localhost:8080/connect", ["jsh-protocol-3", "jsh-protocol-2"]);

socket.addEventListener('open', function (event) {
  console.log("Subprotocol in use: " + socket.protocol);
});

socket.addEventListener('error', function (event) {
  console.error("WebSocket error observed:", event);
});

function send() {
    console.log("test");
}
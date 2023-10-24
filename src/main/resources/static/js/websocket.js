let socket;

window.addEventListener('DOMContentLoaded', function() {
	connectWebsocket();
});

function connectWebsocket() {
    socket = new WebSocket("ws://localhost:8080/connect");
    console.log(socket);
}
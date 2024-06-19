// src/websocket.js
let ws;

export function connectWebSocket(onMessageCallback) {
    ws = new WebSocket("ws://localhost:8081/ws");

    ws.onopen = function() {
        console.log("Connected to WebSocket server.");
    };

    ws.onmessage = function(event) {
        console.log("Received message: ", event.data);
        if (onMessageCallback) {
            onMessageCallback(event.data);
        }
    };

    ws.onerror = function(event) {
        console.error("WebSocket error: ", event);
    };

    ws.onclose = function(event) {
        console.log("WebSocket closed: ", event);
    };
}

export function sendMessage(message) {
    if (ws && ws.readyState === WebSocket.OPEN) {
        ws.send(JSON.stringify(message));
    } else {
        console.error("WebSocket is not connected.");
    }
}



export default{
    connectWebSocket,
    sendMessage
}


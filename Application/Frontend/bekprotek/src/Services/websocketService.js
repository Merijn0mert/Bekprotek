/*
function connect() {

    const ws = new WebSocket('ws://localhost:8081/name');
    ws.onmessage = function(data){
        showGreeting(data.data);
    }
    setConnected(true);
}

function disconnect() {
    if (ws != null) {
        ws.close();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendName() {
    ws.send($("#name").val());
}

function showGreeting(message) {
    $("#greetings").append(" " + message + "");
}

export default{
    connect,
    disconnect,
    sendName,
    showGreeting

}
*/
let ws, currentUser;

// On pressing Connect this method will be called
function connect() {

    ws = new WebSocket("ws://localhost:8081/ws");

    //This function will called everytime new message arrives
    ws.onmessage = function (e) {
        console.log(e);
        printMessage(e.data);
    };
    document.getElementById("connectButton").disabled = true;
    document.getElementById("connectButton").value = "Connected";
    document.getElementById("name").disabled = true;
    currentUser = document.getElementById("name").value;
    console.log(currentUser);
}

//This function takes care of printing the message on browser
function printMessage(data) {
    let messages = document.getElementById("messages");
    let messageData = JSON.parse(data);
    let newMessage = document.createElement("div");
    newMessage.className = "incoming-message";
    newMessage.innerHTML = messageData.name + " : " + messageData.message;
    messages.appendChild(newMessage);
}

//This function handles functionality of sending the message to websocket
// This function handles functionality of sending the message to WebSocket
function sendToGroupChat() {
    if (ws == undefined || ws.readyState !== WebSocket.OPEN) {
        console.error("WebSocket is not connected.");
        return;
    }
    let messageText = document.getElementById("message").value;
    if (!messageText) {
        console.error("Message text is empty.");
        return;
    }
    document.getElementById("message").value = "";
    let name = document.getElementById("name").value;
    let messageObject = {
        name: name,
        message: messageText,
    };

    // Log het verzonden bericht
    console.log("Sending message: ", messageObject);

    let newMessage = document.createElement("div");
    newMessage.innerHTML = currentUser + messageText;
    newMessage.className = "outgoing-message";
    document.getElementById("messages").appendChild(newMessage);

    // Stuur het bericht naar de WebSocket-server
    ws.send(JSON.stringify(messageObject));
}


export default{
    connect,
    sendToGroupChat,
    printMessage,

}


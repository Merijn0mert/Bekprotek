package com.bekprotek.bekprotek.controllers;

import io.micrometer.common.lang.NonNull;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.PingMessage;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import com.google.gson.Gson;
import java.util.Map;

import java.nio.ByteBuffer;
import java.util.HashSet;

@Controller
public class WebSocketController extends TextWebSocketHandler {

    static HashSet<WebSocketSession> sessions = new HashSet<>();
    private Gson gson = new Gson();

    @Override
    public void handleTextMessage(@NonNull WebSocketSession session, @NonNull TextMessage message) throws Exception {
        super.handleTextMessage(session, message);
        String payload = message.getPayload();
        System.out.println("Received message: " + payload);
    }

    @Override
    public void afterConnectionEstablished(@NonNull WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);
        sessions.add(session);
    }

    @Override
    public void afterConnectionClosed(@NonNull WebSocketSession session,@NonNull CloseStatus status) throws Exception {
        sessions.remove(session);
        super.afterConnectionClosed(session, status);
    }

    public void notifyProductChange() {
        for (WebSocketSession session : sessions) {
            try {
                session.sendMessage(new TextMessage("Product changed"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
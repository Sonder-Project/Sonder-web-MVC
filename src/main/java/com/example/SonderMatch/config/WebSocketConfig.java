package com.example.SonderMatch.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

  /*
   * Register a websocket endpoint that the clients will use to connect to websocket server.
   */

  @Override
  public void registerStompEndpoints(StompEndpointRegistry registry){
    registry.addEndpoint("/ws").withSockJS();
  }


  /*
   * Configure a message broker that will be used to route message from one client to another.
   * All messages sent from client with a destination starting with /app will be routed to these
   * message handling methods annotated with @MessageMapping, i.e. a message with destination
   * /app/chat.sendMessage will be routed to the sendMessage() method
   */

  @Override
  public void configureMessageBroker(MessageBrokerRegistry registry){
    // message whose destination starts with /app should be routed to message-handling methods
    registry.setApplicationDestinationPrefixes("/app");
    // messages whose destination starts with '/topic' should be routed to the message broker
    registry.enableSimpleBroker(("/topic"));
  }


}

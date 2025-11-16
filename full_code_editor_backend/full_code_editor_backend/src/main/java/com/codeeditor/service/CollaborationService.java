//package com.codeeditor.service;
//
//import org.springframework.stereotype.Service;
//
//import java.util.Map;
//import java.util.UUID;
//import java.util.concurrent.ConcurrentHashMap;
//
//@Service
//public class CollaborationService {
//
// private final Map<String, String> documents = new ConcurrentHashMap<>();
//
// public String createRoom() {
//  String id = UUID.randomUUID().toString();
//  documents.put(id, "");
//  return id;
// }
//
// public void updateDocument(String roomId, String content) {
//  documents.put(roomId, content);
// }
//
// public String getDocument(String roomId) {
//  return documents.getOrDefault(roomId, "");
// }
//
// public boolean roomExists(String id) {
//  return documents.containsKey(id);
// }
//}

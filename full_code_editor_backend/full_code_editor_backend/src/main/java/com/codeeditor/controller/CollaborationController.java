//package com.codeeditor.controller;
//
//import com.codeeditor.dto.CodeUpdateRequest;
//import com.codeeditor.service.CollaborationService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.tags.Tag;
//
//@RestController
//@RequestMapping("/api/collab")
//@RequiredArgsConstructor
//@Tag(name = "Collaboration", description = "Document collaboration endpoints")
//public class CollaborationController {
//
//    private final CollaborationService service;
//
//    @PostMapping("/room")
//    @Operation(summary = "Create collaboration room", description = "Creates a new collaboration room and returns its ID")
//    public ResponseEntity<String> create() {
//        return ResponseEntity.ok(service.createRoom());
//    }
//
//    @PostMapping("/update")
//    @Operation(summary = "Update document", description = "Update the document content for a given room")
//    public ResponseEntity<String> update(@RequestBody CodeUpdateRequest r) {
//        if (!service.roomExists(r.getRoomId())) {
//            return ResponseEntity.badRequest().body("room missing");
//        }
//        service.updateDocument(r.getRoomId(), r.getContent());
//        return ResponseEntity.ok("Updated");
//    }
//
//    @GetMapping("/{roomId}")
//    @Operation(summary = "Get document", description = "Retrieve the current document content for the given room")
//    public ResponseEntity<String> get(@PathVariable String roomId) {
//        if (!service.roomExists(roomId)) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(service.getDocument(roomId));
//    }
//}

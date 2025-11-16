Real-time Collaborative Code Editor

1. Project Overview
   A web-based code editor where multiple users can edit code together in real-time with AI-powered code suggestions.

Key Features:

Multiple users editing simultaneously

AI code completion

Room-based collaboration

Real-time synchronization

Modern, responsive UI

Tech Stack:

Frontend: Angular 17 + CodeMirror 6 + WebSockets

Backend: Java, Spring Boot + WebSockets + REST APIs

AI: Google Gemini API

2. Quick Setup Guide

Backend (Spring Boot)
bash
cd backend

Configure API key in application.properties
gemini.api.key=your_actual_gemini_key

# Run backend
mvn spring-boot:run
Backend runs on: http://localhost:8080

Frontend (Angular)
bash
cd frontend
# Install dependencies
npm install

# Start development server
ng serve
Frontend runs on: http://localhost:4200

Get Gemini API Key
Visit: https://aistudio.google.com/

Create API key

Add to backend/src/main/resources/application.properties

3. Architecture Overview

System Flow

text
User Types → Angular → WebSocket → Spring Boot → Broadcast → All Users
↓
Ctrl+Space → REST API → Gemini AI → Suggestions → CodeMirror

Component Structure
Frontend:

RoomSelectorComponent - Join/create rooms

CodeEditorComponent - Code editing with real-time sync

WebsocketService - WebSocket communication

CodeCompletionService - AI completion requests

Backend:

EditorController - WebSocket message handling

CodeCompletionController - REST API for AI

GeminiService - Gemini API integration

API Endpoints
WebSocket:

Connect: /ws

Send: /app/editor.update, /app/editor.cursor

Receive: /topic/editor, /topic/cursors

REST API:

POST /api/complete - Get AI suggestions

GET /api/health - Health check

4. How It Works
   Real-Time Collaboration
   User joins a room using a unique ID

Typing triggers WebSocket updates

Backend broadcasts changes

All participants receive updates immediately

AI Code Completion
User presses Ctrl + Space

Angular sends request to backend

Backend calls Gemini with:
Provide 3–5 code completion suggestions.
Return only the completion text.
Gemini returns suggestions

CodeMirror displays them
Data Models
Editor Message:

typescript
{
roomId: string;
content: string;
userId: string;
cursorPosition: number;
type: 'CONTENT_UPDATE' | 'CURSOR_UPDATE';
}

AI Request:

typescript
{
code: string;
cursorPosition: number;
language: string;
}

5. Testing the Application

Test Collaboration
Open two browser windows to http://localhost:4200

Join same room in both windows

Type code in one window - see it appear in other

Verify real-time sync works instantly

Test AI Completion
Type in editor:

javascript
function test() {
console.  // Place cursor here
}
Press Ctrl+Space

Should see suggestions: log, warn, error, etc.

Test API Endpoints
bash
# Health check
curl http://localhost:8080/api/health

# Test AI completion
curl -X POST http://localhost:8080/api/complete \
-H "Content-Type: application/json" \
-d '{"code":"function test(){}", "cursorPosition": 10, "language":"javascript"}'

6. Current Limitations & Future Plans

   Current Limitations & Future Enhancements
   Current Limitations
   Entire document sync (no granular OT diffing yet)

No authentication

Only JavaScript optimized

No database persistence

Planned Improvements
Operational transform or CRDT-based syncing

Multi-language support

File saving & history

User authentication

Team workspaces

Built-in chat

Code execution sandbox



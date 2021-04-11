package com.doongji.nestalk.controller.v1.chat;

import com.doongji.nestalk.controller.v1.chat.dto.RoomDto;
import com.doongji.nestalk.security.JwtAuthentication;
import com.doongji.nestalk.service.chat.ChatService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "채팅방 조회 APIs")
@RequiredArgsConstructor
@RestController
public class ChattingRoomController {

    private final ChatService chatService;

    @ApiOperation(value = "내가 참여중인 모든 채팅방 조회")
    @GetMapping("/api/chat/lookup")
    public ResponseEntity<List<RoomDto>> lookupMyChattingRoom(
            @AuthenticationPrincipal JwtAuthentication jwt
    ) {
        return ResponseEntity.ok(
            chatService.lookupMyChattingRoom(jwt.userId)
        );
    }
}

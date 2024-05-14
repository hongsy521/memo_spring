package com.sparta.memo_spring.controller;

import com.sparta.memo_spring.dto.MemoRequestDto;
import com.sparta.memo_spring.dto.MemoResponseDto;
import com.sparta.memo_spring.entity.Memo;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class MemoController {

    private final Map<Long, Memo> memoList = new HashMap<>();

    // 메모 생성
    @PostMapping("/memos")
    public MemoResponseDto createMemo(@RequestBody MemoRequestDto requestDto) {
        // RequestDto -> Entity // 데이터베이스와 연결하기 위해 entity로 변경
        Memo memo = new Memo(requestDto);

        // Memo max id 찾아야함
        Long maxId = memoList.size() > 0 ? Collections.max(memoList.keySet())+1 : 1;
        memo.setId(maxId);

        // DB 저장
        memoList.put(memo.getId(), memo);

        // Entity -> ResponseDto
        MemoResponseDto responseDto = new MemoResponseDto(memo);

        return responseDto;

    }

    // 메모 조회
    @GetMapping("/memos")
    public List<MemoResponseDto> getAllMemos() {
        // Map to List
        List<MemoResponseDto> responseList = memoList.values().stream()
                .map(MemoResponseDto::new).toList();

        return responseList;
    }

    // 메모 변경
    @PutMapping("/memos/{id}")
    public Long editMemo(@PathVariable int id){
        return null;
    }

    // 메모 삭제
    @DeleteMapping("/memos/{id}")
    public Long deleteMemo(@PathVariable int id){
        return null;
    }
}

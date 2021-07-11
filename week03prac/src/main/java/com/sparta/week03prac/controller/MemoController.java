package com.sparta.week03prac.controller;

import com.sparta.week03prac.domain.Memo;
import com.sparta.week03prac.domain.MemoRepository;
import com.sparta.week03prac.domain.MemoRequestDto;
import com.sparta.week03prac.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MemoController {
    private final MemoRepository memoRepository;
    private final MemoService memoService;

    @GetMapping("/api/memos")
    public List<Memo> readMemos(){
        return memoRepository.findAllByOrderByModifiedAtDesc();
    }

    @PostMapping("/api/memos")
    public Memo createMemo(@RequestBody MemoRequestDto requestDto){
        Memo memo = new Memo(requestDto);
        return memoRepository.save(memo);
    }
    @PutMapping("api/memos/{id}")
    public Long updateMemo(@PathVariable Long id,@RequestBody MemoRequestDto requestDto){
        memoService.update(id,requestDto);
        return id;
    }

    @DeleteMapping("/api/memos/{id}")
    public Long deleteMemo(@PathVariable Long id){
        memoRepository.deleteById(id);
        return id;
    }
}

package com.sparta.week03.controller;

import com.sparta.week03.domain.Memo;
import com.sparta.week03.domain.MemoRepository;
import com.sparta.week03.domain.MemoRequestDto;
import com.sparta.week03.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class MemoController {
    private final MemoRepository memoRepository;    //create,read,delete를 위해서 필요함
    private final MemoService service; //업데이트를 위해서 필요함

    @GetMapping("/api/memos")
    public List<Memo> readMemos(){
        LocalDateTime startDatetime = LocalDateTime.now().minusDays(1);
        LocalDateTime endDatetime = LocalDateTime.now();
        return memoRepository.findAllByModifiedAtBetweenOrderByModifiedAtDesc(startDatetime, endDatetime);
    }

    @PostMapping("/api/memos")
    public Memo createMemo(@RequestBody MemoRequestDto requestDto){
        Memo memo = new Memo(requestDto);   //생성자를 미리 만들어놔서 사용가능
        return memoRepository.save(memo);
    }
    @PutMapping("/api/memos/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto){
        service.update(id, requestDto);
        return id;
    }
    @DeleteMapping("/api/memos/{id}")
    public  Long deleteMemo(@PathVariable Long id){
        memoRepository.deleteById(id);
        return id;
    }
}

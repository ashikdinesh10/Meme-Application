package com.crio.starter.controller;

import com.crio.starter.data.MemeEntity;
import com.crio.starter.exchange.MemeDto;
import com.crio.starter.exchange.ResponseDto;
import com.crio.starter.service.MemeService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemeController {


  @Autowired
  private MemeService memeService;

  @GetMapping("/memes")
  public List<MemeEntity> getResponse() {
    return memeService.getMemes();
  }

  /**
   * Returns meme by Id.
   * 
   * @return
   */
  @GetMapping("/memes/{id}")
  public ResponseEntity<MemeEntity> getResponsebyId(@PathVariable(name = "id") Long id) {
    if (memeService.isExist(id)) {
      return ResponseEntity.ok().body(memeService.getMemeById(id));
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  /**
   * Posts a meme.
   * 
   * @return
   */
  @PostMapping("/memes")
  public ResponseEntity<ResponseDto> savepost(@RequestBody MemeDto memeDto) {
    if (memeDto.getName() != null && memeDto.getUrl() != null && memeDto.getCaption() != null) {
      if (!(memeService.isExist(memeDto))) {
        long id = (memeService.saveMeme(memeDto));
        ResponseDto responseDto = new ResponseDto(String.valueOf(id));
        return new ResponseEntity<ResponseDto>(responseDto,HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.CONFLICT);
      }
    }
    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
  }
}
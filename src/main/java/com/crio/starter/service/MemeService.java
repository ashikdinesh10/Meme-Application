package com.crio.starter.service;

import com.crio.starter.data.MemeEntity;
import com.crio.starter.exchange.MemeDto;
import com.crio.starter.repository.MemeRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class MemeService {
  
  @Autowired
  private MemeRepository memeRepository;

  public static long id = 0;
  
  /**
   * Returns all memes.
   * @return
   */
  public List<MemeEntity> getMemes() {

    List<MemeEntity> memeEntities = memeRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    List<MemeEntity> memes = new ArrayList<MemeEntity>();
    int counter = 100;
    for (MemeEntity memeEntity : memeEntities) {
      if (counter == 0) {
        break;
      }
      memes.add(memeEntity);
      counter--;
    }
    return memes;
  }

  public MemeEntity getMemeById(long id) {
    MemeEntity meme = memeRepository.findById(id);
    return meme;
  }

  /**
   * saves meme to the database.
   * 
   * @return
   */
  public long saveMeme(MemeDto memeDto) {
    id++;
    MemeEntity memeEntity = new MemeEntity(
          id,
          memeDto.getName(),
          memeDto.getUrl(),
          memeDto.getCaption()
      );
    memeRepository.save(memeEntity);
    return  id;
  }

  /**
   * checks if a duplicate meme exists.
   * 
   * @return
   */
  public boolean isExist(MemeDto memeDto) {
    List<MemeEntity> memeEntities = memeRepository.findAll();
    for (MemeEntity memeEntity : memeEntities) {
      if (!((memeEntity != null) && (memeEntity.getName() == null 
          &&  memeEntity.getCaption() == null && memeEntity.getUrl() == null))) {
        if (memeEntity.getName().equals(memeDto.getName())
            && memeEntity.getUrl().equals(memeDto.getUrl())
            && memeEntity.getCaption().equals(memeDto.getCaption())) {
          return true;
        }
      }       
    }
    return false;
  }

  /**
   * checks if a meme exists for an ID.
   * 
   * @return
   */
  public boolean isExist(long id) {
    List<MemeEntity> memeEntities = memeRepository.findAll();
    for (MemeEntity memeEntity : memeEntities) {
      if (memeEntity.getId() == id) {
        return true;
      }
    }
    return false;
  } 
}
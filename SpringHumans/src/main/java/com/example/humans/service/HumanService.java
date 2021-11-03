package com.example.humans.service;

import java.util.List;

import com.example.humans.domain.Human;

public interface HumanService {

	Human createHuman(Human newHuman);

	List<Human> getHumans();

	Human getHuman(Integer id);

	Human replaceHuman(Integer id, Human newHuman);

	boolean removeHuman(Integer id);

}

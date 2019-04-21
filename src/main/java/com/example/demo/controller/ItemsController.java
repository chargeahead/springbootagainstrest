package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.Items;
import com.example.demo.service.ItemsService;

@Controller
@ResponseBody
@RequestMapping("/api")
public class ItemsController {
	@Autowired
	ItemsService its;
	
    //Get all items
	@GetMapping(value= {"/items"})
	public List<Items> getAll(){
		List<Items> items = its.getAll();
		System.out.println(items.size());
        return items;
	}
	
	//Get an item
	@GetMapping("/items/{id}")
	public Items get(@PathVariable("id") Integer id){
		Optional<Items> i = its.get(id);
		return i.get();
	}
	
	//Insert an item
	@PostMapping("/items")
	public Items add(@RequestBody Items item){
		return its.update(item);
	}
	
	//Insert an item
	@PutMapping("/items")
	public Items edit(@RequestBody Items item){
		return its.update(item);
	}
	//delete an item
	@DeleteMapping("/items")
	public String delete(@RequestParam(value="id") Integer id){	
		Optional<Items> i = its.get(id);
		its.delete(i.get());
		return "Item id "+id+" deleted successfully";
	}
}

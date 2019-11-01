package com.example.demo.resources;

import com.example.demo.data.UserData;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by alma on 2019/11/1.
 */
@RestController
@RequestMapping("/user")
public class User {
  private static Map<Integer,UserData> userDataMap = new ConcurrentHashMap<>();
  @PostMapping("/add")
  public boolean addUser(@RequestBody UserData user) {
    boolean r = false;
    if (!userDataMap.containsKey(user.getId())){
      userDataMap.put(user.getId(),user);
      r = true;
    }
    return r;
  }
  @GetMapping("/find/{id}")
  @ApiOperation(notes = "測試用", value = "get user", nickname = "findById",
          tags = {"user"} )
  public UserData findById(@PathVariable("id") int id) {
    UserData r = null;
    System.out.print(id);
    if (userDataMap.containsKey(id)){
      r = userDataMap.get(id);
    }
    return r;
  }
  @PutMapping("/update")
  public boolean update(@RequestBody UserData user) {
    return true;
  }
  @DeleteMapping("/delete/{id}")
  public boolean delete(@PathVariable("id") int id) {
    boolean r = false;
    if (userDataMap.containsKey(id)){
      userDataMap.remove(id);
      r=true;
    }
    return r;
  }
}

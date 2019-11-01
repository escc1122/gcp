package com.example.demo.resources;

import com.example.demo.data.UserData;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * Created by alma on 2019/11/1.
 */
@RestController
@RequestMapping("/user")
public class User {
  @PostMapping("/add")
  public boolean addUser(@RequestBody UserData user) {
    return false;
  }
  @GetMapping("/find/{id}")
  @ApiOperation(notes = "測試用", value = "get user", nickname = "findById",
          tags = {"user"} )
  public UserData findById(@PathVariable("id") int id) {
    System.out.print(id);
    UserData r = new UserData();
    r.setId(id);
    r.setName("test");
    return r;
  }
  @PutMapping("/update")
  public boolean update(@RequestBody UserData user) {
    return true;
  }
  @DeleteMapping("/delete/{id}")
  public boolean delete(@PathVariable("id") int id) {
    return true;
  }
}

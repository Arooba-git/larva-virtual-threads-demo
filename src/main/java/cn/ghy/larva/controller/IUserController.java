package cn.ghy.larva.controller;

import cn.ghy.larva.domain.User;
import cn.ghy.larva.service.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ziyang
 */
@RestController
@RequestMapping(value = "/admin")
public class IUserController {
  private final IUserService iUserService;

  @Autowired
  public IUserController(IUserService iUserService) {
    this.iUserService = iUserService;
  }

  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public ResponseEntity<?> login(@RequestParam String userName, @RequestParam String password) {
    return new ResponseEntity<>(iUserService.login(userName, password), HttpStatus.OK);
  }


  @RequestMapping(value = "/register", method = RequestMethod.POST)
  public ResponseEntity<?> register(@Valid @RequestBody User user, BindingResult bindingResult) {
    ResponseEntity<?> response;
    if (bindingResult.hasErrors()) {
      response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
      System.out.println(bindingResult.getAllErrors());
    } else {
      if (iUserService.isEmailAvailable(user.getUserEmail())) {
        iUserService.register(user);
        response = new ResponseEntity<>(HttpStatus.CREATED);
      } else {
        response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
      }
    }
    return response;
  }

  @RequestMapping(value = "/register/is-email-available", method = RequestMethod.GET)
  public ResponseEntity<?> isEmailAvailable(@RequestParam String email) {
    return new ResponseEntity<>(iUserService.isEmailAvailable(email), HttpStatus.OK);
  }

  @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
  public ResponseEntity<?> selectById(@PathVariable Long id) {
    return new ResponseEntity<>(iUserService.selectById(id), HttpStatus.OK);
  }

  @RequestMapping(value = "/user", method = RequestMethod.GET)
  public ResponseEntity<?> selectAll() {
    System.out.println(Thread.currentThread().toString());
    return new ResponseEntity<>(iUserService.selectAll(), HttpStatus.OK);
  }

  @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
  public ResponseEntity<?> updateById(@RequestBody User user, @PathVariable String id) {
    return new ResponseEntity<>(iUserService.selectAll(), HttpStatus.OK);
  }
}

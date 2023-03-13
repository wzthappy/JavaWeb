package com.jax.impl;

import com.jax.service.HelloService;

public class HelloServiceImp implements HelloService {
  @Override
  public String sayHello(String name) {
    return name + ",service11111213111111111111111111";
  }
}

package com.rajuri

class Counter {
  private var value = 0 // you must initialize the field

  //methods are public by default
  def increment():Unit = {
    value+=1
  }
  def current()= value
}


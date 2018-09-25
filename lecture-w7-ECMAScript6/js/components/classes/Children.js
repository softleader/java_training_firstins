import Parent from "./Parent"

export default class Children extends Parent {

  static getZ() {
    return "z";
  }
}

// Work: 讓 getX = a, getY = b
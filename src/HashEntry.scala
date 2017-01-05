/**
  * Created by dccho on 1/4/2017.
  */
class HashEntry( key: Int, value: String) {

  private val _key : Int = key
  private val _value: String = value

  def getKey(): Int ={
    return _key
  }

  def getValue(): String = {
    return _value
  }

}

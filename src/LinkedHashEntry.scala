/**
  * Created by dccho on 1/9/2017.
  */
class LinkedHashEntry( key: Int, value: String)  {

  private val _key = key
  private var _value = value
  private var _next: LinkedHashEntry =  null

  def getKey(): Int = {
    _key
  }
  def getValue(): String = {
    _value
  }
  def setValue(strValue: String): Unit = {
    _value = strValue
  }
  def setNext(nextHashEntry: LinkedHashEntry): Unit ={
    _next = nextHashEntry
  }

  def getNext(): LinkedHashEntry = {
    _next
  }


}

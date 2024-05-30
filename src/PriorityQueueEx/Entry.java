//자료구조(6007) 과제 #9 (60211665 박진형)
package PriorityQueueEx;

public class Entry<Key extends Comparable<Key>, Value> { //compareTo()
    private Key ky;
    private Value val;
    public Entry (Key newKey, Value newValue) {
        ky = newKey;
        val = newValue;
    }
    public Key getKey() {return ky;}
    public Value getValue() {return val;}
    public void setKey(Key newKey) {ky = newKey;}
    public void setValue(Value newValue) {val = newValue;}
}

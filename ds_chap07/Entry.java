// 60200860 김민희 과제 #8
package ds_chap07;

public class Entry<Key extends Comparable<Key>, Value> {
	private Key ky;
	private Value val;
	public Entry (Key newKey, Value newValue) {
		ky = newKey;
		val = newValue;
	}
	
	public Key getKey() { return ky; }
	public Value getValue() { return val; }
	public void setKey(Key newKey) { ky = newKey; }
	public void setValue(Value newValue) { val = newValue; }
	
}

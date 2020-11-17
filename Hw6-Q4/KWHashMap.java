
public interface KWHashMap<K , V> {
	/**
	 * Returns the value associated with the specified key.
	 * Returns null if the key is not present.
	 * @param key The key being sought
	 * @return The value associated with this key if found;
	 * otherwise, null
	 */
	V get(Object key);
	
	/**
	 * Returns true if this table contains no key-value mappings.
	 * @return true if this table contains no key-value mappings;
	 * otherwise, false.
	 */
	boolean isEmpty();
	
	/**
	 * Associates the specified value with the specified key. Returns
	 * the previous value associated with the specified key, or null
	 * if there was no mapping for the key.
	 * @param key The key of item being inserted
	 * @param value The value for this key
	 * @return The old value associated with this key if
	 * found; otherwise, null
	 */
	V put (K key, V value);
	
	/**
	 * Removes the mapping for this key from this table if it is present
	 * (optional operation). Returns the previous value associated with
	 * the specified key, or null if there was no mapping.
	 * @param key The key being removed
	 * @return The previous value associated with
	 * the specified key, or null if there was no mapping.
	 */
	V remove(Object key);
	
	/**
	 * Returns the size of the table.
	 * @return size of the table.
	 */
	int size();
}

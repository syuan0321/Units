package com.syuan0321.unitseed.StrIntEnum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class StrIntEnumLookup<E extends Enum<E>> {
	Map<Integer, E> intMap;
	Map<String, E> strMap;
	Map<Integer, E> ordinalMap;
	E defaultVal;

	/**
	 * Creates a LookUp object for an <code>enum</code> which implements
	 * StrIntEnum interface
	 *
	 * @param e
	 *            class object of the enum
	 * @param defaultVal
	 *            default value to return when cannot resolve
	 * @param ignoreCase
	 *            will lookup by string be case insensitive
	 */
	public StrIntEnumLookup(Class<E> e, E defaultVal, boolean ignoreCase) {
		this.defaultVal = defaultVal;

		strMap = ignoreCase ? new TreeMap<String, E>(String.CASE_INSENSITIVE_ORDER) : new HashMap<String, E>();
		intMap = new HashMap<Integer, E>();
		ordinalMap = new HashMap<Integer, E>();

		for (E entry : e.getEnumConstants()) {
			// register to int and string maps
			if (entry instanceof IStrIntEnum) {
				IStrIntEnum _entry = (IStrIntEnum) entry;
				intMap.put(_entry.getInt(), entry);
				strMap.put(_entry.getString(), entry);
				ordinalMap.put(_entry.getOrdinal(), entry);
			}
			// register synonyms
			try {
				Synonym synonym = e.getField(entry.name()).getAnnotation(Synonym.class);
				if (synonym != null) {
					for (String syn : synonym.synonyms()) {
						strMap.put(syn, entry);
					}
				}
			} catch (NoSuchFieldException e1) {
				e1.printStackTrace();
			}
		}
	}

	public E fromString(String str) {
		return str != null && strMap.containsKey(str) ? strMap.get(str) : defaultVal;
	}

	public E fromInt(Integer i) {
		return intMap.containsKey(i) ? intMap.get(i) : defaultVal;
	}
	
	public E fromOrdinal(Integer o) {
		return ordinalMap.containsKey(o) ? ordinalMap.get(o) : defaultVal;
	}

	public String intToString(int i) {
		return ((IStrIntEnum)this.fromInt(i)).getString();
	}

	public List<String> describeAllNameLabelValue() {
		List<String> list = new ArrayList<>();
		intMap.values().forEach(entry -> {
			if (entry instanceof IStrIntEnum) {
				IStrIntEnum _entry = (IStrIntEnum) entry;
				list.add("{\"name\":\"" + ((E) _entry).name().toLowerCase() + "\", \"label\":\"" + _entry.getString()
						+ "\", \"value\":" + _entry.getInt() + "},");
			}
		});
		return list;
	}

	public E getDefault() {
		return defaultVal;
	}

	public Map<E, List<String>> allSynonyms() {
		Map<E, List<String>> map = new TreeMap<>();
		strMap.forEach((s, e) -> {
			if (!map.containsKey(e)) {
				map.put(e, new ArrayList<>());
			}
			map.get(e).add(s);
		});
		return map;
	}
}

package com.syuan0321.unitseed.StrIntEnum;

public class StrIntEnumExample {

	public enum ExmpLetterDigits implements IStrIntEnum {
		DEFAULT("unknown", 0), b("BBB", 2), c("CCC", 3), a("AAA", 1),;
		String name;
		int val;

		public static final StrIntEnumLookup<ExmpLetterDigits> lookup = new StrIntEnumLookup<ExmpLetterDigits>(
				ExmpLetterDigits.class, DEFAULT, true);

		ExmpLetterDigits(String name, int value) {
			this.name = name;
			this.val = value;
		}

		public String getString() {
			return this.name;
		}

		public String getName() {
			return this.name;
		}

		public int getOrdinal() {
			return ordinal();
		}

		public int getInt() {
			return this.val;
		}
		/*
		 * @Override public String toString() { return
		 * this.getClass().getTypeName() + "   " + this.getName() + " " +
		 * this.getString() + "  " + this.getInt(); }
		 */
	}

	public enum ExmpBikeType implements IStrIntEnum {
		DEFAULT(0, "unknown vehicle"),

		@Synonym(synonyms = { "Motorbike", "Motorcycles" }) MOTORCYCLE(1,
				"Motorcycle"), @Synonym(synonyms = { "All-Terrain Vehicle" }) ATV(2,
						"ATV"), @Synonym(synonyms = { "Sled", "Snowmachine", "Snowmobiles" }) SNOWMOBILE(3,
								"Snowmobile"), @Synonym(synonyms = { "Trailer", "Trailers" }) TRAILER(4,
										"Trailer (Motorcycle)"), @Synonym(synonyms = { "PersonalWatercraft",
												"Watercraft" }) PERSONAL_WATERCRAFT(
														5,
														"Personal Watercraft"), @Synonym(synonyms = { "Side Car",
																"SideCar", "Sidecars" }) SIDE_CAR(6,
																		"Side Car (Motorcycle)"),;

		public static final StrIntEnumLookup<ExmpBikeType> lookup = new StrIntEnumLookup<>(ExmpBikeType.class, DEFAULT,
				true);
		private final int val;
		private final String str;

		ExmpBikeType(int val, String str) {
			this.str = str;
			this.val = val;
		}

		public String getString() {
			return str;
		}

		public int getInt() {
			return val;
		}

		public int getOrdinal() {
			return ordinal();
		}
	}

	/**
	 * Main Class used to display
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(ExmpLetterDigits.lookup.fromString("AAA"));
		System.out.println(ExmpLetterDigits.lookup.fromInt(1));
		System.out.println(ExmpLetterDigits.lookup.fromOrdinal(3));

		System.out.println(ExmpBikeType.lookup.fromString("Personal Watercraft"));
		System.out.println(ExmpBikeType.lookup.fromString("Watercraft"));
	}
}

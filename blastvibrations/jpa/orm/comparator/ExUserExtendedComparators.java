package com.blastvibrations.jpa.orm.comparator;

import java.util.Comparator;

import com.blastvibrations.jpa.orm.ExUserExtended;

public enum ExUserExtendedComparators implements Comparator<ExUserExtended> {

	USERNAME {
		@Override
		public final int compare(final ExUserExtended o1,
				final ExUserExtended o2) {

			final String str1 = o1.getUsername() == null ? "" : o1
					.getUsername().toLowerCase();
			final String str2 = o2.getUsername() == null ? "" : o2
					.getUsername().toLowerCase();

			return str1.compareTo(str2);
		}
	},
	FULLNAME {
		@Override
		public final int compare(final ExUserExtended o1,
				final ExUserExtended o2) {

			final String str1 = o1.getFullName() == null ? "" : o1
					.getFullName().toLowerCase();
			final String str2 = o2.getFullName() == null ? "" : o2
					.getFullName().toLowerCase();

			return str1.compareTo(str2);
		}
	}
}

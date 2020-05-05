package com.blastvibrations.jpa.orm.comparator;

import java.util.Comparator;

import com.blastvibrations.jpa.orm.ExClientExtended;

public enum ExClientExtendedComparators implements Comparator<ExClientExtended> {

	NAME {
		@Override
		public final int compare(final ExClientExtended o1,
				final ExClientExtended o2) {

			final String str1 = o1.getName() == null ? "" : o1.getName()
					.toLowerCase();
			final String str2 = o2.getName() == null ? "" : o2.getName()
					.toLowerCase();

			return str1.compareTo(str2);
		}
	}
}

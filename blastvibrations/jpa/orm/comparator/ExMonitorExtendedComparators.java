package com.blastvibrations.jpa.orm.comparator;

import java.util.Comparator;

import com.blastvibrations.jpa.orm.ExMonitorExtended;

public enum ExMonitorExtendedComparators implements
Comparator<ExMonitorExtended> {

	CLIENT_NAME {
		@Override
		public final int compare(final ExMonitorExtended o1,
				final ExMonitorExtended o2) {

			final String str1 = o1.getClientName() == null ? "" : o1
					.getClientName().toLowerCase();
			final String str2 = o2.getClientName() == null ? "" : o2
					.getClientName().toLowerCase();

			return str1.compareTo(str2);
		}
	},
	UNIT_SERIAL_NUMBER {
		@Override
		public final int compare(final ExMonitorExtended o1,
				final ExMonitorExtended o2) {

			final String str1 = o1.getUnitSerialNumber() == null ? "" : o1
					.getUnitSerialNumber().toLowerCase();
			final String str2 = o2.getUnitSerialNumber() == null ? "" : o2
					.getUnitSerialNumber().toLowerCase();

			return str1.compareTo(str2);

		}
	};

}

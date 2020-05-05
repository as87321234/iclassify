package com.blastvibrations.jpa.orm.comparator;

import java.util.Comparator;

import com.blastvibrations.jpa.orm.ExBlastRequest;

public enum ExBlastRequestComparators implements Comparator<ExBlastRequest> {

	// CONTACT_NAME {
	// @Override
	// public final int compare(final ExBlastRequest o1,
	// final ExBlastRequest o2) {
	//
	// final String str1 = o1.getC() == null ? "" : o1
	// .getClientName().toLowerCase();
	// final String str2 = o2.getClientName() == null ? "" : o2
	// .getClientName().toLowerCase();
	//
	// return str1.compareTo(str2);
	// }
	// },

	CLIENT {
		@Override
		public final int compare(final ExBlastRequest o1,
				final ExBlastRequest o2) {

			final String str1 = o1.getClientName() == null ? "" : o1
					.getClientName().toLowerCase();
			final String str2 = o2.getClientName() == null ? "" : o2
					.getClientName().toLowerCase();

			return str1.compareTo(str2);

		}
	},
	// ADDRESS {
	// @Override
	// public final int compare(final ExBlastRequest o1,
	// final ExBlastRequest o2) {
	//
	// final String str1 = o1.getDescription() == null ? "" : o1
	// .getDescription().toLowerCase();
	// final String str2 = o2.getDescription() == null ? "" : o2
	// .getDescription().toLowerCase();
	//
	// return str1.compareTo(str2);
	//
	// }
	// },
	STATUS {
		@Override
		public final int compare(final ExBlastRequest o1,
				final ExBlastRequest o2) {

			final String str1 = o1.getStatus() == null ? "" : o1.getStatus()
					.toLowerCase();
			final String str2 = o2.getStatus() == null ? "" : o2.getStatus()
					.toLowerCase();

			return str1.compareTo(str2);

		}
	};

}

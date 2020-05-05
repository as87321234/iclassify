// @formatter:off
@org.hibernate.annotations.NamedQueries({

	@org.hibernate.annotations.NamedQuery(
			cacheable = false,
			readOnly = false,
			name  = CustomQueries.VIEW_CLIENTS_LIST,
			query = "select C " +
					", (select count(MM) from ExBlastMonitorMapping  MM, ExMonitor M  where  MM.clientId = C.clientId  and MM.monitorId = M.monitorId  ) as monitorCnt " +
					", (select count(UM) from ExClientUserMapping UM , ExUser U where  UM.clientId = C.clientId  and UM.userId = U.userId  and U.deleted = false ) as userCnt " +
					", CASE WHEN (select count(GC) from ExGeneralCustomization GC where  GC.clientId = C.clientId   )   > 0 THEN true ELSE false END as isCustomized  " +
			" from ExClient C where deleted = 'false' order by name  ")
	
	,
	
	@org.hibernate.annotations.NamedQuery(
			cacheable = false,
			readOnly = false,
			name  = CustomQueries.VIEW_BLAST_REPORT_EXPLORATION_LIST,
			query = "select     name ,   clientName, "
					+ "startDate ,  endDate ,  jobNumber ,  blastNumber ,"
					+ "location ,  orebody ,  stopeName ,  levels ,  latitude ,"
					+ "longitude ,  elevation ,  blasterName ,  completedBy ,"
					+ "reviewedBy ,  technician ,  measureSystemName ,"
					+ "powderFactorUser ,  powderFactor ,  maxLoadPerDelayUser ,"
					+ "maxLoadPerDelay ,  totalExplosivesUser ,"
					+ "totalExplosives ,  estimatedVolumeUser ,"
					+ "estimatedVolume ,  patternBurdenUser ,  patternBurden ,"
					+ "patternSpacingUser ,  patternSpacing ,"
					+ "bufferLineSpacingUser ,  bufferLineSpacing ,"
					+ "subDrillUser ,  subDrill ,  collarUser ,  collar ,"
					+ "holeCount ,  deckCount ,  miningMethod ,"
					+ "blastCategories ,  explosiveType ,  stemmingMaterial ,"
					+ "rockType ,  fragmentation ,  flyrock ,"
					+ "muckpileConfiguration ,  weather ,  windVelocity ,"
					+ "windDirection ,  description ,  notes ,  custom1 ,"
					+ "custom2 ,  custom3 ,  createdByUser ,  created ,"
					+ "lastModifiedByUser ,  modified ,  deleted   from ExBlastReport ")
})

package com.blastvibrations.jpa.dao.queries.custom;



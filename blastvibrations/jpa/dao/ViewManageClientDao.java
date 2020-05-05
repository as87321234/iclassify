package com.blastvibrations.jpa.dao;

import java.util.List;
import java.util.UUID;

import com.blastvibrations.jpa.orm.ExBlastReport;
import com.blastvibrations.jpa.orm.ExClient;
import com.blastvibrations.jpa.orm.ExUser;
import com.blastvibrations.jpa.orm.ViewBlastReportExploration;
import com.blastvibrations.jpa.orm.ViewManageClient;
import com.blastvibrations.jpa.orm.ViewXBlastReport;

public interface ViewManageClientDao {

	public List<ViewManageClient> findViewManageClient();

	List<ViewXBlastReport> findViewXBlastReportForBlastListId(
			List<UUID> blastIdList);

	public List<ViewManageClient> tableSorting(
			List<ExClient> clientList, SQLClause[] sqlClauses,
			OrderByClause[] orderByClauses, int maxResultsSet);

}

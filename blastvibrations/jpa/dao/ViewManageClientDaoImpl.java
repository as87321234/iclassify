package com.blastvibrations.jpa.dao;

import java.util.List;
import java.util.UUID;

/**
 * Insure you call getEntityManager().clear() to detach the entity
 * from the the entity manager. This will guarantee that the information
 * will be fetch from the database instead of being served from
 * the cache
 */
import org.springframework.stereotype.Repository;

import com.blastvibrations.jpa.orm.ViewManageClient;
import com.blastvibrations.jpa.orm.ViewXBlastReport;

@Repository
public class ViewManageClientDaoImpl extends GenericDaoImpl<ViewManageClient>
implements ViewManageClientDao {
 
	@SuppressWarnings("unchecked") 
	@Override
	public List<ViewManageClient> findViewManageClient() {
		List<ViewManageClient> viewManageClientList = null;

		try {

			final String sqlString = "select * from "
					+ "(select * "
					+ ",   (select count(*) from ex_monitor M  where M.client_id = C.client_id  ) as monitor_cnt"
					+ ",  (select count(*) from ex_client_user_mapping UM , ex_user U where  UM.client_id = C.client_id  and UM.user_id = U.user_id  and U.deleted = false ) as user_cnt"
					+ ", CASE WHEN (select count(*) from ex_general_customization GC where  GC.client_id = C.client_id   )   > 0 THEN true ELSE false END as is_customized "
					+ "from ex_client C where deleted = 'false'  order by lower(name) ) as R";

			viewManageClientList = getEntityManager().createNativeQuery(
					sqlString, ViewManageClient.class).getResultList();

			// Run a clear to detach all the entity retrieved from the
			// the entity manager. This will force a fetch from the
			// database next round.

			// I have tried the sething bypass cache but did not work
			// don't know why.
			getEntityManager().clear();

			if (viewManageClientList == null) {
				throw new Exception("no user found");
			}
		} catch (final Exception ex) {
			ex.printStackTrace();
		}

		return viewManageClientList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ViewXBlastReport> findViewXBlastReportForBlastListId(
			final List<UUID> blastIdList) {
		List<ViewXBlastReport> viewXBlastReport = null;

		try {

			final String sqlString = ""
					+ "  select "
					+ "(select description from ex_picker where bench_id = picker_id) as bench_desc "
					+ ",(select description from ex_picker where detonation_method_id = picker_id) as detonation_method_desc "
					+ ",(select description from ex_picker where firing_location_id = picker_id) as firing_location_desc "
					+ ",(select description from ex_picker where mining_method_id = picker_id) as mining_method_desc  "
					+ ",(select description from ex_picker where pattern_type_id = picker_id) as pattern_type_desc  "
					+ ",(select description from ex_picker where rock_type_id = picker_id) as rock_type_desc  "
					+ ",(select description from ex_picker where stemming_material_id = picker_id) as stemming_material_desc  "
					+ ",(select description from ex_picker where weather_id = picker_id) as weather_desc  "
					+ ",(select description from ex_picker where wind_direction_id = picker_id) as wind_direction_desc"
					+ ",(select description from ex_picker where wind_velocity_id = picker_id) as wind_velocity_desc"
					+ ", * "
					+ "from ex_blast_report where blast_id in (:blastIdList) ";

			if (blastIdList == null || blastIdList.size() == 0) {

				viewXBlastReport = null;

			} else {

				viewXBlastReport = getEntityManager()
						.createNativeQuery(sqlString, ViewXBlastReport.class)
						.setParameter("blastIdList", blastIdList)
						.getResultList();

				// Run a clear to detach all the entity retrieved from the
				// the entity manager. This will force a fetch from the
				// database next round.

				// I have tried the sething bypass cache but did not work
				// don't know why.
				getEntityManager().clear();

				if (viewXBlastReport == null) {
					throw new Exception("no user found");
				}
			}
		} catch (final Exception ex) {
			ex.printStackTrace();
		}

		return viewXBlastReport;
	}
	
	

}

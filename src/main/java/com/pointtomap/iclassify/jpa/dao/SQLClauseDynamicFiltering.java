package com.pointtomap.iclassify.jpa.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SQLClauseDynamicFiltering extends SQLClause {

	private static final Logger LOG = LoggerFactory.getLogger(SQLClauseDynamicFiltering.class);

	static public SQLClauseDynamicFiltering clauseFactory() {

		return null;
	}

	static public List<SQLClause> multiClauseFactory(String filters) {

		List<SQLClause> clauseList = new ArrayList<SQLClause>();

		try {

			// first convert input string to json array
			JSONObject jsonobject = new JSONObject(filters).getJSONObject("newFilters");

			Set<String> keySet = jsonobject.keySet();

			Iterator<String> iterator = keySet.iterator();

			while (iterator.hasNext()) {

				JSONObject o = jsonobject.getJSONObject(iterator.next());

				String filterType = o.getString("filterType");

				switch (filterType) {
				case SQLClause.DATE_BETWEEN:
				case SQLClause.BETWEEN:
					LOG.debug("Processing: " + filterType);

					SQLClauseBetween c = new SQLClauseBetween();

					c.fieldName = o.getString(SQLClause.ID);
					c.name = o.getString(SQLClause.NAME);
					c.tableName = o.getString(SQLClause.TABLE_NAME);
					c.filterType = o.getString(SQLClause.FILTER_TYPE);
					c.fromValue = o.getString(SQLClause.BETWEEN_FROM);
					c.toValue = o.getString(SQLClause.BETWEEN_TO);

					clauseList.add(c);

					break;
				case SQLClause.GREATER_THAN:
				case SQLClause.DATE_GREATER_THAN:
					LOG.debug("Processing: " + filterType);

					SQLClauseGT gt = new SQLClauseGT();

					gt.fieldName = o.getString(SQLClause.ID);
					gt.name = o.getString(SQLClause.NAME);
					gt.tableName = o.getString(SQLClause.TABLE_NAME);
					gt.filterType = o.getString(SQLClause.FILTER_TYPE);
					gt.value = o.getString(SQLClause.VALUE);

					clauseList.add(gt);

					break;
				case SQLClause.GREATER_EQUAL_THAN:
				case SQLClause.DATE_GREATER_EQUAL_THAN:
					LOG.debug("Processing: " + filterType);

					SQLClauseGE ge = new SQLClauseGE();

					ge.fieldName = o.getString(SQLClause.ID);
					ge.name = o.getString(SQLClause.NAME);
					ge.tableName = o.getString(SQLClause.TABLE_NAME);
					ge.filterType = o.getString(SQLClause.FILTER_TYPE);
					ge.value = o.getString(SQLClause.VALUE);

					clauseList.add(ge);

					break;
				case SQLClause.LESS_THAN:
				case SQLClause.DATE_LESS_THAN:
					LOG.debug("Processing: " + filterType);

					SQLClauseLT lt = new SQLClauseLT();

					lt.fieldName = o.getString(SQLClause.ID);
					lt.name = o.getString(SQLClause.NAME);
					lt.tableName = o.getString(SQLClause.TABLE_NAME);
					lt.filterType = o.getString(SQLClause.FILTER_TYPE);
					lt.value = o.getString(SQLClause.VALUE);

					clauseList.add(lt);

					break;
				case SQLClause.LESS_EQUAL_THAN:
				case SQLClause.DATE_LESS_EQUAL_THAN:

					LOG.debug("Processing: " + filterType);

					SQLClauseLE le = new SQLClauseLE();

					le.fieldName = o.getString(SQLClause.ID);
					le.name = o.getString(SQLClause.NAME);
					le.tableName = o.getString(SQLClause.TABLE_NAME);
					le.filterType = o.getString(SQLClause.FILTER_TYPE);
					le.value = o.getString(SQLClause.VALUE);

					clauseList.add(le);

					break;
				case SQLClause.EQUAL:
				case SQLClause.DATE_EQUAL:

					LOG.debug("Processing: " + filterType);

					SQLClauseEqual equal = new SQLClauseEqual();

					equal.fieldName = o.getString(SQLClause.ID);
					equal.name = o.getString(SQLClause.NAME);
					equal.tableName = o.getString(SQLClause.TABLE_NAME);
					equal.filterType = o.getString(SQLClause.FILTER_TYPE);
					equal.value = o.getString(SQLClause.VALUE);

					clauseList.add(equal);

					break;
				case SQLClause.PICKER:

					LOG.debug("Processing: " + filterType);

					SQLClauseEqual picker = new SQLClauseEqual();

					picker.fieldName = o.getString(SQLClause.ID);
					picker.name = o.getString(SQLClause.NAME);
					picker.tableName = o.getString(SQLClause.TABLE_NAME);
					picker.filterType = o.getString(SQLClause.FILTER_TYPE);
					picker.value = o.getString(SQLClause.VALUE);

					clauseList.add(picker);

					break;
				case SQLClause.INCLAUSE:

					LOG.debug("Processing: " + filterType);

					SQLClauseInClause inClause = new SQLClauseInClause();

					inClause.fieldName = o.getString(SQLClause.ID);
					inClause.name = o.getString(SQLClause.NAME);
					inClause.tableName = o.getString(SQLClause.TABLE_NAME);
					inClause.filterType = o.getString(SQLClause.FILTER_TYPE);
					inClause.value = o.getString(SQLClause.VALUE);

					clauseList.add(inClause);

					break;
				default:
					LOG.error("Processing: " + filterType);
					throw new IllegalArgumentException("Invalid filter Type: " + filterType);
				}

				System.out.print(o);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return clauseList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEntityName() {
		return tableName;
	}

	public void setEntityName(String tableName) {
		this.tableName = tableName;
	}

	public String getFilterType() {
		return filterType;
	}

	public void setFilterType(String filterType) {
		this.filterType = filterType;
	}

}
